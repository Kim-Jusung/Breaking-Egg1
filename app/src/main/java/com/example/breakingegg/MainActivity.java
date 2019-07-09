package com.example.breakingegg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ivegg;
    private Button btnStart;

    private Random random;

    private int targetCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivegg = (ImageView)findViewById(R.id.ivegg);
        btnStart = (Button)findViewById(R.id.btnStart);

        ivegg.setImageResource(R.drawable.egg);

        random = new Random();

        targetCount = random.nextInt(50)+1;

        ivegg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>targetCount){
                    ivegg.setImageResource(R.drawable.brokenegg);
                    btnStart.setEnabled(true);
                } else{
                    count++;
                    btnStart.setEnabled(false);
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
            }
        });
    }
}
