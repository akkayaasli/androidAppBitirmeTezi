package com.balikesirbitirme.otizmleyasam.Gamepage.WorldLearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.balikesirbitirme.otizmleyasam.R;

import java.io.IOException;

public class WordSecondActivity extends AppCompatActivity {
    Button btn_harfKelimeCumle_A,btn_harfKelimeCumle_B,btn_harfKelimeCumle_C,btn_harfKelimeCumle_D;
    Button btn_harfKelimeCumle_E,btn_harfKelimeCumle_F,btn_harfKelimeCumle_G,btn_harfKelimeCumle_H;
    Button btn_harfKelimeCumle_I,btn_harfKelimeCumle_J,btn_harfKelimeCumle_K,btn_harfKelimeCumle_L;
    Button btn_harfKelimeCumle_M,btn_harfKelimeCumle_N,btn_harfKelimeCumle_O,btn_harfKelimeCumle_P;
    Button btn_harfKelimeCumle_R,btn_harfKelimeCumle_S,btn_harfKelimeCumle_T,btn_harfKelimeCumle_U;
    Button btn_harfKelimeCumle_V,btn_harfKelimeCumle_Y,btn_harfKelimeCumle_Z;
    MediaPlayer mP1,mP2,mP3,mP4,mP5,mP6,mP7,mP8,mP9,mP10,mP11,mP12,mP13,mP14,mP15,mP16,mP17,mP18,mP19,mP20,mP21,mP22,mP23;
    AssetFileDescriptor asset;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_word_second);

        tanimla();

        clickEvent();

    }

    public void tanimla()
    {
        btn_harfKelimeCumle_A = findViewById( R.id.btn_harfKelimeCumle_A1);
        btn_harfKelimeCumle_B = findViewById( R.id.btn_harfKelimeCumle_B1);
        btn_harfKelimeCumle_C = findViewById( R.id.btn_harfKelimeCumle_C1);
        btn_harfKelimeCumle_D = findViewById( R.id.btn_harfKelimeCumle_D1);
        btn_harfKelimeCumle_E = findViewById( R.id.btn_harfKelimeCumle_E1);
        btn_harfKelimeCumle_F = findViewById( R.id.btn_harfKelimeCumle_F1);
        btn_harfKelimeCumle_G = findViewById( R.id.btn_harfKelimeCumle_G1);
        btn_harfKelimeCumle_H = findViewById( R.id.btn_harfKelimeCumle_H1);
        btn_harfKelimeCumle_I = findViewById( R.id.btn_harfKelimeCumle_I1);
        btn_harfKelimeCumle_J = findViewById( R.id.btn_harfKelimeCumle_J1);
        btn_harfKelimeCumle_K = findViewById( R.id.btn_harfKelimeCumle_K1);
        btn_harfKelimeCumle_L = findViewById( R.id.btn_harfKelimeCumle_L1);
        btn_harfKelimeCumle_M = findViewById( R.id.btn_harfKelimeCumle_M1);
        btn_harfKelimeCumle_N = findViewById( R.id.btn_harfKelimeCumle_N1);
        btn_harfKelimeCumle_O = findViewById( R.id.btn_harfKelimeCumle_O1);
        btn_harfKelimeCumle_P = findViewById( R.id.btn_harfKelimeCumle_P1);
        btn_harfKelimeCumle_R = findViewById( R.id.btn_harfKelimeCumle_R1);
        btn_harfKelimeCumle_S = findViewById( R.id.btn_harfKelimeCumle_S1);
        btn_harfKelimeCumle_T = findViewById( R.id.btn_harfKelimeCumle_T1);
        btn_harfKelimeCumle_U = findViewById( R.id.btn_harfKelimeCumle_U1);
        btn_harfKelimeCumle_V = findViewById( R.id.btn_harfKelimeCumle_V1);
        btn_harfKelimeCumle_Y = findViewById( R.id.btn_harfKelimeCumle_Y1);
        btn_harfKelimeCumle_Z = findViewById( R.id.btn_harfKelimeCumle_Z1);
        image=findViewById( R.id.image );

    }



    public void agac_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.agac );
        }
        else if(id==2)
        {
            image.setImageResource( R.drawable.agac_two );
        }
        else if(id==3)
        {
            image.setImageResource( R.drawable.agac_tree );
        }
    }
    public void balik_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.balik );
        }
        else
        {
            image.setImageResource( R.drawable.balik_two );
        }
    }
    public void cetvel_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.cetvel );
        }
        else
        {
            image.setImageResource( R.drawable.cetvel_two );
        }
    }
    public void davul_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.davul );
        }
        else
        {
            image.setImageResource( R.drawable.davul_two );
        }
    }
    public void ekmek_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.ekmek );
        }
        else
        {
            image.setImageResource( R.drawable.ekmek_two );
        }
    }
    public void fil_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.fil5 );
        }
        else
        {
            image.setImageResource( R.drawable.fil_two );
        }
    }
    public void gemi_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.gemi5 );
        }
        else
        {
            image.setImageResource( R.drawable.gemi_two );
        }
    }
    public void hali_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.hali );
        }
        else
        {
            image.setImageResource( R.drawable.hali_two );
        }
    }
    public void irmak_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.irmak );
        }
        else
        {
            image.setImageResource( R.drawable.irmak_two );
        }
    }
    public void jet_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.jet );
        }
        else
        {
            image.setImageResource( R.drawable.jet_two );
        }
    }
    public void karpuz_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.karpuz );
        }
        else
        {
            image.setImageResource( R.drawable.karpuz_two );
        }
    }
    public void limon_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.limon );
        }
        else
        {
            image.setImageResource( R.drawable.limon_two );
        }
    }
    public void makas_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.makas );
        }
        else
        {
            image.setImageResource( R.drawable.makas_two );
        }
    }
    public void nar_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.nar );
        }
        else
        {
            image.setImageResource( R.drawable.nar_two );
        }
    }
    public void okul_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.okul );
        }
        else
        {
            image.setImageResource( R.drawable.okul_two );
        }
    }
    public void patlican_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.patlican );
        }
        else
        {
            image.setImageResource( R.drawable.patlican_two);
        }
    }
    public void robot_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.robot );
        }
        else
        {
            image.setImageResource( R.drawable.robot_two );
        }
    }
    public void sincap_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.sincap );
        }
        else
        {
            image.setImageResource( R.drawable.sincap_two );
        }
    }
    public void tavsan_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.tavsan );
        }
        else
        {
            image.setImageResource( R.drawable.tavsan_two );
        }
    }
    public void ucurtma_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.ucurtma );
        }
        else
        {
            image.setImageResource( R.drawable.ucurtma_two );
        }
    }
    public void vapur_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.vapur );
        }
        else
        {
            image.setImageResource( R.drawable.vapur_two );
        }
    }

    public void yengec_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.yengec );
        }
        else
        {
            image.setImageResource( R.drawable.yengec_two );
        }
    }
    public void zurafa_getir(int id)
    {
        if(id==1)
        {
            image.setImageResource( R.drawable.zurafa );
        }
        else
        {
            image.setImageResource( R.drawable.zurafa_two );
        }
    }
    public void clickEvent()
    {


        btn_harfKelimeCumle_A.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                //  mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aharf );
                try {
                    mP1=new MediaPlayer();
                    asset = getAssets().openFd( "Agac.mp3" );
                    mP1.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP1.prepare();
                    mP1.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomAgac=(int)(Math.random()*3+1);//1 den 3 e kadar random id gibi düşündüm.
                System.out.println(randomAgac);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                agac_getir(randomAgac);


            }
        } );

        btn_harfKelimeCumle_B.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP2=new MediaPlayer();
                    asset = getAssets().openFd( "Balik.mp3" );
                    mP2.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP2.prepare();
                    mP2.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomBalik=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomBalik);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                balik_getir(randomBalik);


            }
        } );
        btn_harfKelimeCumle_C.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP3=new MediaPlayer();
                    asset = getAssets().openFd( "Cetvel.mp3" );
                    mP3.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP3.prepare();
                    mP3.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomCetvel=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomCetvel);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                cetvel_getir(randomCetvel);
            }
        } );
        btn_harfKelimeCumle_D.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP4=new MediaPlayer();
                    asset = getAssets().openFd( "Davul.mp3" );
                    mP4.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP4.prepare();
                    mP4.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomDavul=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomDavul);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                davul_getir(randomDavul);
            }
        } );
        btn_harfKelimeCumle_E.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP5=new MediaPlayer();
                    asset = getAssets().openFd( "Ekmek.mp3" );
                    mP5.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP5.prepare();
                    mP5.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomekmek=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomekmek);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                ekmek_getir(randomekmek);
            }
        } );
        btn_harfKelimeCumle_F.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP6=new MediaPlayer();
                    asset = getAssets().openFd( "Fil.mp3" );
                    mP6.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP6.prepare();
                    mP6.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomfil=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomfil);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                fil_getir(randomfil);

            }
        } );
        btn_harfKelimeCumle_G.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP7=new MediaPlayer();
                    asset = getAssets().openFd( "Gemi.mp3" );
                    mP7.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP7.prepare();
                    mP7.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomgemi=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomgemi);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                gemi_getir(randomgemi);
            }
        } );
        btn_harfKelimeCumle_H.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP8=new MediaPlayer();
                    asset = getAssets().openFd( "Halı.mp3" );
                    mP8.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP8.prepare();
                    mP8.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomhali=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomhali);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                hali_getir(randomhali);
            }
        } );
        btn_harfKelimeCumle_I.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP9=new MediaPlayer();
                    asset = getAssets().openFd( "Irmak.mp3" );
                    mP9.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP9.prepare();
                    mP9.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomirmak=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomirmak);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                irmak_getir(randomirmak);
            }
        } );
        btn_harfKelimeCumle_J.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP10=new MediaPlayer();
                    asset = getAssets().openFd( "Jet.mp3" );
                    mP10.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP10.prepare();
                    mP10.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomjet=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomjet);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                jet_getir(randomjet);
            }
        } );
        btn_harfKelimeCumle_K.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP11=new MediaPlayer();
                    asset = getAssets().openFd( "Karpuz.mp3" );
                    mP11.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP11.prepare();
                    mP11.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomkarpuz=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomkarpuz);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                karpuz_getir(randomkarpuz);
            }
        } );
        btn_harfKelimeCumle_L.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP12=new MediaPlayer();
                    asset = getAssets().openFd( "Limon.mp3" );
                    mP12.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP12.prepare();
                    mP12.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomlimon=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomlimon);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                limon_getir(randomlimon);
            }
        } );
        btn_harfKelimeCumle_M.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP13=new MediaPlayer();
                    asset = getAssets().openFd( "Makas.mp3" );
                    mP13.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP13.prepare();
                    mP13.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randommakas=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randommakas);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                makas_getir(randommakas);
            }
        } );
        btn_harfKelimeCumle_N.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP14=new MediaPlayer();
                    asset = getAssets().openFd( "Nar.mp3" );
                    mP14.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP14.prepare();
                    mP14.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomnar=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomnar);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                nar_getir(randomnar);
            }
        } );
        btn_harfKelimeCumle_O.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP15=new MediaPlayer();
                    asset = getAssets().openFd( "Okul.mp3" );
                    mP15.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP15.prepare();
                    mP15.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomokul=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomokul);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                okul_getir(randomokul);
            }
        } );
        btn_harfKelimeCumle_P.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP16=new MediaPlayer();
                    asset = getAssets().openFd( "Patlıcan.mp3" );
                    mP16.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP16.prepare();
                    mP16.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randompatlican=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randompatlican);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                patlican_getir(randompatlican);
            }
        } );
        btn_harfKelimeCumle_R.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP17=new MediaPlayer();
                    asset = getAssets().openFd( "Robot.mp3" );
                    mP17.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP17.prepare();
                    mP17.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomrobot=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomrobot);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                robot_getir(randomrobot);
            }
        } );
        btn_harfKelimeCumle_S.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP18=new MediaPlayer();
                    asset = getAssets().openFd( "Sincap.mp3" );
                    mP18.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP18.prepare();
                    mP18.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomsincap=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomsincap);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                sincap_getir(randomsincap);
            }
        } );
        btn_harfKelimeCumle_T.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP19=new MediaPlayer();
                    asset = getAssets().openFd( "Tavsan.mp3" );
                    mP19.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP19.prepare();
                    mP19.start();



                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomtavsan=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomtavsan);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                tavsan_getir(randomtavsan);
            }
        } );
        btn_harfKelimeCumle_U.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP20=new MediaPlayer();
                    asset = getAssets().openFd( "Ucurtma.mp3" );
                    mP20.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP20.prepare();
                    mP20.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomucurtma=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomucurtma);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                ucurtma_getir(randomucurtma);
            }
        } );
        btn_harfKelimeCumle_V.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP21=new MediaPlayer();
                    asset = getAssets().openFd( "Vapur.mp3" );
                    mP21.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP21.prepare();
                    mP21.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomvapur=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomvapur);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                vapur_getir(randomvapur);
            }
        } );
        btn_harfKelimeCumle_Y.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP22=new MediaPlayer();
                    asset = getAssets().openFd( "Yengec.mp3" );
                    mP22.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP22.prepare();
                    mP22.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomyengec=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomyengec);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                yengec_getir(randomyengec);
            }
        } );
        btn_harfKelimeCumle_Z.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP23=new MediaPlayer();
                    asset = getAssets().openFd( "Zurafa.mp3" );
                    mP23.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP23.prepare();
                    mP23.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int randomzurafa=(int)(Math.random()*2+1);//1 den 2 e kadar random id gibi düşündüm.
                System.out.println(randomzurafa);//Aşağıda çıktıdan hangi resimin geldiğini id lerinden takip etmek için yazıyorum.
                zurafa_getir(randomzurafa);
            }
        } );


    }

}
