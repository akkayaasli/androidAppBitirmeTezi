package com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter.Story;
import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter.StoryAdapter;
import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter.StoryDb;
import com.balikesirbitirme.otizmleyasam.R;
import com.balikesirbitirme.otizmleyasam.mainpage.PasswordAlert;

import io.realm.Realm;
import io.realm.RealmResults;

public class StoryMenuActivity extends AppCompatActivity {
    Context context = this;
    String str;
    Realm realm;
    //ArrayList<Story> stories=new ArrayList<>();
    Button btnStoryAdd;
    RecyclerView recyclerView;
    String strUri;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_story_menu);


        addRealm();
        isPermission();


        Init();//aşağıda init ile tanımladığımız recylerview i çağırdık.Başka bir view olsaydı yine aynı metot kullanılırdı.
        //addList();


        //str=getMusic();

        MediaPlayer player = new MediaPlayer();
        /*try
        {//çalıştı
            //Uri uri= getResources
            player.setDataSource(context,uri);
            player.setAudioStreamType(AudioManager.STREAM_ALARM);
            player.setLooping(true);
            player.prepare();
            player.start();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeAdapter();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {//yukarıdaki permission ekranın gelmesi için izin di.Burasıda kullanıcının işlem yaoması için izin isteme işlemidir.
            case Story.PERMİSSİON_READ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //selectMusic();
                } else {

                    addPermission();
                }
                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Story.PERMİSSİON_SONG:
                if (resultCode == RESULT_OK && data != null) {
                    Uri uriSong = data.getData();
                    strUri = uriSong.toString();
                    Story.SoundString = strUri;

                    //Uri uri= Uri.parse(strUri);
                    //addRealm(uri);
                    // getSongs();
                    //startsong(uriSong);
                }
                break;
        }
    }

    private void isPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            //selectMusic();
        } else {
            addPermission();
        }
    }

    /*private void selectMusic(){
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        //Intent.ACTION_PICK İLE SEÇTİĞİN MÜZİK TUTULUR YANİ URİSİ MÜZİK OLMAK ZORUNDA DEĞİL RESİMDE TUTAR
        //MediaStore.Audio.Media.EXTERNAL_CONTENT_URI TELEFONDAKİ MÜZİK DOSYALARINI AL EKRANA KOY.
        startActivityForResult(intent,Story.PERMİSSİON_SONG);
    }*/
    private void addPermission() {//yukarıda belirttiğimiz izin istenir.BU İŞLEMLER İÇİN MANİFESTTE KODU BELİRTTİK.
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Story.PERMİSSİON_READ);
    }

    private void Init() {
        btnStoryAdd = findViewById(R.id.btn_addnewStory);
        recyclerView = findViewById(R.id.RecylerStory);
        addNewStory();

    }

    private void makeAdapter() {
        recyclerView.removeAllViews();
        LinearLayoutManager manager = new LinearLayoutManager(context);

        manager.scrollToPosition(0);

        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);


        RealmResults<StoryDb> stories = realm.where(StoryDb.class).findAll();

        StoryAdapter storyAdapter = new StoryAdapter(stories, context);
        recyclerView.setAdapter(storyAdapter);

    }


    private void addNewStory() {
        btnStoryAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordAlert passwordAlert=new PasswordAlert(activity,1);
                passwordAlert.show();



            }
        });
    }


    private void addRealm() {
        realm = Realm.getDefaultInstance();
    }


}
