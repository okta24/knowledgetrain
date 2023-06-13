package com.shahruie.www.Knowledge_Train;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
public class Play_video extends AppCompatActivity {
    VideoView videoView;
    String video_path;
    Boolean _isInternetPresent = false;
    ConnectionDetector _cd;
    int stopPosition;
    int i,cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_video);
        videoView = (VideoView) findViewById(R.id.video_player);
        Question_library question_library=new Question_library();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            i = extras.getInt("id");
            cat=extras.getInt("cat");
        }
        if(cat==2)
            video_path=question_library.get_video_path(i);
        else if(cat==1)
            video_path=question_library.get_Video_dini_path(i);
        else if(cat==3)
            video_path=question_library.get_Video_amuzeshi_path(i);

        String downloadFileName = video_path.substring(video_path.lastIndexOf( '/' ),video_path.length());
        String filePath=Environment.getExternalStorageDirectory().getPath()+ "/قطار دانش/"+downloadFileName;
        File file = new File(filePath);
        if(file.exists()) {
            videoView.setVideoPath(filePath);
            MediaController mediaController;
            mediaController = new MediaController(Play_video.this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.start();
            videoView.requestFocus();
        }
        else {
            _cd = new ConnectionDetector(getApplicationContext());
            _isInternetPresent = _cd.isConnectingToInternet();
            if (_isInternetPresent) {
                MediaController mediaController;
                videoView.setVideoPath(video_path);
                mediaController = new MediaController(Play_video.this);
                mediaController.setAnchorView(videoView);
                videoView.setMediaController(mediaController);
                videoView.start();
                videoView.requestFocus();
                new DownloadTask(Play_video.this, video_path);
            } else {
                Toast.makeText(Play_video.this, "اتصال اینترنت برقرار نمیباشد", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
    @Override
    public void onPause() {
//        Log.d("jkl", "onPause called");
//        if(videoView.isPlaying()){
//        stopPosition = videoView.getCurrentPosition(); //stopPosition is an int
//        Log.d("ti",stopPosition+"");
//        videoView.pause();}
        finish();
        super.onPause();
    }
    @Override
    public void onResume() {
        //Log.d("gf", "onResume called");
        //videoView.start(); //Or use resume() if it doesn't work. I'm not sure
        //videoView.seekTo(stopPosition);
       // Log.d("ti",stopPosition+"");
        super.onResume();
    }
    }
