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

public class Film_Amuzeshi extends AppCompatActivity {
    int []cell_img;
    int cat;
    GridView gridview;
    String video_title[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film__amuzeshi);
        Question_library question_library=new Question_library();
        cell_img=question_library.get_video_amuzeshi_img();
         video_title=question_library.get_amuzeshi_video_title();
         gridview=(GridView)findViewById(R.id.gv_film_amuzesh);
         cat=1;
        gridview.setAdapter(new Title_iamge_gridview_adapter(this,cat,cell_img,video_title));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if((position>5)&&(!loadData())){
                    position=0;
                    Intent serviceIntent = new Intent("ir.cafebazaar.pardakht.InAppBillingService.BIND");
                    serviceIntent.setPackage("com.farsitel.bazaar");
                    List<ResolveInfo> intentServices = Film_Amuzeshi.this.getPackageManager().queryIntentServices(serviceIntent, 0);
                    if(serviceIntent!=null)
                        if (intentServices != null && intentServices.isEmpty() == false) {
                            Intent newActivity = new Intent(Film_Amuzeshi.this,Pardakht.class);
                            startActivity(newActivity);
                        }else 		Toast.makeText(Film_Amuzeshi.this, "برای خریداری نسخه اصلی بایستی برنامه بازار بر روی گوشی شما نصب باشد.", Toast.LENGTH_LONG).show();

                }else{
                Intent intent = new Intent(getApplicationContext(), Play_video.class);
                intent.putExtra("id",position);
                intent.putExtra("cat",3);
                startActivity(intent);
            }}
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
        gridview.setAdapter(new Title_iamge_gridview_adapter(this,cat,cell_img,video_title));
    }
}
