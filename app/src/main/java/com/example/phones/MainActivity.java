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


public class MainActivity extends AppCompatActivity {
    ImageView Wo; //이미지 선언을 해서 visible 을 띄우게 해야된다.
    TextView Find; //TextViw는 final로 할 수 없음.
    Animation blink;
    TextView dontsee;
    TextView thanku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.locked);
        final Button back = (Button) findViewById(R.id.back);

        Wo = (ImageView) findViewById(R.id.woman); // 이 곳 Wo의 아이디를 받으면 된다.
        dontsee = (TextView) findViewById(R.id.dontsee);
        thanku = (TextView) findViewById(R.id.thanku);
        Find = (TextView) findViewById(R.id.Find);
//        Find.startAnimation(blink); 이 곳에 다가 시작을 넣으면 에러 발생.
        blink = new AlphaAnimation(0.0f,1.0f);
        blink.setDuration(1000); // 지속 시간 100=1초
        blink.setStartOffset(200); // 대기 시간
        blink.setRepeatMode(Animation.REVERSE); // 애니메이션 반복
        blink.setRepeatCount(Animation.INFINITE); // 애니메이션 무한 반복 Animation.(횟수)

        Find.startAnimation(blink); // 위에 설정을 하고 밑 부분에 시작을 해야됨.

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 버튼 사라지고 여자나타나기
                if (v == button){
                    Wo.setVisibility(View.VISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    thanku.setVisibility(View.VISIBLE);
                    dontsee.setVisibility(View.INVISIBLE);
                    blink.cancel();
                }
                getWindow().addFlags((WindowManager.LayoutParams.FIRST_SUB_WINDOW));
                Intent intent = new Intent(getApplicationContext(), Screenlock.class);
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
