package gui;
import core.*;
import javax.swing.*;
import java.awt.*;
public class PreviewMenu extends Menu 
{
	private static final long serialVersionUID = 1L;
	private JPanel cpan = new JPanel();
	private JPanel east_pan = new JPanel();
	private JPanel west_pan = new JPanel();
	private JPanel south_pan = new JPanel();
	private JPanel north_pan = new JPanel();
	public PreviewMenu(core.Icon icon)
	{
		super("Icon Preview");
		IconPanel ip = Factory.getPreviewPanel();
		ip.setIcon(icon);
		cpan.setLayout(new BorderLayout());
		cpan.add(ip,BorderLayout.CENTER);
		cpan.add(east_pan,BorderLayout.EAST);
		cpan.add(west_pan,BorderLayout.WEST);
		cpan.add(south_pan,BorderLayout.SOUTH);
		cpan.add(north_pan,BorderLayout.NORTH);
		setContentPane(cpan);
	}
}
