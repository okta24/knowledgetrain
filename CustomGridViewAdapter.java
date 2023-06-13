package com.shahruie.www.Knowledge_Train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class CustomGridViewAdapter extends BaseAdapter {
 
    private Context context;
    private String [] ostan_name;
    private int [] ostan_icon;

 
    public CustomGridViewAdapter(Context context, String [] ostan_name,int [] ostan_icon) {
 
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
        convertView=inflater.inflate(R.layout.row_lay, null);
        TextView name=(TextView)convertView.findViewById(R.id.row_tv);
        ImageView icon=(ImageView)convertView.findViewById(R.id.row_img);

        name.setText(ostan_name[position]);
        icon.setImageResource(ostan_icon[position]);

        return convertView;
    }
}