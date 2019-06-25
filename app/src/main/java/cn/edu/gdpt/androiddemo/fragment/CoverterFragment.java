package cn.edu.gdpt.androiddemo.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.spark.submitbutton.SubmitButton;

import cn.edu.gdpt.androiddemo.R;
import cn.edu.gdpt.androiddemo.bean.MyHuilv;
import cn.edu.gdpt.androiddemo.databinding.FragmentCoverterBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoverterFragment extends Fragment {
    public static FragmentActivity activity;
    private SubmitButton submitButton;
    private EditText editText;

public static FragmentCoverterBinding coverterBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity=getActivity();

        // Inflate the layout for this fragment
        coverterBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_coverter,container,false);
        return coverterBinding.getRoot();
    }
    public FragmentActivity activity(){
        return getActivity();
    }
public static void Setdata( MyHuilv.DataBean dataBean){
       if(activity!=null&&coverterBinding!=null){
            //Toast.makeText(activity, dataBean.getName(), Toast.LENGTH_SHORT).show();
            coverterBinding.setBank(dataBean);
        }
}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        submitButton = (SubmitButton) getActivity().findViewById(R.id.submitButton);
        editText = (EditText) getActivity().findViewById(R.id.et_rate);
        String s = editText.getText().toString();

    }
}
