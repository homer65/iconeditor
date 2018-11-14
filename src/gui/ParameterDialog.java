package gui;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.prefs.Preferences;
public class ParameterDialog extends JDialog implements ActionListener
{
	public static final long serialVersionUID= 0;
	private JPanel cpan = new JPanel();
	private JPanel apan = new JPanel();
	private JLabel lab1 = new JLabel("MinIconWidth");
	private JTextField tf1 = new JTextField(20);
	private JButton butt1 = new JButton("Default");
	private JLabel lab2 = new JLabel("MaxIconWidth");
	private JTextField tf2 = new JTextField(20);
	private JButton butt2 = new JButton("Default");
	private JLabel lab3 = new JLabel("MinIconHeight");
	private JTextField tf3 = new JTextField(20);
	private JButton butt3 = new JButton("Default");
	private JLabel lab4 = new JLabel("MaxIconHeight");
	private JTextField tf4 = new JTextField(20);
	private JButton butt4 = new JButton("Default");
	private JLabel lab6 = new JLabel("IconPanelSize");
	private JTextField tf6 = new JTextField(20);
	private JButton butt6 = new JButton("Default");
	private JLabel lab7 = new JLabel("ColorDistance");
	private JTextField tf7 = new JTextField(20);
	private JButton butt7 = new JButton("Default");
	private JLabel lab8 = new JLabel("Gain");
	private JTextField tf8 = new JTextField(20);
	private JButton butt8 = new JButton("Default");
	private JLabel lab9 = new JLabel("Bias");
	private JTextField tf9 = new JTextField(20);
	private JButton butt9 = new JButton("Default");	
	private JLabel lab10 = new JLabel("Rmax");
	private JTextField tf10 = new JTextField(20);
	private JButton butt10 = new JButton("Default");	
	private JLabel lab11 = new JLabel("Rmin");
	private JTextField tf11 = new JTextField(20);
	private JButton butt11 = new JButton("Default");	
	private JPanel bpan = new JPanel();
	private JPanel bpanx = new JPanel();
	private JButton buttb1 = new JButton("save");
	private JButton buttb2 = new JButton("cancel");
	private Preferences prefs = Preferences.userRoot();
	public ParameterDialog()
	{
		// super("Settings");
		tf1.setText("" + Parameter.minIconWidth);
		tf2.setText("" + Parameter.maxIconWidth);
		tf3.setText("" + Parameter.minIconHeight);
		tf4.setText("" + Parameter.maxIconHeight);
		tf6.setText("" + Parameter.iconPanelSize);
		tf7.setText("" + Parameter.colorDistance);
		tf8.setText("" + Parameter.gain);
		tf9.setText("" + Parameter.bias);
		tf10.setText("" + Parameter.rmax);
		tf11.setText("" + Parameter.rmin);
		apan.setLayout(new GridLayout(11,3));
		apan.add(lab1);
		apan.add(tf1);
		apan.add(butt1);
		apan.add(lab2);
		apan.add(tf2);
		apan.add(butt2);
		apan.add(lab3);
		apan.add(tf3);
		apan.add(butt3);
		apan.add(lab4);
		apan.add(tf4);
		apan.add(butt4);
		apan.add(lab6);
		apan.add(tf6);
		apan.add(butt6);
		apan.add(lab7);
		apan.add(tf7);
		apan.add(butt7);
		apan.add(lab8);
		apan.add(tf8);
		apan.add(butt8);
		apan.add(lab9);
		apan.add(tf9);
		apan.add(butt9);
		apan.add(lab10);
		apan.add(tf10);
		apan.add(butt10);
		apan.add(lab11);
		apan.add(tf11);
		apan.add(butt11);
		bpan.setLayout(new GridLayout(1,2));
		bpan.add(buttb1);
		bpan.add(buttb2);
		bpanx.setLayout(new BorderLayout());
		bpanx.add(bpan,BorderLayout.WEST);
		cpan.setLayout(new BorderLayout());
		cpan.add(apan,BorderLayout.CENTER);
		cpan.add(bpanx,BorderLayout.SOUTH);
		setContentPane(cpan);
		butt1.addActionListener(this);
		butt2.addActionListener(this);
		butt3.addActionListener(this);
		butt4.addActionListener(this);
		butt6.addActionListener(this);
		butt7.addActionListener(this);
		buttb1.addActionListener(this);
		buttb2.addActionListener(this);
		butt8.addActionListener(this);
		butt9.addActionListener(this);
		butt10.addActionListener(this);
		butt11.addActionListener(this);
		this.pack();
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object quelle = ae.getSource();
		if (quelle == butt1)
		{
			tf1.setText("" + Parameter.minIconWidthDefault);
		}
		if (quelle == butt2)
		{
			tf2.setText("" + Parameter.maxIconWidthDefault);
		}
		if (quelle == butt3)
		{
			tf3.setText("" + Parameter.minIconHeightDefault);
		}
		if (quelle == butt4)
		{
			tf4.setText("" + Parameter.maxIconHeightDefault);
		}
		if (quelle == butt6)
		{
			tf6.setText("" + Parameter.iconPanelSizeDefault);
		}
		if (quelle == butt7)
		{
			tf7.setText("" + Parameter.colorDistanceDefault);
		}
		if (quelle == butt8)
		{
			tf8.setText("" + Parameter.gainDefault);
		}
		if (quelle == butt9)
		{
			tf9.setText("" + Parameter.biasDefault);
		}
		if (quelle == butt10)
		{
			tf10.setText("" + Parameter.rmaxDefault);
		}
		if (quelle == butt11)
		{
			tf11.setText("" + Parameter.rminDefault);
		}
		if (quelle == buttb1)
		{
			String s1 = tf1.getText();
			String s2 = tf2.getText();
			String s3 = tf3.getText();
			String s4 = tf4.getText();
			String s6 = tf6.getText();
			String s7 = tf7.getText();
			String s8 = tf8.getText();
			String s9 = tf9.getText();
			String s10 = tf10.getText();
			String s11 = tf11.getText();
			Parameter.minIconWidth = getNumber(s1);
			Parameter.maxIconWidth = getNumber(s2);
			Parameter.minIconHeight = getNumber(s3);
			Parameter.maxIconHeight = getNumber(s4);
			Parameter.iconPanelSize = getNumber(s6);
			Parameter.colorDistance = getNumber(s7);
			Parameter.gain = getDouble(s8);
			Parameter.bias = getDouble(s9);
			Parameter.rmax = getDouble(s10);
			Parameter.rmin = getDouble(s11);
			tf1.setText(Parameter.minIconWidth + "");
			tf2.setText(Parameter.maxIconWidth + "");
			tf3.setText(Parameter.minIconHeight + "");
			tf4.setText(Parameter.maxIconHeight + "");
			tf6.setText(Parameter.iconPanelSize + "");
			tf7.setText(Parameter.colorDistance + "");
			tf8.setText(Parameter.gain + "");
			tf9.setText(Parameter.bias + "");
			tf10.setText(Parameter.rmax + "");
			tf11.setText(Parameter.rmin + "");
			prefs.put("iconeditor_miniconwidth",Parameter.minIconWidth + "");
			prefs.put("iconeditor_maxiconwidth",Parameter.maxIconWidth + "");
			prefs.put("iconeditor_miniconheight",Parameter.minIconHeight + "");
			prefs.put("iconeditor_maxiconheight",Parameter.maxIconHeight + "");
			prefs.put("iconeditor_iconpanelsize",Parameter.iconPanelSize + "");
			prefs.put("iconeditor_colordistance",Parameter.colorDistance + "");
			prefs.put("iconeditor_gain",Parameter.gain + "");
			prefs.put("iconeditor_bias",Parameter.bias + "");
			prefs.put("iconeditor_rmax",Parameter.rmax + "");
			prefs.put("iconeditor_rmin",Parameter.rmin + "");
		}
		if (quelle == buttb2)
		{
			dispose();
		}
	}
	public int getNumber(String s)
	{
		int erg = 0;
		try
		{
			erg = new Integer(s).intValue();
		}
		catch (Exception e)
		{
			erg = 0;
			Protokol.write("ParameterDialog:getNumber:not a Number:" + s);
		}
		return erg;
	}
	public double getDouble(String s)
	{
		double erg = 0;
		try
		{
			erg = new Double(s).doubleValue();
		}
		catch (Exception e)
		{
			erg = 0;
			Protokol.write("ParameterDialog:getDouble:not a Number:" + s);
		}
		return erg;
	}
}
