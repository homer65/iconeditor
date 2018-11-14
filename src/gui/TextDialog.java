package gui;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class TextDialog extends Menu
{
	public static final long serialVersionUID= 0;
	private JPanel cpan = new JPanel();
	private JLabel lab1 = new JLabel("Text     :");
	private JLabel lab2 = new JLabel("Font Size:");
	private JTextField tf1 = new JTextField(20);
	private JTextField tf2 = new JTextField(20);
	private JButton butt1 = new JButton("ok");
	private JButton butt2 = new JButton("cancel");
	public TextDialog()
	{
		super("Text");
		tf1.setText(Parameter.text);
		tf2.setText(Parameter.textsize);
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
		this.pack();
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object quelle = ae.getSource();
		if (quelle == butt1)
		{
			Parameter.text = tf1.getText();
			String x = tf2.getText();
			try
			{
				new Integer(x).intValue();
				Parameter.textsize = x;
				dispose();
			}
			catch (Exception e)
			{
				Protokol.write("TextDialog:actionPerformed:Font Size not numeric:" + x);
			}
		}
		if (quelle == butt2)
		{
			dispose();
		}
	}
}
