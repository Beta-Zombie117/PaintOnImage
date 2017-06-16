package com.example.mihai.paintonimage;


import android.os.Environment;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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


    public void clearCanvas(View v) {
        canvasView.clearCanvas();
    }

    public void setColorRed(View v) {

        canvasView.setColorRed();
    }

    public void setColorGreen(View v) {
        canvasView.setColorGreen();
    }

    public void setColorBlue(View v) {
        canvasView.setColorBlue();
    }

    public void setColorBlack(View v) {
        canvasView.setColorBlack();
    }

    public void setColorCyan(View v) {
        canvasView.setColorCyan();
    }

    public void setColorMagenta(View v) {
        canvasView.setColorMagenta();
    }

    //-the methods for stroke size!!!
    public void setStrokeSmall(View v) {
        canvasView.setStrokeSmall();
    }

    public void setStrokeMedium(View v) {
        canvasView.setStrokeMedium();
    }

    public void setStrokeLarge(View v) {
        canvasView.setStrokeLarge();
    }

    public void setStrokeXLarge(View v) {
        canvasView.setStrokeXLarge();
    }

    public void setStrokeXXLarge(View v) {
        canvasView.setStrokeXXLarge();
    }

    public void setStrokeXXXLarge(View v) {
        canvasView.setStrokeXXXLarge();
    }


    public void saveChanges(View v) {
        canvasView.saveChanges();
    }

    //methods for setting the brush style!
    public void setBrushsStyleStroke(View v) {
        canvasView.setBrushStyleStroke();
    }

    public void setBrushStyleFill(View v) {
        canvasView.setBrushStyleFill();

    }

    public void setBrushsStyleFandS(View v) {
        canvasView.setBrushStyleFandS();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasView = (CanvasView) findViewById(R.id.canvas);

        Button radio_button_save = (Button) findViewById(R.id.button_save_image);
        radio_button_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                File folder = new File(Environment.getExternalStorageDirectory().toString());
                boolean success = false;
                if (!folder.exists()) {
                    success = folder.mkdirs();
                }

                System.out.println(success + "folder");

                File file = new File(Environment.getExternalStorageDirectory().toString() + "/sample.png");

                if (!file.exists()) {
                    try {
                        success = file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(success + "file");


                FileOutputStream ostream = null;
                try {
                    ostream = new FileOutputStream(file);

                    System.out.println(ostream);
                    View targetView = canvasView;


                    Bitmap well = canvasView.getBitmap();
                    Bitmap save = Bitmap.createBitmap(720, 1280, Config.ARGB_8888);
                    Paint paint = new Paint();
                    paint.setColor(Color.WHITE);
                    Canvas now = new Canvas(save);
                    now.drawRect(new Rect(0, 0, 720, 1280), paint);
                    now.drawBitmap(well, new Rect(0, 0, well.getWidth(), well.getHeight()), new Rect(0, 0, 720, 1280), null);


                    if (save == null) {
                        System.out.println("NULL bitmap save\n");
                    }
                    save.compress(Bitmap.CompressFormat.PNG, 100, ostream);

                } catch (NullPointerException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Null error", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "File error", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "IO error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_settings) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View root = inflater.inflate(R.layout.dialog_settings, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("OPTIONS");

            colorsGroup1 = (RadioGroup) root.findViewById(R.id.dialog_subject);
            colorsGroup2 = (RadioGroup) root.findViewById(R.id.dialog_subject2);
            canvasGroup = (RadioGroup) root.findViewById(R.id.dialog_canvas_options);

            builder.setView(root);
           // builder.setPositiveButton("Select", dialogLisener);
            builder.setNegativeButton("Cancel", null);

            builder.create().show();
        }
        return super.onOptionsItemSelected(item);
    }

    DialogInterface.OnClickListener dialogLisener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String choiceColor = ((RadioButton) colorsGroup1.findViewById(colorsGroup1.getCheckedRadioButtonId())).getText().toString();
            String choiceColor2 = ((RadioButton) colorsGroup2.findViewById(colorsGroup2.getCheckedRadioButtonId())).getText().toString();

        }
    };
}

