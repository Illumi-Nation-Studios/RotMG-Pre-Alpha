package com.illumination.realm.graphics;

public class Sprite {

	public static int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass_green = new Sprite(16, 6, 4, SpriteSheet.lofiEnvironment);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * (sheet.SIZE)];
			}
		}
	}
}
