package cn.edu.gdpt.androiddemo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.gdpt.androiddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoverterFragment extends Fragment {


    public CoverterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coverter, container, false);
    }

}
