package cn.edu.gdpt.androiddemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapters<T> extends BaseAdapter {
    private List<T> obj=new ArrayList<>();
    private Context context;
    private int layout;
    private int vid;
    private LayoutInflater layoutInflater;
    private FragmentActivity activity;
    public BaseAdapters(List<T> obj, FragmentActivity activity, int layout, int vid) {
        this.obj = obj;
        this.context =activity.getApplicationContext();
        this.layout = layout;
        this.vid = vid;
        layoutInflater=LayoutInflater.from(context);
        activity=this.activity;
    }

    @Override
    public int getCount() {
        return obj.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if(convertView==null){
            binding= DataBindingUtil.inflate(layoutInflater,layout,parent,false);

        }else{
        binding=DataBindingUtil.getBinding(convertView);
        }

        binding.setVariable(vid,obj.get(position));
        return binding.getRoot();
    }
}
