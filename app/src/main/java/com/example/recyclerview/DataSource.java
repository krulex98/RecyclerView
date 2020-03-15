package com.example.recyclerview;

import java.util.List;
import java.util.ArrayList;

public class DataSource {

	private static final int NUMBER_COUNT = 100;
	private final List<Integer> sourceData;

	private DataSource() {
		sourceData = new ArrayList<>();

		for (Integer i = 0; i < NUMBER_COUNT; i++) {
			sourceData.add(i);
		}
	}

	public List<Integer> getSourceData() {
		return sourceData;
	}

	private static class SingletonHolder {
		private static final DataSource INSTANCE = new DataSource();
	}

	public static DataSource getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
