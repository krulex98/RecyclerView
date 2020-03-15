package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class NumberViewHolder extends RecyclerView.ViewHolder {

	final TextView title;

	NumberViewHolder(@NonNull View itemView) {
		super(itemView);

		title = itemView.findViewById(R.id.item_title);
	}
}
