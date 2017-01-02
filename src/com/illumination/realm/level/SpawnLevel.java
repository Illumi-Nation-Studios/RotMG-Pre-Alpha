package com.illumination.realm.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.illumination.realm.tile.Tile;

public class SpawnLevel extends Level{

	private int[] levelPixels;
	
	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			levelPixels = new int[w * h];
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generateLevel() {
	}
}
