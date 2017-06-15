package com.example.mihai.paintonimage;

import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private CanvasView canvasView;

    RadioGroup colorsGroup1;
    RadioGroup colorsGroup2;
    RadioGroup canvasGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasView = (CanvasView) findViewById(R.id.canvas);
    }

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
