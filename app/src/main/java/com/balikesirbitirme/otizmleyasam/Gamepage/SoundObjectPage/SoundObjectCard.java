package com.balikesirbitirme.otizmleyasam.Gamepage.SoundObjectPage;

public class SoundObjectCard {
    private String strName;
    private String strUrl;
    private int intImg;

    public SoundObjectCard(String strName, String strUrl, int intImg) {
        this.strName = strName;
        this.strUrl = strUrl;
        this.intImg = intImg;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrUrl() {
        return strUrl;
    }

    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }

    public int getIntImg() {
        return intImg;
    }

    public void setIntImg(int intImg) {
        this.intImg = intImg;
    }
}
