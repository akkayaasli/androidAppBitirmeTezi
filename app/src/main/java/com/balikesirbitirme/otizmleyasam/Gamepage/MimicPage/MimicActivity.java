package com.balikesirbitirme.otizmleyasam.Gamepage.MimicPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MimicActivity extends AppCompatActivity {
    ImageView imgMain;
    ImageView imgSelecter1, imgSelecter2, imgSelecter3, imgSelecter4;
    ImageView[] Selecter = new ImageView[4];
    Random rnd = new Random();
    List<Mimic> mimics = new ArrayList<Mimic>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_mimic);

        Init();
        startScane();
    }

    private void Init() {
        imgMain = findViewById(R.id.img_mimic_main);

        imgSelecter1 = findViewById(R.id.img_mimic_selecter1);
        imgSelecter2 = findViewById(R.id.img_mimic_selecter2);
        imgSelecter3 = findViewById(R.id.img_mimic_selecter3);
        imgSelecter4 = findViewById(R.id.img_mimic_selecter4);

        mimics.add(new Mimic(R.drawable.people_bir, R.drawable.emotion_bir));
        mimics.add(new Mimic(R.drawable.people_iki, R.drawable.emotion_iki));
        mimics.add(new Mimic(R.drawable.people_uc, R.drawable.emotion_uc));
        mimics.add(new Mimic(R.drawable.people_dort, R.drawable.emotion_dort));//yazarken 5 atlandı kaza ile
        mimics.add(new Mimic(R.drawable.people_alti, R.drawable.emotion_alti));
        mimics.add(new Mimic(R.drawable.people_yedi, R.drawable.emotion_yedi));
        mimics.add(new Mimic(R.drawable.people_sekiz, R.drawable.emotion_sekiz));
        mimics.add(new Mimic(R.drawable.people_dokuz, R.drawable.emotion_dokuz));
        mimics.add(new Mimic(R.drawable.people_on, R.drawable.emotion_on));
        mimics.add(new Mimic(R.drawable.people_onbir, R.drawable.emotion_onbir));
        mimics.add(new Mimic(R.drawable.people_oniki, R.drawable.emotion_oniki));
        mimics.add(new Mimic(R.drawable.people_onuc, R.drawable.emotion_onuc));
        mimics.add(new Mimic(R.drawable.people_ondort, R.drawable.emotion_ondort));
        mimics.add(new Mimic(R.drawable.people_onbes, R.drawable.emotion_onbes));
        mimics.add(new Mimic(R.drawable.people_onalti, R.drawable.emotion_onalti));
        mimics.add(new Mimic(R.drawable.people_onyedi, R.drawable.emotion_onyedi));
        mimics.add(new Mimic(R.drawable.people_onsekiz, R.drawable.emotion_onsekiz));
        mimics.add(new Mimic(R.drawable.people_ondokuz, R.drawable.emotion_ondokuz));
        mimics.add(new Mimic(R.drawable.people_yirmi, R.drawable.emotion_yirmi));
        mimics.add(new Mimic(R.drawable.people_yirmibir, R.drawable.emotion_yirmibir));
        mimics.add(new Mimic(R.drawable.people_yirmibir, R.drawable.emotion_yirmiiki));

        Selecter[0] = (imgSelecter1);
        Selecter[1] = (imgSelecter2);
        Selecter[2] = (imgSelecter3);
        Selecter[3] = (imgSelecter4);


        for (int i = 0; i < 20; i++) {
            int Core = rnd.nextInt(Selecter.length);
            ImageView imgFlag = Selecter[Core];
            Selecter[Core] = Selecter[1];
            Selecter[1] = imgFlag;

        }

    }

    private void startScane(){

        final int Core=rnd.nextInt(mimics.size());


        imgMain.setImageResource(mimics.get(Core).getIntHuman());
        Selecter[0].setImageResource(mimics.get(Core).getIntMimic());
        Selecter[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Oldu",Toast.LENGTH_SHORT).show();
                recreate();
            }
        });



        int Core2=Core,Core3=Core,Core4=Core;
        int[] False=new int[3];
        False[0]=Core;
        False[0]=Core;
        False[0]=Core;

        int intFalseCore =rnd.nextInt(mimics.size());
        for (int i=1;i<4;i++){
            while ((intFalseCore==Core)||(intFalseCore==False[0])||(intFalseCore==False[1])||(intFalseCore==False[2])){
                intFalseCore =rnd.nextInt(mimics.size());
            }
            False[i-1]=intFalseCore;

            Selecter[i].setImageResource(mimics.get(intFalseCore).getIntMimic());
            Selecter[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Yanlış",Toast.LENGTH_SHORT).show();


                }
            });
        }

    }
}
