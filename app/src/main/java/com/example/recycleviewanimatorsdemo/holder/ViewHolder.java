package com.example.recycleviewanimatorsdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycleviewanimatorsdemo.R;

/**
 * author：Admin
 * date：2017/11/2118:40
 * 编程使我快乐
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView text;

    public ViewHolder(View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image);
        text = itemView.findViewById(R.id.text);
    }
}
