import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;


public class Game {

	JPanel panel = new JPanel(new GridLayout(1, 9));
	static RowPanel[] rowPanel = new RowPanel[7];
	static EmptyRow[] emptyRows = new EmptyRow[7];
	static Row[] rows = new Row[7];
	JPanel panel8 = new JPanel(new GridLayout(1, 9));
	static int[] maxNumbersArray = {65,65,129,129,255,255};
	
	TextRow textrow = new TextRow();
	TextRow textrow1 = new TextRow();

	JTextArea box2 = new JTextArea(1, 3);
	JTextArea box3 = new JTextArea(1, 3);

	static int numberOfRows;
	static int delay = 12; // in seconds
	
	static Timer timer;  //timer used to add rows
	static Timer newLevelTimer; //timer used to pause between levels
	
	//score variables
	public static int scores;
	public static int level;
	public static int linesRemaining;
	static int bonus = 0; 
	
	public void startGame(JPanel gamePanel){
		
		
		//Initialise variables
		scores = 0;
		level = 1;
		linesRemaining = 5;
		numberOfRows = 3;
		
		//Displays score variables in Score Panel
		StartInit.scoreAmount.setText(Integer.toString(scores));
		StartInit.levelAmount.setText(Integer.toString(level));
		StartInit.linesRemainingAmount.setText(Integer
				.toString(linesRemaining));
		
		gamePanel.add(panel);
		for (int i = 6; i >= 0; i--) {
			rowPanel[i] = new RowPanel(new GridLayout(1, 10, 1, 0), i);
			gamePanel.add(rowPanel[i]);
		}

		gamePanel.add(panel8);
		
		for (int i = 0; i < 7; i++) {
			emptyRows[i] = new EmptyRow();
			if (i < numberOfRows) {
				rows[i] = new Row();
				rows[i].createRow(rowPanel[i], i);
			} else {
				emptyRows[i].createRow(rowPanel[i], i);
			}
		}

		textrow.createRow(panel);
		textrow1.createRow(panel8);

		timer = new Timer(delay * 1000, new AddRows());
		timer.start();
	}
	
	public void quitGame(JPanel gamePanel){
		gamePanel.removeAll();
		timer.stop();
	}
	
	public void pauseGame(JPanel gamePanel){
		timer.stop();
		gamePanel.setVisible(false);
	}
	
	public void unpauseGame(JPanel gamePanel){
		timer.start();
		gamePanel.setVisible(true);
	}
	
	
	
	public static void goalReached() {
		scores = scores + (50 + 50 * level);
		StartInit.scoreAmount.setText(Integer.toString(scores));
		linesRemaining--;
		StartInit.linesRemainingAmount.setText(Integer.toString(linesRemaining));
		if (linesRemaining == 0) {
			nextLevel();
		}
	}

	public static void nextLevel() {
		timer.stop();
		newLevelTimer = new Timer(5000, new NewLevel());
		newLevelTimer.setRepeats(false);
		System.out.println(numberOfRows);
		for (int i = 0; i<numberOfRows;i++){
			//System.out.println(i);
			rowPanel[i].removeAll();
			emptyRows[i].createRow(rowPanel[i],i);
		}
		bonus = (7-numberOfRows) * 1000 * Game.level;
		Game.scores += bonus;
		StartInit.scoreAmount.setText(Integer.toString(Game.scores));
		StartInit.message.setText("Level completed! Bonus: " + bonus);
		newLevelTimer.start();
		
		
		//timer.start();
	}
	
	public static void deleteRow(int rowPosition) {
		if (numberOfRows == 1) {
			scores += 1000;
			StartInit.scoreAmount.setText(Integer.toString(scores));
			for (int i = 0; i < 3; i++) {
				rowPanel[i].removeAll();
				rows[i] = new Row();
				rows[i].createRow(rowPanel[i], i);
			}
			numberOfRows = 3;
			
		} else {
			rowPanel[rowPosition].removeAll();
			for (int i = rowPosition; i < numberOfRows - 1; i++) {
				rows[i] = rows[i + 1];
				rows[i + 1].createRow(rowPanel[i], i);
				rowPanel[i + 1].removeAll();
			}
			emptyRows[numberOfRows - 1].createRow(rowPanel[numberOfRows - 1],
					numberOfRows - 1);
			numberOfRows--;
			
		}
		if (StartInit.frame.getWidth() == 675){ 
		StartInit.frame.setSize(new Dimension(674, 650));
		}
		else{
			StartInit.frame.setSize(new Dimension(675,650));
		}
	}
	
}
