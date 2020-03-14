package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	final int GRID_COLUMNS_VERTICAL = 3;
	final int GRID_COLUMNS_HORIZONTAL = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RecyclerView recyclerView = findViewById(R.id.recycler);

		List<Integer> data = DataSource.getInstance().getSourceData();
		DataAdapter adapter = new DataAdapter(data);

		GridLayoutManager manager = new GridLayoutManager(this, GRID_COLUMNS_VERTICAL);
		recyclerView.setLayoutManager(manager);

		recyclerView.setAdapter(adapter);
	}
}
