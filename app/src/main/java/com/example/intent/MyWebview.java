package com.example.intent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MyWebview extends AppCompatActivity {

        private WebView webview;

        @SuppressLint("SetJavaScriptEnabled")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mywebview);
            webview = (WebView) findViewById(R.id.webview);
            WebSettings webSettings = webview.getSettings();
            //设置WebView属性，能够执行Javascript脚本
            webSettings.setJavaScriptEnabled(true);
            //设置可以访问文件
            webSettings.setAllowFileAccess(true);
            //设置支持缩放
            webSettings.setBuiltInZoomControls(true);
            //加载需要显示的网页
            Intent it = getIntent();
            webview.loadUrl(it.getExtras().getString("url"));
            //设置Web视图
            webview.setWebViewClient(new webViewClient());

        }




        @Override
        //设置回退
        //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
                webview.goBack(); //goBack()表示返回WebView的上一页面
                return true;
            }
            finish();//结束退出程序
            return false;
        }

        //Web视图
        private class webViewClient extends WebViewClient {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

    }
