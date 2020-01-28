package com.example.splittempattgllahir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button splitBtn, splitBtn1, splitBtn2, splitBtn3;
    private TextView resultTempat, resultTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input_text);
        splitBtn = findViewById(R.id.btn_split);
        splitBtn1 = findViewById(R.id.btn_split_1);
        splitBtn2 = findViewById(R.id.btn_split_2);
        splitBtn3 = findViewById(R.id.btn_split_3);
        resultTanggal = findViewById(R.id.result_tgl);
        resultTempat = findViewById(R.id.result_tempat);

        splitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.getText().toString().isEmpty()) {
                    splitGenerator(input.getText().toString().trim());
                }
            }
        });

        splitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempTgl = "Jakarta, 10-10-1996";
                splitGenerator(tempTgl);
            }
        });

        splitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempTgl = "Banjarmasin 10-10-1996";
                splitGenerator(tempTgl);
            }
        });

        splitBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempTgl = "Bandar Lampung 10-10-1996";
                splitGenerator(tempTgl);
            }
        });

    }

    private void splitGenerator(String tempTgl) {
        try {
            String tempString[] = tempTgl.split(" ");
            if (tempString.length <= 2) {
                tempString[0]= tempString[0].replace(",","");
                resultTempat.setText(tempString[0].trim());
                resultTanggal.setText(tempString[1].trim());
            } else {
                String temp = "";
                for (int i = 0; i < tempString.length - 1; i++) {
                    temp += tempString[i] + " ";
                }

                temp = temp.replace(",","");

                resultTempat.setText(temp.trim());
                resultTanggal.setText(tempString[tempString.length - 1].trim());
            }
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }

    }
}
