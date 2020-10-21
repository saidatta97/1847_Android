package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SwipeRefreshLayout refreshLayout=(SwipeRefreshLayout)findViewById(R.id.mainLayout);
        webView=(WebView) findViewById(R.id.webView);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setSoundEffectsEnabled(true);

        webView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        if(checkConnection()){
            webView.loadUrl("https://www.youtube.com");
        }
        else{
            webView.loadUrl("file:///android_asset/profile.html");
        }

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(checkConnection()){
                    webView.loadUrl("https://www.youtube.com");
                }
                else{
                    webView.loadUrl("file:///android_asset/profile.html");
                }

                refreshLayout.setRefreshing(false);
            }


        });


    }

    private boolean checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

//        if(null!=activeNetwork)
//        {
//            if(activeNetwork.getType()==ConnectivityManager.TYPE_WIFI)
//            {
//                Toast.makeText(this,"wifi enabled",Toast.LENGTH_SHORT).show();
//            }
//            if(activeNetwork.getType()==ConnectivityManager.TYPE_MOBILE)
//            {
//                Toast.makeText(this,"Data Network enabled",Toast.LENGTH_SHORT).show();
//            }
//        }
//        else
//        {
//            Toast.makeText(this,"No Internet",Toast.LENGTH_SHORT).show();
//        }

        return activeNetwork!= null && activeNetwork.isConnected();
    }

}