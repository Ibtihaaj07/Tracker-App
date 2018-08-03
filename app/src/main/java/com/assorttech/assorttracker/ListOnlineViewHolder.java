package com.assorttech.assorttracker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ListOnlineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtEmail;
    ItemClickListener mItemClickListener;
    public ListOnlineViewHolder(View itemView) {
        super(itemView);
        txtEmail = itemView.findViewById(R.id.txt_email);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        mItemClickListener.onClick(view, getAdapterPosition());

    }
}
