package com.example.phones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//&D 부분
public class First_SC  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstscreen);

        final Button meal = (Button) findViewById(R.id.meal);
        final Button love = (Button) findViewById(R.id.love);
        //@Override 안에서 버튼 을 지정 해야된다. 실수 했던 부분: &D 부분에 코딩을 했을 때 layout이 열리지 않음.

        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), love_SC.class);
                startActivity(intent);
            }
        });
    }
}
