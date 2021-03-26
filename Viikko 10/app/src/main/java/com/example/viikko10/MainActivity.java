package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String url;
    EditText text;
    WebView web;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI elements by ID's.
        Button search = findViewById(R.id.search);
        EditText text = findViewById(R.id.editText);

        // Web view ID + set new Client to avoid opening in default browser but in app instead.
        WebView web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://" + text.getText().toString();
                System.out.println(url);
                web.loadUrl(url);
            }
        });
    }
}