package edu.nyu.cs.yx2021;
import java.util.*;
import processing.core.*;

/**
 * Basic controller for this game.
 * @author Vincent and Oscar
 * @version 0.1
 */
public class PlayGame extends PApplet {
	//Width and height of the window
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;
	//Set background color
	private final int WHITE = this.color(255,255,255);
	private final int BLACK = this.color(0,0,0);
	//One doge for each playgame.
	private Doge doge;
	//list for the obstacles and the number
	private ArrayList<SmileObstacle> obstacles = new ArrayList<SmileObstacle>();
	public static int NUM_OBSTACLES = 20;
	//list for heart, smallBone, and bone
	private ArrayList<Heart> hearts = new ArrayList<Heart>();
	private ArrayList<SmallBone> smallBones = new ArrayList<SmallBone>();
	private ArrayList<Bone> bones = new ArrayList<Bone>();
	//player score
	private int score=0;
	/**
	 * Setters
	 */
	public void setHearts(ArrayList<Heart> hearts) {
		this.hearts = hearts;
	}
	public void setObstacles(ArrayList<SmileObstacle> obstacles) {
		this.obstacles = obstacles;
	}
	public void setSmallBones(ArrayList<SmallBone> smallBones) {
		this.smallBones = smallBones;
	}
	public void setBones(ArrayList<Bone> bones) {
		this.bones = bones;
	}
	public void setScore(int x) {
		this.score=x;
	}
	
	/**
	 * Getters
	 */
	public ArrayList<Heart> getHearts(){
		return this.hearts;
	}
	public ArrayList<SmileObstacle> getObstacles(){
		return this.obstacles;
	}
	public ArrayList<SmallBone> getSmallBones(){
		return this.smallBones;
	}
	public ArrayList<Bone> getBones(){
		return this.bones;
	}
	public static int getWidth() {
		return PlayGame.WIDTH;
	}
	public static int getHeight() {
		return PlayGame.HEIGHT;
	}
	public int getScore() {
		return this.score;
	}
	//The main program start here.
	public void settings() {
		this.size(PlayGame.WIDTH,PlayGame.HEIGHT);
	}
	public void setup() {
		//Set doge
		this.doge = new Doge(this);
		int x = 0;
		int y = 0;
		//Set Smileobstacles
		for (int i = 0; i < PlayGame.NUM_OBSTACLES; i++) {
			x = SmileObstacle.getWidth()+(int)(Math.random() * (PlayGame.WIDTH-2*SmileObstacle.getWidth()));
			y = SmileObstacle.getHeight()+(int)(Math.random() * (PlayGame.HEIGHT-2*SmileObstacle.getHeight()));
			SmileObstacle obstacle = new SmileObstacle(this,x,y);
			this.obstacles.add(obstacle);
		}
		//Set hearts
		for (int i=0; i<doge.getLife(); i++) {
			x=i*Heart.getWidth();
			y=Heart.getHeight();
			Heart heart=new Heart(this,x,y);
			this.hearts.add(heart);
		}
		//Set the bond to catch
		Bone theBone=new Bone(this);
		this.bones.add(theBone);
	}
	public void draw() {
		//The move of the doge object.
		if (doge.getLife()>0) {
			this.background(WHITE);
			if (keyPressed) {
				if (key == 'a') {
					doge.goLeft();
					if (doge.getX()<=0) {
						doge.setX(PlayGame.WIDTH);
					}
				}
				if(key == 's') {
					doge.goDown();
					if (doge.getY()>=PlayGame.HEIGHT) {
						doge.setY(0);
					}
				}
				if(key == 'd') {
					doge.goRight();
					if (doge.getX()>=PlayGame.WIDTH) {
						doge.setX(0);
					}
				}
				if(key == 'w') {
					doge.goUp();
					if (doge.getY()<=0) {
						doge.setY(PlayGame.HEIGHT);
					}
				}

			}
			doge.draw();
			
			if (!bones.get(0).getIsEaten()) {
				//Movee and draw bone, if it has not been eaten.
				bones.get(0).move();
				bones.get(0).draw();
				//if it get eaten, score + 1, get a new bone, and get one more obstacle
				if (Math.pow((bones.get(0).getY() - doge.getY()), 2) + Math.pow(bones.get(0).getX() - doge.getX(),2) <= 2*(Math.pow(Bone.getHeight()/2+doge.getHeight()/2, 2)/10)) {
					bones.get(0).eat();
					this.setScore(this.score+1);
					Bone theBone=new Bone(this);
					this.bones.add(theBone);
					SmileObstacle newObstacle = new SmileObstacle(this);
					this.obstacles.add(newObstacle);
				}
			}
		
			for (int i = 0; i < this.obstacles.size(); i++) {
				//Keep draw and move obstacle
				SmileObstacle obstacle = this.obstacles.get(i);
				obstacle.move();
				obstacle.draw();
				//If clashed, eliminate the obtical and make the background black for a moment.
				if (Math.pow((obstacle.getY() - doge.getY()), 2) + Math.pow(obstacle.getX() - doge.getX(),2) <= Math.pow(SmileObstacle.getHeight()/2+doge.getHeight()/2, 2)/10) {
					this.background(BLACK);
					obstacle.eliminate();
					this.hearts.get(this.hearts.size()-1).loseHeart();
					doge.setLife(doge.getLife()-1);
				}		
			}
			//draw heart for life numbers.
			for (int j = 0; j < this.hearts.size(); j++) {
				Heart heart = this.hearts.get(j);
				heart.draw();
			}
			//Draw smallbone for scors. 
			for (int h = 0; h<this.score; h++) {
				SmallBone smallBone=new SmallBone(this, h*SmallBone.getWidth(), PlayGame.getHeight()-SmallBone.getHeight());
				this.smallBones.add(smallBone);
			}
			for (int n = 0; n<this.smallBones.size(); n++) {
				SmallBone theSM = this.smallBones.get(n);
				theSM.draw();
			}
		}
		//Once life is lower than 0, game over. 
		else {
			System.out.println("Game Over! Your score is " + this.score);
		}
		
	}
	//Main program to run.
	public static void main(String[] args) {
		PApplet.main("edu.nyu.cs.yx2021.PlayGame");
	}

	
}
