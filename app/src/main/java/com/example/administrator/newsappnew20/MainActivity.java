package com.example.administrator.newsappnew20;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidkun.xtablayout.XTabLayout;
import com.example.administrator.newsappnew20.Fragment.AllNewsFragment;
import com.example.administrator.newsappnew20.Fragment.EntertainmentFragment;
import com.example.administrator.newsappnew20.Fragment.FinanceNewsFragment;
import com.example.administrator.newsappnew20.Fragment.GoldCatFragment;
import com.example.administrator.newsappnew20.Fragment.TechnologyFragment;
import com.example.administrator.newsappnew20.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }
    /**初始化ViewPager*/
    private void initData() {
       titles = new ArrayList<>();
        titles.add("全部");
        titles.add("金猫头条");
        titles.add("文娱八卦");
        titles.add("财经资讯");
        titles.add("科技前沿");
        fragments.add(new AllNewsFragment());
        fragments.add(new GoldCatFragment());
        fragments.add(new EntertainmentFragment());
        fragments.add(new FinanceNewsFragment());
        fragments.add(new TechnologyFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        // 将TabLayout和ViewPager关联起来。
        XTabLayout tabLayout = (XTabLayout) findViewById(R.id.xTablayout);
        tabLayout.setupWithViewPager(viewPager);
        //给TabLayout设置适配器
        tabLayout.setupWithViewPager(viewPager);
    }
}
