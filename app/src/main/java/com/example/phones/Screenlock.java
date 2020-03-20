package com.example.phones;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Screenlock extends AppCompatActivity {
    SeekBar sb; /*seekbar sb로 먼저 선언.*/
    long now = System.currentTimeMillis(); // 현재 날짜 시간 불러오기
    Date date = new Date(now); // 시간
    Date ydate = new Date(now); // 날짜
    Date ndate = new Date(now);

    SimpleDateFormat ttime = new SimpleDateFormat("HH:mm"); // 시간
    SimpleDateFormat tdate = new SimpleDateFormat("MM월dd일"); // 날짜
    SimpleDateFormat Wdate = new SimpleDateFormat("EE요일");

    String ttdae = tdate.format(ydate); // 날짜 변수 지정
    String formateDate = ttime.format(date); // 시간 변수 지정
    String weekdate = Wdate.format(ndate);

    TextView nowDate;
    TextView dateNow;
    TextView nwdate;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_lock);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);


        dateNow = (TextView) findViewById(R.id.now_time); // 시간 textview
        dateNow.setText(formateDate);

        nowDate = (TextView) findViewById(R.id.now_date); // 날짜 textview
        nowDate.setText(ttdae);

        nwdate = (TextView) findViewById(R.id.dydlf);
        nwdate.setText(weekdate);

        final SeekBar sb;
        sb = findViewById(R.id.slide);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (sb.getProgress() > 50) {
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (sb.getProgress() >= 80){
                    sb.setProgress(100);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Screenlock.this);
                    builder.setTitle("밥 시간 ")/*확인창 버튼*/
                            .setMessage("너 밥 다 먹었어?")/*확인창 내용*/
                            .setCancelable(false)
                            .setPositiveButton("배불러~ 다 먹었어"/*yes 창 만들기*/, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).setNegativeButton("아직 안먹었어..", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sb.setProgress(0);
                            dialog.cancel();
                            Toast.makeText(Screenlock.this,"밥 먹을 때는 폰을 꺼두자!",Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                else{
                    sb.setProgress(0);
                }


            }
        });


    }
    @Override
    public void onBackPressed(){
        //뒤로가기 버튼 막기
    }
    protected void onPause(){ //메뉴키 막는 코드
        super.onPause();
        ActivityManager activityManager = (ActivityManager) getApplicationContext().
                getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.moveTaskToFront(getTaskId(), 0);
    }
    public void onStop(){
        super.onStop();
    }

}
