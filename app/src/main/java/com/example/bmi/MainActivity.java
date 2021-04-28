package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView showbmi;
    private EditText height;
    private EditText weight;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.edHeight);
        weight = findViewById(R.id.edWeight);
        showbmi = findViewById(R.id.tvShowbmi);
        imageView = findViewById(R.id.ivShow);
    }

    public void calBMI(View view) {

       double bmi=Double.parseDouble(bmi_value()) ;
        String txt = "";

        if (bmi < 18.5) {
            txt = "體重過輕";
            imageView.setImageResource(R.drawable.images1);
        } else if (bmi > 25) {
            txt = "體重過重";
            imageView.setImageResource(R.drawable.images3);
        } else {
            txt = "體重正常";
            imageView.setImageResource(R.drawable.images2);
        }

        // showbmi.setText(String.valueOf(bmi)+txt);
        showbmi.setText(String.valueOf(bmi)+txt);


    }

    private String bmi_value() {
        if (height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()) {
            showbmi.setText("請輸入身高或體重的數值");
            return "0.0";
        } else {
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            double bmi = w / ((h / 100.0) * (h / 100.0));
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            return decimalFormat.format(bmi) ;
        }
    }

    public void showToast(View view) {
       String bmi= bmi_value();
        Toast toast=Toast.makeText(this, bmi,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
                toast.show();
    }

    public void show_alertdialog(View view) {
        String[] a={"Red","Green","Blue"};

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("你的BMI")
                //.setMessage(bmi_value())
                .setItems(a,null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "ABC", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("ABC",null)
                .setIcon(R.drawable.ic_launcher_background)
                .show();
    }
}