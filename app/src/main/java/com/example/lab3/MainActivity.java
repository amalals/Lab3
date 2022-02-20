package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double number;
    double ConvertCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Number = (EditText) findViewById(R.id.txtMoney);
        final TextView Result = (TextView) findViewById(R.id.Result);
        final RadioButton Euro = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton Peso = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton CAD = (RadioButton) findViewById(R.id.radioButton);
        final Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(Number.getText().toString());
                DecimalFormat y = new DecimalFormat(("#.#"));

                if(Euro.isChecked()){
                    if(number <100000){
                        ConvertCurrency = number * 1.16303;
                        Result.setText( number + " USD = " + ConvertCurrency+ " Euro");}
                    else{
                        Toast.makeText(MainActivity.this,
                                "US Dollars input should be < $100,000", Toast.LENGTH_LONG).show();
                    } }

                if(Peso.isChecked()){
                    if(number<100000){
                        ConvertCurrency = number * 0.05;
                        Result.setText(number + " USD = " + ConvertCurrency+ " Mexican Peso");}
                    else{
                        Toast.makeText(MainActivity.this,
                                "US Dollars input should be < $100,000", Toast.LENGTH_LONG).show();
                    } }

                if(CAD.isChecked()){
                    if(number<100000){
                        ConvertCurrency = number * 0.79;
                        Result.setText(number + " USD = " + ConvertCurrency+ " Canadian Dollar");}

                    else{
                        Toast.makeText(MainActivity.this,
                                "US Dollars input should be < $100,000", Toast.LENGTH_LONG).show();
                    } }
            }
        });

    }
}