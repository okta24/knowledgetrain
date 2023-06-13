package com.shahruie.www.Knowledge_Train;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Dini3 extends AppCompatActivity {
    ImageView back;
    MediaPlayer mp3;
    private boolean sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dini);
        sound=false;
        final Animation skake = AnimationUtils.loadAnimation(Dini3.this,
                R.anim.shake2);
        final ImageView gol=(ImageView)findViewById(R.id.dini3_img);
        gol.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int touchX = (int) event.getX();
                    int touchY = (int) event.getY();
                    int color = getColour(touchX, touchY);
                    Log.d("color:", color + "");
                    String hexColor = String.format("#%06X", (0xFFFFFF & color));
                    Log.d("hexColor:", hexColor + "");
                    final Question_library question_library = new Question_library();
                    int i = 0;
                    while (color != ContextCompat.getColor(Dini3.this, question_library.get_dini_color(i))) {
                        i++;
                        if (i > 11) break;
                    }
                    if (i > 11) {
                    } else {
                        if(!sound) {
                            final int dini_voice = question_library.get_sound_of_emam(i);
                            mp3 = MediaPlayer.create(Dini3.this, dini_voice);
                            mp3.start();
                            sound = true;
                            gol.setAnimation(skake);
                            gol.startAnimation(skake);
                            mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp3.release();
                                    sound = false;
                                    gol.clearAnimation();
                                }
                            });
                        }
                    }
                }
                return true;
            }
        });
        }
    private int getColour( int x, int y)
    {
        ImageView img = (ImageView) findViewById(R.id.dini3_img);
        img.setDrawingCacheEnabled(true);
        Bitmap hotspots=Bitmap.createBitmap(img.getDrawingCache());
        img.setDrawingCacheEnabled(false);
        return hotspots.getPixel(x, y);
    }
    public void onBackPressed() {
        if(sound ){
            stop_play();
        }
        this.finish();
    }
    private void stop_play() {
    /*if(mp3!=null){
        mp3.stop();
        mp3.release();    }*/
        if(mp3!=null && sound){
            mp3.release();
        }
    }
    @Override
    protected void onPause() {
        if(sound ){
            stop_play();
        }
        super.onPause();
    }
    @Override
    protected void onStop() {
        if(sound ){
            stop_play();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if(sound ){
            stop_play();
        }
        super.onDestroy();
    }
}
