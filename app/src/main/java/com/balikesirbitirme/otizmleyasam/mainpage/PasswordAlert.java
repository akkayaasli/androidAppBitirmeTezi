package com.balikesirbitirme.otizmleyasam.mainpage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.balikesirbitirme.otizmleyasam.Ebeveyn.TodolistEbeveyn;
import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.AddAlert;
import com.balikesirbitirme.otizmleyasam.R;


public class PasswordAlert {
    Button btnonay;
    EditText edPasswprd;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;
    private Activity activity;
    private View view;
    private AlertDialog dialog;
    Boolean flag=true;
    private String PassWord="admin";// ileride ebebeyn ayarlar kısmı eklenip orada  şifre kullanıcıya belirletilirse ( sharedpreferences ile kaydedilip ) buraya ataması yapılarak
    //başka bir değişikliğe gerek kalmadan halledilebilir

    public  PasswordAlert(Activity activity,int activityNumber){
        this.activity=activity;
        builder = new AlertDialog.Builder(this.activity);
        builder.setTitle("");
        inflater=activity.getLayoutInflater();
        view =inflater.inflate(R.layout.password_alert,null);
        Init();
        if (activityNumber==1)
            story();
        if (activityNumber==2)
            toDoList();
        builder.setView(view);

    }
    public void Init(){
        btnonay=view.findViewById(R.id.btn_pasword_alert);
        edPasswprd=view.findViewById(R.id.ed_password_alert);

    }
    public void story(){
        btnonay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edPasswprd.getText().toString().equals(PassWord))
                {
                    AddAlert alert = new AddAlert(activity);
                    alert.show();

                }
                else
                {

                }

            }
        });
    }
    public void toDoList(){
        btnonay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edPasswprd.getText().toString().equals(PassWord))
                {
                    Intent intent= new Intent(activity.getApplicationContext(), TodolistEbeveyn.class);
                    activity.startActivity(intent);

                }
                else
                {

                }

            }
        });
    }
    public void show(){
        dialog=builder.create();
        dialog.show();
    }
    public Boolean isNotChild(){


        return flag;


    }

}
