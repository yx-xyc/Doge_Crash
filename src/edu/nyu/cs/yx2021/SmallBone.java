package edu.nyu.cs.yx2021;
import processing.core.PImage;

/**
 * This class is for the smallbone as scores. 
 * @author Vincent and Oscar
 *
 */
public class SmallBone {
	//Hold a reference to the PlayGame object
	PlayGame app;
	//To reference the SmallBone image
	private final static String SMALLBONE_IMAGE_PATH = "SmallBone.png";
	private PImage img;
	//position
	private int x,y; 
	//The height and width of the SmallBone.
	private final static int HEIGHT = 20;
	private final static int WIDTH = 50;
	/**
	 * Constructor
	 * @param app PlayGame
	 * @param x position
	 * @param y position
	 */
	public SmallBone(PlayGame app, int x, int y) {
		this.app=app;
		this.setX(x);
		this.setY(y);
		this.img = app.loadImage(SmallBone.SMALLBONE_IMAGE_PATH);
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
		return SmallBone.HEIGHT;
	}
	public static int getWidth() {
		return SmallBone.WIDTH;
	}
	/**
	 * Methods
	 * Actions SmallBone could do.
	 */
	public void gainScore() {
		this.app.getSmallBones().add(this);
	}
	public void draw() {
		this.app.image(this.img, this.x, this.y);
	}
}
