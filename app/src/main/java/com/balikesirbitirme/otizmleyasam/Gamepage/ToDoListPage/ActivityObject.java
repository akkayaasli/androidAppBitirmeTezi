package com.balikesirbitirme.otizmleyasam.Gamepage.ToDoListPage;

public class ActivityObject {

    private String strSaat;
    private String strNote;
    private String strActivity;

    public ActivityObject(String strActivity, String strSaat, String strNote ) {
        this.strSaat = strSaat;
        this.strNote = strNote;
        this.strActivity = strActivity;
    }

    public String getStrSaat() {
        return strSaat;
    }

    public void setStrSaat(String strSaat) {
        this.strSaat = strSaat;
    }

    public String getStrNote() {
        return strNote;
    }

    public void setStrNote(String strNote) {
        this.strNote = strNote;
    }

    public String getStrActivity() {
        return strActivity;
    }

    public void setStrActivity(String strActivity) {
        this.strActivity = strActivity;
    }
}
