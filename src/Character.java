import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class Character extends Game_Object {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
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
		if (needImage) {
		    loadImage ("character.gif");
		}
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	
    public void move() {
    	super.update();
    if (isRight) {
    	if (x!=1210) {
        	x+=speed;
    	}
    }
    if (isLeft) {
    	if (x!=0) {
        	x-=speed;
    	}
    }
    if (isDashingReady && isRight) {
    	isRight = false;
    	//x+=8*speed;
    	isDashingReady = false;
    }
    if (isDashingReady && isLeft) {
    	isLeft = false;
    	//x-=8*speed;
    	isDashingReady = false;
    }
     if (isJumping) {
    	width++;
    	height++;
    	y--;
    	if (width >= 70) {
    		isJumping = false;
    	}
    }
    else if (!isGrounded) {
    	width--;
    	height--;
    	y++;
        if (width <= 60) {
        	isGrounded = true;
        }
    }
    }
    void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
    	    gotImage = true;
            } catch (Exception e) {
                
            }
            needImage = false;
        }
    }
}
	
