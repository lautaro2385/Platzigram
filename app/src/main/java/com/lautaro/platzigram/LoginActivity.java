package com.lautaro.platzigram;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lautaro.platzigram.views.ContainerActivity;
import com.lautaro.platzigram.views.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void onLogin(View view){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    public void onClickImage(View view){
        invokeWebBrowser(this);
    }

    public static void invokeWebBrowser(Activity activity){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        activity.startActivity(intent);
    }

}
