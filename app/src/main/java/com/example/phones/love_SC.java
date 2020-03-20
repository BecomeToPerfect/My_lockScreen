package com.example.phones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class love_SC extends AppCompatActivity {
    ImageView Wo;
    ImageView heart;
    ImageView happy_wo;
    TextView tt;
    Animation animate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lovescreen);
    final Button back = (Button) findViewById(R.id.back);
    final Button phone = (Button) findViewById(R.id.phone);

    happy_wo = (ImageView) findViewById(R.id.happy_woman);
    Wo = (ImageView) findViewById(R.id.cry_woman);
    heart = (ImageView) findViewById(R.id.heart);
    tt = (TextView) findViewById(R.id.bline_text);

    animate = new AlphaAnimation(0.0f,1.0f);
    animate.setDuration(1000);
    animate.setStartOffset(200);
    animate.setRepeatMode(Animation.REVERSE);
    animate.setRepeatCount(Animation.INFINITE);

    tt.startAnimation(animate);

    phone.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ( v == phone){
                phone.setVisibility(View.INVISIBLE);
                heart.setVisibility(View.VISIBLE);
                Wo.setVisibility(View.INVISIBLE);
                happy_wo.setVisibility(View.VISIBLE);
                animate.cancel();
            }
            getWindow().addFlags((WindowManager.LayoutParams.FIRST_SUB_WINDOW));
            Intent intent = new Intent(getApplicationContext(), Love_Locksc.class);
            startActivity(intent);
        }
    });
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), First_SC.class);
            startActivity(intent);
        }
    });
    }


}
