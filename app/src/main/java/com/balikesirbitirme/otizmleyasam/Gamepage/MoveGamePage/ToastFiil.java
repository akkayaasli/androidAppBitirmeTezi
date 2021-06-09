package com.balikesirbitirme.otizmleyasam.Gamepage.MoveGamePage;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import pl.droidsonroids.gif.GifImageView;

public class ToastFiil {



    Toast toast;
    View view;
    TextView textView;
    GifImageView gif;


    public ToastFiil(Context Main){
        LayoutInflater inflater = (LayoutInflater) Main.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        toast=new Toast(Main);
        view= inflater.inflate(R.layout.custom_toast,null);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER,0,-900);

        gif=view.findViewById(R.id.gif);
        textView=view.findViewById(R.id.txt_message);
    }
        public void Show(Direction type){
            switch (type){
                case LOCATİON_UP:
                    gif.setImageResource(R.drawable.down_directions);
                    textView.setText(R.string.down);
                    break;
                case LOCATİON_DOWN:
                    gif.setImageResource(R.drawable.up_directions);
                    textView.setText(R.string.up);
                    break;
                case LOCATION_RIGHT:
                    gif.setImageResource(R.drawable.right_directions);
                    textView.setText(R.string.right);
                    break;
                case LOCATION_LEFT:
                    gif.setImageResource(R.drawable.left_directions);
                    textView.setText(R.string.left);
                    break;
            }
            toast.show();
        }
}
