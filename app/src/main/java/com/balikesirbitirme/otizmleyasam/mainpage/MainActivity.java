package com.balikesirbitirme.otizmleyasam.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.Ebeveyn.EbeveynMenu;
import com.balikesirbitirme.otizmleyasam.Ebeveyn.TodolistEbeveyn;
import com.balikesirbitirme.otizmleyasam.R;

import java.lang.invoke.MethodType;

public class MainActivity extends AppCompatActivity {

    Context context=this;
    private Button btnMain;
    Button btnEbeveyn;
    Activity activity=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//yeni eklendi Yan çevirilemez yapıyor ilgili aktiviteyi
        setContentView(R.layout.activity_main);

        Init();
        eventMainbutton();
    }
    private void Init(){
        btnMain=findViewById(R.id.btn_main);
        btnEbeveyn=findViewById(R.id.btnebeveyn);

    }

    private  void eventMainbutton(){
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,MainMenuActivity.class);

                startActivity(intent);
            }
        });
        btnEbeveyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordAlert passwordAlert=new PasswordAlert(activity,2);
                passwordAlert.show();

            }
        });
    }


}
