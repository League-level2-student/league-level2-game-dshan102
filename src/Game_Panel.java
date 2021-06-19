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
    Font titleFont2;
    Timer frameDraw;
    Character c = new Character (590, 475, 60, 60);
    Object_Manager OM = new Object_Manager(c);
    public static BufferedImage image;
    public static BufferedImage life;
    public Game_Panel() {
    	titleFont = new Font("Arial", Font.PLAIN, 96);
    	titleFont1 = new Font("Arial", Font.PLAIN, 54);
    	titleFont2 = new Font("Arial", Font.PLAIN, 48);
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
        image = loadImage ("background.jpg");
        life = loadImage ("Life.png");
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
    	g.drawString("Frog vs. Fireball", 300, 150);
    	g.setFont(titleFont1);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press ENTER to start", 375, 300);
    	g.setFont(titleFont2);
    	g.setColor(Color.YELLOW);
    	g.drawString("Hold W and S to move", 390, 425);
    	g.drawString ("Press Space while moving to dash", 300, 550);
    }
    public void drawGameState(Graphics g) {  
    	g.drawImage(image, 0, 0, Game_Runner.WIDTH, Game_Runner.HEIGHT, null);
		OM.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(titleFont1);
	    g.drawString("Score: " + OM.getScore() + "", 0, 50);
	    g.drawString("Lives: ", 0, 100);
	    for (int i=0; i<OM.getLives(); i++) {
	    	g.drawImage(life, 140+i*50, 65, 50, 50, null);
	    }
    }
    public void drawEndState(Graphics g)  {  
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, Game_Runner.WIDTH, Game_Runner.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("GAME OVER", 350, 100);
    	g.setFont(titleFont1);
    	g.setColor(Color.YELLOW);
    	g.drawString("Your score was " + OM.getScore(), 420, 225);
    	g.setFont(titleFont1);
    	g.setColor(Color.YELLOW);
    	g.drawString("Press ENTER to restart", 360, 350);
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
			}
		}
		//Ask about jumping mechanism (up and down).
		else if (e.getKeyCode()==KeyEvent.VK_A) {
			if (currentState == GAME) {
				c.isLeft = true;
			}
		}
		else if (e.getKeyCode()==KeyEvent.VK_D) {
			if (currentState == GAME) {
				c.isRight = true;		
				}
			}
		else if (e.getKeyCode()==KeyEvent.VK_SPACE && !c.isDashingReady) {
			if (currentState == GAME) {
				c.isDashingReady = true;
				OM.isDashing.start();
				c.speed = 150;
				
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
		
	}
	BufferedImage loadImage(String imageFile) {
	        try {
	            return ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	        } catch (Exception e) {
	            
	        }   return null;
	}

	}
