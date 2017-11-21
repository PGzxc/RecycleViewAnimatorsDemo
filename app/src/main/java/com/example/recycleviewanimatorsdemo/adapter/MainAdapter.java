package com.example.recycleviewanimatorsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.recycleviewanimatorsdemo.R;
import com.example.recycleviewanimatorsdemo.holder.ViewHolder;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * author：Admin
 * date：2017/11/2118:39
 * 编程使我快乐
 */

public class MainAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private List<String> mDatas;

    public MainAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context).load(R.drawable.chip).into(holder.image);
        holder.text.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public void add(String text, int position) {
        mDatas.add(position, text);
        notifyItemInserted(position);
    }
}
