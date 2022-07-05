package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebSiteActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    public void onBackPressed() {
        if(webView!= null && webView.canGoBack())
            webView.goBack();// if there is previous page open it
        else
            super.onBackPressed();//if there is no previous page, close app
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_site);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setSupportMultipleWindows(true);
        webView.loadUrl("https://github.com/ZacharelFloat");
//        webView.setWebViewClient(new WebViewClient());

    }
}