package com.example.phones;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Love_Locksc extends AppCompatActivity {
    ImageView hert;
    ImageView cry;
    ImageView happy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.love_lock);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        hert = (ImageView) findViewById(R.id.disableheart);
        cry = (ImageView) findViewById(R.id.cry_woman);
        happy = (ImageView) findViewById(R.id.happy_woman);

        final SeekBar sb;
        sb = findViewById(R.id.seekbar_slide);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (sb.getProgress() > 50) {
                    cry.setVisibility(View.VISIBLE);
                    hert.setVisibility(View.INVISIBLE);
                    happy.setVisibility(View.INVISIBLE);
                }
                else if (sb.getProgress() < 50){
                    hert.setVisibility(View.VISIBLE);
                    happy.setVisibility(View.VISIBLE);
                    cry.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (sb.getProgress() >= 80){
                    sb.setProgress(100);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Love_Locksc.this);
                    builder.setTitle("이성친구 ")/*확인창 버튼*/
                            .setMessage("핸드폰 볼꺼야?")/*확인창 내용*/
                            .setCancelable(false)
                            .setPositiveButton("응! 핸드폰 볼껀데"/*yes 창 만들기*/, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).setNegativeButton("아니야 너랑 놀래~", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sb.setProgress(0);
                            dialog.cancel();
                            Toast.makeText(Love_Locksc.this,"좋은 시간 보내요ㅎ",Toast.LENGTH_LONG).show();
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