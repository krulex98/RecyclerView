package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.recyclerview.DataAdapter;
import com.example.recyclerview.DataSource;
import com.example.recyclerview.R;

import java.util.List;


public class RecyclerViewFragment extends Fragment {

	private static final int GRID_COLUMNS_VERTICAL = 3;
	private static final int GRID_COLUMNS_HORIZONTAL = 4;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_recycler_view, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		RecyclerView recyclerView = view.findViewById(R.id.recycler);

		List<Integer> data = DataSource.getInstance().getSourceData();
		DataAdapter adapter = new DataAdapter(data);

		GridLayoutManager manager = new GridLayoutManager(getContext(), GRID_COLUMNS_VERTICAL);
		recyclerView.setLayoutManager(manager);

		recyclerView.setAdapter(adapter);
	}
}
