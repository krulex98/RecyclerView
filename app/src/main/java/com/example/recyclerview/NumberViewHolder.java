package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.fragment.NumberViewFragment;

class NumberViewHolder extends RecyclerView.ViewHolder {

	private final TextView textView;
	private final FragmentManager fragmentManager;

	NumberViewHolder(@NonNull View itemView, FragmentManager _fragmentManager) {
		super(itemView);
		fragmentManager = _fragmentManager;

		textView = itemView.findViewById(R.id.item_title);
	}

	void setTitle(String text) {
		textView.setText(text);
	}

	void bindClickListener(final int position) {
		itemView.findViewById(R.id.view_item).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				fragmentManager
					.beginTransaction()
					.add(R.id.container, new NumberViewFragment(DataSource.getInstance().getByIndex(position)))
					.addToBackStack(null)
					.commit();
			}
		});
	}
}
