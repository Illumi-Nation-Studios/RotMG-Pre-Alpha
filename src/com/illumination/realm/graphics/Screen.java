package com.illumination.realm.graphics;

import java.util.Random;

import com.illumination.realm.Game;

@SuppressWarnings({ "unused" })
public class Screen {
	private int width, height;
	public int[] tiles = new int[64 * 64];
	public int[] pixels;

	private Random rnd = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		for (int i = 0; i < 64 * 64; i++) {
			tiles[i] = rnd.nextInt(0xfffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render() {
	
		for (int y1 = 0; y1 < height; y1++) {
			if (y1 < 0 || y1 >= height)
				break;
			int y2 = y1;
			for (int x1 = 0; x1 < width; x1++) {
				if (x1 < 0 || x1 >= width)
					break;
				int x2 = x1;
				int tileIndex = (x1 >> 4) + (y1 >> 4) * 64;
				pixels[x1 + y1 * width] = tiles[tileIndex];
			}
		}
	}
}
