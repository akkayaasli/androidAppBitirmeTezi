package com.balikesirbitirme.otizmleyasam.Gamepage.WorldLearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.balikesirbitirme.otizmleyasam.R;

import java.io.IOException;

public class WorldActivity extends AppCompatActivity {
    Button btn_harfKelimeCumle_A,btn_harfKelimeCumle_B,btn_harfKelimeCumle_C,btn_harfKelimeCumle_D;
    Button btn_harfKelimeCumle_E,btn_harfKelimeCumle_F,btn_harfKelimeCumle_G,btn_harfKelimeCumle_H;
    Button btn_harfKelimeCumle_I,btn_harfKelimeCumle_J,btn_harfKelimeCumle_K,btn_harfKelimeCumle_L;
    Button btn_harfKelimeCumle_M,btn_harfKelimeCumle_N,btn_harfKelimeCumle_O,btn_harfKelimeCumle_P;
    Button btn_harfKelimeCumle_R,btn_harfKelimeCumle_S,btn_harfKelimeCumle_T,btn_harfKelimeCumle_U;
    Button btn_harfKelimeCumle_V,btn_harfKelimeCumle_Y,btn_harfKelimeCumle_Z;
    MediaPlayer mP1,mP2,mP3,mP4,mP5,mP6,mP7,mP8,mP9,mP10,mP11,mP12,mP13,mP14,mP15,mP16,mP17,mP18,mP19,mP20,mP21,mP22,mP23;
    AssetFileDescriptor asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_world);

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
                    asset = getAssets().openFd( "aharf.mp3" );
                    mP1.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP1.prepare();
                    mP1.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_B.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP2=new MediaPlayer();
                    asset = getAssets().openFd( "bharf.mp3" );
                    mP2.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP2.prepare();
                    mP2.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } );
        btn_harfKelimeCumle_C.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP3=new MediaPlayer();
                    asset = getAssets().openFd( "charf.mp3" );
                    mP3.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP3.prepare();
                    mP3.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_D.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP4=new MediaPlayer();
                    asset = getAssets().openFd( "d.mp3" );
                    mP4.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP4.prepare();
                    mP4.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_E.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP5=new MediaPlayer();
                    asset = getAssets().openFd( "eharf.mp3" );
                    mP5.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP5.prepare();
                    mP5.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_F.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP6=new MediaPlayer();
                    asset = getAssets().openFd( "f.mp3" );
                    mP6.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP6.prepare();
                    mP6.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_G.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP7=new MediaPlayer();
                    asset = getAssets().openFd( "g.mp3" );
                    mP7.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP7.prepare();
                    mP7.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_H.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP8=new MediaPlayer();
                    asset = getAssets().openFd( "h.mp3" );
                    mP8.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP8.prepare();
                    mP8.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_I.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP9=new MediaPlayer();
                    asset = getAssets().openFd( "ı.mp3" );
                    mP9.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP9.prepare();
                    mP9.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_J.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP10=new MediaPlayer();
                    asset = getAssets().openFd( "j.mp3" );
                    mP10.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP10.prepare();
                    mP10.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_K.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP11=new MediaPlayer();
                    asset = getAssets().openFd( "k.mp3" );
                    mP11.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP11.prepare();
                    mP11.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_L.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP12=new MediaPlayer();
                    asset = getAssets().openFd( "l.mp3" );
                    mP12.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP12.prepare();
                    mP12.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_M.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP13=new MediaPlayer();
                    asset = getAssets().openFd( "m.mp3" );
                    mP13.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP13.prepare();
                    mP13.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_N.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP14=new MediaPlayer();
                    asset = getAssets().openFd( "n.mp3" );
                    mP14.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP14.prepare();
                    mP14.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_O.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP15=new MediaPlayer();
                    asset = getAssets().openFd( "o.mp3" );
                    mP15.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP15.prepare();
                    mP15.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_P.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP16=new MediaPlayer();
                    asset = getAssets().openFd( "p.mp3" );
                    mP16.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP16.prepare();
                    mP16.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_R.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP17=new MediaPlayer();
                    asset = getAssets().openFd( "r.mp3" );
                    mP17.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP17.prepare();
                    mP17.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_S.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP18=new MediaPlayer();
                    asset = getAssets().openFd( "s.mp3" );
                    mP18.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP18.prepare();
                    mP18.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_T.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP19=new MediaPlayer();
                    asset = getAssets().openFd( "t.mp3" );
                    mP19.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP19.prepare();
                    mP19.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_U.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP20=new MediaPlayer();
                    asset = getAssets().openFd( "u.mp3" );
                    mP20.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP20.prepare();
                    mP20.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_V.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP21=new MediaPlayer();
                    asset = getAssets().openFd( "v.mp3" );
                    mP21.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP21.prepare();
                    mP21.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_Y.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP22=new MediaPlayer();
                    asset = getAssets().openFd( "y.mp3" );
                    mP22.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP22.prepare();
                    mP22.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
        btn_harfKelimeCumle_Z.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mP23=new MediaPlayer();
                    asset = getAssets().openFd( "z.mp3" );
                    mP23.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP23.prepare();
                    mP23.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );


    }
}
