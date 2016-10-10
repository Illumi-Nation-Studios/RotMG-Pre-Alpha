package com.illumination.realm.level;

import com.illumination.realm.graphics.Screen;

public class Level {

	protected int width, height;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	private void generateLevel() {

	}

	private void loadLevel(String path) {

	}

	public void update() {

	}
	
	private void time() {
		
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		int x0 = xScroll / 16;
	}
}
