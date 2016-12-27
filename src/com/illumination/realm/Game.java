package com.illumination.realm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.illumination.realm.entities.mobs.Player;
import com.illumination.realm.graphics.Screen;
import com.illumination.realm.input.Keyboard;
import com.illumination.realm.level.Level;
import com.illumination.realm.level.RandomLevel;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int width = 430;
	public static int height = width / 16 * 11;
	public static int scale = 2;
	public static int scaleWidth = width * scale;
	public static int scaleHeight = height * scale;
	public static String _frames = "";
	public static int _framerate;
 
	public static String title = "RotMG Pre-Alpha";

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	private Keyboard key;

	private Screen screen;
	private Level level;
	
	private Player player;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(scaleWidth, scaleHeight);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		player = new Player(key);

		level = new RandomLevel(64, 64);

		addKeyListener(key);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Realm of the Mad God");
		System.out.println("Starting...");
		thread.start();
		System.out.println("Started...");
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " |" + frames + "|");
				_framerate = frames;
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {
		key.update();
		player.update();
	}

	public void render() {
		_frames = "Framerate: " + _framerate;
		
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		level.render(player.x, player.y, screen);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(new Color(0x005555));
		g.setXORMode(getBackground());
		g.setFont(new Font("Sans Serif", 0, 12));
		/**
		g.drawString(title, 0, 12);
		g.drawString(_frames, 0, 24);
		g.drawString("Facing: " + player.facing, 0, 36);
		g.drawString("X: " + (player.x >> 4) + " Y: " + (player.y >> 4), 0, 48);
		**/
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();

		game.frame.setResizable(false);
		game.frame.setTitle(Game.title + " |0|");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
}
