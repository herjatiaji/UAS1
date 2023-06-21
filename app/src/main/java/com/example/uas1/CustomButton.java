package com.example.uas1;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import java.util.Random;

public class CustomButton extends AppCompatButton {
    private Paint buttonPaint;
    private Paint textPaint;
    private int buttonColor;
    private String buttonText;
    private Drawable loveIcon;



    public CustomButton(Context context) {
        super(context);
        loveIcon = ResourcesCompat.getDrawable(getResources(),
                R.drawable.baseline_favorite_24,null);

        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        buttonPaint = new Paint();
        buttonColor = Color.BLUE;
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(36);
        textPaint.setTextAlign(Paint.Align.CENTER);
        buttonText = "♥CLICK ME♥";
        setCompoundDrawablesWithIntrinsicBounds(loveIcon, null, loveIcon,null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        buttonPaint.setColor(buttonColor);
        canvas.drawRect(0, 0, 300, 300, buttonPaint);
        float textX = getWidth() / 2f;
        float textY = getHeight() / 2f - ((textPaint.descent() + textPaint.ascent()) / 2f);
        canvas.drawText(buttonText, textX, textY, textPaint);

    }

    @Override
    public boolean performClick() {

        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        buttonColor = Color.rgb(red, green, blue);
        invalidate();

        return super.performClick();
    }
}
