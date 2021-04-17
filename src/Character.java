import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Character extends Game_Object {
	boolean isJumping = false;
	public Character(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	
    public void move() {
    //if (y<500) {
    	//y+=speed;

        //ask how to make a "jump" (Up-pause-down)
    }
    public void left() {
    	x-=speed;
    }
    public void right() {
    	x+=speed;
    }
	
}
