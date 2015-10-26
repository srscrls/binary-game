import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Row implements ActionListener, KeyListener {

	public JBlock[] line = new JBlock[8];
	Random randomGenerator = new Random();
	int maxNumber = Game.maxNumbersArray[Math.min(Game.level-1, 5)];
	int number = randomGenerator.nextInt(maxNumber);
	int number2 = randomGenerator.nextInt(maxNumber);

	boolean clickBoxes = randomGenerator.nextBoolean();

	int RowPosition;

	JBlock block0 = new JBlock("0", 7);
	JBlock block1 = new JBlock("0", 6);
	JBlock block2 = new JBlock("0", 5);
	JBlock block3 = new JBlock("0", 4);
	JBlock block4 = new JBlock("0", 3);
	JBlock block5 = new JBlock("0", 2);
	JBlock block6 = new JBlock("0", 1);
	JBlock block7 = new JBlock("0", 0);

	boolean destroyed = false;

	JTextField box = new JTextField();
	JPanel boxContainer = new JPanel();
//	JTextArea box1 = new JTextArea(1, 3);

	boolean[] bine = integerToBinary(number);

	public void createRow(JPanel panel, int rowNumber) {

		RowPosition = rowNumber;
//		box1.setText(Integer.toString(RowPosition));
		while(number==number2){
			number2 = randomGenerator.nextInt(maxNumber);
		}
		for (int i = 0; i < 8; i++) {
			line[i] = new JBlock(Integer.toString(i), 7 - i);
			line[i].setPreferredSize(new Dimension(50, 50));
			line[i].setFont(new Font("Arial", Font.BOLD, 25));
			panel.add(line[i]);
			int val = bine[i] ? 1 : 0;
			line[i].setText(Integer.toString(val));
			line[i].setBackground(bine[i] ? Color.BLUE : null);
		}

		if (clickBoxes == false) {
			for (int i = 0; i < 8; i++) {
				line[i].setEnabled(false);
			}
			box.addKeyListener(this);
		} else {
			box.setEnabled(false);
			box.setDisabledTextColor(new Color(128,128,255));
			box.setText(Integer.toString(number2));
			for (int i = 0; i < 8; i++) {
				line[i].addActionListener(this);
			}
		}

		// box.setText(Integer.toString(number2));
		// box1.setText(Integer.toString(number));
		boxContainer.repaint();
		boxContainer.setBorder(new EmptyBorder(3,3,3,3));
		box.setPreferredSize(new Dimension(30,30));
		box.setHorizontalAlignment(JTextField.CENTER);
		panel.add(boxContainer, BorderLayout.EAST);
		boxContainer.add(box);
		box.setBorder(new TitledBorder(""));
		//panel.add(box, BorderLayout.EAST);
//		panel.add(box1, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JBlock block = (JBlock) e.getSource();
		block.setFocusPainted(false);
		if (bine[7 - block.position] == true) {

			block.setText("0");
			block.setBackground(null);
			bine[7 - block.position] = false;
		} else {
			block.setText("1");
			bine[7 - block.position] = true;
			block.setBackground(Color.blue);
		}
		number = binaryToInteger(bine);
		// number2 = Integer.parseInt(box.getText());
		// box1.setText(Integer.toString(number));

		if (number == number2) {
			Game.goalReached();
			Game.deleteRow(RowPosition);
		}

	}

	public boolean[] integerToBinary(int number) {
		boolean binary[] = new boolean[8];
		for (int i = 7; i >= 0; i--) {
			if (number >= Math.pow(2, i)) {
				binary[7 - i] = true;
				number -= Math.pow(2, i);
			} else {
				binary[7 - i] = false;
			}
		}
		return binary;
	}

	public static int binaryToInteger(boolean[] binary) {
		int number = 0;
		for (int i = 0; i < 8; i++) {
			if (binary[i] == true) {
				number += Math.pow(2, 7 - i);
			}
		}

		return number;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		try {
			number2 = Integer.parseInt(box.getText());
		} catch (NumberFormatException f) {
		}
		if (number == number2 && destroyed == false) {
			// System.out.println("From Keypress: "+ Block.numberOfRows);
			Game.goalReached();
			Game.deleteRow(RowPosition);
			destroyed = true;
		}
	}

}
