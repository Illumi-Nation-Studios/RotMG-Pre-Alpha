package com.illumination.realm.entities.mobs;

import com.illumination.realm.entities.Entity;
import com.illumination.realm.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;

	public void move() {
	}

	public void update() {
	}

	public void render() {
	}

	public boolean collision() {
		return false;
	}
}
