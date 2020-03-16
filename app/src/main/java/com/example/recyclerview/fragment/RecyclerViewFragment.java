package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.recyclerview.DataAdapter;
import com.example.recyclerview.DataSource;
import com.example.recyclerview.R;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment {

	private static final int GRID_COLUMNS_VERTICAL = 3;
	private static final int GRID_COLUMNS_HORIZONTAL = 4;

	private DataAdapter adapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

		RecyclerView recyclerView = view.findViewById(R.id.recycler);

		ArrayList<Integer> data = DataSource.getInstance().getSourceData();
		adapter = new DataAdapter();
		adapter.update(data);

		int columnsCount = getResources().getBoolean(R.bool.is_horizontal) ?  GRID_COLUMNS_HORIZONTAL : GRID_COLUMNS_VERTICAL;
		GridLayoutManager manager = new GridLayoutManager(getContext(), columnsCount, RecyclerView.VERTICAL, false);
		recyclerView.setLayoutManager(manager);

		recyclerView.setAdapter(adapter);

		Button btn = view.findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DataSource.getInstance().add();
				ArrayList<Integer> newData = DataSource.getInstance().getSourceData();
				adapter.update(newData);
			}
		});

		return view;
	}
}
