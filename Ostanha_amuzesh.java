package com.shahruie.www.Knowledge_Train;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Ostanha_amuzesh extends AppCompatActivity {
     static  boolean  is_playing=false;
    public GridView gridview;
    private static String [] ostan_name;
    private static int [] ostan_img;
    static public MediaPlayer mp3,mp5;
    int images[]={R.drawable.circle1,R.drawable.circle2,R.drawable.circle3,
            R.drawable.circle7,R.drawable.circle5,R.drawable.circle6,
            R.drawable.circle7,R.drawable.circle2,R.drawable.circle3,
            R.drawable.circle4,R.drawable.circle5,R.drawable.circle6,
            R.drawable.circle1,R.drawable.circle2,R.drawable.circle3,
            R.drawable.circle4,R.drawable.circle5,R.drawable.circle6,
            R.drawable.circle1,R.drawable.circle2,R.drawable.circle3,
            R.drawable.circle4,R.drawable.circle5,R.drawable.circle6,
            R.drawable.circle1,R.drawable.circle2,R.drawable.circle3,
            R.drawable.circle4,R.drawable.circle5,R.drawable.circle6,
            R.drawable.circle1,R.drawable.circle2,R.drawable.circle3,
            R.drawable.circle4,R.drawable.circle5,R.drawable.circle6,
            R.drawable.circle1,R.drawable.circle2,R.drawable.circle3,
            R.drawable.circle4,R.drawable.circle5,R.drawable.circle6,
    };
    Question_library question_library=new Question_library();
    private MediaPlayer mp;
   // private MediaPlayer mp2,mp3,mp4,mp5;
    private boolean is_playing5,is_playing4,is_playing3,is_playing2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amuzesh);
        is_playing=false;
        ostan_name=question_library.get_ostanha();
       // ostan_img=question_library.get_ostanha_img();
        gridview=(GridView)findViewById(R.id.gv_amuzesh);
        gridview.setAdapter(new CustomGridViewAdapter2(this,ostan_name,images));
       gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


           }
       });

    }
    private void stop_play() {
        /*//if(is_playing2) {mp2.stop();mp2.release();is_playing2=false;}
        if(is_playing3) {mp3.stop();mp3.release();is_playing3=false;}
       // if(is_playing4) {mp4.stop();mp4.release();is_playing4=false;}
        if(is_playing5){ mp5.stop();mp5.release();is_playing5=false;}*/
        if(mp3!=null && is_playing){
            mp3.release();
        }

    }
    public void onBackPressed() {

        if(is_playing){
            stop_play();

        }
        this.finish();
    }
    @Override
    protected void onPause() {

        if(is_playing){
            stop_play();

        }
        super.onPause();
    }
    @Override
    protected void onStop() {

        if(is_playing){
            stop_play();

        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        if(is_playing){
            stop_play();

        }
        super.onDestroy();
    }
}
