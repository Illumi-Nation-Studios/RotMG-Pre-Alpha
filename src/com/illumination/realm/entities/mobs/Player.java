package com.illumination.realm.entities.mobs;

import com.illumination.realm.graphics.Screen;
import com.illumination.realm.graphics.Sprite;
import com.illumination.realm.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (input.up) {
			ya--;
			facing = north;
		}
		if (input.down) {
			ya++;
			facing = south;
		}
		if (input.left) {
			xa--;
			facing = west;
		}
		if (input.right) {
			xa++;
			facing = east;
		}
		
		if (xa != 0 || ya != 0) move(xa, ya);
		
		if (input.up && input.left) facing = northWest;
		if (input.up && input.right) facing = northEast;
		if (input.down && input.left) facing = southWest;
		if (input.down && input.right) facing = southEast;
	}

	public void render(Screen screen) {
		screen.renderEntity16x(x, y, Sprite.rogueDown);
	}

}
