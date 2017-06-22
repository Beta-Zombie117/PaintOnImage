package com.example.mihai.paintonimage;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Color_Palette_Activity extends AppCompatActivity {

    Button button_color;
    SeekBar seekBar_blue, seekBar_green, seekBar_red;
    int red, green, blue;
    TextView textView;
    private CanvasView canvasView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_palette);



        button_color =(Button) findViewById(R.id.button_color);

        seekBar_red =(SeekBar) findViewById(R.id.seekBar_red);
        seekBar_green =(SeekBar) findViewById(R.id.seekBar_green);
        seekBar_blue =(SeekBar) findViewById(R.id.seekBar_blue);
        textView = (TextView) findViewById(R.id.textView_color_properties);

        red = 255;
        green = 255;
        blue = 255;

        seekBar_red.setMax(red);
        seekBar_red.setProgress(red);

        seekBar_green.setMax(green);
        seekBar_green.setProgress(green);

        seekBar_blue.setMax(blue);
        seekBar_blue.setProgress(blue);

        button_color.setBackgroundColor(Color.argb(255, red, green, blue));
        textView.setText(red + "," + green + "," + blue);



        seekBar_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                button_color.setBackgroundColor(Color.argb(255, red, green, blue));
              //  canvasView.setColor(Color.argb(255, red, green, blue));
                textView.setText(red + "," + green + "," + blue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                button_color.setBackgroundColor(Color.argb(255, red, green, blue));
              //  canvasView.setColor(Color.argb(255, red, green, blue));
                textView.setText(red + "," + green + "," + blue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        seekBar_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                button_color.setBackgroundColor(Color.argb(255, red, green, blue));
                //canvasView.setColor(Color.argb(255, red, green, blue));
                textView.setText(red + "," + green + "," + blue);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    public void setColor(){
        button_color =(Button) findViewById(R.id.button_color);
        button_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button button_color = (Button)v;
                //String buttonText = button_color.getText().toString();
                //int argb = Integer.parseInt(buttonText.replaceFirst("^#",""),16);
               // int argb = Color.parseColor(buttonText);

                 //       canvasView.setColor(255, red, green, blue);
                canvasView.setColor(Color.argb(255, red, green, blue));

            }
        });
    }





//    public void setColor(int argb){
//        String buttontext = (Button)findViewById(R.id.button_color).getT()
//           int argb = Color.parseColor(Button.getDefaultSize
//
//
//            canvasView.setColor(argb);
//
//    }

}
