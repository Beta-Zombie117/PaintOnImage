package com.example.mihai.paintonimage;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.pm.PackageManager;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_REQUEST = 10;
    private static int RESULT_LOAD_IMAGE = 30;



    private CanvasView canvasView;

    RadioGroup colorsGroup1;
    RadioGroup colorsGroup2;
    RadioGroup canvasGroup;

    MyApplication myApplication;

    Bitmap mBitmap;
    Paint mPaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasView = (CanvasView) findViewById(R.id.canvas);

//        myApplication = (MyApplication)getApplicationContext();
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
//            {  myApplication.readStoragePermision = true;
//                                    }
//
//        if (!myApplication.readStoragePermision){
//            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 20);
//
//
//        }


//
//        RadioButton button_load_image = (RadioButton) findViewById(R.id.button_load_image);
//        button_load_image.setOnClickListener(new View.OnClickListener()
//        {   @Override
//            public void onClick(View arg0){
//
//                Intent i = new Intent(
//                        Intent.ACTION_PICK,
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(i, RESULT_LOAD_IMAGE);
//
//            }
//
//        });
//
//        RadioButton button_take_image = (RadioButton) findViewById(R.id.button_take_image);
//        button_take_image.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(
//                        Intent.ACTION_PICK,
//                        Uri.parse(MediaStore.ACTION_IMAGE_CAPTURE_SECURE));
//                startActivityForResult(i, CAMERA_REQUEST);
//            }
//
//
//
//        });


    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        setContentView(R.layout.activity_main);
//
//
//
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//
//            Bitmap mBitmap = BitmapFactory.decodeFile(picturePath);
//            Drawable drawable = new BitmapDrawable(mBitmap);
//            CanvasView canvasView = (CanvasView) findViewById(R.id.canvas);



//        }

//            ImageView imageView = (ImageView) findViewById(R.id.imgView);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//              SurfaceView mySurfaceView =(SurfaceView) findViewById(R.id.surfaceView);
//             mySurfaceView.(BitmapFactory.decodeFile(picturePath);
//        }


      //  else if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK && null != data){
       //     Bitmap cameraImage = (Bitmap) data.getExtras().get("data");

            //CanvasView canvasView =(CanvasView) findViewById(R.id.canvas);

         //   ImageView imageView = (ImageView) findViewById(R.id.imgView);
           // imageView.setImageBitmap(BitmapFactory.decodeFile(String.valueOf(cameraImage)));

       // }


//    }


//    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
//
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 20 && grantResults.length>0){
//            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            myApplication.readStoragePermision = true;
//
//        }
//    }


    public void  clearCanvas(View v){
        canvasView.clearCanvas();
    }
    public void setColorRed(View v){

        canvasView.setColorRed();
    }
    public void setColorGreen(View v){
        canvasView.setColorGreen();
    }
    public void setColorBlue(View v){
        canvasView.setColorBlue();
    }
    public void setColorBlack(View v){
        canvasView.setColorBlack();
    }
    public void setColorCyan(View v){
        canvasView.setColorCyan();
    }
    public void setColorMagenta(View v){
        canvasView.setColorMagenta();
    }

    //-the methods for stroke size!!!
    public void setStrokeSmall(View v){
        canvasView.setStrokeSmall();
    }

    public void setStrokeMedium(View v){
        canvasView.setStrokeMedium();
    }

    public void setStrokeLarge(View v){
        canvasView.setStrokeLarge();
    }
    public void setStrokeXLarge(View v){
        canvasView.setStrokeXLarge();
    }
    public void setStrokeXXLarge(View v){
        canvasView.setStrokeXXLarge();
    }
    public void setStrokeXXXLarge(View v){
        canvasView.setStrokeXXXLarge();
    }



    //methods for setting the brush style!
    public void setBrushsStyleStroke(View v){
        canvasView.setBrushStyleStroke();
    }

    public void setBrushStyleFill(View v){
        canvasView.setBrushStyleFill();

    }

    public void setBrushsStyleFandS(View v){
        canvasView.setBrushStyleFandS();
    }

//    public  void setimageincanvas(View v){
//        canvasView.setmCanvas();
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_settings ){
            LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View root = inflater.inflate(R.layout.dialog_settings, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("OPTIONS");

            colorsGroup1 = (RadioGroup)root.findViewById(R.id.dialog_subject);
            colorsGroup2 = (RadioGroup)root.findViewById(R.id.dialog_subject2);
            canvasGroup = (RadioGroup)root.findViewById(R.id.dialog_canvas_options);

            builder.setView(root);
            //builder.setPositiveButton("Select", dialogLisener);
            builder.setNegativeButton("Cancel", null);

            builder.create().show();
        }
        return super.onOptionsItemSelected(item);
    }

    DialogInterface.OnClickListener dialogLisener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String choiceColor = ((RadioButton)colorsGroup1.findViewById(colorsGroup1.getCheckedRadioButtonId())).getText().toString();
            String choiceColor2 = ((RadioButton)colorsGroup2.findViewById(colorsGroup2.getCheckedRadioButtonId())).getText().toString();

        }
    };







}
