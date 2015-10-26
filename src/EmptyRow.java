import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EmptyRow {
	JButton[] box = new JButton[8];

	JTextArea box1 = new JTextArea(1, 3);
//	JTextArea box2 = new JTextArea(1, 3);

	public void createRow(JPanel panel, int rowPosition) {

		for (int i = 0; i < 8; i++) {
			box[i] = new JButton("");
			box[i].setPreferredSize(new Dimension(50,50));
			box[i].setEnabled(false);
			box[i].setContentAreaFilled(false);
			panel.add(box[i]);
		}

		box1.setText("");
		box1.setVisible(true);
		box1.setOpaque(false);
		box1.setEnabled(false);
		box1.repaint();
//		box2.setVisible(false);
		panel.add(box1);
//		panel.add(box2);

	}

}
