import java.awt.Color;
import java.awt.Graphics;

public class Token extends Game_Object{
public Token (int x, int y, int width, int height) {
	super (x, y, width, height);
	speed = 3;
}

public void update() {
	y+=speed;
}

public void draw(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(x, y, width, height);
}
}
