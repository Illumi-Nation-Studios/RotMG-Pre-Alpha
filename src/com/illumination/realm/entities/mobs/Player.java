package com.illumination.realm.entities.mobs;

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
		if (input.up) {
			y--;
			facing = north;
		}
		if (input.down) {
			y++;
			facing = south;
		}
		if (input.left) {
			x--;
			facing = west;
		}
		if (input.right) {
			x++;
			facing = east;
		}
		/*
			if (input.up && input.left) facing = northWest;
			if (input.up && input.right) facing = northEast;
			if (input.down && input.left) facing = southWest;
			if (input.down && input.right) facing = southEast;
		*/
	}

	public void render() {
	}

}
