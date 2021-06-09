package com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter.MainMenuAdapter;
import com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter.MenuRow;
import com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StorySound;
import com.balikesirbitirme.otizmleyasam.R;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter  extends RecyclerView.Adapter<StoryAdapter.ViewHolder>
{//recylerview androidin ana classlarından biridir.Kullanma sebebimiz cardview i istenilen adette basacak.Yerine listview kullanabilirdik.Ama listview daha ilkel artık  kullanılmıyor.
    //extends ler classlar iiçin kullanılır implementler interfaceler için kullnaılır.

    List<StoryDb> stories;
    //verileri arraylistten yani story class dan alacak ve her veri için yeni satır oluşturacak.
    LayoutInflater inflater;
    Context context;



    public StoryAdapter(List<StoryDb> stories, Context context) {//dışardan bir liste çağırırken kullandığımız stories
        this.stories = stories;
        this.context = context;
    }



    class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgStory;
        TextView txtStoryName;
        TextView txtStoryID;
        LinearLayout lylStory;
        //viewholder satırlar için yer tutar.

        public ViewHolder(@NonNull View itemView) {
            super(itemView);//super ilk önce recyler yani kalıtım alınan class da ki aynı isimli metotu çalıştırır sonra bizim yazdığımız viewholder a gelir.
            imgStory=itemView.findViewById(R.id.img_story);
            txtStoryID=itemView.findViewById(R.id.txtStoryID);
            txtStoryName=itemView.findViewById(R.id.txtStoryName);
            lylStory=itemView.findViewById(R.id.lyt_Story);
        }
    }
    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.story_row, parent,false);
        StoryAdapter.ViewHolder viewHolder= new StoryAdapter.ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, final int position) {
        holder.txtStoryName.setText(stories.get(position).getStrStoryAdi());
        holder.txtStoryID.setText(String.valueOf(stories.get(position).getIntStoryID()));
        holder.imgStory.setImageResource(stories.get(position).intStoryImageURI);
        holder.lylStory.setTag(holder);
        holder.lylStory.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(context, StorySound.class);
                intent.putExtra(Story.KEY_İMG,stories.get(position).intStoryImageURI);
                intent.putExtra(Story.KEY_SOUND,stories.get(position).getFileDescriptor());
                context.startActivity(intent);
                //buraya tıklama yazılacak
            }
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }





}

