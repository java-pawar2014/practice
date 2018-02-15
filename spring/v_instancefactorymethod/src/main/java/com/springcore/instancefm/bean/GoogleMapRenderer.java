package com.springcore.instancefm.bean;

public class GoogleMapRenderer {

	private MapEngine mapEngine;

	public void render(String source, String destination) {
		String[] directions = mapEngine.getDirection(source, destination);
		System.out.print("Directions: ");
		for (String direction : directions) {
			System.out.print(direction);
		}
	}

	public MapEngine getMapEngine() {
		return mapEngine;
	}

	public void setMapEngine(MapEngine mapEngine) {
		this.mapEngine = mapEngine;
	}

}
