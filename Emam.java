package com.shahruie.www.Knowledge_Train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Emam extends AppCompatActivity {

    public static boolean is_playing;
    GridView emam;
    private int[] emam_images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_english);
        emam=(GridView)findViewById(R.id.english_gv);
        Question_library question_library=new Question_library();
        //emam_images=question_library.get_emam_img();

        int emam_voice[]=question_library.get_sounds_of_emam();
        emam=(GridView)findViewById(R.id.english_gv);
        emam.setAdapter(new English_GridViewAdapter(this,emam_images,emam_voice));
        emam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }
    private void stop_play() {

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
