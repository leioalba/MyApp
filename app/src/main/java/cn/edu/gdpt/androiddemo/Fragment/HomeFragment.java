package cn.edu.gdpt.androiddemo.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import cn.edu.gdpt.androiddemo.Adapter.ListViewInfoAdapter;
import cn.edu.gdpt.androiddemo.ListViewInfo;
import cn.edu.gdpt.androiddemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ListView listView;
    private Context context;
    private ListViewInfoAdapter mAdapter;
    private List<ListViewInfo> listViewInfos;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home,container,false);
        listView = (ListView) view.findViewById(R.id.listView_home);
        initListView();
        return view;

    }

    private void initListView() {
        context = getActivity();
        listViewInfos = new LinkedList<ListViewInfo>();
        listViewInfos.add(new ListViewInfo(R.drawable.yingguo,"英镑","England",""));
        listViewInfos.add(new ListViewInfo(R.drawable.hongkong,"港币","HongKong",""));
        listViewInfos.add(new ListViewInfo(R.drawable.meiguo,"美元","American",""));
        listViewInfos.add(new ListViewInfo(R.drawable.ruishi,"瑞士法郎","Switzerland",""));
        listViewInfos.add(new ListViewInfo(R.drawable.xinjiapo,"新加坡元","Singapore",""));
        listViewInfos.add(new ListViewInfo(R.drawable.ruidian,"瑞典克朗","Sweden",""));
        listViewInfos.add(new ListViewInfo(R.drawable.danmai,"丹麦克朗","Denmark",""));
        listViewInfos.add(new ListViewInfo(R.drawable.nuowei,"挪威克朗","Norway",""));
        listViewInfos.add(new ListViewInfo(R.drawable.riben,"日元","Japan",""));
        listViewInfos.add(new ListViewInfo(R.drawable.jianada,"加拿大元","Canada",""));
        listViewInfos.add(new ListViewInfo(R.drawable.aodaliya,"澳大利亚元","Australia",""));
        listViewInfos.add(new ListViewInfo(R.drawable.oumeng,"欧元","Europe",""));
        listViewInfos.add(new ListViewInfo(R.drawable.aomen,"澳门币","Macao",""));
        listViewInfos.add(new ListViewInfo(R.drawable.feilvbin,"比索","The Philippines",""));
        listViewInfos.add(new ListViewInfo(R.drawable.taiguo,"泰铢","Thailand",""));
        listViewInfos.add(new ListViewInfo(R.drawable.xinxilan,"新西兰元","New Zealand",""));
        listViewInfos.add(new ListViewInfo(R.drawable.hanguo,"韩元","Korea",""));
        mAdapter = new ListViewInfoAdapter((LinkedList<ListViewInfo>)listViewInfos,context);
        listView.setAdapter(mAdapter);
    }

}
