package com.shahruie.www.Knowledge_Train;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class English extends AppCompatActivity {
    static boolean is_playing=false;
    public static boolean is_playing3;
    public GridView gridview;
    //private static String [] ostan_name;
    private static int [] word_img;
    Question_library question_library=new Question_library();
    static MediaPlayer mp3,mp5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        word_img=question_library.get_words_img();
        int word_voice[]=question_library.get_sounds_of_words();
        String ewords[]=question_library.get_ewords();
        is_playing=false;
        gridview=(GridView)findViewById(R.id.english_gv);
        gridview.setAdapter(new EnlishGridViewAdapter(this,word_img,ewords,word_voice));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

    }
    private void stop_play() {
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

