package com.balikesirbitirme.otizmleyasam.Gamepage.MathGamePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Random;

public class MathGameActivity extends AppCompatActivity {
    private LinearLayout lylS1,lylS2,lylS3;
    ArrayList<LinearLayout> Circle=new ArrayList<>();
    ArrayList<LinearLayout> Selecter=new ArrayList<>();
    private int intMaxCore=99;
    private int intAnswer=0;


    ArrayList<Integer> Numbers= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_math_game2);


        Init();
        makeGame();
    }
    private void makeScane(){



        Random rnd=new Random();
        if (rnd.nextBoolean()==false){
            Circle.clear();
            Circle.add((LinearLayout) findViewById(R.id.imgQ4));
            Circle.add((LinearLayout) findViewById(R.id.imgQ3));
            Circle.add((LinearLayout) findViewById(R.id.imgQ2));
            Circle.add((LinearLayout) findViewById(R.id.imgQ1));
        }
        for (int i=0; i<5;i++){
            vTakas();
        }


    }
    private void vTakas(){
        Random rnd =new Random();
        int flag=rnd.nextInt(3);
        LinearLayout lylFlager=Selecter.get(flag);
        Selecter.set(flag,Selecter.get(0));
        Selecter.set(0,lylFlager);

    }
    private void Init(){

        Circle.clear();
        Circle.add((LinearLayout) findViewById(R.id.imgQ1));
        Circle.add((LinearLayout) findViewById(R.id.imgQ2));
        Circle.add((LinearLayout) findViewById(R.id.imgQ3));
        Circle.add((LinearLayout) findViewById(R.id.imgQ4));

        /*
        lylQ1=findViewById(R.id.imgQ1);
        lylQ2=findViewById(R.id.imgQ2);
        lylQ3=findViewById(R.id.imgQ3);
        lylQ4=findViewById(R.id.imgQ4);
        */

        /*
        lylS1=findViewById(R.id.imgS1);
        lylS2=findViewById(R.id.imgS2);
        lylS3=findViewById(R.id.imgS3);
        */
        Selecter.clear();

        Selecter.add((LinearLayout) findViewById(R.id.imgS1));
        Selecter.add((LinearLayout) findViewById(R.id.imgS2));
        Selecter.add((LinearLayout) findViewById(R.id.imgS3));


        makeNumber();

    }
    private void makeNumber(){
        Numbers.add(R.drawable.zero);
        Numbers.add(R.drawable.one);
        Numbers.add(R.drawable.two);
        Numbers.add(R.drawable.three);
        Numbers.add(R.drawable.four);
        Numbers.add(R.drawable.five);
        Numbers.add(R.drawable.six);
        Numbers.add(R.drawable.seven);
        Numbers.add(R.drawable.eight);
        Numbers.add(R.drawable.nine);
    }
    private ImageView makeImage(int intImage){
        ImageView img=new ImageView(getApplicationContext());
        img.setImageResource(intImage);
        img.setPadding(10,10,10,10);
        return img;
    }

    private void makeGame(){
        makeScane();
        Random rnd=new Random();
        int intRange=rnd.nextInt(20)+1; //1 ila 20arası bir artış değeri belirler;
        int intCore=rnd.nextInt(intMaxCore-(3*intRange));//başlangıç değerini seçer
        int intDisable=rnd.nextInt(Circle.size());//hangi artışın sorulacağı

        for (int i=0; i<Circle.size();i++){

            if (i==intDisable){
                intAnswer=intCore;
                Circle.get(i).addView(makeImage(R.drawable.question));
                makeSelecter(intAnswer);
                //cavaplara cavabı yerleştir
            }
            else{
                Circle.get(i).addView(makeImage(Numbers.get(Integer.valueOf(String.valueOf((String.valueOf(intCore).charAt(0)))))));
                if(String.valueOf(intCore).length()>1){

                    Circle.get(i).addView(makeImage(Numbers.get(Integer.valueOf(String.valueOf((String.valueOf(intCore).charAt(1)))))));

                }

            }
            intCore=intCore+intRange;
        }


    }
    private void makeSelecter(int intAnswer){
        Random rnd =new Random();
        for (int i=0;i<3;i++){
            if (i!=1){
                int flag=rnd.nextInt(100);
                Selecter.get(i).addView(makeImage(Numbers.get(Integer.valueOf(String.valueOf((String.valueOf(flag).charAt(0)))))));
                if(String.valueOf(flag).length()>1){
                    Selecter.get(i).addView(makeImage(Numbers.get(Integer.valueOf(String.valueOf((String.valueOf(flag).charAt(1)))))));
                }
                Selecter.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_SHORT).show();


                    }
                });
            }
            else
            {

                Selecter.get(i).addView(makeImage(Numbers.get(Integer.valueOf(String.valueOf((String.valueOf(intAnswer).charAt(0)))))));
                if(String.valueOf(intAnswer).length()>1){
                    Selecter.get(i).addView(makeImage(Numbers.get(Integer.valueOf(String.valueOf((String.valueOf(intAnswer).charAt(1)))))));
                }
                Selecter.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
                        recreate();
                    }
                });
            }
        }

    }
}


