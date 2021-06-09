package com.balikesirbitirme.otizmleyasam.Gamepage.PuzzleGamePage;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

public class PuzzlePiece extends AppCompatImageView {
    public int xCoord;
    public int yCoord;
    public int pieceWidth;
    public int pieceHeight;
    public boolean canMove = true;//parça hareket ettirilebilir mi?

    public PuzzlePiece(Context context) {
        super(context);
    }
}