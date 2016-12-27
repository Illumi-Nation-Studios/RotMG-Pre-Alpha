package com.illumination.realm.graphics;

public class Sprite {

	public static int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	//Void Sprite
	public static Sprite voidSprite = new Sprite(16, 0);
	
	//Environment
	public static Sprite grassGreen = new Sprite(16, 6, 4, SpriteSheet.lofiEnvironment);
	public static Sprite grassDarkGreen = new Sprite(16, 6, 5, SpriteSheet.lofiEnvironment);
	public static Sprite sandLight = new Sprite(16, 13, 11, SpriteSheet.lofiEnvironment);

	//Rogue
	public static Sprite rogueUp = new Sprite(16, 0, 2, SpriteSheet.lofiRogue);
	public static Sprite rogueDown = new Sprite(16, 0, 1, SpriteSheet.lofiRogue);
	public static Sprite rogueLeft = new Sprite(16, 1, 0, SpriteSheet.lofiRogue);
	public static Sprite rogueRight = new Sprite(16, 1, 0, SpriteSheet.lofiRogue);
	
	//Rogue Walking
	public static Sprite rogueUpWalking = new Sprite(16, 2, 1, SpriteSheet.lofiRogue);
	public static Sprite rogueDownWalking = new Sprite(16, 1, 1, SpriteSheet.lofiRogue);
	public static Sprite rogueLeftWalking = new Sprite(16, 1, 0, SpriteSheet.lofiRogue);
	public static Sprite rogueRightWalking = new Sprite(16, 1, 0, SpriteSheet.lofiRogue);
	public static Sprite _rogueUpWalking = new Sprite(16, 2, 2, SpriteSheet.lofiRogue);
	public static Sprite _rogueDownWalking = new Sprite(16, 1, 2, SpriteSheet.lofiRogue);
	
	//Archer
	public static Sprite archerUp = new Sprite(16, 0, 2, SpriteSheet.lofiArcher);
	public static Sprite archerDown = new Sprite(16, 0, 1, SpriteSheet.lofiArcher);
	public static Sprite archerLeft = new Sprite(16, 0, 0, SpriteSheet.lofiArcher);
	public static Sprite archerRight = new Sprite(16, 0, 0, SpriteSheet.lofiArcher);
	
	//Archer Walking
	public static Sprite archerUpWalking = new Sprite(16, 0, 2, SpriteSheet.lofiArcher);
	public static Sprite archerDownWalking = new Sprite(16, 0, 1, SpriteSheet.lofiArcher);
	public static Sprite archerLeftWalking = new Sprite(16, 0, 0, SpriteSheet.lofiArcher);
	public static Sprite archerRightWalking = new Sprite(16, 0, 0, SpriteSheet.lofiArcher);
	public static Sprite _archerUpWalking = new Sprite(16, 2, 2, SpriteSheet.lofiArcher);
	public static Sprite _archerDownWalking = new Sprite(16, 1, 2, SpriteSheet.lofiArcher);
	
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
