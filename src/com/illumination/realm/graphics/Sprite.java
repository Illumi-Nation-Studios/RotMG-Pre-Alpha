package com.illumination.realm.graphics;

import java.util.Arrays;

public class Sprite {

	public static int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite voidSprite = new Sprite(16, 0);

	public static Sprite grass1 = new Sprite(16, 6, 4, SpriteSheet.lofiEnvironment);
	public static Sprite grass2 = new Sprite(16, 6, 5, SpriteSheet.lofiEnvironment);

	public static Sprite sand1 = new Sprite(16, 13, 11, SpriteSheet.lofiEnvironment);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * (sheet.SIZE)];
			}
		}
	}
}
