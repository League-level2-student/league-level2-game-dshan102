import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Object_Manager implements ActionListener{
Character c;
ArrayList <Fireball> fb = new ArrayList <Fireball>();
Random rand = new Random();

public Object_Manager (Character c) {
	this.c = c;
}
public void addFireball() {
	fb.add(new Fireball(rand.nextInt(Game_Runner.WIDTH),0,60,60));
}
public void update() {
	for(int i=0; i<fb.size(); i++) {
		fb.get(i).update();
	if(fb.get(i).y<=475) {
		fb.get(i).isActive = false;
		}
	}
}
public void draw(Graphics g) {
	c.draw(g);
	for(int i=0; i<fb.size(); i++) {
		fb.get(i).draw(g);
}
}
public void purgeObjects() {
	for (int i=0; i<fb.size(); i++) {
		if (fb.get(i).isActive == false) {
			fb.remove(i);
		}
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		addFireball();
}
}

