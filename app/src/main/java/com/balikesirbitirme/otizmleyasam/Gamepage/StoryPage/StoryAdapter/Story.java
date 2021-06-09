package com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter;

import android.content.res.AssetFileDescriptor;

public class Story {
    String strStoryAdi;
    int intStoryID;
    int intStoryImageURI;
    String fileDescriptor;

    public static final String KEY_İMG="makber";
    public static final String KEY_SOUND="tarhan";
    public static final int PERMİSSİON_READ=11;//TELEFONDAKİ BÜTÜN SESLERİ ALIR
    public static final int PERMİSSİON_SONG=9;//SESLERİ EKRANDA GÖSTERİR.
    public static String SoundString="";
    //key ler dursun boş boş bi class olmasın




    public String getFileDescriptor() {
        return fileDescriptor;
    }

    public void setFileDescriptor(String fileDescriptor) {
        this.fileDescriptor = fileDescriptor;
    }

    public Story(int intStoryID, String strStoryAdi, int strStoryImageURI,String fileDescriptor) {
        this.strStoryAdi = strStoryAdi;
        this.intStoryID = intStoryID;
        this.intStoryImageURI = strStoryImageURI;
        this.fileDescriptor=fileDescriptor;
    }

    public String getStrStoryAdi() {
        return strStoryAdi;
    }

    public void setStrStoryAdi(String strStoryAdi) {
        this.strStoryAdi = strStoryAdi;
    }

    public int getIntStoryID() {
        return intStoryID;
    }

    public void setIntStoryID(int intStoryID) {
        this.intStoryID = intStoryID;
    }

    public int getIntStoryImageURI() {
        return intStoryImageURI;
    }

    public void setIntStoryImageURI(int intStoryImageURI) {
        this.intStoryImageURI = intStoryImageURI;
    }
}
