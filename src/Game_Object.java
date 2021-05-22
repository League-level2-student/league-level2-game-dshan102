import java.awt.Rectangle;

public class Game_Object {
int x;
int y;
int width;
int height;
int speed = 0;
boolean isActive = true;
Rectangle collisionBox;
public Game_Object (int x, int y, int width, int height){
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	collisionBox = new Rectangle (x, y, width, height);
}
public void update() {
	collisionBox.setBounds(x, y, width, height);
}
}
