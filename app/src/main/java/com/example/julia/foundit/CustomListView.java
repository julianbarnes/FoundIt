package com.example.julia.foundit;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by julia on 3/8/2018.
 */

public class CustomListView extends ArrayAdapter<String> {
    private String[] item_names;
    private String[] desc;
    private Integer[] imgid;
    private Activity context;

    public CustomListView(Activity context, String[] item_names, String[] desc, Integer[] imgid) {

        super(context, R.layout.listviewlayout, item_names);

        this.context = context;
        this.item_names = item_names;
        this.desc=desc;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null) {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listviewlayout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) r.getTag();

        }

        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(item_names[position]);
        viewHolder.tvw2.setText(desc[position]);
        return r;

    }
}
class ViewHolder
{
    TextView tvw1;
    TextView tvw2;
    ImageView ivw;
    ViewHolder(View v)
    {
        tvw1=v.findViewById(R.id.item_title);
        tvw2= v.findViewById(R.id.item_desc);
        ivw= v.findViewById(R.id.item_pic);
    }
}
