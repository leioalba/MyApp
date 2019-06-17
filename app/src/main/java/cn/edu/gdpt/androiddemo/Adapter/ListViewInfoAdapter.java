package cn.edu.gdpt.androiddemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

import cn.edu.gdpt.androiddemo.ListViewInfo;
import cn.edu.gdpt.androiddemo.R;

public class ListViewInfoAdapter extends BaseAdapter {
    private LinkedList<ListViewInfo> mData;
    private Context context;

    public ListViewInfoAdapter(LinkedList<ListViewInfo> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_item,parent,false);
        ImageView img_logo = (ImageView) convertView.findViewById(R.id.img_country);
        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tv_content = (TextView) convertView.findViewById(R.id.tv_content);
        TextView tv_rate = (TextView) convertView.findViewById(R.id.tv_rate);
        img_logo.setBackgroundResource(mData.get(position).getImg_logo());
        tv_title.setText(mData.get(position).getTitle());
        tv_content.setText(mData.get(position).getContent());
        tv_rate.setText(mData.get(position).getRate());
        return convertView;
    }
}
