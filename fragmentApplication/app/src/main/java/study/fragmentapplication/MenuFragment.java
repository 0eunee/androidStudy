package study.fragmentapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sungju on 2017-07-12.
 */

public class MenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu, container, false);

        Button btn = (Button) rootView.findViewById(R.id.menuBtn);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.onFragmentChanged(1,"헬로우");
            }
        });
        return rootView;
    }
}
