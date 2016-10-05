package com.illumination.realm.graphics;

import java.util.Random;

import com.illumination.realm.tile.Tile;

public class Screen {
	private int width, height;
	public final int mapSize = 64;
	public final int mapSize_mask = mapSize - 1;
	public int[] tiles = new int[mapSize * mapSize];
	public int[] pixels;

	private Random rnd = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		for (int i = 0; i < mapSize * mapSize; i++) {
			tiles[i] = rnd.nextInt(0xfffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffset, int yOffset) {

		for (int y1 = 0; y1 < height; y1++) {
			int y2 = y1 - yOffset;
			if (y2 < 0 || y2 >= height)
				continue;
			for (int x1 = 0; x1 < width; x1++) {
				int x2 = x1 - xOffset;
				if (x2 < 0 || x2 >= width)
					continue;
				pixels[(x2) + (y2) * width] = Sprite.grass_green.pixels[(x1 & (Sprite.grass_green.SIZE - 1))
						+ (y1 & (Sprite.grass_green.SIZE - 1)) * Sprite.SIZE];
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
		}
	}
	
}
