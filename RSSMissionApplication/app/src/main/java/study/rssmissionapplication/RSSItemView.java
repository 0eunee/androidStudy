package study.rssmissionapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sungju on 2017-07-31.
 */

public class RSSItemView extends LinearLayout {

    ImageView imageView;
    TextView title1;
    TextView date1;
    WebView content1;

    public RSSItemView (Context context) {
        super(context);
        init(context);
    }
    public RSSItemView (Context context, AttributeSet set) {
        super(context, set);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listitem, this, true);

        title1 = (TextView) findViewById(R.id.gridTitle);
        date1 = (TextView) findViewById(R.id.gridDate);
        content1 = (WebView) findViewById(R.id.gridContent);
        imageView = (ImageView) findViewById(R.id.gridImg);

    }

    public void setTitle(String title) {
        title1.setText(title);
    }

    public void setDate(String date) {
        date1.setText(date);
    }

    public void setContent(String content) {
        String msg = content.replace("\"//","\"http://");
        content1.loadDataWithBaseURL("http://localhost",msg,"text/html","utf-8",null);
    }

    public void setImg(Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }
}
