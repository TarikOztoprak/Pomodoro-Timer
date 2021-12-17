package com.tarikoztoprak.zamanynetimi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private Button mButton2;
    private boolean buton1 = false;
    static int dakika = 30;
    static int saniye = 0;
    static int starLevel = 0;
    static int calismaSuresi = 30;
    static int molaSuresi = 10;
    static int uzunMolaSuresi = 60;
    static String durum = "çalışma";
    Handler mTimerHandler = new Handler();
    Handler mTimerHandler2 = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText3 =findViewById(R.id.editTextTime3);
        editText3.setText(String.valueOf(dakika) + ":" + String.valueOf(saniye) + "0");
        mButton = findViewById(R.id.button2);
        mButton.setOnClickListener(this);

        mButton2 = findViewById(R.id.button3);
        mButton2.setOnClickListener(this);


    }

    protected void onResume() {
        EditText editText3 =findViewById(R.id.editTextTime3);
        if (saniye < 10 && dakika > 9) {
            editText3.setText(dakika + ":0" + saniye);
        } else if (saniye < 10 && dakika < 10) {
            editText3.setText("0" + dakika + ":0" + saniye);
        } else if (saniye > 9 && dakika < 10) {
            editText3.setText("0" + dakika + ":" + saniye);
        } else {
            editText3.setText(dakika + ":" + saniye);
        }
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                if (buton1 == false){
                    timer();
                    buton1 = true;
                    ((android.widget.Button)findViewById(R.id.button2)).setText("Stop");
                }
                else if(buton1 == true)
                {
                    timerStop();
                    buton1 = false;
                    ((android.widget.Button)findViewById(R.id.button2)).setText("START");
                }
              break;
            case R.id.button3:
               sayfaDegis();
               break;
        }
    }

    public void sayfaDegis(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void star(){
        if (starLevel == 0)
        {
            ImageView blueBtn  = (ImageView)findViewById(R.id.imageView);
            blueBtn.setImageResource(R.drawable.bos);

            ImageView blueBtn2  = (ImageView)findViewById(R.id.imageView3);
            blueBtn2.setImageResource(R.drawable.bos);

            ImageView blueBtn3  = (ImageView)findViewById(R.id.imageView4);
            blueBtn3.setImageResource(R.drawable.bos);

            ImageView blueBtn4  = (ImageView)findViewById(R.id.imageView5);
            blueBtn4.setImageResource(R.drawable.bos);
        }
        else if ((starLevel % 4) == 1)
        {
            ImageView blueBtn  = (ImageView)findViewById(R.id.imageView);
            blueBtn.setImageResource(R.drawable.dolu);

            ImageView blueBtn2  = (ImageView)findViewById(R.id.imageView3);
            blueBtn2.setImageResource(R.drawable.bos);

            ImageView blueBtn3  = (ImageView)findViewById(R.id.imageView4);
            blueBtn3.setImageResource(R.drawable.bos);

            ImageView blueBtn4  = (ImageView)findViewById(R.id.imageView5);
            blueBtn4.setImageResource(R.drawable.bos);
        }
        else if ((starLevel % 4) == 2)
        {
            ImageView blueBtn  = (ImageView)findViewById(R.id.imageView);
            blueBtn.setImageResource(R.drawable.dolu);

            ImageView blueBtn2  = (ImageView)findViewById(R.id.imageView3);
            blueBtn2.setImageResource(R.drawable.dolu);

            ImageView blueBtn3  = (ImageView)findViewById(R.id.imageView4);
            blueBtn3.setImageResource(R.drawable.bos);

            ImageView blueBtn4  = (ImageView)findViewById(R.id.imageView5);
            blueBtn4.setImageResource(R.drawable.bos);
        }
        else if ((starLevel % 4) == 3)
        {
            ImageView blueBtn  = (ImageView)findViewById(R.id.imageView);
            blueBtn.setImageResource(R.drawable.dolu);

            ImageView blueBtn2  = (ImageView)findViewById(R.id.imageView3);
            blueBtn2.setImageResource(R.drawable.dolu);

            ImageView blueBtn3  = (ImageView)findViewById(R.id.imageView4);
            blueBtn3.setImageResource(R.drawable.dolu);

            ImageView blueBtn4  = (ImageView)findViewById(R.id.imageView5);
            blueBtn4.setImageResource(R.drawable.bos);
        }
        else if ((starLevel % 4) == 0)
        {
            ImageView blueBtn  = (ImageView)findViewById(R.id.imageView);
            blueBtn.setImageResource(R.drawable.dolu);

            ImageView blueBtn2  = (ImageView)findViewById(R.id.imageView3);
            blueBtn2.setImageResource(R.drawable.dolu);

            ImageView blueBtn3  = (ImageView)findViewById(R.id.imageView4);
            blueBtn3.setImageResource(R.drawable.dolu);

            ImageView blueBtn4  = (ImageView)findViewById(R.id.imageView5);
            blueBtn4.setImageResource(R.drawable.dolu);
        }
    }

    public void alert(final MediaPlayer xd)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Time's Up!");
        builder1.setCancelable(false);
        builder1.setPositiveButton(
                "Stop Alarm!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        timer2.cancel();
                        ImageView tick  = (ImageView)findViewById(R.id.imageView2);
                        tick.setImageResource(R.drawable.logo);
                        xd.stop();
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void alarm()
    {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sunshine_in_my_heart);
        mp.setLooping(true);
        mp.start();
        alert(mp);
    }

    boolean tickBool = false;
    java.util.Timer timer2;
    public void tick(){
        timer2 = new java.util.Timer();
        final TimerTask timerTask2 = new TimerTask() {
            public void run() {
                mTimerHandler2.post(new Runnable() {
                    public void run() {
                        if (tickBool == false){
                            ImageView tick  = (ImageView)findViewById(R.id.imageView2);
                            tick.setImageResource(R.drawable.ticklogo);
                            tickBool = true;
                        }
                        else if(tickBool == true)
                        {
                            ImageView tick  = (ImageView)findViewById(R.id.imageView2);
                            tick.setImageResource(R.drawable.logo);
                            tickBool = false;
                        }
                    }
                });
            }
        };
        timer2.scheduleAtFixedRate(timerTask2, 0, (300));
    }


    java.util.Timer timer;
    public void timer() {

        timer = new java.util.Timer();
        final TimerTask timerTask = new TimerTask() {
            public void run() {
                mTimerHandler.post(new Runnable() {
                    public void run() {
                        if (saniye == 0 && dakika != 0) {
                            dakika--;
                            saniye = 59;
                        } else if (saniye != 0) {
                            saniye--;
                        } else {
                            if (durum == "çalışma"){
                                starLevel++;
                                if(starLevel % 4 == 0)
                                {
                                    dakika = uzunMolaSuresi;
                                    durum = "uzunmola";
                                    TextView textView=findViewById(R.id.textView);
                                    textView.setText("Longer Break Time");
                                }
                                else
                                {
                                    dakika = molaSuresi;
                                    durum = "mola";
                                    TextView textView=findViewById(R.id.textView);
                                    textView.setText("Break Time");

                                }
                                buton1 = false;
                                star();
                                timerStop();
                                ((android.widget.Button)findViewById(R.id.button2)).setText("Start");
                                tick();
                                alarm();

                            }
                            else if(durum =="mola" || durum =="uzunmola")
                            {
                                buton1 = false;
                                dakika = calismaSuresi;
                                durum = "çalışma";
                                star();
                                timerStop();
                                ((android.widget.Button)findViewById(R.id.button2)).setText("Start");
                                TextView textView=findViewById(R.id.textView);
                                textView.setText("Study Time");
                                tick();
                                alarm();
                            }
                        }
                        TextView textView = (TextView) findViewById(R.id.editTextTime3);
                        if (saniye < 10 && dakika > 9) {
                            textView.setText(dakika + ":0" + saniye);
                        } else if (saniye < 10 && dakika < 10) {
                            textView.setText("0" + dakika + ":0" + saniye);
                        } else if (saniye > 9 && dakika < 10) {
                            textView.setText("0" + dakika + ":" + saniye);
                        } else {
                            textView.setText(dakika + ":" + saniye);
                        }
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, (1000));
    }
    public void timerStop(){
        timer.cancel();
    }
}

