package com.balikesirbitirme.otizmleyasam.Gamepage.WorldLearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.balikesirbitirme.otizmleyasam.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class WorldMenuActivity extends AppCompatActivity {
    CircleImageView cimgHarf;
    CircleImageView cimgKelime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_world_menu);

        cimgHarf=findViewById(R.id.cimg_word_menu1);
        cimgKelime=findViewById(R.id.cimg_word_menu2);

        cimgHarf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),WordSecondActivity.class);
                startActivity(intent);
            }
        });
        cimgKelime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st;
                Intent intent= new Intent(getApplicationContext(),WorldActivity.class);
                startActivity(intent);
            }
        });
    }
}
