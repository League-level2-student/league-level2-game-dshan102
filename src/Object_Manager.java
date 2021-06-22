import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Object_Manager implements ActionListener{
Character c;
ArrayList <Fireball> fb = new ArrayList <Fireball>();
ArrayList <Token> to = new ArrayList <Token>();
Random rand = new Random();
Timer fireballSpawn;
Timer tokenSpawn;
Timer isDashing;
int score = 0;
int lives = 3;
public Object_Manager (Character c) {
	this.c = c;
	 fireballSpawn = new Timer(1000, this);
	 //fireballSpawn.start();
	 tokenSpawn = new Timer(5000, this);
	 //tokenSpawn.start();
	 isDashing = new Timer(275, this);
}
public void addFireball() {
	fb.add(new Fireball(rand.nextInt(Game_Runner.WIDTH),0,60,60));
}
public void addToken() {
	to.add(new Token(rand.nextInt(Game_Runner.WIDTH),0,60,60));
}
public void update() {
	for(int i=0; i<fb.size(); i++) {
		fb.get(i).update();
	if(fb.get(i).y>=475) {
		fb.get(i).isActive = false;
		}
	}
	for(int i=0; i<to.size();i++) {
		to.get(i).update();
	if(to.get(i).y>=475) {
		to.get(i).isActive = false;
		}
	}
	checkCollision();
	purgeObjects();
}
public void draw(Graphics g) {
	c.draw(g);
	for(int i=0; i<fb.size(); i++) {
		fb.get(i).draw(g);
}
	for(int i=0; i<to.size(); i++) {
		to.get(i).draw(g);
	}
}
public void purgeObjects() {
	for (int i=0; i<fb.size(); i++) {
		if (fb.get(i).isActive == false) {
			fb.remove(i);
		}
		for (int i1=0; i1<to.size(); i1++) {
			if (to.get(i1).isActive == false) {
				to.remove(i1);
			}
		}
	}
}
public void checkCollision() {
	for (int i=0; i<fb.size(); i++) {
		if (fb.get(i).collisionBox.intersects(c.collisionBox) && !c.isDashingReady) {
				fb.get(i).isActive = false;
				lives-=1;
				if(lives == 0) {
					c.isActive = false;
				}
		}
	}
	for (int j=0; j<to.size(); j++) {
		if (to.get(j).collisionBox.intersects(c.collisionBox)) {
			to.get(j).isActive = false;
			score+=1;
		}
	}
}
public int getLives() {
	return lives;
	
}
public int getScore() {
	return score;
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		if (e.getSource()==fireballSpawn) {
			addFireball();
		}
		else if (e.getSource()==tokenSpawn) {
			addToken();
		}
		else if (e.getSource()==isDashing) {
			c.isDashingReady = false;
			isDashing.stop();
			c.speed = 10;
		}
}

}

