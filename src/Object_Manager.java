import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Object_Manager {
Character c;
ArrayList <Fireball> fb = new ArrayList <Fireball>();
ArrayList <Token> to = new ArrayList <Token>();
Random rand = new Random();

public Object_Manager (Character c) {
	this.c = c;
}
public void addFireball(Fireball f) {
	fb.add(new Fireball(rand.nextInt(Game_Runner.WIDTH),0,60,60));

}
public void addToken(Token t) {
	to.add(new Token(rand.nextInt(Game_Runner.WIDTH),0,60,60));
}
public void update() {
	for(int i=0; i<fb.size(); i++) {
		fb.get(i).update();
	if(fb.get(i).y>=500) {
		fb.get(i).isActive = false;
		}
	}
	for(int i1=0; i1<to.size();i1++) {
		to.get(i1).update();
	if(to.get(i1).y>=500) {
		to.get(i1).isActive = false;
	}
	}
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
	}
	for (int j=0; j<to.size(); j++) {
		if (to.get(j).isActive == false) {
			to.remove(j);
		}
	}
}
}

