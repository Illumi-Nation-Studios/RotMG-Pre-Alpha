package com.illumination.realm.entities;

import java.util.Random;

import com.illumination.realm.graphics.Screen;
import com.illumination.realm.level.Level;

public abstract class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected Random random = new Random();
	
	public void update() {
	}
	
	public void run(Screen screen) {
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
