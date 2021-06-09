package com.balikesirbitirme.otizmleyasam.Gamepage.ToDoListPage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class ToDoAdaptor extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<ActivityObject> events;
    Activity activity;

    public ToDoAdaptor(Activity activity,List<ActivityObject> events) {
        layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.activity=activity;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View satır=layoutInflater.inflate(R.layout.custom_to_do_list_row,null);
        CircleImageView imcIcon=satır.findViewById(R.id.imc_row_icon_to_do);
        TextView txtSaat=satır.findViewById(R.id.txt_to_do_row_saat);
        TextView txtActivity=satır.findViewById(R.id.txt_to_do_row_activity);

        int[] icons= new int[5];
        icons[0]=R.drawable.star1;
        icons[1]=R.drawable.star2;
        icons[2]=R.drawable.star3;
        icons[3]=R.drawable.star4;
        icons[4]=R.drawable.star5;

        Random rnd=new Random();
        imcIcon.setImageResource(icons[rnd.nextInt(5)]);
        txtSaat.setText(events.get(position).getStrSaat());
        txtActivity.setText(events.get(position).getStrActivity());

        imcIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),events.get(position).getStrNote(),Toast.LENGTH_LONG).show();
            }
        });

        return satır;
    }
}
