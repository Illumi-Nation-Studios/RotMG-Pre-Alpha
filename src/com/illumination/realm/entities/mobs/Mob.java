package com.illumination.realm.entities.mobs;

import com.illumination.realm.entities.Entity;
import com.illumination.realm.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;

	public char facing;
	
	public char north = 'N';
	public char south = 'S';
	public char east = 'E';
	public char west = 'W';
	
	public void move(int xAxis, int yAxis) {
		if (xAxis > 0) {
			direction = 1;
			facing = east;
		}
		if (xAxis < 0) {
			direction = 2;
			facing = west;
		}
		if (yAxis > 0) {
			direction = 3;
			facing = south;
		}
		if (yAxis < 0) {
			direction = 0;
			facing = north;
		}

		if (!collision()) {
			x += xAxis;
			y += yAxis;
		}
	}

	public void update() {
	}

	public void render() {
	}

	public boolean collision() {
		return false;
	}
}
