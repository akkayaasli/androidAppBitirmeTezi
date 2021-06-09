package com.balikesirbitirme.otizmleyasam.Ebeveyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.balikesirbitirme.otizmleyasam.R;

public class EbeveynMenu extends AppCompatActivity {
    ImageView todolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebeveyn_menu);


        todolist=findViewById(R.id.ebeveyn_menu_todolist);



        todolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),TodolistEbeveyn.class);
                startActivity(intent);
            }
        });

    }
}
