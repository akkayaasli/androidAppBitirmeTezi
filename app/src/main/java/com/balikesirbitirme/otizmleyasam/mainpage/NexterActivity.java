package com.balikesirbitirme.otizmleyasam.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.balikesirbitirme.otizmleyasam.R;

public class NexterActivity extends AppCompatActivity {

    ImageView imgChildren;
    TextView txtBigChildren;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_nexter);

        Init();
    }

    public void Init(){
        imgChildren=findViewById(R.id.img_next_child);
        txtBigChildren=findViewById(R.id.txt_nexter_bigchild);

        setEvents();

    }
    public void setEvents(){
        imgChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }
        });
        txtBigChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BigChildrenActivity.class);
                startActivity(intent);
            }
        });
    }
}
