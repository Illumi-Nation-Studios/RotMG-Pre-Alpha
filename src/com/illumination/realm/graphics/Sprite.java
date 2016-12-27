package com.illumination.realm.graphics;

public class Sprite {

	public static int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	// Void Sprite
	public static Sprite voidSprite = new Sprite(16, 0);

	// Environment
	public static Sprite grassGreen = new Sprite(16, 6, 4, SpriteSheet.lofiEnvironment);
	public static Sprite grassDarkGreen = new Sprite(16, 6, 5, SpriteSheet.lofiEnvironment);
	public static Sprite sandLight = new Sprite(16, 13, 11, SpriteSheet.lofiEnvironment);
	public static Sprite sandDark = new Sprite(16, 14, 11, SpriteSheet.lofiEnvironment);
	public static Sprite waterLeft = new Sprite(16, 12, 11, SpriteSheet.lofiEnvironment);
	public static Sprite waterRight = new Sprite(16, 12, 12, SpriteSheet.lofiEnvironment);

	// Objects
	public static Sprite rockSmall = new Sprite(16, 9, 6, SpriteSheet.lofiEnvironment);
	public static Sprite boulderGrey = new Sprite(16, 9, 5, SpriteSheet.lofiEnvironment);
	public static Sprite treeMediumGreen = new Sprite(16, 9, 5, SpriteSheet.lofiEnvironment);
	public static Sprite treeMediumYellow = new Sprite(16, 10, 5, SpriteSheet.lofiEnvironment);
	public static Sprite mushroomRedSmall = new Sprite(16, 12, 6, SpriteSheet.lofiEnvironment);
	public static Sprite mushroomRedLarge = new Sprite(16, 13, 6, SpriteSheet.lofiEnvironment);

	// Rogue
	public static Sprite rogueSide = new Sprite(16, 0, 0, SpriteSheet.lofiRogue);
	public static Sprite rogueUp = new Sprite(16, 0, 2, SpriteSheet.lofiRogue);
	public static Sprite rogueDown = new Sprite(16, 0, 1, SpriteSheet.lofiRogue);

	// Rogue Walking
	public static Sprite rogueSideWalking = new Sprite(16, 1, 0, SpriteSheet.lofiRogue);
	public static Sprite rogueUpWalking = new Sprite(16, 2, 1, SpriteSheet.lofiRogue);
	public static Sprite rogueDownWalking = new Sprite(16, 1, 1, SpriteSheet.lofiRogue);
	public static Sprite _rogueUpWalking = new Sprite(16, 2, 2, SpriteSheet.lofiRogue);
	public static Sprite _rogueDownWalking = new Sprite(16, 1, 2, SpriteSheet.lofiRogue);

	// Archer
	public static Sprite archerUp = new Sprite(16, 0, 2, SpriteSheet.lofiArcher);
	public static Sprite archerDown = new Sprite(16, 0, 1, SpriteSheet.lofiArcher);
	public static Sprite archerSide = new Sprite(16, 0, 0, SpriteSheet.lofiArcher);

	// Archer Walking
	public static Sprite archerSideWalking = new Sprite(16, 1, 0, SpriteSheet.lofiArcher);
	public static Sprite archerUpWalking = new Sprite(16, 1, 2, SpriteSheet.lofiArcher);
	public static Sprite archerDownWalking = new Sprite(16, 0, 1, SpriteSheet.lofiArcher);
	public static Sprite _archerUpWalking = new Sprite(16, 2, 2, SpriteSheet.lofiArcher);
	public static Sprite _archerDownWalking = new Sprite(16, 2, 1, SpriteSheet.lofiArcher);

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