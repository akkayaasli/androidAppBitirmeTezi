package com.balikesirbitirme.otizmleyasam.mainpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter.MainMenuAdapter;
import com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter.MenuRow;
import com.balikesirbitirme.otizmleyasam.R;

import java.util.ArrayList;

public class MathActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MenuRow> menuRows=new ArrayList<>();
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_math_game);
        Init();
        createArray();
        setRecycler();
    }

    public void Init(){
        recyclerView=findViewById(R.id.math_recycler);
    }
    private void createArray() {

        menuRows.add(new MenuRow(context.getString(R.string.strMathMenu1), R.drawable.sayitamam));
        menuRows.add(new MenuRow(context.getString(R.string.strMathMenu2), R.drawable.nesnesayi));
    }
    public  void setRecycler(){



        GridLayoutManager manager=new GridLayoutManager(context,2, LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        MainMenuAdapter mainMenuAdapter=new MainMenuAdapter(menuRows,context,false);
        recyclerView.setAdapter(mainMenuAdapter);
    }
}
