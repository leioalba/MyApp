package cn.edu.gdpt.androiddemo.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdpt.androiddemo.BR;
import cn.edu.gdpt.androiddemo.R;
import cn.edu.gdpt.androiddemo.adapter.BaseAdapters;
import cn.edu.gdpt.androiddemo.bean.Huilv;
import cn.edu.gdpt.androiddemo.bean.MyHuilv;
import cn.edu.gdpt.androiddemo.databinding.FragmentHomeBinding;
import cn.edu.gdpt.androiddemo.utils.NetworkListining;
import cn.edu.gdpt.androiddemo.utils.OkhttpUntil;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
  FragmentHomeBinding fragmentHomeBinding;
    public static    FragmentActivity activitys;

    public FragmentActivity getActivitys() {
        return activitys;
    }

    public void setActivitys(FragmentActivity activitys) {
        this.activitys = activitys;
    }

    @Nullable




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activitys=getActivity();
        // Inflate the layout for this fragment
        fragmentHomeBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        View view=fragmentHomeBinding.getRoot();
        getdata();


        return view;

    }

public void getdata(){
    OkhttpUntil.enqueueGetrequest("http://web.juhe.cn:8080/finance/exchange/rmbquot?key=efbddb0b2107a1957c750b6d1592f361", Huilv.class, new NetworkListining<Huilv>() {
        @Override
        public void BackResultSuccess(Huilv bean, int code) {
            if(bean!=null){

                List<Huilv.ResultBean> result = bean.getResult();
                List<MyHuilv.DataBean> myHuilvs=new ArrayList<>();
                Huilv.ResultBean resultBean = result.get(0);
                myHuilvs.add(resultBean.getData1());
                myHuilvs.add(resultBean.getData2());
                myHuilvs.add(resultBean.getData3());
                myHuilvs.add(resultBean.getData4());
                myHuilvs.add(resultBean.getData5());
                myHuilvs.add(resultBean.getData6());
                myHuilvs.add(resultBean.getData7());
                myHuilvs.add(resultBean.getData8());
                myHuilvs.add(resultBean.getData9());
                myHuilvs.add(resultBean.getData10());
                myHuilvs.add(resultBean.getData11());
                myHuilvs.add(resultBean.getData12());
                myHuilvs.add(resultBean.getData13());
                myHuilvs.add(resultBean.getData14());
                myHuilvs.add(resultBean.getData15());
//                Log.i("AAA", myHuilvs.size()+"");
//                Toast.makeText(activity, result.size()+"", Toast.LENGTH_SHORT).show();
              BaseAdapters<MyHuilv.DataBean> baseAdapters=new BaseAdapters(myHuilvs,activitys,R.layout.listview_item, BR.bank);
                fragmentHomeBinding.setAdapter(baseAdapters);
            }
        }

        @Override
        public void BackResultFail(Exception errow) {
            Log.i("AAA", errow.getMessage());
        }

        @Override
        public void tostring(String responseString) {

        }
    });
}
}
