package com.balikesirbitirme.otizmleyasam.Gamepage.MathGamePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import java.util.ArrayList;
import java.util.Random;

public class MathGameActivity2 extends AppCompatActivity {
    LinearLayout lnlObject;
    LinearLayout lnlNumber;
    int intRandom=0;
    int intMaxNumber=8;
    ArrayList<Integer> Numbers=new ArrayList<>();
    ArrayList<ImageView> Selecter=new ArrayList<>();
    int randomSelecter;
    String strSelecter="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_math_game3);
        Init();
        startScane();
    }
    private void Init(){
        lnlNumber=findViewById(R.id.img_math_esle_number);
        lnlObject=findViewById(R.id.img_math_esle_object);

        setNumbers();


        for (int i=0;i<4;i++){
            ImageView imageView=new ImageView(getApplicationContext());
            imageView.setPadding(10,10,10,10);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_SHORT).show();
                }
            });
            Selecter.add(imageView);
        }


        getRandom();

    }
    private void setNumbers(){

        Numbers.add(0);
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
    private void getRandom(){
        Random rnd=new Random();
        while(intRandom==0)
            intRandom=rnd.nextInt(intMaxNumber);

        randomSelecter=rnd.nextInt(4);

    }
    private void startScane(){
        for (int i=0;i<intRandom;i++){
            ImageView imageView=new ImageView(getApplicationContext());
            imageView.setImageResource(R.drawable.fruit);
            imageView.setPadding(10,10,10,10);
            lnlObject.addView(imageView);
        }

        for (int i=0;i<4;i++){

            if (i!=randomSelecter)
                Selecter.get(i).setImageResource(Numbers.get(getRandomImage()));
            else{
                Selecter.get(i).setImageResource(Numbers.get(intRandom));
                Selecter.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
                        recreate();
                    }
                });
            }
            lnlNumber.addView(Selecter.get(i));

        }
    }
    private int getRandomImage(){
        Random rnd=new Random();
        int flag =rnd.nextInt(intMaxNumber-1)+1;
        while(flag==intRandom||strSelecter.equals(flag)){
            flag =rnd.nextInt(intMaxNumber-1)+1;

        }

        strSelecter=strSelecter + String.valueOf(flag);
        return flag;

    }


}

