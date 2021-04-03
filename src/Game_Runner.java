import javax.swing.JFrame;

public class Game_Runner {
JFrame frame;
Game_Panel GP;
public static final int WIDTH = 1280;
public static final int HEIGHT = 680;
public static void main(String[] args) {
	Game_Runner GR = new Game_Runner();
	GR.setup();
	
}

public void setup() {
	frame = new JFrame();
	GP = new Game_Panel();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WIDTH, HEIGHT);
	frame.add(GP);
	frame.addKeyListener(GP);
	frame.setVisible(true);
}
}
