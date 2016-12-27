package com.illumination.realm.entities.mobs;

import com.illumination.realm.graphics.Screen;
import com.illumination.realm.graphics.Sprite;
import com.illumination.realm.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	public boolean flip = false;
	public boolean walking = false;

	public int animate = 0;

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
		if (animate < 7500) {
			animate++;
		} else
			animate = 0;

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

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else
			walking = false;

		if (input.up && input.left)
			facing = northWest;
		if (input.up && input.right)
			facing = northEast;
		if (input.down && input.left)
			facing = southWest;
		if (input.down && input.right)
			facing = southEast;
	}

	public void render(Screen screen) {
		sprite = Sprite.archerDown;
		flip = false;
		if (facing == north) {
			sprite = Sprite.archerUp;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.archerUpWalking;
				}
				if (animate % 20 > 10) {
					sprite = Sprite._archerUpWalking;
				}
			}
		}
		if (facing == northWest || facing == northEast) {
			sprite = Sprite.archerUp;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.archerUpWalking;
				}
				if (animate % 20 > 10) {
					sprite = Sprite._archerUpWalking;
				}
			}
		}
		if (facing == south) {
			sprite = Sprite.archerDown;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.archerDownWalking;
				}
				if (animate % 20 > 10) {
					sprite = Sprite._archerDownWalking;
				}
			}
		}
		if (facing == southWest || facing == southEast) {
			sprite = Sprite.archerDown;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.archerDownWalking;
				}
				if (animate % 20 > 10) {
					sprite = Sprite._archerDownWalking;
				}
			}
		}
		if (facing == east) {
			sprite = Sprite.archerSide;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.archerSideWalking;
				}
			}
		}
		if (facing == west) {
			flip = true;
			sprite = Sprite.archerSide;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.archerSideWalking;
				}
			}
		}
		screen.renderEntity16x(x, y, sprite, flip);
	}

}
