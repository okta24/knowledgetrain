package com.shahruie.www.Knowledge_Train;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Title_iamge_gridview_adapter extends BaseAdapter {

    private Context context;
    private int [] icons;
    private  String [] title;
    private  int cat;

    public Title_iamge_gridview_adapter(Context context,int cat, int [] icons, String [] title) {
 
        this.context=context;
        this.icons=icons;
        this.title=title;
        this.cat=cat;

    }
 
    @Override
    public int getCount() {
 
        return icons.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
 
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.row_lay, null);
        Question_library question_library=new Question_library();
        final ImageView icon=(ImageView)convertView.findViewById(R.id.row_img);
        final ImageView download=(ImageView)convertView.findViewById(R.id.video_download_img);
        TextView titletv=(TextView)convertView.findViewById(R.id.row_tv);
        TextView mask_tv=(TextView)convertView.findViewById(R.id.tv_mask_cell);
        icon.setImageResource(icons[position]);
        titletv.setText(title[position]);
        String video_path = null;
         if(cat==1)
             video_path=question_library.get_Video_amuzeshi_path(position);
        else if(cat==2)
            video_path=question_library.get_Video_dini_path(position);
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