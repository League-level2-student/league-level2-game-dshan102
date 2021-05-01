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
	fb.add(new Fireball(rand.nextInt(Game_Runner.WIDTH),0,50,50));

}
public void addToken(Token t) {
	to.add(new Token(rand.nextInt(Game_Runner.WIDTH),0,50,50));
	//ask about how to make a system for the "tokens"
	//Falls faster; Spawns less frequently; Possibly stays on ground for some time
}
public void update() {
	
}
}
