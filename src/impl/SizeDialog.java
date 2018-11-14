package impl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import core.Parameter;
import core.Protokol;
public class SizeDialog extends JDialog implements ActionListener,KeyListener
{
	private static final long serialVersionUID = 1L;
	private JLabel lab1 = new JLabel("Width: ");
	private JLabel lab2 = new JLabel("Height: ");
	private JTextField tf1 = new JTextField(10);
	private JTextField tf2 = new JTextField(10);
	private JButton butt1 = new JButton("ok");
	private JButton butt2 = new JButton("cancel");
	private JPanel cpan = new JPanel();
	private Dimension erg = null;
	public SizeDialog(Dimension dim)
	{
		setTitle("SizeDialog");
		erg = dim;
		cpan.setLayout(new GridLayout(3,2));
		cpan.add(lab1);
		cpan.add(tf1);
		cpan.add(lab2);
		cpan.add(tf2);
		cpan.add(butt1);
		cpan.add(butt2);
		setContentPane(cpan);
		butt1.addActionListener(this);
		butt2.addActionListener(this);
		tf1.addKeyListener(this);
		tf2.addKeyListener(this);
		cpan.addKeyListener(this);
		pack();
	}
	public void ok()
	{
		erg.width = 0;
		erg.height = 0;
		String sw = tf1.getText();
		String sh = tf2.getText();
		try
		{
			int w = new Integer(sw).intValue();
			int h = new Integer(sh).intValue();
			if (w < Parameter.minIconWidth) w = Parameter.minIconWidth;
			if (w > Parameter.maxIconWidth) w = Parameter.maxIconWidth;
			if (h < Parameter.minIconHeight) h = Parameter.minIconHeight;
			if (h > Parameter.maxIconHeight) h = Parameter.maxIconHeight;
			erg.width = w;
			erg.height = h;
		}
		catch (Exception e)
		{
			Protokol.write("SizeDialog:Exception:");
			Protokol.write(e.toString());
		}
		dispose();
	}
	public void actionPerformed(ActionEvent ae) 
	{
		Object quelle = ae.getSource();
		if (quelle == butt1)
		{
			ok();
		}
		if (quelle == butt2)
		{
			erg.width = 0;
			erg.height = 0;
			dispose();
		}
	}
	public void keyPressed(KeyEvent ke) 
	{
		
	}
	public void keyReleased(KeyEvent ke) 
	{
		
	}
	public void keyTyped(KeyEvent ke) 
	{
		char kc = ke.getKeyChar();
		if (kc == KeyEvent.VK_ENTER)
		{
			ok();
		}
	}
}
