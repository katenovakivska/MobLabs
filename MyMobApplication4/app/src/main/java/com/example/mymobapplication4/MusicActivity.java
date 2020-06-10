package com.example.mymobapplication4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {
    MediaPlayer mPlayer1, mPlayer2;
    Button startButton1, pauseButton1, stopButton1,startButton2, pauseButton2, stopButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mPlayer1=MediaPlayer.create(this, R.raw.audio1);
        mPlayer2=MediaPlayer.create(this, R.raw.audio2);

        startButton1 = findViewById(R.id.play1);
        pauseButton1 = findViewById(R.id.pause1);
        stopButton1 = findViewById(R.id.stop1);
        startButton2 = findViewById(R.id.play2);
        pauseButton2 = findViewById(R.id.pause2);
        stopButton2 = findViewById(R.id.stop2);

        stop();
        play();
        pause();

    }
    public void play() {
        startButton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPlayer1.start();
                    }
                }
        );
        startButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPlayer2.start();
                    }
                }
        );
    }

    public void pause() {
        pauseButton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPlayer1.pause();
                    }
                }
        );
        pauseButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPlayer2.pause();
                    }
                }
        );
    }


    public void stop(){
        stopButton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPlayer1.stop();
                    }
                }
        );
        stopButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPlayer2.stop();
                    }
                }
        );
    }

}
