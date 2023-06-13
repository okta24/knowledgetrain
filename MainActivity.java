package com.shahruie.www.Knowledge_Train;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import co.ronash.pushe.Pushe;

import static android.support.v7.app.AlertDialog.*;

public class MainActivity extends AppCompatActivity {

    ImageView info,comment;
    private boolean sound;
    ImageView exit,mut,english, music,ostanha,keshvar,emam,alefba;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

       Pushe.initialize(this,true);
        Animation slid_in = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.slide_in_from_right);
        music = (ImageView) findViewById(R.id.main_music);
        comment = (ImageView) findViewById(R.id.main_comment);
        info = (ImageView) findViewById(R.id.main_info);
        ImageView ghatar = (ImageView) findViewById(R.id.ghatar_ic);
        english = (ImageView) findViewById(R.id.main_english);
        alefba = (ImageView) findViewById(R.id.main_alefba);
        ostanha = (ImageView) findViewById(R.id.main_ostanha);
        emam = (ImageView) findViewById(R.id.main_emam);
        keshvar = (ImageView) findViewById(R.id.main_keshvarha);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll_main);
        ll.setAnimation(slid_in);
        ll.startAnimation(slid_in);
       // mut = (ImageView) findViewById(R.id.main_mut);
       exit = (ImageView) findViewById(R.id.main_exit);
        sound = true;
        /*AudioManager amanager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = amanager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
        amanager.setStreamVolume(AudioManager.STREAM_ALARM, maxVolume, 0);

        mp.setAudioStreamType(AudioManager.STREAM_ALARM); // this is important.*/

        mp = MediaPlayer.create(MainActivity.this, R.raw.train);
        //mp.setLooping(true);
        mp.setVolume(0.07f, 0.07f);
        mp.start();
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Film_Amuzeshi.class);
                startActivity(intent);
            }
        });
        emam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Dini.class);
                startActivity(intent);
            }
        });
        keshvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Keshvarha3.class);
                startActivity(intent);
            }
        });
        alefba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Select_alefba_video.class);
                startActivity(intent);
            }
        });
        ostanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Ostanha_amuzesh.class);
                startActivity(intent);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), English2.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                info.getWindow().getAttributes().windowAnimations=R.style.PauseDialogAnimation2;
                DisplayMetrics displaymetrics = new DisplayMetrics();
                MainActivity.this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
                lp.dimAmount = 0.3f;
                lp.width = LinearLayout.LayoutParams.WRAP_CONTENT;
                lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;
                dialog.getWindow().setAttributes(lp);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog.setContentView(R.layout.exit);
                ImageView comment = (ImageView) dialog.findViewById(R.id.exit_comment);
                ImageView exit = (ImageView) dialog.findViewById(R.id.exit_exit);
                comment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setData(Uri.parse("bazaar://details?id=" + "com.shahruie.www.Knowledge_Train"));
                        intent.setPackage("com.farsitel.bazaar");
                        startActivity(intent);
                    }
                });
                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        if (mp != null) {
                            mp.release();
                            mp = null;
                        }
                        finish();
                    }
                });
                dialog.show();
            }
        });
       /* mut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound) {
                    mut.setImageResource(R.drawable.if_mute_2);
                    sound = false;
                    mp.pause();
                } else {
                    mut.setImageResource(R.drawable.if_unmute);
                    sound = true;
                    mp.start();
                }
            }
        });*/
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setData(Uri.parse("bazaar://details?id=" +  "com.shahruie.www.Knowledge_Train"));
                intent.setPackage("com.farsitel.bazaar");
                startActivity(intent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Builder alertDialog = new Builder(MainActivity.this);
                alertDialog.setTitle("درباره ما");
                alertDialog.setMessage("طراح و برنامه نویس:شهرویی \n منبع فیلم ها:آپارات");
                alertDialog.setPositiveButton("yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
                           }
        });
    }
    public void onBackPressed() {

        if (mp != null) {
            mp.release();
            mp  = null;}
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mp != null) {
            if(sound)
            mp.pause();}
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mp != null) {
            if(sound)
            mp.start();}
       // else
          //  mut.setImageResource(R.drawable.if_mute_2);
    }
    /*private int getColour( int x, int y)
    {
        ImageView img = (ImageView) findViewById(R.id.keshvar);
        img.setDrawingCacheEnabled(true);
        Bitmap hotspots=Bitmap.createBitmap(img.getDrawingCache());
        img.setDrawingCacheEnabled(false);
        return hotspots.getPixel(x, y);
    }*/
}
