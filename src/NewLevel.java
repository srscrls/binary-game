import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewLevel implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Game.level++;
		StartInit.levelAmount.setText(Integer.toString(Game.level));
		Game.linesRemaining = 5 + (Game.level - 1);
		StartInit.linesRemainingAmount.setText(Integer.toString(Game.linesRemaining));
		Game.delay = Math.max(5,Game.delay--); 
		StartInit.message.setText("");
		Game.timer.setDelay(Game.delay*1000);
		Game.timer.start();
		for (int i = 0; i < 3; i++) {
			Game.rowPanel[i].removeAll();
			Game.rows[i] = new Row();
			Game.rows[i].createRow(Game.rowPanel[i], i);
		}
		Game.numberOfRows = 3;
	}

}
