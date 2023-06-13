package com.shahruie.www.Knowledge_Train;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Keshvarha extends AppCompatActivity {
    public static boolean is_playing,is_playing3;
    GridView keshvar;
    private int[] keshvar_images;
    static public MediaPlayer mp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        keshvar=(GridView)findViewById(R.id.english_gv);
        is_playing=false;
        Question_library question_library=new Question_library();
        keshvar_images=question_library.get_parcham_img();
        String keshvar_name[]=question_library.get_keshvar_name();
        int keshvar_voice[]=question_library.get_sounds_of_keshvar();
        keshvar=(GridView)findViewById(R.id.english_gv);
        keshvar.setAdapter(new ParchamGridViewAdapter(this,keshvar_images,keshvar_name,keshvar_voice));
        keshvar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
