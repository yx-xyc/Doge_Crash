package edu.nyu.cs.yx2021;
import processing.core.*;

/**
 * This class represents a doge that controlled by user in the game.
 * @author Vincent and Oscar
 * @version 0.1
 */

public class Heart {
	//Hold a reference to the PlayGame object
	PlayGame app;
	//To reference the heart image
	private final static String HEART_IMAGE_PATH = "Heart.png";
	private PImage img;
	//Position
	private int x,y; 
	//The height and width of the heart.
	private final static int HEIGHT = 21;
	private final static int WIDTH = 23;
	/**
	 * Constructors for a heart
	 * @param app PlayGame object
	 * @param x position
	 * @param y position
	 */
	public Heart(PlayGame app, int x, int y) {
		this.app=app;
		this.setX(x);
		this.setY(y);
		this.img = app.loadImage(Heart.HEART_IMAGE_PATH);
	}
	/**
	 * Setters
	 */
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	/**
	 * Getters
	 */
	public int getX() {
		int x = this.x;
		return x;
	}
	public int getY() {
		int y = this.y;
		return y;
	}
	public static int getHeight() {
		return Heart.HEIGHT;
	}
	public static int getWidth() {
		return Heart.WIDTH;
	}
	/**
	 * Methods
	 * Actions this Heart could do.
	 */
	public void loseHeart() {
		this.app.getHearts().remove(this);
	}
	public void draw() {
		this.app.image(this.img, this.x, this.y);
	}
}
