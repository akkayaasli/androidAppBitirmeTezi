package com.balikesirbitirme.otizmleyasam.Gamepage.ToDoListPage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.TimePickerDialog;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.Ebeveyn.EbeveynMenu;
import com.balikesirbitirme.otizmleyasam.Ebeveyn.TodolistEbeveyn;
import com.balikesirbitirme.otizmleyasam.R;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ToDoAddActivity extends AppCompatActivity {
    private Button btnSaat,btnAdd;
    EditText edNote;
    TextView txtSaat;
    TimePickerDialog timePickerDialog;
    private SQLiteDatabase sqLiteDatabase;
    Spinner spinner;
    List<String> Activites;
    final static String EVENT_TABLE_NAME="tablomtrak";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_to_do_add);

        btnSaat=findViewById(R.id.seleck_clock);
        btnAdd=findViewById(R.id.btn_todolist_add_add);
        edNote=findViewById(R.id.ed_note);
        txtSaat=findViewById(R.id.txtsaat);
        spinner=findViewById(R.id.spinner);
        sqLiteDatabase=getApplicationContext().openOrCreateDatabase(TodolistEbeveyn.TODOLÄ°STDATABASENAME,MODE_PRIVATE,null);
        Activites=new ArrayList<String>();

         timePickerDialog= new TimePickerDialog(ToDoAddActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                txtSaat.setText(hourOfDay+" . "+minute);
            }
        },12,0,true);
       timePickerDialog.setButton(TimePickerDialog.BUTTON_POSITIVE,"SeÃ§",timePickerDialog);
        timePickerDialog.setButton(TimePickerDialog.BUTTON_NEGATIVE,"Ä°ptal",timePickerDialog);
        timePickerDialog.setTitle("SAAT");
        timePickerDialog.setCancelable(false);//boÅluÄa tÄ±klandÄ±ÄÄ±nda kaybolsun mu?
        timePickerDialog.setIcon(R.drawable.clock);
        timePickerDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Toast.makeText(getApplicationContext(),"LÃ¼tfen Saati SeÃ§iniz",Toast.LENGTH_SHORT).show();
            }
        });
        btnSaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timePickerDialog.show();

            }
        });

        try {
            Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+ TodolistEbeveyn.TODOLÄ°STTABLENAME,null);
            cursor.moveToFirst();



            int columnActivity=cursor.getColumnIndex("activity");
            String flag=cursor.getString(columnActivity);
            Boolean isNull=true;
            try {
                if (!(flag.trim().equals(""))) {//bu kÄ±sÄ±m sadece aktivite spinnerÄ±na koyacak eleman cursorde olmazsa hata verir bundan faydalanarark hata verdiÄinde alttaki komudun Ã§alÄ±ÅmamasÄ±
                    //ama programÄ±n Ã§alÄ±ÅmasÄ± saÄlanabilir buda try catch ile yapÄ±lÄ±r//YapÄ±lan Ã§alÄ±Åmada hatanÄ±n buradan kaynaklanmadÄ±ÄÄ± bulundu ve bu kÄ±sÄ±ma dokunulmadÄ± lakin aynÄ± mantÄ±k ile
                    // cursor kodlarÄ± try catch iÃ§ine alÄ±narak sorun Ã§Ã¶zÃ¼ldÃ¼.



                    //sqLiteDatabase.rawQuery("SELECT * FROM "+ TodolistEbeveyn.TODOLÄ°STTABLENAME,null).moveToFirst();


                }
            }catch (Exception e){
                isNull=false;
                Activites.add("Listelenecek eleman bulunamadÄ±. Ebeveyn menÃ¼sÃ¼nden ekleyiniz");
            }

            if (isNull){
                try {

                    while (cursor.moveToNext()) {


                        Activites.add(cursor.getString(columnActivity));
                        //Toast.makeText(getApplicationContext(),String.valueOf(Activites.size()),Toast.LENGTH_SHORT).show();


                    }


                }catch (Exception e){}
            }
            cursor.close();

            ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,Activites);
            spinner.setAdapter(arrayAdapter);
            spinner.setSelection(0);


            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(txtSaat.getText().toString().trim().equals(""))
                        Toast.makeText(getApplicationContext(),"LÃ¼tfen Bir Saat SeÃ§iniz",Toast.LENGTH_SHORT).show();

                    else
                    {
                        String strSaat=txtSaat.getText().toString();
                        String strActivityt=spinner.getSelectedItem().toString();
                        String strNote=edNote.getText().toString();
                        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+ EVENT_TABLE_NAME +" (activity VARCHAR , saat VARCHAR , note VARCHAR)");
                        sqLiteDatabase.execSQL("INSERT INTO "+ EVENT_TABLE_NAME+ " (activity,saat, note) VALUES ('"+strActivityt +"','"+strSaat +"','"+strNote +"')");
                        edNote.setText("");
                    }
                }
            });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Ãncelikle Ebeveyn KÄ±smÄ±ndan Aktivite Ekleyiniz",Toast.LENGTH_SHORT).show();
            btnAdd.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.GONE);
        }
    }
}
