package com.tarikoztoprak.zamanynetimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private Button mButton2;
    private Button mButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText editText=findViewById(R.id.editTextNumber);
        EditText editText2=findViewById(R.id.editTextNumber2);
        EditText editText3=findViewById(R.id.editTextNumber3);
        editText.setText(String.valueOf(MainActivity.calismaSuresi));
        editText2.setText(String.valueOf(MainActivity.molaSuresi));
        editText3.setText(String.valueOf(MainActivity.uzunMolaSuresi));
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this);

        mButton2 = findViewById(R.id.button4);
        mButton2.setOnClickListener(this);

        mButton3 = findViewById(R.id.button5);
        mButton3.setOnClickListener(this);



    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                EditText editText=findViewById(R.id.editTextNumber);
                String value=editText.getText().toString();
                int i=Integer.parseInt(value);
                MainActivity.calismaSuresi = i;
                if (MainActivity.durum == "çalışma"){
                    MainActivity.dakika = i;
                    MainActivity.saniye = 0;
                }
                break;
            case R.id.button4:
                EditText editText2=findViewById(R.id.editTextNumber2);
                String value2=editText2.getText().toString();
                int i2=Integer.parseInt(value2);
                MainActivity.molaSuresi = i2;
                if (MainActivity.durum == "mola"){
                    MainActivity.dakika = i2;
                    MainActivity.saniye = 0;
                }
                break;
            case R.id.button5:
                EditText editText3=findViewById(R.id.editTextNumber3);
                String value3=editText3.getText().toString();
                int i3=Integer.parseInt(value3);
                MainActivity.uzunMolaSuresi = i3;
                if (MainActivity.durum == "uzunmola"){
                    MainActivity.dakika = i3;
                    MainActivity.saniye = 0;
                }
                break;

        }
    }
}