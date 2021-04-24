import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Character extends Game_Object {
	boolean isJumping = false;
	boolean isRight = false;
	boolean isLeft = false;
	boolean isGrounded = true;
	boolean isDashingReady = false;
	boolean isDashingRight = false;
	boolean isDashingLeft = false;
	public Character(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	
    public void move() {
    if (isRight) {
    	x+=speed;
    }
    if (isLeft) {
    	x-=speed;
    }
    if (isDashingReady && isRight) {
    	isRight = false;
    	x+=5*speed;
    	isDashingReady = false;
    }
    if (isDashingReady && isLeft) {
    	isLeft = false;
    	x-=5*speed;
    	isDashingReady = false;
    }
    if (isJumping) {
    	width++;
    	height++;
    	y--;
    	if (width >= 60) {
    		isJumping = false;
    	}
    }
    else if (!isGrounded) {
    	width--;
    	height--;
    	y++;
        if (width <= 50) {
        	isGrounded = true;
        }
    }

    }
        //ask how to make a "jump"
 
    
   
}
