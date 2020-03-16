package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<NumberViewHolder> {
	private final ArrayList<Integer> data = new ArrayList<>();

	@NonNull
	@Override
	public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater
				.from(parent.getContext())
				.inflate(R.layout.recycler_view_item, parent, false);

		return new NumberViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
		Integer number = data.get(position);
		holder.title.setText(String.valueOf(number));
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	public void update(ArrayList<Integer> newData) {
		data.clear();
		data.addAll(newData);
		notifyDataSetChanged();
	}
}
