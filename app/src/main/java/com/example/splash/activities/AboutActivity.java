package com.example.splash.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.splash.R;

public class AboutActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBarabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        webView = (WebView) findViewById(R.id.webview);
        progressBarabout = (ProgressBar) findViewById(R.id.prograssabout);
        webView();
    }

    private void webView() {

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new myWebClient());

        webView.loadUrl("https://vectiestrichy.web.app/");
    }

    public class myWebClient extends WebViewClient{

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            Toast.makeText(AboutActivity.this, "something went wrong!", +  Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {


            super.onPageFinished(view, url);

            progressBarabout.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }else {
            finish();
            return true;
        }
    }

}
