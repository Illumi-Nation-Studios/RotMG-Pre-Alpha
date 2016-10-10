package com.illumination.realm.tile;

import com.illumination.realm.graphics.Screen;
import com.illumination.realm.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
}
