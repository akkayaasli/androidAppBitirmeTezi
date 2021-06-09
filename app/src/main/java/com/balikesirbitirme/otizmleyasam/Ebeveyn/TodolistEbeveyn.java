package com.balikesirbitirme.otizmleyasam.Ebeveyn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import java.util.ArrayList;
import java.util.List;

public class TodolistEbeveyn extends AppCompatActivity {
    private ListView listView;
    private Button btnadd;
    final public static String TODOLİSTDATABASENAME="todolistdatabase";
    final public static String TODOLİSTTABLENAME="todolisttable";
    SQLiteDatabase sqLiteDatabase;
    List<String> Activites;

    EditText edActivity;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_todolist_ebeveyn);

        Activites=new ArrayList<String>();
        listView=findViewById(R.id.ebeveyn_menu_todolist_list);
        btnadd=findViewById(R.id.btn_todolist_addnewEvent);
        edActivity=findViewById(R.id.ed_ectivity);
        sqLiteDatabase= getApplicationContext().openOrCreateDatabase(TODOLİSTDATABASENAME,MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS " +TODOLİSTTABLENAME+  " (activity VARCHAR)");

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(edActivity.getText().toString().trim().equals("")))//boşluk kontrolü
                {


                    sqLiteDatabase.execSQL("INSERT INTO "+ TODOLİSTTABLENAME+ " (activity) VALUES ('"+ edActivity.getText().toString() +"')");
                    reload();
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                sqLiteDatabase.execSQL("DELETE FROM "+TODOLİSTTABLENAME +"  WHERE activity='" +Activites.get(position)+"'");
                reload();
                return false;
            }
        });
        reload();
    }
    public void reload(){
        listView.setAdapter(null);
        Activites.clear();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM "+TODOLİSTTABLENAME,null );
        int column=cursor.getColumnIndex("activity");
        while (cursor.moveToNext()){
            Activites.add(cursor.getString(column));
        }
        cursor.close();
        //Toast.makeText(getApplicationContext(),Activites.get(0),Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, Activites){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);


                textView.setTextColor(getResources().getColor(R.color.colorTextMain));
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setTextSize(40);
                textView.setBackground(getResources().getDrawable(R.drawable.styl_main_start_btn));
                return view;
            }

        };

        listView.setAdapter(adapter);


    }
}
