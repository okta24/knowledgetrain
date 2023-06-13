package com.shahruie.www.Knowledge_Train;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

public class Select_alefba_video extends AppCompatActivity {
GridView alefba;
    private int[] video_images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        alefba=(GridView)findViewById(R.id.english_gv);
        Question_library question_library=new Question_library();
        video_images=question_library.get_alefba_img();
        alefba.setAdapter(new Alefba_adapter(this,video_images));
        alefba.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if((position>5)&&(!loadData())){
                    position=0;
                    Intent serviceIntent = new Intent("ir.cafebazaar.pardakht.InAppBillingService.BIND");
                    serviceIntent.setPackage("com.farsitel.bazaar");
                    List<ResolveInfo> intentServices = Select_alefba_video.this.getPackageManager().queryIntentServices(serviceIntent, 0);
                    if(serviceIntent!=null)
                        if (intentServices != null && intentServices.isEmpty() == false) {
                            Intent newActivity = new Intent(Select_alefba_video.this,Pardakht.class);
                            startActivity(newActivity);
                        }else 		Toast.makeText(Select_alefba_video.this, "برای خریداری نسخه اصلی بایستی برنامه بازار بر روی گوشی شما نصب باشد.", Toast.LENGTH_LONG).show();

                }else{
                Intent intent = new Intent(getApplicationContext(), Play_video.class);
                intent.putExtra("id",position);
                intent.putExtra("cat",2);
                startActivity(intent);}
            }
        });
    }
    private Boolean loadData() {
        SharedPreferences pref;
        pref = getApplicationContext().getSharedPreferences("MyPref3", MODE_PRIVATE);
        Boolean mIsPremium =  pref.getBoolean("mIsPremium", false);
        return mIsPremium;
    }
    @Override
    public void onResume() {
        super.onResume();
        alefba.setAdapter(new Alefba_adapter(this,video_images));
    }
}
