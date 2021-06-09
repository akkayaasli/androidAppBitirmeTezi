package com.balikesirbitirme.otizmleyasam.Gamepage.SoundObjectPage;

import androidx.appcompat.app.AppCompatActivity;

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

public class SoundObjectActivity extends AppCompatActivity {
    ImageView imgMain;
    Button btnSelect1,btnSelect2,btnSelect3,btnSelect4;
    List<SoundObjectCard> SoundObjects=new ArrayList<SoundObjectCard>();
    Button[] Selecter=new Button[4];
    Random rnd=new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_sound_object);

        Init();
        startScane();
    }
    private void Init(){
        imgMain=findViewById(R.id.img_sound_object);
        btnSelect1=findViewById(R.id.btn_sound_object_select1);
        btnSelect2=findViewById(R.id.btn_sound_object_select2);
        btnSelect3=findViewById(R.id.btn_sound_object_select3);
        btnSelect4=findViewById(R.id.btn_sound_object_select4);

        SoundObjects.add(new SoundObjectCard("Ağaç","Agac.mp3",R.drawable.soundagac));
        SoundObjects.add(new SoundObjectCard("Ambulans","Ambulans.mp3",R.drawable.soundambulance));
        SoundObjects.add(new SoundObjectCard("Araba","Araba.mp3",R.drawable.araba));
        SoundObjects.add(new SoundObjectCard("Ayva","Ayva.mp3",R.drawable.soundayva));
        SoundObjects.add(new SoundObjectCard("Bağlama","Baglama.mp3",R.drawable.soundbaglama));
        SoundObjects.add(new SoundObjectCard("Balık","Balik.mp3",R.drawable.soundbalik));
        SoundObjects.add(new SoundObjectCard("Balon","Balon.mp3",R.drawable.soundbalon));
        SoundObjects.add(new SoundObjectCard("Bardak","Bardak.mp3",R.drawable.soundglass));
        SoundObjects.add(new SoundObjectCard("Bebek","Bebek.mp3",R.drawable.soundbaby));
        SoundObjects.add(new SoundObjectCard("Ceket","Ceket.mp3",R.drawable.soundjacket));
        SoundObjects.add(new SoundObjectCard("Cekirge","Cekirge.mp3",R.drawable.soundcekirge));
        SoundObjects.add(new SoundObjectCard("Cetvel","Cetvel.mp3",R.drawable.soundruler));
        SoundObjects.add(new SoundObjectCard("Ceviz","Ceviz.mp3",R.drawable.soundceviz));
        SoundObjects.add(new SoundObjectCard("Çita","Cita.mp3",R.drawable.soundcita));
        SoundObjects.add(new SoundObjectCard("Civciv","Civciv.mp3",R.drawable.soundcivciv));
        SoundObjects.add(new SoundObjectCard("Davul","Davul.mp3",R.drawable.sounddavul));
        SoundObjects.add(new SoundObjectCard("Deve","Deve.mp3",R.drawable.sounddeve));
        SoundObjects.add(new SoundObjectCard("Dinazor","Dinozor.mp3",R.drawable.sounddino));
        SoundObjects.add(new SoundObjectCard("Domates","Domates.mp3",R.drawable.soundtomato));
        SoundObjects.add(new SoundObjectCard("Ekmek","Ekmek.mp3",R.drawable.soundbread));
        SoundObjects.add(new SoundObjectCard("Elbise","Elbise.mp3",R.drawable.sounddress));
        SoundObjects.add(new SoundObjectCard("Eldiven","Eldiven.mp3",R.drawable.soundgloves));
        SoundObjects.add(new SoundObjectCard("Elma","Elma.mp3",R.drawable.soundelma));
        SoundObjects.add(new SoundObjectCard("Eşek","Eşek.mp3",R.drawable.sounddonkey));
        SoundObjects.add(new SoundObjectCard("Fasulye","Fasulye.mp3",R.drawable.soundbeans));
        SoundObjects.add(new SoundObjectCard("Fil","Fil.mp3",R.drawable.soundelephand));
        SoundObjects.add(new SoundObjectCard("Fındık","Fındık.mp3",R.drawable.soundhazelnuts));
        SoundObjects.add(new SoundObjectCard("Fırça","Fırça.mp3",R.drawable.soundfirca));
        SoundObjects.add(new SoundObjectCard("Gemi","Gemi.mp3",R.drawable.soundgemi));
        SoundObjects.add(new SoundObjectCard("Geyik","Geyik.mp3",R.drawable.sounddeer));
        SoundObjects.add(new SoundObjectCard("Gitar","Gitar.mp3",R.drawable.soundguitar));
        SoundObjects.add(new SoundObjectCard("Gözlük","Gözlük.mp3",R.drawable.soundgozluk));
        SoundObjects.add(new SoundObjectCard("Halı","Halı.mp3",R.drawable.soundcarpet));
        SoundObjects.add(new SoundObjectCard("Havuç","Havuç.mp3",R.drawable.soundcarrot));
        SoundObjects.add(new SoundObjectCard("İnek","Inek.mp3",R.drawable.sountcow));
        SoundObjects.add(new SoundObjectCard("İp","Ip.mp3",R.drawable.soundrope));
        SoundObjects.add(new SoundObjectCard("Irmak","Irmak.mp3",R.drawable.soundriver));
        SoundObjects.add(new SoundObjectCard("Ispanak","Ispanak.mp3",R.drawable.soundispanak));
        SoundObjects.add(new SoundObjectCard("İtfaye","Itfaye.mp3",R.drawable.sounditfaye));
        SoundObjects.add(new SoundObjectCard("Işık","Işık.mp3",R.drawable.soundlight));
        SoundObjects.add(new SoundObjectCard("Jaguar","Jaguar.mp3",R.drawable.soundjaguar));
        SoundObjects.add(new SoundObjectCard("Jet","Jet.mp3",R.drawable.soundjet));
        SoundObjects.add(new SoundObjectCard("Jeton","Jeton.mp3",R.drawable.soundtoken));
        SoundObjects.add(new SoundObjectCard("Kamyon","Kamyon.mp3",R.drawable.soundkamyon));
        SoundObjects.add(new SoundObjectCard("Karpuz","Karpuz.mp3",R.drawable.soundmelon));
        SoundObjects.add(new SoundObjectCard("Kiraz","Kiraz.mp3",R.drawable.sountkiraz));
        SoundObjects.add(new SoundObjectCard("Kitaplık","Kitaplık.mp3",R.drawable.soundbook));
        SoundObjects.add(new SoundObjectCard("Kurbağa","Kurbağa.mp3",R.drawable.soundfrog));
        SoundObjects.add(new SoundObjectCard("Lale","Lale.mp3",R.drawable.soundlale));
        SoundObjects.add(new SoundObjectCard("Limon","Limon.mp3",R.drawable.soundlemon));
        SoundObjects.add(new SoundObjectCard("Makas","Makas.mp3",R.drawable.soundmakas));
        SoundObjects.add(new SoundObjectCard("Mantar","Mantar.mp3",R.drawable.soundmantar));
        SoundObjects.add(new SoundObjectCard("Muz","Muz.mp3",R.drawable.soundbanana));
        SoundObjects.add(new SoundObjectCard("Nal","Nal.mp3",R.drawable.soundnal));
        SoundObjects.add(new SoundObjectCard("Nar","Nar.mp3",R.drawable.soundnar));
        SoundObjects.add(new SoundObjectCard("Nilüfer","Nilüfer.mp3",R.drawable.soundnilu));
        SoundObjects.add(new SoundObjectCard("Nota","Nota.mp3",R.drawable.soundnota));
        SoundObjects.add(new SoundObjectCard("Okul","Okul.mp3",R.drawable.soundschool));
        SoundObjects.add(new SoundObjectCard("Olta","Olta.mp3",R.drawable.soundrod));
        SoundObjects.add(new SoundObjectCard("Onluk", "Onluk.mp3",R.drawable.soundonluk));
        SoundObjects.add(new SoundObjectCard("Ot","Ot.mp3",R.drawable.soundweed));
        SoundObjects.add(new SoundObjectCard("Otobüs","Otobus.mp3",R.drawable.soundbus));
        SoundObjects.add(new SoundObjectCard("Oyuncak","Oyuncak.mp3",R.drawable.soundtoy));
        SoundObjects.add(new SoundObjectCard("Patlıcan", "Patlican.mp3",R.drawable.soundpatli));
        SoundObjects.add(new SoundObjectCard("Pırasa", "Pirasa.mp3",R.drawable.soundleek));
        SoundObjects.add(new SoundObjectCard("Rende","Rende.mp3",R.drawable.soundrende));
        SoundObjects.add(new SoundObjectCard("Robot","Robot.mp3",R.drawable.soundrobot));
        SoundObjects.add(new SoundObjectCard("Roket","Roket.mp3",R.drawable.soundrocket));
        SoundObjects.add(new SoundObjectCard("Sincap","Sincap.mp3",R.drawable.soundsincap));
        SoundObjects.add(new SoundObjectCard("soğan","Sogan.mp3",R.drawable.soundonion));
        SoundObjects.add(new SoundObjectCard("Tavuk","Tavuk.mp3",R.drawable.soundtavuk));
        SoundObjects.add(new SoundObjectCard("Tavşan", "Tavsan.mp3",R.drawable.soundrabit));
        SoundObjects.add(new SoundObjectCard("Telefon","Telefon.mp3",R.drawable.soundphone));
        SoundObjects.add(new SoundObjectCard("Top","Top.mp3",R.drawable.soundball));
        SoundObjects.add(new SoundObjectCard("Uğur Böceği","UgurBöcegi.mp3",R.drawable.soundlady));
        SoundObjects.add(new SoundObjectCard("Un","Un.mp3",R.drawable.soundhamur));
        SoundObjects.add(new SoundObjectCard("Uçak", "Ucak.mp3",R.drawable.soundfly));
        SoundObjects.add(new SoundObjectCard("Uçurtma", "Ucurtma.mp3",R.drawable.soundkite));
        SoundObjects.add(new SoundObjectCard("Vatoz Balığı","VatozBaligi.mp3",R.drawable.soundvatoz5));
        SoundObjects.add(new SoundObjectCard("Vazo","vazo.mp3",R.drawable.soundvase));
        SoundObjects.add(new SoundObjectCard("Yay","Yay.mp3",R.drawable.soundbow));
        SoundObjects.add(new SoundObjectCard("Yengeç", "Yengec.mp3",R.drawable.soundyengec));
        SoundObjects.add(new SoundObjectCard("Yılan","Yılan.mp3",R.drawable.soundsnake));
        SoundObjects.add(new SoundObjectCard("Zebra","Zebra.mp3",R.drawable.soundzebra));
        SoundObjects.add(new SoundObjectCard("Zeytin","Zeytin.mp3",R.drawable.soundolive));
        SoundObjects.add(new SoundObjectCard("Zil", "Zil.mp3",R.drawable.soundbell));
        SoundObjects.add(new SoundObjectCard("Zümrüt", "Zumrut.mp3",R.drawable.soundzumru));
        SoundObjects.add(new SoundObjectCard("Zurafa","Zurafa.mp3",R.drawable.soundgraf));
        SoundObjects.add(new SoundObjectCard("Ördek","Ordek.mp3",R.drawable.soundducks));
        SoundObjects.add(new SoundObjectCard("Örgü","Orgu.mp3",R.drawable.soundorgu));
        SoundObjects.add(new SoundObjectCard("Üzüm","Uzum.mp3",R.drawable.soungrape));

        SoundObjects.add(new SoundObjectCard("Üçgen", "Ucgen.mp3",R.drawable.soundtriangle));
        SoundObjects.add(new SoundObjectCard("Şahin", "Sahin.mp3",R.drawable.soundhawk));
        SoundObjects.add(new SoundObjectCard("Şapka", "Sapka.mp3",R.drawable.soundhat));
        SoundObjects.add(new SoundObjectCard("Şeker", "Seker.mp3",R.drawable.soundsugar));
        SoundObjects.add(new SoundObjectCard("Şemsiye", "Semsiye.mp3",R.drawable.soundumbrella));
        SoundObjects.add(new SoundObjectCard("Şişe", "Sise.mp3",R.drawable.sountbottle));

        Selecter[0]=(btnSelect1);
        Selecter[1]=(btnSelect2);
        Selecter[2]=(btnSelect3);
        Selecter[3]=(btnSelect4);


        for (int i=0;i<20;i++){
            int Core=rnd.nextInt(Selecter.length);
            Button btnFlag=Selecter[Core];
            Selecter[Core]= Selecter[1];
            Selecter[1]=btnFlag;

        }






    }
    private void startScane(){

        final int Core=rnd.nextInt(SoundObjects.size());


        imgMain.setImageResource(SoundObjects.get(Core).getIntImg());
        Selecter[0].setText(SoundObjects.get(Core).getStrName());
        Selecter[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Oldu",Toast.LENGTH_SHORT).show();
                recreate();
            }
        });
        MediaPlayer mP2=new MediaPlayer();
        try {

            AssetFileDescriptor asset = getAssets().openFd( SoundObjects.get(Core).getStrUrl() );
            mP2.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
            mP2.prepare();
            mP2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mP1=new MediaPlayer();

                try {

                    AssetFileDescriptor asset = getAssets().openFd( SoundObjects.get(Core).getStrUrl() );
                    mP1.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                    mP1.prepare();
                    mP1.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        ///////////////////////////////////////////////////////////birbirinden farklı yanlış cevap ekleme kısmı (başka kısımda kullanılacak)

        int Core2=Core,Core3=Core,Core4=Core;
        int[] False=new int[3];
        False[0]=Core;
        False[0]=Core;
        False[0]=Core;

        int intFalseCore =rnd.nextInt(SoundObjects.size());
        for (int i=1;i<4;i++){
            while ((intFalseCore==Core)||(intFalseCore==False[0])||(intFalseCore==False[1])||(intFalseCore==False[2])){
                intFalseCore =rnd.nextInt(SoundObjects.size());
            }
            False[i-1]=intFalseCore;


            Selecter[i].setText(SoundObjects.get(intFalseCore).getStrName());
            Selecter[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Yanlış",Toast.LENGTH_SHORT).show();
                    MediaPlayer mP1=new MediaPlayer();

                    try {

                        AssetFileDescriptor asset = getAssets().openFd( SoundObjects.get(Core).getStrUrl() );
                        mP1.setDataSource( asset.getFileDescriptor(), asset.getStartOffset(), asset.getLength() );
                        mP1.prepare();
                        mP1.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

    }
}
