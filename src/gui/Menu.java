package gui;
import javax.swing.*;
import java.awt.event.*;
public class Menu extends JFrame implements ActionListener
{
	static final long serialVersionUID = 1;
	public Menu(String name)
	{
		this.setName("IconEditor");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	public void anzeigen()
	{
		JFrame rahmen = this;
		WindowListener wl = new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				int ok = onClose();
				if (ok == Menu.dispose)
				{
					we.getWindow().dispose();
				}
				else if (ok == Menu.exit)
				{
					System.exit(0);
				}
			}
		};
		rahmen.addWindowListener(wl);
		rahmen.pack();
		rahmen.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{

	}
	public int onClose()
	{
		return 1;
	}
	public static int stayalive = 0;
	public static int dispose = 1;
	public static int exit = 2;
}
