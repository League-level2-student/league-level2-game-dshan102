import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game_Panel extends JPanel implements ActionListener, KeyListener{
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font titleFont1;
    Timer frameDraw;
    Character c = new Character (590, 475, 60, 60);
    Object_Manager OM = new Object_Manager(c);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    public Game_Panel() {
    	titleFont = new Font("Arial", Font.PLAIN, 96);
    	titleFont1 = new Font("Arial", Font.PLAIN, 54);
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
        if (needImage) {
            loadImage ("background.jpg");
        }
    }
    
    public void updateMenuState() {  
    	
    }
    public void updateGameState() {  
    	if (c.isActive == false) {
    		currentState = END;
    	}
    	OM.update();
       	c.move();
    }
    public void updateEndState()  {  
    	
    }
    public void drawMenuState(Graphics g) {  
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, Game_Runner.WIDTH, Game_Runner.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("Game Name", 330, 100);
    	g.setFont(titleFont1);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press ENTER to start", 360, 300);
    	g.setFont(titleFont1);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press SPACE for instructions", 300, 500);
    }
    public void drawGameState(Graphics g) {  
    	if (gotImage) {
    		g.drawImage(image, 0, 0, Game_Runner.WIDTH, Game_Runner.HEIGHT, null);
    	} else {
    		g.setColor(Color.BLACK);
    		g.fillRect(0, 0, Game_Runner.WIDTH, Game_Runner.HEIGHT);
    	}
		OM.draw(g);
    }
    public void drawEndState(Graphics g)  {  
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, Game_Runner.WIDTH, Game_Runner.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("GAME OVER", 60, 100);
    	g.setFont(titleFont1);
    	g.setColor(Color.YELLOW);
    	//g.drawString("You killed " + OM.getScore() + " enemie(s)", 120, 300);
    	g.setFont(titleFont1);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press ENTER to restart", 110, 425);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        c = new Character (590, 475, 60, 60);
		        OM = new Object_Manager(c);
		    } 
		    else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_W && c.isGrounded) {
			if (currentState == GAME) {
				c.isJumping = true;
				c.isGrounded = false;
			    System.out.println("UP");
			}
		}
		//Ask about jumping mechanism (up and down).
		else if (e.getKeyCode()==KeyEvent.VK_A) {
			if (currentState == GAME) {
				c.isLeft = true;
				System.out.println("LEFT");
			}
		}
		else if (e.getKeyCode()==KeyEvent.VK_D) {
			if (currentState == GAME) {
				c.isRight = true;
				System.out.println("RIGHT"); 
				
				}
			}
		else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			if (currentState == GAME) {
				c.isDashingReady = true;
				System.out.println("DASH");
				
			}
		}
		}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_A) {
			c.isLeft = false;
		}
		else if (e.getKeyCode()==KeyEvent.VK_D) {
			c.isRight = false;
		}
		else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			c.isDashingReady = false;
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
