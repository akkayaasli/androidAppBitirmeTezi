package com.balikesirbitirme.otizmleyasam.mainpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.balikesirbitirme.otizmleyasam.R;
import com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter.MainMenuAdapter;
import com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter.MenuRow;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {
    ArrayList<MenuRow> menuRows=new ArrayList<>();
    Context context=this;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// activity only portrait
        setContentView(R.layout.activity_main_menu);
        Init();
        createArray();
        setRecycler();
    }
    public  void setRecycler(){
        /* Linear tekli kodu
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        manager.scrollToPosition(0);

         */
        GridLayoutManager manager=new GridLayoutManager(context,2,LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        MainMenuAdapter mainMenuAdapter=new MainMenuAdapter(menuRows,context,true);
        recyclerView.setAdapter(mainMenuAdapter);
    }
    public void Init(){
        recyclerView=findViewById(R.id.rcy_main_menu);
    }
    private void createArray(){

        menuRows.add(new MenuRow(context.getString(R.string.strMenu1),R.drawable.main_menu_cizerge1));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu2),R.drawable.main_menu_math2));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu3),R.drawable.pandomim));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu4),R.drawable.main_menu_hikaye4));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu5),R.drawable.main_menu_esleme5));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu6),R.drawable.main_menu_harfkelime6));
        //menuRows.add(new MenuRow(context.getString(R.string.strMenu7),R.drawable.main_menu_tane7));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu8),R.drawable.main_menu_fiiller8));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu9),R.drawable.puzzle_new2));
        menuRows.add(new MenuRow(context.getString(R.string.strMenu10),R.drawable.sound_object_new2));


    }


}
