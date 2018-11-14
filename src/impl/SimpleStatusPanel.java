package impl;
import core.*;
import java.awt.*;
import javax.swing.*;
public class SimpleStatusPanel extends StatusPanel
{
	private JLabel labMoved = new JLabel("9999:9999");
	private JLabel labClicked = new JLabel("9999:9999");
	private JPanel xpan = new JPanel();
	private JPanel cpan = new JPanel();
	public SimpleStatusPanel()
	{
		setLayout(new BorderLayout());
		xpan.setLayout(new GridLayout(2,1));
		xpan.add(labMoved);
		xpan.add(labClicked);
		add(xpan,BorderLayout.NORTH);
		add(cpan,BorderLayout.CENTER);
	}
	private static final long serialVersionUID = 1L;
	public void clicked(Pixel pixel)
	{
		int x = pixel.getX();
		int y = pixel.getY();
		labClicked.setText(get3(x) + ":" + get3(y));
	}
	public void moved(Pixel pixel)
	{
		int x = pixel.getX();
		int y = pixel.getY();
		labMoved.setText(get3(x) + ":" + get3(y));
	}
	public String get3(int i)
	{
		String erg = new Integer(i).toString();
		int l = erg.length();
		if (l == 1) erg = "000" + erg;
		else if (l == 2) erg = "00" + erg;
		else if (l == 3) erg = "0" + erg;
		return erg;
	}
}
