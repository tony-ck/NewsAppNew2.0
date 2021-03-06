package com.example.administrator.newsappnew20.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.newsappnew20.Activity.DetailsActivity;
import com.example.administrator.newsappnew20.Finals.OtherFinals;
import com.example.administrator.newsappnew20.Listener.OnItemClickListener;
import com.example.administrator.newsappnew20.Obj.Image2Text;
import com.example.administrator.newsappnew20.R;
import com.example.administrator.newsappnew20.Utils.NetUtils;
import com.example.administrator.newsappnew20.adapter.RecyClerViewAdapter;

import java.util.ArrayList;

/**
 * 财经
 * Created by Administrator on 2017/6/8/008.
 */

public class FinanceNewsFragment extends Fragment{
    private RecyClerViewAdapter adapter;
    private RecyclerView recyclerView;
    private View view;
    private ArrayList<Image2Text> newList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fg_news,container,false);
        newList.clear();
        initView();
        return view;
    }
    private void initView() {
        recyclerView= (RecyclerView) view.findViewById(R.id.rv);
        Image2Text image2Text = new Image2Text(OtherFinals.resArray[2],OtherFinals.newTitleArray[2]);
        newList.add(image2Text);
        adapter=new RecyClerViewAdapter(newList,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(!NetUtils.isAvailable(getActivity())){
                    Toast.makeText(getActivity(),"网络不可用，请稍后再试",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent= new Intent(getActivity(), DetailsActivity.class);
                    intent.putExtra(OtherFinals.ALLNEWS,OtherFinals.FINANCE);
                    startActivity(intent);
                }
            }
        });
    }
}
