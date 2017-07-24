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

public class GridViewItemView extends LinearLayout {
    ImageView imageView;
    TextView textView;
    TextView textView2;
    TextView textView3;

    public GridViewItemView(Context context) {
        super(context);
        init(context);
    }

    public GridViewItemView(Context context, AttributeSet set) {
        super(context, set);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.gridsinger_item, this, true);

        imageView = (ImageView) findViewById(R.id.gridViewImg);
        textView = (TextView) findViewById(R.id.gridViewText);
        textView2 = (TextView) findViewById(R.id.gridViewText2);
        textView3 = (TextView) findViewById(R.id.gridViewText3);
    }

    public void setName(String name) {textView.setText(name);};
    public void setImg(int resId) {imageView.setImageResource(resId);};
    public void setAge(int age) {textView3.setText(String.valueOf(age));};
    public void setPhone(String phone) {textView2.setText(phone);};
}
