package study.study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by sungju on 2017-07-12.
 */

public class ViewerFragment extends Fragment {
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)  inflater.inflate(R.layout.fragment_viewer,container,false);

        imageView = (ImageView) viewGroup.findViewById(R.id.imageView);

        return viewGroup;
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
