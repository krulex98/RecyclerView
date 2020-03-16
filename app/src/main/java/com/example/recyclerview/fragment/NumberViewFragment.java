package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recyclerview.R;

public class NumberViewFragment extends Fragment {

	public NumberViewFragment() {}

	private Integer number;

	public NumberViewFragment(Integer _number) {
		number = _number;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_number_view, container, false);
		TextView textView = view.findViewById(R.id.number);
		textView.setText(String.valueOf(number));
		return view;
	}
}
