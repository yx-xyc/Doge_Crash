package edu.nyu.cs.yx2021;
import processing.core.*;

/**
 * This class represents a doge that controlled by user in the game.
 * @author Vincent and Oscar
 * @version 0.1
 */
public class Doge {

	//Hold a reference to the PlayGame object
	PlayGame app;
	//To reference the doge image
	private final static String DOGE_IMAGE_PATH = "Doge.png";
	private PImage img;
	//To determine whether the doge crash with the smileobstacle
	private boolean clash = false;
	//Position
	private int x,y; 
	//Speed on two axis
	private final static int speedY = 5;
	private final static int speedX = 5;
	//Life number of player
	private int life = 5;
	/**
	 * Constructor for a Doge.
	 * @para the PlayGame app object.
	 */
	public Doge(PlayGame app) {
		this.app = app;
		this.x = (int)(this.app.width / 2);
		this.y = (int)(this.app.height / 2);
		this.img = this.app.loadImage(Doge.DOGE_IMAGE_PATH);
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
	public void setLife(int x) {
		this.life=x;
	}
	/**
	 * Getters
	 */
	public int getHeight() {
		return this.img.height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean getClash() {
		return this.clash;
	}
	public int getLife() {
		return this.life;
	}
	/**
	 * Actions this Doge could do.
	 */
	public void draw() {
		this.app.image(this.img, this.x, this.y);
	}
	public void goRight() {
		this.x += Doge.speedX;
	}
	public void goLeft() {
		this.x -= Doge.speedX;
	}
	public void goUp() {
		this.y -= Doge.speedY;
	}
	public void goDown() {
		this.y += Doge.speedY;
	}
}
