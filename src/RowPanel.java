import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class RowPanel extends JPanel {

	public RowPanel(LayoutManager layout, int value) {
		// TODO Auto-generated constructor stub
		super(layout);
		this.position = value;
	}

	public int position;

}
