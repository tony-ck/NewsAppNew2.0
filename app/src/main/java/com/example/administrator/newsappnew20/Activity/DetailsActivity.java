package com.example.administrator.newsappnew20.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.newsappnew20.Finals.OtherFinals;
import com.example.administrator.newsappnew20.R;

/**
 * 详情页
 * Created by pfsu on 2017/6/8/008.
 */

public class DetailsActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsdetails_activity);
        initWebView();
    }
    /**初始化webView*/
    private void initWebView() {
        webView= (WebView) findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);//关键点
        webView.getSettings().setBuiltInZoomControls(true); // 设置显示缩放按钮
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().getLoadWithOverviewMode();
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url); // 根据传入的参数，加载新的网页
                return true; // 表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器
            }
        });
        webView.loadUrl(getIntent().getStringExtra(OtherFinals.ALLNEWS));
    }
}
