package edu.nyu.cs.yx2021;
import processing.core.*;

/**
 * The SmileObstacle class represents an obstacle
 * @author Vincent and Oscar
 * @version 0.1
 */

public class SmileObstacle {
	//Hold a reference to the PlayGame object
	PlayGame app;
	//To reference the heart image
	private final static String SMILEOBSTACLE_IMAGE_PATH = "Smile.png";
	private PImage img;	
	//Position
	private int x,y;
	//Speed on two axis
	private int speedX = 2;
	private int speedY = 2;
	//The height and width of the SmileObstacle.
	private final static int HEIGHT = 100;
	private final static int WIDTH = 100;	
	/**
	 * No args constructor.
	 */
	public SmileObstacle() {
	}
	/**
	 * Constructors for an SmileObstacle
	 * @param app PlayGame object
	 * @param x position
	 * @param y position
	 */
	public SmileObstacle(PlayGame app, int x, int y) {
		this.app = app;
		this.setX(x);
		this.setY(y);
		if (Math.random()>=0.5) {
			this.setSpeedX(-2);
		}
		if (Math.random()>=0.5) {
			this.setSpeedY(-2);
		}
		this.setImg(SmileObstacle.SMILEOBSTACLE_IMAGE_PATH);
	}
	/**
	 * Constructors for an SmileObstacle that generate random position.
	 * @param app
	 */
	public SmileObstacle(PlayGame app) {
		this.app=app;
		this.setX((int)(Math.random()*PlayGame.getWidth()));
		this.setY((int)(Math.random()*PlayGame.getHeight()));
		if (Math.random()>=0.5) {
			this.setSpeedX(-2);
		}
		if (Math.random()>=0.5) {
			this.setSpeedY(-2);
		}
		this.setImg(SmileObstacle.SMILEOBSTACLE_IMAGE_PATH);
	}
	/**
	 * Getters
	 * 
	 */
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getSpeedX() {
		return this.speedX;
	}
	public int getSpeedY() {
		return this.speedY;
	}
	public static int getWidth() {
		return SmileObstacle.WIDTH;
	}
	public static int getHeight() {
		return SmileObstacle.HEIGHT;
	}
	/**
	 * Setters
	 */
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setSpeedX(int x) {
		this.speedX=x;
	}
	public void setSpeedY(int y) {
		this.speedY=y;
	}
	public void setImg(String imgName) {
		this.img=app.loadImage(imgName);
	}
	/**
	 * Methods
	 * The actions that an SmileObstacle could do.
	 */
	public void eliminate() {
		this.app.getObstacles().remove(this);
	}
	public void draw() {
		this.app.image(this.img, this.x,this.y);
	}
	public void move() {
		if(this.x > (PlayGame.getWidth()-SmileObstacle.getHeight()) || this.x <= 0)
			this.setSpeedX(this.speedX * -1);
		if(this.y > (PlayGame.getHeight()-SmileObstacle.getHeight()) || this.y <= 0 )
			this.setSpeedY(this.speedY * -1);
		int newX = this.x + this.speedX;
		int newY = this.y + this.speedY;
		this.setX(newX);
		this.setY(newY);	
	}
	
}