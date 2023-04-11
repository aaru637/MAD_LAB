package com.dk.mad_lab.third;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;
public class MyCanvas {
    public static Canvas getCanvas(ImageView image){
        Bitmap bitmap = Bitmap.createBitmap(720, 720, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        image.setImageBitmap(bitmap);
        return canvas;}
    public static Paint getPaint(){
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        return paint;}

}
