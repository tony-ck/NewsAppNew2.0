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
import java.util.List;

/**
 * Created by pfsu on 2017/6/8/008.
 */

public class AllNewsFragment  extends Fragment{
    private  RecyclerView recyclerView;
    private List<Image2Text> newsList=new ArrayList<>();
    private RecyClerViewAdapter adapter;
    private  View view;
    private int resArray [] = {R.mipmap.goldcat,R.mipmap.tw,R.mipmap.finance,R.mipmap.tachnology};
    private String newTitleArray[]={"淘金猫头条","汤唯短发利落西装干练女神范","CNN财经要闻","苹果在店里引入机器人，给你修手机"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fg_news,container,false);
        newsList.clear();
        initView();
        return view;
    }

    private void initView() {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        for (int i = 0; i< resArray.length; i++){
            Image2Text image2Text = new Image2Text(resArray[i],newTitleArray[i]);
            newsList.add(image2Text);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new RecyClerViewAdapter(newsList,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(!NetUtils.isAvailable(getActivity())){
                    Toast.makeText(getActivity(),"网络不可用，请稍后再试",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent =new Intent(getActivity(), DetailsActivity.class);
                    intent.putExtra(OtherFinals.ALLNEWS, OtherFinals.addNews().get(position));
                    startActivity(intent);
                }
            }
        });
    }
}
