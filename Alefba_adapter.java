package com.shahruie.www.Knowledge_Train;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Alefba_adapter extends BaseAdapter {

    private Context context;
    private int [] word_icon;
    private Question_library question_library=new Question_library();
    private MediaPlayer mp3;
    private Animation skake;

    public Alefba_adapter(Context context, int [] word_icon) {
 
        this.context=context;
        this.word_icon=word_icon;
       // this.word_name=word_name;
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
        convertView=inflater.inflate(R.layout.image_only_row, null);
        final ImageView icon=(ImageView)convertView.findViewById(R.id.row_img_2);
        TextView mask_tv=(TextView)convertView.findViewById(R.id.tv_mask_cell_2);
        final ImageView download=(ImageView)convertView.findViewById(R.id.video_download_img2);
        icon.setImageResource(word_icon[position]);
        String video_path = null;
        video_path=question_library.get_video_path(position);
        String downloadFileName = video_path.substring(video_path.lastIndexOf( '/' ),video_path.length());
        String filePath= Environment.getExternalStorageDirectory().getPath()+ "/قطار دانش/"+downloadFileName;
        File file = new File(filePath);
        if(file.exists()) {
            download.setVisibility(View.GONE);
            mask_tv.setVisibility(View.GONE);
        }else{
            download.setVisibility(View.VISIBLE);
            mask_tv.setVisibility(View.VISIBLE);}
        return convertView;

    }
}