package study.study;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sungju on 2017-07-24.
 */

public class MissionListView extends LinearLayout {
    ImageView imageView;
    TextView textView;
    TextView textView2;
    TextView textView3;

    public MissionListView(Context context) {
        super(context);
        init(context);
    }

    public MissionListView(Context context, AttributeSet set) {
        super(context, set);

        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listviewmissionitem, this, true);

        imageView = (ImageView) findViewById(R.id.missionListViewImg);
        textView = (TextView) findViewById(R.id.missionListViewText1);
        textView2 = (TextView) findViewById(R.id.missionListViewText2);
        textView3 = (TextView) findViewById(R.id.missionListViewText3);
    }

    public void setImg(int resId) {imageView.setImageResource(resId);}

    public void setName(String name) {
        textView.setText(name);
    };

    public void setPhone(String phone) {textView2.setText(phone);};

    public void setAge(int age) {textView3.setText(String.valueOf(age));}
}
