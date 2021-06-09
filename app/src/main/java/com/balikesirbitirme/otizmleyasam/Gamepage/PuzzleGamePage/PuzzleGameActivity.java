package com.balikesirbitirme.otizmleyasam.Gamepage.PuzzleGamePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.balikesirbitirme.otizmleyasam.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class PuzzleGameActivity extends AppCompatActivity {

    Bitmap bmImage;
    ImageView imgMain;
    int doTrue;
    ArrayList<PuzzlePiece> parts;
    //ConstraintLayout constraintLayout;
    //ArrayList<Bitmap> parts;
    RelativeLayout rlyMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_puzzle_game);
        Init();

    }
    private void Init(){
        //constraintLayout=findViewById(R.id.cns_main);
        imgMain=findViewById(R.id.img_main);
        rlyMain=findViewById(R.id.ryl_main);//relative den büyük ihtimalle
        ////////////////////////////////////////////////////////////////
        int[] images=new int[20];
        Random rnd=new Random();
        images[0]=R.drawable.puzz1;
        images[1]=R.drawable.puzz2;
        images[2]=R.drawable.puzz3;
        images[3]=R.drawable.puzz4;
        images[4]=R.drawable.puzz5;
        images[5]=R.drawable.puzz6;
        images[6]=R.drawable.puzz7;
        images[7]=R.drawable.puzz8;
        images[8]=R.drawable.puzz9;
        images[9]=R.drawable.puzz9;
        images[10]=R.drawable.puzz11;
        images[11]=R.drawable.puzz12;
        images[12]=R.drawable.puzz13;
        images[13]=R.drawable.puzz14;
        images[14]=R.drawable.puzz15;
        images[15]=R.drawable.puzz16;
        images[16]=R.drawable.puzz17;
        images[17]=R.drawable.puzz18;
        images[18]=R.drawable.puzz19;
        images[19]=R.drawable.puzz10;


        imgMain.setImageResource(images[rnd.nextInt(images.length)]);

        //////////////////////////////////////////////////////////



        makeScane();
    }
    private void makeScane(){
        doTrue=0; //kaç parçanın doğru yerleştirildiğini tutan değişken
        //random image ataması yap
        imgMain.post(new Runnable() {
            @Override
            public void run() {
                parts=getParts();
                TouchListener touchListener = new TouchListener();//dokunma olay dinleyicisi
                for (PuzzlePiece part:parts){
                    //ImageView view=new ImageView(getApplicationContext());
                    //view.setImageBitmap(part);
                    part.setOnTouchListener(touchListener);
                    rlyMain.addView(part);
                }
            }
        });
    }


    private ArrayList<PuzzlePiece> getParts(){//fonksiyon resmi parçalar
        int partNumber=9;
        int row=3;

        //parts= new ArrayList<>(partNumber); //part adedi kadar bitmap dizisi oluşturuldu
        parts=new ArrayList<PuzzlePiece>(partNumber);


        //ilgili realm fonksiyonunun uygun kısmına(büyük ihtimalle altına) realmde atanan değişken x iden while (x==null) eklersek x ataması yapılana kadar
        //realm kodundan sonraki sıralı kodlar çalışmayacaktır.
        //***********************ULTRA ÖNEMLİ PROJEDE DEĞİŞTİRİLECEK KISIM*********************************************************************************
        //Random resim seçicek


        BitmapDrawable drawable = (BitmapDrawable) imgMain.getDrawable();//burada kaynak  imageviewin srcsinden alındı ama projede veri tabanından alınacak
        Bitmap bitmap = drawable.getBitmap();

        int[] dimensions = getBitmapPositionInsideImageView(imgMain);
        int scaledBitmapLeft = dimensions[0];
        int scaledBitmapTop = dimensions[1];
        int scaledBitmapWidth = dimensions[2];
        int scaledBitmapHeight = dimensions[3];

        //parçaların genişlik ve yüksekliğini alıyor
        int croppedImageWidth = scaledBitmapWidth - 2 * abs(scaledBitmapLeft);//abs mutlak değer fonksiyonu
        int croppedImageHeight = scaledBitmapHeight - 2 * abs(scaledBitmapTop);//her stun ve satırda 3 parca olacağından anaresimden  iki kırpılmış parçayı çıkartıp  1 parça boyutunu bulur


        //scaledbitmap imageview in ölçüsünü alır


        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, scaledBitmapWidth, scaledBitmapHeight, true);
        Bitmap croppedBitmap = Bitmap.createBitmap(scaledBitmap, abs(scaledBitmapLeft), abs(scaledBitmapTop), croppedImageWidth, croppedImageHeight);

        int edgeH=croppedBitmap.getHeight()/row;
        int edgeW=croppedBitmap.getWidth()/row;


        int yCoord = 0;
        for (int i = 0; i < row; i++) {
            int xCoord = 0;
            for (int j = 0; j < row; j++) {
                //Bitmap pieceBitmap = Bitmap.createBitmap(croppedBitmap, xCoord, yCoord,edgeW, edgeH);

                int offsetX = 0;
                int offsetY = 0;
                if (j > 0) {
                    offsetX = edgeW / 3;
                }
                if (i > 0) {

                    offsetY=edgeH/3;
                }
                Bitmap pieceBitmap = Bitmap.createBitmap(croppedBitmap, xCoord - offsetX, yCoord - offsetY, edgeW + offsetX, edgeH + offsetY);


                PuzzlePiece piece = new PuzzlePiece(getApplicationContext());
                piece.setImageBitmap(pieceBitmap);



                //piece.xCoord = xCoord + imgMain.getLeft();
                //piece.yCoord = yCoord + imgMain.getTop();
                //piece.pieceWidth = edgeW;
                //piece.pieceHeight = edgeH;

                piece.xCoord = xCoord - offsetX + imgMain.getLeft();
                piece.yCoord = yCoord - offsetY + imgMain.getTop();
                piece.pieceWidth = edgeW + offsetX;
                piece.pieceHeight = edgeH + offsetY;


                Bitmap puzzlePiece = Bitmap.createBitmap(edgeW + offsetX, edgeH + offsetY, Bitmap.Config.ARGB_8888);

                int bumpSize = edgeH / 4;
                Canvas canvas = new Canvas(puzzlePiece);//ekrana şekil çizmek için kullanılan canvas kodları
                Path path = new Path();
                path.moveTo(offsetX, offsetY);
                if (i == 0) {

                    path.lineTo(pieceBitmap.getWidth(), offsetY);

                } else {

                    path.lineTo(offsetX + (pieceBitmap.getWidth() - offsetX) / 3, offsetY);
                    path.cubicTo(offsetX + (pieceBitmap.getWidth() - offsetX) / 6, offsetY - bumpSize, offsetX + (pieceBitmap.getWidth() - offsetX) / 6 * 5, offsetY - bumpSize, offsetX + (pieceBitmap.getWidth() - offsetX) / 3 * 2, offsetY);
                    path.lineTo(pieceBitmap.getWidth(), offsetY);


                }

                if (j == row - 1) {

                    path.lineTo(pieceBitmap.getWidth(), pieceBitmap.getHeight());
                } else {

                    path.lineTo(pieceBitmap.getWidth(), offsetY + (pieceBitmap.getHeight() - offsetY) / 3);
                    path.cubicTo(pieceBitmap.getWidth() - bumpSize,offsetY + (pieceBitmap.getHeight() - offsetY) / 6, pieceBitmap.getWidth() - bumpSize, offsetY + (pieceBitmap.getHeight() - offsetY) / 6 * 5, pieceBitmap.getWidth(), offsetY + (pieceBitmap.getHeight() - offsetY) / 3 * 2);
                    path.lineTo(pieceBitmap.getWidth(), pieceBitmap.getHeight());
                }

                if (i == row - 1) {

                    path.lineTo(offsetX, pieceBitmap.getHeight());
                } else {

                    path.lineTo(offsetX + (pieceBitmap.getWidth() - offsetX) / 3 * 2, pieceBitmap.getHeight());
                    path.cubicTo(offsetX + (pieceBitmap.getWidth() - offsetX) / 6 * 5,pieceBitmap.getHeight() - bumpSize, offsetX + (pieceBitmap.getWidth() - offsetX) / 6, pieceBitmap.getHeight() - bumpSize, offsetX + (pieceBitmap.getWidth() - offsetX) / 3, pieceBitmap.getHeight());
                    path.lineTo(offsetX, pieceBitmap.getHeight());
                }
                if (j == 0) {

                    path.close();
                } else {

                    path.lineTo(offsetX, offsetY + (pieceBitmap.getHeight() - offsetY) / 3 * 2);
                    path.cubicTo(offsetX - bumpSize, offsetY + (pieceBitmap.getHeight() - offsetY) / 6 * 5, offsetX - bumpSize, offsetY + (pieceBitmap.getHeight() - offsetY) / 6, offsetX, offsetY + (pieceBitmap.getHeight() - offsetY) / 3);
                    path.close();
                }



                Paint paint = new Paint();
                paint.setColor(0XFF000000);
                paint.setStyle(Paint.Style.FILL);

                canvas.drawPath(path, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(pieceBitmap, 0, 0, paint);


                Paint border = new Paint();
                border.setColor(0X80FFFFFF);
                border.setStyle(Paint.Style.STROKE);
                border.setStrokeWidth(8.0f);
                canvas.drawPath(path, border);


                border = new Paint();
                border.setColor(0X80000000);
                border.setStyle(Paint.Style.STROKE);
                border.setStrokeWidth(3.0f);
                canvas.drawPath(path, border);


                piece.setImageBitmap(puzzlePiece);

                parts.add(piece);


                //parts.add(Bitmap.createBitmap(croppedBitmap, xCoord, yCoord, edgeW, edgeH));
                xCoord += edgeW;
            }
            yCoord += edgeH;

            /**1 2 3
             * 4 5 6
             * 7 8 9
             * şeklinde sırayla parçalar**/
        }


        return parts;
    }
    private int[] getBitmapPositionInsideImageView(ImageView imageView) {// olduğu gibi alına bilen kısım
        int[] ret = new int[4]; //dizi oluştur

        if (imageView == null || imageView.getDrawable() == null) //view boşsa yada içinde resim yoksa boş dizi döndür
            return ret;


        float[] f = new float[9];
        imageView.getImageMatrix().getValues(f); // görüntü matrixi değerlerini diziye ekle

        //x ve y yi bulma
        final float scaleX = f[Matrix.MSCALE_X];
        final float scaleY = f[Matrix.MSCALE_Y];

        //resmin boyutlarını al
        final Drawable d = imageView.getDrawable();
        final int origW = d.getIntrinsicWidth();
        final int origH = d.getIntrinsicHeight();


        final int actW = Math.round(origW * scaleX);//orjinal resim boyutu ile imageview in çarpımını al //round en yakın tam sayıya yuvarla
        final int actH = Math.round(origH * scaleY);

        ret[2] = actW;//geri döndürülecek dizinin son iki değerine genişlik ve yüksekliği yaz
        ret[3] = actH;

        // Get image position
        // We assume that the image is centered into ImageView
        int imgViewW = imageView.getWidth();
        int imgViewH = imageView.getHeight();

        int top = (int) (imgViewH - actH)/2;
        int left = (int) (imgViewW - actW)/2;

        ret[0] = left; //parçanın ait olduğu yerin sol üstü alınır ve dizide atanır
        ret[1] = top;

        return ret;
    }

    public class TouchListener implements View.OnTouchListener {//fillerdekinin  benzeri
        private float xDelta;
        private float yDelta;

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float x = motionEvent.getRawX();
            float y = motionEvent.getRawY();

            final double tolerance = sqrt(pow(view.getWidth(), 2) + pow(view.getHeight(), 2)) / 10;
            PuzzlePiece piece = (PuzzlePiece) view;
            if (!piece.canMove) {
                return true;
            }

            RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    piece.bringToFront();
                    break;
                case MotionEvent.ACTION_MOVE:
                    lParams.leftMargin = (int) (x - xDelta);
                    lParams.topMargin = (int) (y - yDelta);
                    view.setLayoutParams(lParams);
                    break;
                case MotionEvent.ACTION_UP:
                    int xDiff = abs(piece.xCoord - lParams.leftMargin);
                    int yDiff = abs(piece.yCoord - lParams.topMargin);
                    if (xDiff <= tolerance && yDiff <= tolerance) {//buranın parçasıysa (yakınlığı tolerans aralığındaysa yerleştir)
                        lParams.leftMargin = piece.xCoord;
                        lParams.topMargin = piece.yCoord;
                        piece.setLayoutParams(lParams);
                        piece.canMove = false;
                        sendViewToBack(piece);
                        doTrue++;
                        if (doTrue>=9){
                            Toast.makeText(getApplicationContext(),"Tamamladın Tebrikler",Toast.LENGTH_SHORT).show();
                            recreate();}
                    }
                    break;
            }

            return true;
        }
        public void sendViewToBack(final View child) {
            final ViewGroup parent = (ViewGroup)child.getParent();
            if (null != parent) {
                parent.removeView(child);
                parent.addView(child, 0);
            }
        }

    }

}



