import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartInit implements ActionListener {

	static JFrame frame = new JFrame("Binary Game");
	JPanel mainPanel = new JPanel(new BorderLayout());
	JPanel gamePanel = new JPanel(new GridLayout(9, 1));
	JPanel scorePanel = new JPanel(new GridLayout(3,1));
	JPanel scoreContainer = new JPanel(new BorderLayout());
	JPanel levelContainer = new JPanel(new BorderLayout());
	JPanel linesRemainingContainer = new JPanel(new BorderLayout());
	JPanel menuPanel = new JPanel(new GridLayout(2,1));
	JPanel titlePanel = new JPanel();
	JPanel gameContainer = new JPanel(new BorderLayout());
	JPanel infoContainer = new JPanel(new BorderLayout());
	JLabel title = new JLabel("B I N A R Y    G A M E");
	JPanel messagePanel = new JPanel();
	static JLabel message = new JLabel(" ");
	JButton startButton = new JButton("Start");
	JButton pauseButton = new JButton("Pause");
	
	JLabel scoreLabel = new JLabel("Score: ");
	static JLabel scoreAmount = new JLabel();
	JLabel levelLabel = new JLabel("Level: ");
	static JLabel levelAmount = new JLabel();
	JLabel linesRemainingLabel = new JLabel("<html>Lines<br>Remaining: </html>");
	static JLabel linesRemainingAmount = new JLabel();

	Game game;

	public void ui() {

		frame.setVisible(true);
		frame.setSize(new Dimension(675, 650));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mainPanel.setPreferredSize(new Dimension(550, 1200));
		frame.add(mainPanel);
		// mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		title.setFont(new Font(title.getFont().getFontName(), Font.BOLD, 40));
		titlePanel.add(title);
		gameContainer.setBorder(
	            BorderFactory.createEtchedBorder());
		infoContainer.setBorder(
	            BorderFactory.createEtchedBorder());
		mainPanel.add(gameContainer,BorderLayout.WEST);
		mainPanel.add(infoContainer,BorderLayout.EAST);
		mainPanel.add(messagePanel,BorderLayout.SOUTH);
		gameContainer.add(gamePanel);
		gameContainer.add(messagePanel,BorderLayout.SOUTH);
		infoContainer.add(scorePanel,BorderLayout.NORTH);
		infoContainer.add(menuPanel,BorderLayout.SOUTH);
		infoContainer.setPreferredSize(new Dimension(150,700));
		gameContainer.setPreferredSize(new Dimension(475,700));
		menuPanel.add(pauseButton);
		menuPanel.add(startButton);
		scoreLabel.setFont(new Font(scoreLabel.getName(),Font.PLAIN,18));
		scoreAmount.setFont(new Font(scoreAmount.getName(),Font.PLAIN,18));
		levelLabel.setFont(new Font(levelLabel.getName(),Font.PLAIN,18));
		levelAmount.setFont(new Font(levelAmount.getName(),Font.PLAIN,18));
		linesRemainingLabel.setFont(new Font(linesRemainingLabel.getName(),Font.PLAIN,18));
		linesRemainingAmount.setFont(new Font(linesRemainingAmount.getName(),Font.PLAIN,18));
		scoreContainer.add(scoreLabel,BorderLayout.WEST);
		scoreContainer.add(scoreAmount,BorderLayout.EAST);
		levelContainer.add(levelLabel,BorderLayout.WEST);
		levelContainer.add(levelAmount,BorderLayout.EAST);
		linesRemainingContainer.add(linesRemainingLabel,BorderLayout.WEST);
		linesRemainingContainer.add(linesRemainingAmount,BorderLayout.EAST);
		scorePanel.add(scoreContainer);
		scorePanel.add(levelContainer);
		scorePanel.add(linesRemainingContainer);
		messagePanel.add(message);
		pauseButton.setEnabled(false);
		startButton.addActionListener((ActionListener) this);
		pauseButton.addActionListener((ActionListener) this);

	}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton button = (JButton) e.getSource();
	if (button.getText() == "Start"){
	game = new Game();
	startButton.setText("Quit");
	pauseButton.setEnabled(true);
	game.startGame(gamePanel);
	}
	else if (button.getText() == "Quit"){
		startButton.setText("Start");
		if (pauseButton.getText()=="Unpause"){
			pauseButton.setText("Pause");
			message.setText("");
			game.unpauseGame(gamePanel);
		}
		game.quitGame(gamePanel);
		pauseButton.setEnabled(false);
		scoreAmount.setText("");
		levelAmount.setText("");
		linesRemainingAmount.setText("");
	}
	else if (button.getText() == "Pause"){
		pauseButton.setText("Unpause");
		message.setText("G A M E   P A U S E D");
		game.pauseGame(gamePanel);
	}
	else if(button.getText() == "Unpause") {
		pauseButton.setText("Pause");
		message.setText("");
		game.unpauseGame(gamePanel);
	}
}



}
