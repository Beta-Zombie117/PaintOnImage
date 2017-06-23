package com.example.mihai.paintonimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {

    public int widht;
    public int height;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mPaint;
    private Paint   mBitmapPaint;
    private float mX, mY;
    private static final float TOLERANCE = 4;
    private Paint argb;
    Context context;

     public int red, green, blue;



    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);



    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        }


    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
            canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        canvas.drawPath(mPath, mPaint);

    }

    private void startTouch(float x, float y){
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY =y;
    }

    private void moveTouch(float x, float y){
        float dx = Math.abs( x - mX);
        float dy = Math.abs( y - mY);
        if (dx >= TOLERANCE || dy >= TOLERANCE){
            mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
            mX = x;
            mY = y;

        }
    }

    private void upTouch(){
        mPath.lineTo(mX, mY);
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        // kill this so we don't double draw
       // mPath.reset();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;

        }

        return true;

    }

    public Bitmap getBitmap()
    {
        //this.measure(100, 100);
        //this.layout(0, 0, 100, 100);
        this.setDrawingCacheEnabled(true);
        this.buildDrawingCache();
        Bitmap bmp = Bitmap.createBitmap(this.getDrawingCache());
        this.setDrawingCacheEnabled(false);


        return bmp;
    }

    public void clearCanvas(){
        mPath.reset();
        invalidate();
        mBitmap.eraseColor(Color.WHITE);
        invalidate();
        System.gc();
    }

//    public void undoChange(){
//        mPath.();
//        invalidate();
//    }


//    public void clear(){
//        mBitmap.eraseColor(Color.WHITE);
//        invalidate();
//        System.gc();
//    }


//-setarea culorilor de baza.
    public void setColorRed(){
        mPaint.setColor(Color.RED);

    }
    public void setColorGreen(){
        mPaint.setColor(Color.GREEN);

    }
    public void setColorBlue(){
        mPaint.setColor(Color.BLUE);

    }
    public void setColorBlack(){
        mPaint.setColor(Color.BLACK);

    }
    public void setColorCyan(){
        mPaint.setColor(Color.CYAN);

    }
    public void setColorMagenta(){
        mPaint.setColor(Color.MAGENTA);

    }
    public void setColorYellow(){
        mPaint.setColor(Color.YELLOW);

    }
    public void setColorGray(){
        mPaint.setColor(Color.GRAY);

    }
    public void setColorWhite(){
        mPaint.setColor(Color.WHITE);

    }

    // metoda pentru setarea unui canvas nou.
    // +treb de facut imaginea--> mBitmap
    public void   setmCanvas(){
        mCanvas = new Canvas(mBitmap);

    }

//metodele pentru setarea marimii pensulei.
    public void setStrokeSmall(){
        mPaint.setStrokeWidth(4f);

    }

    public void setStrokeMedium(){
        mPaint.setStrokeWidth(8f);

    }
    public void setStrokeLarge(){
        mPaint.setStrokeWidth(16f);

    }
    public void setStrokeXLarge(){
        mPaint.setStrokeWidth(24f);

    }
    public void setStrokeXXLarge(){
        mPaint.setStrokeWidth(32f);

    }
    public void setStrokeXXXLarge(){
        mPaint.setStrokeWidth(64f);

    }
//metodele pentru setarea stilului liniei.
    public void setBrushStyleStroke(){
        mPaint.setStyle(Paint.Style.STROKE);
    }
    public void setBrushStyleFill(){
        mPaint.setStyle(Paint.Style.FILL);
    }
    public void setBrushStyleFandS(){
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

//metodele pentru setarea stilului pensulei.
    public void setCapStyleButt(){
        mPaint.setStrokeCap(Paint.Cap.BUTT);
    }
    public void setCapStyleRound(){
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }
    public void setCapStyleSquare(){
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
    }


    //o invocam in clasa paletei pentru a seta culoarea speciala.
    public void setColor(int argb) {

        red = 100;
        green = 100;
        blue = 100;
        mPaint.setColor(Color.argb(255, red, green, blue));
    }

    //    public void setColor(int a, int r,int g, int b) {
//
//        a = 255;
//        mPaint.setColor(Color.argb(a, r, g, b));
//    }
//    public void setColorRGB(){
//        mPaint.setColor(Color.color);
//
//    }

}

