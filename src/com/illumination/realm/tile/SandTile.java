package com.illumination.realm.tile;

import com.illumination.realm.graphics.Screen;
import com.illumination.realm.graphics.Sprite;

public class SandTile extends Tile {

	public SandTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
