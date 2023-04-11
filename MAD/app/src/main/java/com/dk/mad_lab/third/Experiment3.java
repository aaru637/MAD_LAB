package com.dk.mad_lab.third;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.dk.mad_lab.R;

public class Experiment3 extends AppCompatActivity {
    private ImageView image;
    private int width, height ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment3);

        Button line = findViewById(R.id.line);
        Button square = findViewById(R.id.square);
        Button rect = findViewById(R.id.rect);
        Button circle = findViewById(R.id.circle);
        image = findViewById(R.id.image);

        Paint paint = MyCanvas.getPaint();
        Canvas canvas = MyCanvas.getCanvas(image);
        width = getWidth(canvas);
        height = getHeight(canvas);

        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Canvas canvas = MyCanvas.getCanvas(image);
                canvas.drawLine((width/2), 10, (width/2), (height), paint);
                //                  360,         10,    360,      720
            }});

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Canvas canvas = MyCanvas.getCanvas(image);
                canvas.drawRect((width/4), (height/4), (width - (width/4)), (height - (height/4)), paint);
                //                 180,        180,           540,                  540
            }});

        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Canvas canvas = MyCanvas.getCanvas(image);
                canvas.drawRect((width/8), (height/4), (width - (width/8)), (height - (height/4)), paint);
                //                  90,       180,             540,                 540
            }});

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Canvas canvas = MyCanvas.getCanvas(image);
                canvas.drawCircle((width/2), (height/2), 200, paint);
                //                    360,      360,           200
            }});
    }
    static int getWidth(Canvas canvas){
        return canvas.getWidth();
    }
    static int getHeight(Canvas canvas){
        return canvas.getHeight();
    }
}

