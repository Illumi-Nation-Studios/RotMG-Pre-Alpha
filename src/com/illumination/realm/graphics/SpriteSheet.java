package com.illumination.realm.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	private final int SIZE;
	public int[] pixels;

	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;

		pixels = new int[SIZE * SIZE];
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
