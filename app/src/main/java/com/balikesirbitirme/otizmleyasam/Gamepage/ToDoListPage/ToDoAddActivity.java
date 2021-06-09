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
        sqLiteDatabase=getApplicationContext().openOrCreateDatabase(TodolistEbeveyn.TODOLİSTDATABASENAME,MODE_PRIVATE,null);
        Activites=new ArrayList<String>();

         timePickerDialog= new TimePickerDialog(ToDoAddActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                txtSaat.setText(hourOfDay+" . "+minute);
            }
        },12,0,true);
       timePickerDialog.setButton(TimePickerDialog.BUTTON_POSITIVE,"Seç",timePickerDialog);
        timePickerDialog.setButton(TimePickerDialog.BUTTON_NEGATIVE,"İptal",timePickerDialog);
        timePickerDialog.setTitle("SAAT");
        timePickerDialog.setCancelable(false);//boşluğa tıklandığında kaybolsun mu?
        timePickerDialog.setIcon(R.drawable.clock);
        timePickerDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Toast.makeText(getApplicationContext(),"Lütfen Saati Seçiniz",Toast.LENGTH_SHORT).show();
            }
        });
        btnSaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timePickerDialog.show();

            }
        });

        try {
            Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+ TodolistEbeveyn.TODOLİSTTABLENAME,null);
            cursor.moveToFirst();



            int columnActivity=cursor.getColumnIndex("activity");
            String flag=cursor.getString(columnActivity);
            Boolean isNull=true;
            try {
                if (!(flag.trim().equals(""))) {//bu kısım sadece aktivite spinnerına koyacak eleman cursorde olmazsa hata verir bundan faydalanarark hata verdiğinde alttaki komudun çalışmaması
                    //ama programın çalışması sağlanabilir buda try catch ile yapılır//Yapılan çalışmada hatanın buradan kaynaklanmadığı bulundu ve bu kısıma dokunulmadı lakin aynı mantık ile
                    // cursor kodları try catch içine alınarak sorun çözüldü.



                    //sqLiteDatabase.rawQuery("SELECT * FROM "+ TodolistEbeveyn.TODOLİSTTABLENAME,null).moveToFirst();


                }
            }catch (Exception e){
                isNull=false;
                Activites.add("Listelenecek eleman bulunamadı. Ebeveyn menüsünden ekleyiniz");
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
                        Toast.makeText(getApplicationContext(),"Lütfen Bir Saat Seçiniz",Toast.LENGTH_SHORT).show();

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
            Toast.makeText(getApplicationContext(),"Öncelikle Ebeveyn Kısmından Aktivite Ekleyiniz",Toast.LENGTH_SHORT).show();
            btnAdd.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.GONE);
        }
    }
}
