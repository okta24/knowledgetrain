package com.shahruie.www.Knowledge_Train;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dini extends AppCompatActivity {

    ImageView video,emaman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dini);
        video=(ImageView)findViewById(R.id.play_dini_video_btn);
        emaman=(ImageView)findViewById(R.id.amuzesh_emaman_btn);
        emaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dini.this, Dini3.class);
                startActivity(intent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dini.this, Select_Dini_video.class);
                startActivity(intent);
            }
        });


    }
}
