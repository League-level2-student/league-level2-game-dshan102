import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Object_Manager1 implements ActionListener{
Character c;
ArrayList <Token> to = new ArrayList <Token>();
Random rand = new Random();

public Object_Manager1 (Character c) {
	this.c = c;
}
public void addToken() {
	to.add(new Token(rand.nextInt(Game_Runner.WIDTH),0,60,60));
}
public void update() {
	for(int i=0; i<to.size();i++) {
		to.get(i).update();
	if(to.get(i).y<=475) {
		to.get(i).isActive = false;
		}
	}
}
public void draw(Graphics g) {
	c.draw(g);
	for(int i=0; i<to.size(); i++) {
		to.get(i).draw(g);
	}
}
public void purgeObjects() {
	for (int i=0; i<to.size(); i++) {
		if (to.get(i).isActive == false) {
			to.remove(i);
		}
	}
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addToken();
		//ask about separate Timers and how to get tokenSpawn working
	}

}
