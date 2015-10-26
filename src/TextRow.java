import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class TextRow {

	JLabel[] text = new JLabel[8];

	JTextArea box = new JTextArea(1, 3);
//	JTextArea box1 = new JTextArea(1, 3);

	public void createRow(JPanel panel) {

		int numberCast;
		for (int i = 0; i < 8; i++) {
			numberCast = (int) Math.pow(2, 7 - i);
			text[i] = new JLabel(Integer.toString(numberCast),
					SwingConstants.CENTER);
			text[i].setFont(new Font(text[i].getFont().getFontName(),
					Font.BOLD, 20));
			panel.add(text[i]);
		}
		box.setVisible(false);
//		box1.setVisible(false);
		panel.add(box);
//		panel.add(box1);

	}
}
