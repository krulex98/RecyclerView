package com.example.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.fragment.NumberViewFragment;

class NumberViewHolder extends RecyclerView.ViewHolder {

	private final TextView textView;
	private final FragmentManager fragmentManager;
	private final ContextProvider contextProvider;

	private int color;

	NumberViewHolder(@NonNull View itemView, FragmentManager _fragmentManager, ContextProvider _contextProvider) {
		super(itemView);
		fragmentManager = _fragmentManager;
		contextProvider = _contextProvider;

		textView = itemView.findViewById(R.id.item_title);
	}

	void setTitle(Integer number) {
		textView.setText(String.valueOf(number));

		Context context = contextProvider.getContext();
		color = number % 2 == 0 ? context.getResources().getColor(R.color.colorWhite) : context.getResources().getColor(R.color.colorDark);
		textView.setTextColor(color);
	}

	void bindClickListener(final int position) {
		itemView.findViewById(R.id.view_item).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			fragmentManager
				.beginTransaction()
				.add(R.id.container, new NumberViewFragment(DataSource.getInstance().getByIndex(position), color))
				.addToBackStack(null)
				.commit();
			}
		});
	}
}
