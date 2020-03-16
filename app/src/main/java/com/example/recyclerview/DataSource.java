package com.example.recyclerview;

import java.util.ArrayList;

public class DataSource {

	private static final int NUMBER_COUNT = 10;
	private final ArrayList<Integer> sourceData;

	private DataSource() {
		sourceData = new ArrayList<>();

		for (Integer i = 0; i < NUMBER_COUNT; i++) {
			sourceData.add(i);
		}
	}

	public ArrayList<Integer> getSourceData() {
		return sourceData;
	}

	private static class SingletonHolder {
		private static final DataSource INSTANCE = new DataSource();
	}

	public static DataSource getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void add() {
		Integer last = sourceData.get(sourceData.size() - 1);
		sourceData.add(last + 1);
	}
}
