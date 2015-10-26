import javax.swing.JButton;

public class JBlock extends JButton {

	public JBlock(String string, int value) {
		// TODO Auto-generated constructor stub
		super(string);
		this.position = value;
	}

	public int position;

}
