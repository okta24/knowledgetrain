package com.shahruie.www.Knowledge_Train;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EnlishGridViewAdapter extends BaseAdapter {

    private Context context;
    private int [] icons;
    private  String [] title;
    private int [] voice;

    private Animation skake;

    public EnlishGridViewAdapter(Context context, int [] icons, String [] keshvar_name, int [] voice) {
 
        this.context=context;
        this.icons=icons;
        this.title =keshvar_name;
        this.voice=voice;
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
        convertView=inflater.inflate(R.layout.cell_lay, null);
        final ImageView icon=(ImageView)convertView.findViewById(R.id.row_img);
        TextView name=(TextView)convertView.findViewById(R.id.row_tv);
        icon.setImageResource(icons[position]);
        name.setText(title[position]);

        skake = AnimationUtils.loadAnimation(context,
                R.anim.shake2);
        icon.setTag(Integer.valueOf(position));
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer)v.getTag();
                if((position>5)&&(!loadData())){
                    position=0;
                    Intent serviceIntent = new Intent("ir.cafebazaar.pardakht.InAppBillingService.BIND");
                    serviceIntent.setPackage("com.farsitel.bazaar");
                    List<ResolveInfo> intentServices = context.getPackageManager().queryIntentServices(serviceIntent, 0);
                    if(serviceIntent!=null)
                        if (intentServices != null && intentServices.isEmpty() == false) {
                            Intent newActivity = new Intent(context,Pardakht.class);
                            context.startActivity(newActivity);
                        }else 		Toast.makeText(context, "برای خریداری نسخه اصلی بایستی برنامه بازار بر روی گوشی شما نصب باشد.", Toast.LENGTH_LONG).show();

                }else{
                final int sound=voice[position];
                English.mp3 = MediaPlayer.create(context, sound);
                if(!English.is_playing){
                    English.mp3.start();
                    English.is_playing=true;
                    English.is_playing3=true;
                    icon.setAnimation(skake);
                    icon.startAnimation(skake);
                }
                    English.mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        English.mp3.release();
                        English.is_playing3=false;
                        English.is_playing=false;
                        icon.clearAnimation();
                    }
                });
            }}
        });

        return convertView;
    }
    private Boolean loadData() {
        SharedPreferences pref;
        pref = context.getSharedPreferences("MyPref3", context.MODE_PRIVATE);
        Boolean mIsPremium =  pref.getBoolean("mIsPremium", false);
        return mIsPremium;
    }
}