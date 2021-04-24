import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    Character c = new Character (250, 500, 50, 50);
    
    public Game_Panel() {
    	titleFont = new Font("Arial", Font.PLAIN, 96);
    	titleFont1 = new Font("Arial", Font.PLAIN, 54);
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }
    
    public void updateMenuState() {  
    	
    }
    public void updateGameState() {  
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
    	g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game_Runner.WIDTH, Game_Runner.HEIGHT);
		c.draw(g);
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

	}
