package com.example.mihai.paintonimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
    private float mX, mY;
    private static final float TOLERANCE = 5;
    Context context;

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        mPath = new Path();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
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
        super.onDraw(canvas);

        canvas.drawPath(mPath, mPaint);
    }

    private void startTouch(float x, float y){
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

    public void clearCanvas(){

        mPath.reset();
        invalidate();
    }

    private void upTouch(){
        mPath.lineTo(mX, mY);
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        // kill this so we don't double draw
        mPath.reset();


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
                moveTouch(x, y);
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


    //methods for seting the brush colors
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

    //methods for setting the brush size!
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


    //methods for changing brush style!
    public void setBrushStyleStroke(){
        mPaint.setStyle(Paint.Style.STROKE);
    }
    public void setBrushStyleFill(){
        mPaint.setStyle(Paint.Style.FILL);
    }
    public void setBrushStyleFandS(){
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

//
    // AUUUUU EUGEN !!!!!!!!!!!!!!!!!!!!!!
// trebu de facut ca cand se scimba culoarea/marimea/brush-type sa se salveze tot ce a fost inainte nu sa se schimbe tot din nou !
// trebu de facut metoda pentru ca sa se salveze imaginea pe sdcard/local/galerie!
//      +  de inkarcat imaginea din galerie de scanat bitmapu si de incarcat in canvasView pentru a putea desena peste imagine!
    //  +
    ///



    }

