import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Token extends Game_Object{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
public Token (int x, int y, int width, int height) {
	super (x, y, width, height);
	speed = 3;
	if (needImage) {
	    loadImage ("token.png");
	}
}

public void update() {
	y+=speed;
}

public void draw(Graphics g) {
	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
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
