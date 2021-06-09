package com.balikesirbitirme.otizmleyasam.Gamepage.PairingGamePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.balikesirbitirme.otizmleyasam.R;

import java.util.Random;

public class PairingActivity extends AppCompatActivity {
    private Button btnadd;
    LinearLayout lnlsag;
    LinearLayout lnlsol;



    private final int imgMaxsize=30;//img adeti
    String idSag="";
    String idSoL="";
    View idSelectSol;
    View idSelectSag;
    int intTrue=0;
    Random rnd=new Random();

    int[][] intImages =new int[imgMaxsize][2];
    ImageView[] listRight=new ImageView[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_pairing);

        Init();

        //getResources().getResourceEntryName(((LinearLayout) btn.getParent()).getId());

        //Toast.makeText(getApplicationContext(),String.valueOf(getResources().getResourceEntryName(((LinearLayout) btn.getParent()).getId())),Toast.LENGTH_SHORT).show();

    }
    private void Init(){
        makeImgArray();
        btnadd = findViewById(R.id.btn_esleme_add);
        btnadd.setVisibility(View.GONE);
        lnlsag =findViewById(R.id.lnlRight);
        lnlsol=findViewById(R.id.lnlLeft);
        idSelectSag=new ImageView(getApplicationContext());
        idSelectSag.setId(Integer.valueOf(1455));
        idSelectSol=new ImageView(getApplicationContext());
        idSag=getResources().getResourceEntryName(lnlsag.getId());
        idSoL=getResources().getResourceEntryName(lnlsol.getId());

        listRandomImages();

    }

    private void makeImgArray(){

        intImages[0][0]=(R.drawable.araba);
        intImages[0][1]=(R.drawable.araba1);
        intImages[1][0]=(R.drawable.armut);
        intImages[1][1]=(R.drawable.armut1);
        intImages[2][0]=(R.drawable.atac);
        intImages[2][1]=(R.drawable.atac1);
        intImages[3][0]=(R.drawable.bisiklet);
        intImages[3][1]=(R.drawable.bisiklet1);
        intImages[4][0]=(R.drawable.cekic);
        intImages[4][1]=(R.drawable.cekic1);
        intImages[5][0]=(R.drawable.cengel);
        intImages[5][1]=(R.drawable.cengel1);
        intImages[6][0]=(R.drawable.cilek);
        intImages[6][1]=(R.drawable.cilek1);
        intImages[7][0]=(R.drawable.ddolap);
        intImages[7][1]=(R.drawable.ddolap1);
        intImages[8][0]=(R.drawable.elma);
        intImages[8][1]=(R.drawable.elma1);
        intImages[9][0]=(R.drawable.fil);
        intImages[9][1]=(R.drawable.fil1);
        intImages[10][0]=(R.drawable.flut);
        intImages[10][1]=(R.drawable.flut1);
        intImages[11][0]=(R.drawable.gemi);
        intImages[11][1]=(R.drawable.gemi1);

        ///////////////////////////////////////////
        intImages[12][0]=(R.drawable.geyik);
        intImages[12][1]=(R.drawable.geyik1);

        intImages[13][0]=(R.drawable.gitar);
        intImages[13][1]=(R.drawable.gitar1);

        intImages[14][0]=(R.drawable.kalem);
        intImages[14][1]=(R.drawable.kalem1);

        intImages[15][0]=(R.drawable.kapi);
        intImages[15][1]=(R.drawable.kapi1);

        intImages[16][0]=(R.drawable.kedi);
        intImages[16][1]=(R.drawable.kedi1);

        intImages[17][0]=(R.drawable.kiraz);
        intImages[17][1]=(R.drawable.kiraz1);

        intImages[18][0]=(R.drawable.kopek);
        intImages[18][1]=(R.drawable.kopek1);

        intImages[19][0]=(R.drawable.kus);
        intImages[19][1]=(R.drawable.kus1);

        intImages[20][0]=(R.drawable.maymun);
        intImages[20][1]=(R.drawable.maymun);

        intImages[21][0]=(R.drawable.motorsiklet);
        intImages[21][1]=(R.drawable.motorsiklet1);

        intImages[22][0]=(R.drawable.otobus);
        intImages[22][1]=(R.drawable.otobus1);

        intImages[23][0]=(R.drawable.pense);
        intImages[23][1]=(R.drawable.pense1);

        intImages[24][0]=(R.drawable.portakal);
        intImages[24][1]=(R.drawable.portakal1);

        intImages[25][0]=(R.drawable.states);
        intImages[25][1]=(R.drawable.states1);

        intImages[26][0]=(R.drawable.tahterevalli);
        intImages[26][1]=(R.drawable.tahterevalli1);

        intImages[27][0]=(R.drawable.top);
        intImages[27][1]=(R.drawable.top1);

        intImages[28][0]=(R.drawable.tornavida);
        intImages[28][1]=(R.drawable.tornavida1);

        intImages[29][0]=(R.drawable.traktor);
        intImages[29][1]=(R.drawable.traktor1);





        /////////////////////////////////////////////


        for (int i=0;i<imgMaxsize;i++){
            int flag= rnd.nextInt(imgMaxsize);
            int first= intImages[flag][0];
            int second= intImages[flag][1];

            if(rnd.nextBoolean()){
                int swap = first;
                first=second;
                second=swap;
            }

            intImages[flag][0]=intImages[0][0];
            intImages[flag][1]=intImages[0][1];

            intImages[0][0]=first;
            intImages[0][1]=second;

        }



    }


    private void listRandomImages(){
        for (int i=0;i<9;i++){
            lnlsol.addView(newImage(intImages[i][0],i,false));
            listRight[i]=(ImageView) newImage(intImages[i][1],i,true);//sağ sol çalışmazsa buraya bak

        }
        for (int i=0;i<40;i++)
        {
            int flag=rnd.nextInt(9);

            ImageView imgFlag= new ImageView(getApplicationContext());
            imgFlag =listRight[0];
            listRight[0]=listRight[flag];
            listRight[flag]=imgFlag;
        }
        //yeni öğrendiğin xml yolu ile select kırmızısı belirtilecek
        for (int i=0;i<9;i++){
            lnlsag.addView(listRight[i]);
        }

        // inScreenLeft = inScreenLeft.replaceAll("\\s+","2");
        //Toast.makeText(getApplicationContext(),inScreenLeft,Toast.LENGTH_SHORT).show();

    }
    //LinearLayout linearLayout;

    ImageView img;
    private ImageView newImage(int intImage,  int id, Boolean isRight){

        //aslının mantıklı yaptığı yer
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);



        // linearLayout=new LinearLayout(getApplicationContext());
        //linearLayout.setOrientation(LinearLayout.VERTICAL);
        //linearLayout.setGravity(Gravity.CENTER);
        //linearLayout.setHorizontalGravity(Gravity.CENTER);
        //linearLayout.setId(0);

        //linearLayout.setHorizontalGravity(LinearLayout.HORIZONTAL);
        //linearLayout.setBackgroundResource(R.color.colorWhite);
        //linearLayout.setPadding(100,50,0,0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(250, 250);
        //layoutParams.gravity=Gravity.CENTER;
        //linearLayout.setLayoutParams(layoutParams);
        img=new ImageView(getApplicationContext());

        img.setImageResource(intImage);

        img.setPadding( 0,0,0,30 );
        img.setId(id);



        //Toast.makeText(getApplicationContext(),String.valueOf(img.getId()),Toast.LENGTH_SHORT).show();


        // layoutParams = new LinearLayout.LayoutParams(400, 400);
        layoutParams.gravity= Gravity.CENTER;
        //img.setPadding(10,50,0,0);
        img.setLayoutParams(layoutParams);


/**
 linearLayout.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
if (linearLayout.getId()==0){
linearLayout.setBackgroundResource(R.color.colorButtonPlusBorder);
linearLayout.setId(0+1000);

if(idSag.equals(String.valueOf(getResources().getResourceEntryName(((LinearLayout) linearLayout.getParent()).getId())))){
idSelectSag=String.valueOf(id);
}
if(idSag.equals(String.valueOf(getResources().getResourceEntryName(((LinearLayout) linearLayout.getParent()).getId())))){
idSelectSol=String.valueOf(id);
}

}
else{
linearLayout.setBackgroundResource(R.color.colorWhite);
linearLayout.setId(0);

if(idSag.equals(String.valueOf(getResources().getResourceEntryName(((LinearLayout) linearLayout.getParent()).getId())))){
idSelectSag="";
}
if(idSag.equals(String.valueOf(getResources().getResourceEntryName(((LinearLayout) linearLayout.getParent()).getId())))){
idSelectSol="";
}
}



if(idSelectSol.equals(idSelectSag)){
// Eşlendi
idSelectSol="";
idSelectSag="";
linearLayout.setVisibility(View.GONE);
}
}

});**/

        //linearLayout.addView(img);
        if (isRight)
            img.setOnClickListener(clickListenerRight);
        else
            img.setOnClickListener(clickListenerLeft);
        return img;

    }

    private void controlGame(){//kontrol kısmı
        if(idSelectSag.getId()==idSelectSol.getId()) {
            //Toast.makeText(getApplicationContext(),"oldi",Toast.LENGTH_SHORT).show();
            idSelectSol.setVisibility(View.GONE);
            idSelectSag.setVisibility(View.GONE);
            intTrue++;

        }

    }
    private View.OnClickListener clickListenerRight = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            idSelectSag=v;
            controlGame();
        }
    };
    private View.OnClickListener clickListenerLeft = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            idSelectSol=v;
            controlGame();
        }
    };



}
