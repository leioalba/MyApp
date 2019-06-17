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
        
    }

}
