package com.illumination.realm.tile;

import com.illumination.realm.graphics.Screen;
import com.illumination.realm.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grassGreen = new GrassTile(Sprite.grassGreen);
	public static Tile grassYellow = new GrassTile(Sprite.grassDarkGreen);
	public static Tile sandLight = new SandTile(Sprite.sandLight);
	public static Tile sandDark = new SandTile(Sprite.sandDark);
	public static Tile waterLeft = new WaterTile(Sprite.waterLeft);
	public static Tile waterRight = new WaterTile(Sprite.waterRight);
	public static Tile waterDarkLeft = new WaterDarkTile(Sprite.waterDarkLeft);
	public static Tile waterDarkRight = new WaterDarkTile(Sprite.waterDarkRight);
	public static Tile mushroomRedSmall = new MushroomTile(Sprite.mushroomRedSmall);
	public static Tile mushroomRedLarge = new MushroomTile(Sprite.mushroomRedLarge);
	public static Tile treeMediumGreen = new TreeTile(Sprite.treeMediumGreen);
	public static Tile treeMediumYellow = new TreeTile(Sprite.treeMediumYellow);

	public static Tile tileVoid = new VoidTile(Sprite.voidSprite);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}
}
