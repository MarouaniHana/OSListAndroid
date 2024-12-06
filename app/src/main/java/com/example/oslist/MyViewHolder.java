package com.example.oslist;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView1,textView2;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.img);
        textView1=itemView.findViewById(R.id.tvOS);
        textView2=itemView.findViewById(R.id.tvPlateforme);
    }
    public void bind(OSystem osystem){
        imageView.setImageResource(osystem.getLogo());
        textView1.setText(osystem.getOsys());
        textView2.setText(osystem.getPlateforme());
    }
}

