package com.shahruie.www.Knowledge_Train;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.media.MediaPlayer;
import android.util.Log;
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

import static com.shahruie.www.Knowledge_Train.Ostanha_amuzesh.is_playing;

public class CustomGridViewAdapter2 extends BaseAdapter {

    private Context context;
    private String [] ostan_name;
    private int [] ostan_icon;

     Boolean is_playing3,is_playing5;
     Question_library question_library=new Question_library();


    public CustomGridViewAdapter2(Context context, String [] ostan_name, int [] ostan_icon) {
 
        this.context=context;
        this.ostan_icon=ostan_icon;

        this.ostan_name=ostan_name;
    }
 
    @Override
    public int getCount() {
 
        return ostan_name.length;
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
        convertView=inflater.inflate(R.layout.title_on_img_row_layout, null);
        TextView name=(TextView)convertView.findViewById(R.id.row_tv);
        final ImageView icon=(ImageView)convertView.findViewById(R.id.row_img);
        final Animation skake = AnimationUtils.loadAnimation(context,
                R.anim.shake2);
        name.setText(ostan_name[position]);
        icon.setImageResource(ostan_icon[position]);
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
                icon.setAnimation(skake);
                    final int ostan=question_library.get_voice_of_ostan(position);
                    final int finalI = position;
                    Ostanha_amuzesh.mp3 = MediaPlayer.create(context, ostan);
                    if(!is_playing){
                        Ostanha_amuzesh.mp3.start();
                        icon.startAnimation(skake);
                        is_playing=true;
                        is_playing3=true;
                        Log.d("aval","aval");
                    }
                    Ostanha_amuzesh.mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Ostanha_amuzesh.mp3.release();
                            is_playing3=false;
                            is_playing=false;
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