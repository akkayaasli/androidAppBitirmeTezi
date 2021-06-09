package com.balikesirbitirme.otizmleyasam.Gamepage.StoryPage.StoryAdapter;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class StoryDb extends RealmObject
{
    String strStoryAdi;
    int intStoryID;
    int intStoryImageURI;

    public int getIntStoryImageURI() {
        return intStoryImageURI;
    }

    public void setIntStoryImageURI(int intStoryImageURI) {
        this.intStoryImageURI = intStoryImageURI;
    }

    public String getFileDescriptor() {
        return fileDescriptor;
    }

    public void setFileDescriptor(String fileDescriptor) {
        this.fileDescriptor = fileDescriptor;
    }

    String fileDescriptor;





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





}
