package impl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TypDialog extends JDialog implements ActionListener,KeyListener
{
	private static final long serialVersionUID = 1L;
	private JRadioButton r1 = new JRadioButton("png"); 
	private JRadioButton r2 = new JRadioButton("gif");
	private JRadioButton r3 = new JRadioButton("jpg");
	private JRadioButton r4 = new JRadioButton("ico");
	private ButtonGroup bg = new ButtonGroup();
	private JButton butt1 = new JButton("ok");
	private JPanel cpan = new JPanel();
	private Typ erg = null;
	public TypDialog(Typ typ)
	{
		setTitle("TypDialog");
		erg = typ;
		cpan.setLayout(new GridLayout(5,1));
		cpan.add(r1);
		cpan.add(r2);
		cpan.add(r3);
		cpan.add(r4);
		cpan.add(butt1);
		setContentPane(cpan);
		butt1.addActionListener(this);
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		r1.setSelected(true);
		cpan.addKeyListener(this);
		pack();
	}
	public void ok()
	{
		if (r1.isSelected()) erg.setName("png");
		if (r2.isSelected()) erg.setName("gif");
		if (r3.isSelected()) erg.setName("jpg");
		if (r4.isSelected()) erg.setName("ico");
		dispose();
	}
	public void actionPerformed(ActionEvent ae) 
	{
		Object quelle = ae.getSource();
		if (quelle == butt1)
		{
			ok();
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
