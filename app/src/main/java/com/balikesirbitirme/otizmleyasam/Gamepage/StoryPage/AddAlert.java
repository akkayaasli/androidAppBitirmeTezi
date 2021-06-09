package com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter.Story;
import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter.StoryDb;
import com.balikesirbitirme.otizmleyasam.R;

import java.util.Random;
import java.util.RandomAccess;

import io.realm.Realm;

public class AddAlert {
    private AlertDialog dialog;
    private EditText edStoryName;
    private Button btnStoryAdd;
    private Button btnSelectSound;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;
    private Activity activity;
    private View view;
    Realm realm;
    int nextidreturn;

    public AddAlert(Activity activity) {
        this.activity = activity;
        builder = new AlertDialog.Builder(this.activity);
        builder.setTitle("");
        inflater=activity.getLayoutInflater();
        view =inflater.inflate(R.layout.add_story_alert,null);
        Init();
        addRealm();
        builder.setView(view);

    }
    private void Init(){
        btnSelectSound=view.findViewById(R.id.btn_storyalert_select_sound);
        btnStoryAdd=view.findViewById(R.id.btn_storyalert_add);
        edStoryName=view.findViewById(R.id.btn_storyalert_name);

        setEvents();
    }
    public void show(){
        dialog=builder.create();
        dialog.show();
    }



    private void setEvents(){
       // activity.startActivityForResult();
        btnSelectSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectMusic();

            }
        });
        btnStoryAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(activity.getBaseContext(),Story.SoundString,Toast.LENGTH_LONG).show();
                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        StoryDb story=realm.createObject(StoryDb.class);
                        Number maxId = realm.where(StoryDb.class).max("intStoryID");
                        int nextId;//bir sonraki ıd yi almak için
                        if(maxId == null)
                        {
                            nextId = 0;//max id boş ise 1 den başla
                        } else {
                            nextId = maxId.intValue();
                            nextId++;
                            //değilse max id yi bir arttır.
                        }
                        story.setIntStoryID(nextId);
                        story.setStrStoryAdi(edStoryName.getText().toString());
                        story.setFileDescriptor(Story.SoundString);

                        int[] imgStory=new int[35];
                        imgStory[0]=R.drawable.hikaye1_new;
                        imgStory[1]=R.drawable.hikaye2_new;
                        imgStory[2]=R.drawable.hikaye3_new;
                        imgStory[3]=R.drawable.hikaye4_new;
                        imgStory[4]=R.drawable.hikaye5_new;
                        imgStory[5]=R.drawable.hikaye6_new;
                        imgStory[6]=R.drawable.hikaye7_new;
                        imgStory[7]=R.drawable.hikaye8_new;
                        imgStory[8]=R.drawable.hikaye9_new;
                        imgStory[9]=R.drawable.hikaye10_new;
                        imgStory[10]=R.drawable.hikaye11_new;
                        imgStory[11]=R.drawable.hikaye12_new;
                        imgStory[12]=R.drawable.hikaye13_new;
                        imgStory[13]=R.drawable.hikaye14_new;
                        imgStory[14]=R.drawable.hikaye15_new;
                        imgStory[15]=R.drawable.hikaye16_new;
                        imgStory[16]=R.drawable.hikaye17_new;
                        imgStory[17]=R.drawable.hikaye18_new;
                        imgStory[18]=R.drawable.hikaye19_new;
                        imgStory[19]=R.drawable.hikaye20_new;
                        imgStory[20]=R.drawable.hikaye21_new;
                        imgStory[21]=R.drawable.hikaye22_new;
                        imgStory[22]=R.drawable.hikaye23_new;
                        imgStory[23]=R.drawable.hikaye24_new;
                        imgStory[24]=R.drawable.hikaye25_new;
                        imgStory[25]=R.drawable.hikaye26_new;
                        imgStory[26]=R.drawable.hikaye27_new;
                        imgStory[27]=R.drawable.hikaye28_new;
                        imgStory[28]=R.drawable.hikaye29_new;
                        imgStory[29]=R.drawable.hikaye30_new;
                        imgStory[30]=R.drawable.hikaye31_new;
                        imgStory[31]=R.drawable.hikaye32_new;
                        imgStory[32]=R.drawable.hikaye33_new;
                        imgStory[33]=R.drawable.hikaye34_new;
                        imgStory[34]=R.drawable.hikaye35_new;

                        Random rnd=new Random();
                        story.setIntStoryImageURI(imgStory[rnd.nextInt(imgStory.length)]);

                        // burada kaldın story.
                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(activity.getBaseContext(),"Hikaye eklendi",Toast.LENGTH_SHORT).show();
                    }
                });
                activity.recreate();
                dialog.dismiss();

            }
        });


    }
    private void selectMusic(){

        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        //Intent.ACTION_PICK İLE SEÇTİĞİN MÜZİK TUTULUR YANİ URİSİ MÜZİK OLMAK ZORUNDA DEĞİL RESİMDE TUTAR
        //MediaStore.Audio.Media.EXTERNAL_CONTENT_URI TELEFONDAKİ MÜZİK DOSYALARINI AL EKRANA KOY.
        activity.startActivityForResult(intent, Story.PERMİSSİON_SONG);

    }
    private void addRealm(){
        realm= Realm.getDefaultInstance();
    }




}
