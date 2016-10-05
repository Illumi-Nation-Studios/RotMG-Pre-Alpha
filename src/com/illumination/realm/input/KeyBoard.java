package com.illumination.realm.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[120];
	public boolean UP, DOWN, LEFT, RIGHT;

	public void update() {
		UP = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		LEFT = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		DOWN = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		RIGHT = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
