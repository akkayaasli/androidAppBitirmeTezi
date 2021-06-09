package com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.balikesirbitirme.otizmleyasam.Gamepage.MathGamePage.MathGameActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.MathGamePage.MathGameActivity2;
import com.balikesirbitirme.otizmleyasam.Gamepage.MimicPage.MimicActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.MoveGamePage.MoveGameActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.PuzzleGamePage.PuzzleGameActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.SoundObjectPage.SoundObjectActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryMenuActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.ToDoListPage.EbeveynMainList;
import com.balikesirbitirme.otizmleyasam.Gamepage.WorldLearn.WordSecondActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.WorldLearn.WorldActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.WorldLearn.WorldMenuActivity;
import com.balikesirbitirme.otizmleyasam.R;
import com.balikesirbitirme.otizmleyasam.mainpage.MainActivity;
import com.balikesirbitirme.otizmleyasam.mainpage.MathActivity;
import com.balikesirbitirme.otizmleyasam.Gamepage.PairingGamePage.PairingActivity;

import java.util.ArrayList;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder> {
    ArrayList<MenuRow> menuRows= new ArrayList<>();
    LayoutInflater inflater;
    Context context;
    boolean isMainMenuActivity;



    int flag=0;

    public MainMenuAdapter(ArrayList<MenuRow> menuRows, Context context,boolean isMAinMenuAdapter) {
        this.menuRows = menuRows;
        this.context = context;
        this.isMainMenuActivity=isMAinMenuAdapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.styl_main_menu_row,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.txtTitle.setText(menuRows.get(position).getStrTitle());
    holder.imgMain.setImageResource(menuRows.get(position).intSrcImage);
    holder.lnl.setTag(holder);

    if(isMainMenuActivity==true){
        final Intent  intent= getMainMenuActivityIntent(position);
        holder.lnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);
            }
        });
        }

        if(isMainMenuActivity==false)
        {
            final Intent  intent= getMathMenuActivityIntent(position);
            holder.lnl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(intent);
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return menuRows.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        ImageView imgMain;
        LinearLayout lnl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txt_main_row);
            imgMain=itemView.findViewById(R.id.img_main_row);
            lnl=itemView.findViewById(R.id.lyt_main_row);

        }

    }
    // burdan sonrası yeni

    private Intent getMathMenuActivityIntent(int position){
        Intent intent = null;
        switch(position) {
            case 0:
                intent = new Intent(context, MathGameActivity.class);
                break;
            case 1:
                intent = new Intent(context, MathGameActivity2.class);
                break;
        }
        return intent;
    }
    private Intent getMainMenuActivityIntent(int position){
        Intent intent = null;
        switch(position){
            case 0:
                 intent= new Intent(context, EbeveynMainList.class);//ebeveyn kısmı ile ilgisi yok kaza ile o isim verildi değiştirilmeye gerek görülmedi
                break;
            case 1:
                intent= new Intent(context, MathActivity.class);
                break;
            case 2:
                intent= new Intent(context, MimicActivity.class);
                break;
            case 3:
                intent= new Intent(context, StoryMenuActivity.class);
                break;
            case 4:
                intent= new Intent(context, PairingActivity.class);
                break;
            case 5:
               // intent= new Intent(context, WorldActivity.class);//tasarlanmadı
                intent= new Intent(context, WorldMenuActivity.class);//tasarlanmadı
                break;/**
            case 6:
                intent= new Intent(context,MainActivity.class);//tasarlanmadı
                break;**/
            case 6:
                intent= new Intent(context, MoveGameActivity.class);
                break;
            case 7:
                intent= new Intent(context, PuzzleGameActivity.class);
                break;
            case 8:
                intent= new Intent(context, SoundObjectActivity.class);
                break;

        }

        return intent;

    }
}
