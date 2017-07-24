package study.study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sungju on 2017-07-12.
 */

public class ToolBarFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootGroup = (ViewGroup) inflater.inflate(R.layout.toolbarfragment2,container,false);
        return rootGroup;
    }
}
