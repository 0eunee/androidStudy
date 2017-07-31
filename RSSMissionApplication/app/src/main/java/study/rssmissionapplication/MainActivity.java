package study.rssmissionapplication;

import android.app.ProgressDialog;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static String rssUrl = "http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=entertainment";

    ProgressDialog dialog;

    Handler handler = new Handler();

    Button button;

    GridView gridView;

    RSSListAdapter adapter;

    List<RSSItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new RSSListAdapter(getApplicationContext());
        button = (Button) findViewById(R.id.show_btn);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRSS();
            }
        });
    }

    private void showRSS() {
        dialog = ProgressDialog.show(this,"RSS Refresh","RSS 정보 가져오는 중....",true, true);
        Thread thread = new RSSThread();
        thread.start();
    }


    class RSSThread extends Thread {
        @Override
        public void run() {

            try {
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();

                InputStream inputStream = getInputStreamUsingHttp(new URL(rssUrl));

                Document document = builder.parse(inputStream);
                int count = processDocument(document);

                handler.post(updateRSSData);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public InputStream getInputStreamUsingHttp(URL url) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        int resCode = conn.getResponseCode();

        Log.d(TAG,"Response Code : " + resCode);

        return conn.getInputStream();
    }

    private int processDocument(Document document) {
        int count = 0;

        Element docEle = document.getDocumentElement();
        NodeList nodeList = docEle.getElementsByTagName("item");

        if(nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                RSSItem item = parserItem(nodeList,i);
                itemList.add(item);
                count++;
            }
        }
        Log.d(TAG,"count : " + count);
        return count;
    }

    private RSSItem parserItem(NodeList nodeList, int index) {
        RSSItem item = null;

        try {
            Element entry = (Element) nodeList.item(index);
            Element title = (Element) entry.getElementsByTagName("title").item(0);
            Element link = (Element) entry.getElementsByTagName("link").item(0);
            Element description = (Element) entry.getElementsByTagName("description").item(0);

            NodeList pubDateNode = entry.getElementsByTagName("pubDate");
            if (pubDateNode == null) {
                pubDateNode = entry.getElementsByTagName("dc:date");
            }
            Element pubDate = (Element) pubDateNode.item(0);

            String titleValue = "";
            if (title != null) {
                Node node = title.getFirstChild();
                if (node != null) {
                    titleValue = node.getNodeValue();
                }
            }

            String pubDateValue = "";
            if (pubDate != null) {
                Node node = pubDate.getFirstChild();
                if (node != null) {
                    pubDateValue = node.getNodeValue();
                }
            }

            String descriptionValue = "";
            if (description != null) {
                Node node = description.getFirstChild();
                if (node != null) {
                    descriptionValue = node.getNodeValue();
                }
            }
            Log.d(TAG,"title : " + titleValue + ",\n" +  "date : " + pubDateValue + ",\n" + "descriptionValue : " + descriptionValue);

            Drawable drawable = getResources().getDrawable(R.drawable.rss_icon);
            item = new RSSItem(titleValue,descriptionValue,pubDateValue, drawable);


        } catch (Exception e) {
            Log.d(TAG,"parserError : " + e);
        }

        return item;
    }

    Runnable updateRSSData = new Runnable() {
        @Override
        public void run() {
            for (RSSItem item : itemList) {
                adapter.addItem(item);
            }

            adapter.notifyDataSetChanged();

            dialog.dismiss();
        }
    };
}
