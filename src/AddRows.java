import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class AddRows implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (Game.numberOfRows == 7) {
			Game.timer.stop();
			StartInit.message.setText("G A M E   O V E R");
		}
		else{
		Game.rowPanel[Game.numberOfRows].removeAll();
		for (int i = Game.numberOfRows - 1; i >= 0; i--) {
			Game.rows[i + 1] = Game.rows[i];
			Game.rows[i + 1].createRow(Game.rowPanel[i + 1], i + 1);
			Game.rowPanel[i].removeAll();
		}
		Game.rows[0] = new Row();
		Game.rows[0].createRow(Game.rowPanel[0], 0);
		Game.numberOfRows++;
		}
	}

}
