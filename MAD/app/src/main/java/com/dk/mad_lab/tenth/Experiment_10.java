package com.dk.mad_lab.tenth;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import com.dk.mad_lab.R;

public class Experiment_10 extends AppCompatActivity {

    private EditText urlField;
    private WebView webView;

    @SuppressLint({"ClickableViewAccessibility", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);

        urlField = findViewById(R.id.urlField);
        webView = findViewById(R.id.web);
        Button search = findViewById(R.id.search);

        WebSettings web = webView.getSettings();
        web.setJavaScriptEnabled(true);
        webView.setWebViewClient(new Callback());

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlField.getText().toString().isEmpty()) {
                    webView.loadUrl("www.google.com");
                } else {
                    webView.loadUrl(urlField.getText().toString());
                }
            }
        });

        if(urlField.getText().toString().isEmpty()) {
            webView.loadUrl("www.google.com");
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else
            super.onBackPressed();
    }

    private static class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}