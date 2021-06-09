package com.balikesirbitirme.otizmleyasam.Gamepage.ToDoListPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.Ebeveyn.TodolistEbeveyn;
import com.balikesirbitirme.otizmleyasam.R;

import java.util.ArrayList;
import java.util.List;

public class EbeveynMainList extends AppCompatActivity {
    Button btnadd;
    ListView listView;
    List<ActivityObject> events=new ArrayList<ActivityObject>();
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_ebeveyn_main_list);
        btnadd=findViewById(R.id.btn_todolist_add);
        listView=findViewById(R.id.list_activity_main);
        sqLiteDatabase=getApplicationContext().openOrCreateDatabase(TodolistEbeveyn.TODOLİSTDATABASENAME,MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+ ToDoAddActivity.EVENT_TABLE_NAME +" (activity VARCHAR , saat VARCHAR , note VARCHAR)");

        reload();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtSaat=view.findViewById(R.id.txt_to_do_row_saat);
                TextView txtActivity=view.findViewById(R.id.txt_to_do_row_activity);
               // Toast.makeText(getApplicationContext(),txtSaat.getText().toString()+"   "+txtActivity.getText().toString(),Toast.LENGTH_SHORT).show();
                sqLiteDatabase.execSQL("DELETE FROM "+ ToDoAddActivity.EVENT_TABLE_NAME+ " WHERE saat= '"+ txtSaat.getText().toString() +"' AND activity='"+txtActivity.getText().toString()+"'");
                reload();
                return false;
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ToDoAddActivity.class);
                startActivity(intent);


            }
        });


    }
    public void reload(){
        listView.setAdapter(null);
        events.clear();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM "+ToDoAddActivity.EVENT_TABLE_NAME,null );
        int intSaat=cursor.getColumnIndex("saat");
        int intActivity=cursor.getColumnIndex("activity");
        int intNote=cursor.getColumnIndex("note");

        while (cursor.moveToNext()){
            events.add(new ActivityObject(cursor.getString(intActivity),cursor.getString(intSaat),cursor.getString(intNote)));

        }
        cursor.close();
        ToDoAdaptor toDoAdaptor=new ToDoAdaptor(EbeveynMainList.this,events);
        listView.setAdapter(toDoAdaptor);



    }

    @Override
    protected void onResume() {
        super.onResume();
        reload();
    }
}
