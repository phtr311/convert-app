package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner sp1, sp2;
    EditText input;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.input);
        sp1 = (Spinner)findViewById(R.id.spF);
        sp2 = (Spinner)findViewById(R.id.spT);
        btn = (Button) findViewById(R.id.btn);

        String[] s = {"Binary", "Octal", "Decimal", "Hexadecimal"};
        ArrayAdapter ad = new ArrayAdapter <String>(this, R.layout.support_simple_spinner_dropdown_item, s);

        sp1.setAdapter(ad);
        sp2.setAdapter(ad);

        TextView result = (TextView)findViewById(R.id.output);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String in = input.getText().toString();
                if (sp1.getSelectedItem().toString().equals(sp2.getSelectedItem().toString())) {
                    result.setText(in);
                } else {
                    if (sp1.getSelectedItem().toString() == "Hexadecimal") {
                        int hex = Integer.parseInt(in, 16);
                        in = Integer.toString(hex);
                    }
                    if (sp1.getSelectedItem().toString() == "Octal") {
                        int oct = Integer.parseInt(in, 8);
                        in = Integer.toString(oct);
                    }
                    if (sp1.getSelectedItem().toString() == "Binary") {
                        int bin = Integer.parseInt(in, 2);
                        in = Integer.toString(bin);
                    }
                    int covert = Integer.parseInt(in);
                    if (sp2.getSelectedItem().toString() == "Hexadecimal"){
                        result.setText(Integer.toHexString(covert));
                    }
                    if (sp2.getSelectedItem().toString() == "Decimal"){
                        result.setText(in);
                    }
                    if (sp2.getSelectedItem().toString() == "Octal"){
                        result.setText(Integer.toOctalString(covert));
                    }
                    if (sp2.getSelectedItem().toString() == "Binary"){
                        result.setText(Integer.toBinaryString(covert));
                    }
                }
            }
        });


    }

}