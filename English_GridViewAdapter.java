package com.shahruie.www.Knowledge_Train;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class English_GridViewAdapter extends BaseAdapter {

    private Context context;
    private int [] word_icon;
    private int [] sounds;
    private MediaPlayer mp3;
    private Animation skake;

    public English_GridViewAdapter(Context context,  int [] word_icon,int [] sounds) {
 
        this.context=context;
        this.word_icon=word_icon;
        this.sounds=sounds;
    }
 
    @Override
    public int getCount() {
 
        return word_icon.length;
    }
 
    @Override
    public Object getItem(int position) {
 
        return null;
    }
 
    @Override
    public long getItemId(int position) {
 
        return 0;
    }
 
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
 
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.english_row_lay, null);
        final ImageView icon=(ImageView)convertView.findViewById(R.id.english_row_img);
        skake = AnimationUtils.loadAnimation(context,
                R.anim.shake2);
        icon.setImageResource(word_icon[position]);
        icon.setTag(Integer.valueOf(position));
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer)v.getTag();
            final int sound=sounds[position];
                mp3 = MediaPlayer.create(context, sound);
                if(!English.is_playing){
                    mp3.start();
                    English.is_playing=true;
                    English.is_playing3=true;
                    icon.setAnimation(skake);
                    icon.startAnimation(skake);
                }
                mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp3.release();
                        English.is_playing3=false;
                        English.is_playing=false;
                        icon.clearAnimation();
                        /*int center=question_library.get_sound_of_eword(finalI);
                        *//*mp5 = MediaPlayer.create(Context, center);
                        mp5.start();
                        mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp5.release();
                                is_playing5=false;
                                is_playing=false;
                            }
                        });*/
                    }
                });
            }
        });
        return convertView;

    }
}