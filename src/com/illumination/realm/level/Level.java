package com.illumination.realm.level;

import com.illumination.realm.graphics.Screen;
import com.illumination.realm.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tileInt;
	
	public int mapSize = 2048;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tileInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public void update() {

	}

	@SuppressWarnings("unused")
	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.tileVoid;
		if (tileInt[x * y + width] == 0) return Tile.sandLight;
		if (tileInt[x * y + width] == 2) return Tile.grassGreen;
		if (tileInt[x * y + width] == 3) return Tile.grassYellow;
		if (tileInt[x * y + width] == 4) return Tile.sandDark;
		return Tile.tileVoid;
	}
}
