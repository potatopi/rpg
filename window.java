import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class window extends JPanel implements ActionListener, KeyListener, constants
{
	private static final long serialVersionUID = 1L;
	hero player1 = null;
	private boolean moveLeft, moveRight;
	public window()
	{
		setBackground(Color.DARK_GRAY);
		addKeyListener(this);
		setFocusable(true);
		player1 = new hero();
		
		System.out.println("new window");
		Timer timer = new Timer(10, game);
		timer.start();		
	}
	
	
	ActionListener game = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if(player1.isMovingRight)
				player1.moveX(player1.dx);

			if(player1.isMovingLeft)
				player1.moveX(-player1.dx);

			if(player1.isJumping)
			{
				player1.jump();
			}

			repaint();
		}
	};
	
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = ( Graphics2D ) g;
		super.paintComponent(g);
		g2d.setColor(Color.white);
		player1.paint(g);
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='a') {
			if(player1.canMoveLeft) {
				player1.isMovingLeft = true;
			}
		}
		if(e.getKeyChar()=='s')
			player1.isMovingUp = false;
		
		if(e.getKeyChar()=='d') {
			if(player1.canMoveRight) {
				player1.isMovingRight = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyChar() == 'w')
		{
			if(!player1.isJumping)
			{
				player1.isJumping = true;
				player1.isMovingUp = true;
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar()=='d')
				player1.isMovingRight = false;
		if(e.getKeyChar()=='a')
			player1.isMovingLeft = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}