package gui;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class ProtokolMenu extends Menu
{
	public static final long serialVersionUID= 0;
	private JPanel cpan = new JPanel();
	private JTextArea ta = new JTextArea(20,100);
	private JScrollPane sp = new JScrollPane(ta);
	public ProtokolMenu()
	{
		super("Protokol");
		ArrayList<String> msg = Protokol.getMessages();
		for (int i=0;i<msg.size();i++)
		{
			String satz = msg.get(i);
			ta.append(satz + "\n");
		}
		cpan.setLayout(new BorderLayout());
		cpan.add(sp);
		setContentPane(cpan);
		this.pack();
	}
}
