package com.illumination.realm.graphics;

import java.util.Random;

import com.illumination.realm.Game;

@SuppressWarnings({ "unused" })
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
			if (y1 < 0 || y1 >= height)
				continue;
			int y2 = y1 + yOffset;
			for (int x1 = 0; x1 < width; x1++) {
				if (x1 < 0 || x1 >= width)
					continue;
				int x2 = x1 + xOffset;
				int tileIndex = ((x2 >> 4) & mapSize_mask) + ((y2 >> 4) & mapSize_mask) * mapSize;
				pixels[x1 + y1 * width] = tiles[tileIndex];
			}
		}
	}
}
