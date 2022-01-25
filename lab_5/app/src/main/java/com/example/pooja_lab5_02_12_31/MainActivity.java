package com.example.pooja_lab5_02_12_31;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageView play;
    int starTime=0;
    int stopTime=0;
    int forwardTime=5000;
    int backward=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.demon_slayer);

        play= findViewById(R.id.play);
        ImageView pause = findViewById(R.id.pause);
        ImageView replay= findViewById(R.id.replay);
        ImageView forward1= findViewById(R.id.forward);
        Button backward= findViewById(R.id.button);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Song is playing", Toast.LENGTH_SHORT).show();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                Toast.makeText(getApplicationContext(), "Song paused", Toast.LENGTH_SHORT).show();
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Replaying the song", Toast.LENGTH_SHORT).show();
            }
        });

        forward1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curpos= mediaPlayer.getCurrentPosition();
                if((curpos+forwardTime) <= (stopTime=(mediaPlayer.getDuration()))){
                    mediaPlayer.seekTo(curpos+forwardTime);
                    Toast.makeText(getApplicationContext(), "Forward by 5 sec", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curpos= mediaPlayer.getCurrentPosition();
                if((curpos-forwardTime) >= 0){
                    mediaPlayer.seekTo(curpos-forwardTime);
                    Toast.makeText(getApplicationContext(), "backward by 5 sec", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}