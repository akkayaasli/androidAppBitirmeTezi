package com.balikesirbitirme.otizmleyasam.AdapterPage.MainMenuAdapter;

public class MenuRow {
    String strTitle;
    int intSrcImage;

    public MenuRow(String strTitle, int intSrcImage) {
        this.strTitle = strTitle;
        this.intSrcImage = intSrcImage;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public int getIntSrcImage() {
        return intSrcImage;
    }

    public void setIntSrcImage(int intSrcImage) {
        this.intSrcImage = intSrcImage;
    }
}
