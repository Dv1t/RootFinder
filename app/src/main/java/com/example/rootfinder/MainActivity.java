package com.example.rootfinder;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity {

    private EditText av;
    private EditText bv;
    private EditText cv;
    private TextView out1,out2;
    private double D,a,b,c;
    private double x1,x2;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        av=findViewById(R.id.a);
        bv=findViewById(R.id.b);
        cv=findViewById(R.id.c);
        out1=findViewById(R.id.textView);
        out2=findViewById(R.id.textView2);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Start(View view) {
        a = Double.parseDouble(av.getText().toString());
        b = Double.parseDouble(bv.getText().toString());
        c = Double.parseDouble(cv.getText().toString());
        D = b * b - (4 * a * c);

        String p1 = "1";
        String p2 = "1";
        if (a == 0.0) {
            p1 = "Ошибка ввода";
            p2 = "";

        } else {
            if (D > 0) {
                D = Math.sqrt(D);
                x1 = ((b * -1) - D) / (2 * a);
                x2 = ((b * -1) + D) / (2 * a);
                p1 = "X1= " + Double.toString(x1);
                p2 = "X2= " + Double.toString(x2);

            }
            if (D == 0) {
                x1 = x1 = ((b * -1) - D) / (2 * a);
                p1 = "X= " + Double.toString(x1);
                p2 = "Второго корня нет";

            }
            if (D < 0) {
                p1 = "Действительных корней нет";
                p2 = "";
            }
        }
            out1.setText(p1);
            out2.setText(p2);

    }
}