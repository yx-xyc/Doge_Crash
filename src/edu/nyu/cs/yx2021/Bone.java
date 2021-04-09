package edu.nyu.cs.yx2021;

/**
 * This class represents a bone our doge tries to catch.
 * @author Vincent and Oscar
 * @version 0.1
 */
public class Bone extends SmileObstacle {
	//The height and width of the bone.
	private final static int HEIGHT = 50;
	private final static int WIDTH = 125;
	//To reference the bone image
	private final static String BONE_IMAGE_PATH = "Bone.png";
	//To determine whether the bone is caught by our doge.
	private boolean isEaten=false;
	/**
	 * Constructors
	 * @param app PlayGame
	 */
	public Bone(PlayGame app) {
		this.app=app;
		this.setX((int)(Math.random()*(PlayGame.getWidth()-Bone.getWidth())+Bone.getWidth()));
		this.setY((int)(Math.random()*(PlayGame.getHeight()-Bone.getHeight())+Bone.getHeight()));
		if (Math.random()>=0.5) {
			this.setSpeedX(-2);
		}
		if (Math.random()>=0.5) {
			this.setSpeedY(-2);
		}
		this.setImg(Bone.BONE_IMAGE_PATH);
	}
	/**
	 * Constructors with our parameter
	 */
	public Bone() {
		this.setX((int)(Math.random()*(PlayGame.getWidth()-Bone.getWidth())+Bone.getWidth()));
		this.setY((int)(Math.random()*(PlayGame.getHeight()-Bone.getHeight())+Bone.getHeight()));
		if (Math.random()>=0.5) {
			this.setSpeedX(-2);
		}
		if (Math.random()>=0.5) {
			this.setSpeedY(-2);
		}
		this.setImg(Bone.BONE_IMAGE_PATH);
	}
	/**
	 *Getters
	 */
	public boolean getIsEaten() {
		return this.isEaten;
	}
	public static int getWidth() {
		return Bone.WIDTH;
	}
	public static int getHeight() {
		return Bone.HEIGHT;
	}
	/**
	 * Methods 
	 * Actions a bone could do.
	 */
	public void eat() {
		this.app.getBones().remove(this);
	}
	public void move() {
		if(this.getX() > (PlayGame.getWidth()) || this.getX() <= 0)
			this.setSpeedX(this.getSpeedX() * -1);
		if(this.getY() > (PlayGame.getHeight()) || this.getY() <= 0 )
			this.setSpeedY(this.getSpeedY() * -1);
		int newX = this.getX() + this.getSpeedX();
		int newY = this.getY() + this.getSpeedY();
		this.setX(newX);
		this.setY(newY);	
	}
}
