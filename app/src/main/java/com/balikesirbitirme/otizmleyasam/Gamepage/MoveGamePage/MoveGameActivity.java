package com.balikesirbitirme.otizmleyasam.Gamepage.MoveGamePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import java.util.Random;

public class MoveGameActivity extends AppCompatActivity {
    Button btnTouch;
    Context context=this;

    int intScreenX;
    int intScreenY;
    Direction direction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_move_game);

        Init();


    }
    private void Init(){
        btnTouch=findViewById(R.id.btn_touch);

        setDragEvents();
        setGameCircle();
    }

    private void setDragEvents(){
        selectScreenBorder();

        btnTouch.setOnTouchListener(new MyTouchListener());
        btnTouch.setOnDragListener(new MyDragListener());
    }

    private Point getScreenSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }
    private void selectScreenBorder(){
        intScreenX=getScreenSize().x;
        intScreenY=getScreenSize().y;

    }

    private class MyTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if(event.getAction()==MotionEvent.ACTION_DOWN){

                ClipData clipData=ClipData.newPlainText("","");
                View.DragShadowBuilder dragShadowBuilder=new View.DragShadowBuilder(v);
                v.startDrag(clipData,dragShadowBuilder,v,0);
                return true;
            }
            else {
                return false;
            }
        }
    }

    private class MyDragListener implements View.OnDragListener{
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action=event.getAction();
            try {
                if (true){
                    switch (event.getAction())
                    {
                        case DragEvent.ACTION_DRAG_STARTED:
                            break;
                        case DragEvent.ACTION_DROP:

                            View view = (View) event.getLocalState();
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            LinearLayout container = (LinearLayout) v;
                            container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            break;
                        case DragEvent.ACTION_DRAG_ENDED:
                            findViewById(R.id.btn_touch).setX((getScreenSize().x/2-(findViewById(R.id.btn_touch).getWidth()/2)));
                            findViewById(R.id.btn_touch).setY((getScreenSize().y/2-(findViewById(R.id.btn_touch).getHeight()/2)));
                            //btnTouch.setX(event.getX());
                            //btnTouch.setY(event.getY());



                            switch (direction){

                                case LOCATİON_UP:
                                    if (event.getY()>(intScreenY/5)*4)
                                        isVictory(true);
                                    break;
                                case LOCATİON_DOWN:
                                    if (event.getY()<intScreenY/5)
                                        isVictory(true);
                                    break;
                                case LOCATION_LEFT:
                                    if (event.getX()<intScreenX/5)
                                        isVictory(true);
                                    break;
                                case LOCATION_RIGHT:
                                    if (event.getX()>(intScreenX/5)*4)
                                        isVictory(true);
                                    break;
                                    default:
                                        isVictory(false);
                            }





                            /**
                            if (event.getX()<intScreenX/5)
                                Toast.makeText(context,"solda",Toast.LENGTH_SHORT).show();
                            if (event.getX()>(intScreenX/5)*4)
                                Toast.makeText(context,"sağda",Toast.LENGTH_SHORT).show();
                            if (event.getY()<intScreenY/5)
                                Toast.makeText(context,"yukarda",Toast.LENGTH_SHORT).show();
                            if (event.getY()>(intScreenY/5)*4)
                                Toast.makeText(context,"Aşşağıda",Toast.LENGTH_SHORT).show();**/
                            break;


                    }
                }

            }catch (Exception e){}
            return true;

        }
    }

    private Direction randomQuest(){
        Random random = new Random();//random enum metodu
        return Direction.values()[random.nextInt(Direction.values().length)];

    }
    private void setGameCircle(){//enum kullanımı na bak
        Direction level=randomQuest();
        //Toast.makeText(context,level.toString(),Toast.LENGTH_SHORT).show();

        ToastFiil toastFiil=new ToastFiil(getApplicationContext());
        toastFiil.Show(level);
        direction=level;



    }
    private void isVictory(Boolean isVictory){
        //Toast.makeText(context,isVictory.toString(),Toast.LENGTH_SHORT).show();

        if (isVictory) {
            Toast.makeText(getApplicationContext(), "Tebrikler Doğru", Toast.LENGTH_SHORT).show();
            setGameCircle();
        }
        else {
            Toast.makeText(getApplicationContext(),"Malesef Yanlış",Toast.LENGTH_SHORT).show();
        }
    }
    private void setReloadButton(){
        btnTouch.setX(intScreenX/2);
        btnTouch.setY(intScreenY/2);


    }
}
