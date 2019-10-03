package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import core.*;
import core.Icon;
import java.io.*;
import operation.*;
import images.*;
import java.net.*;
import java.util.*;
public class IconEditor extends Menu implements PixelListener,ColorListener
{
	private static final long serialVersionUID = 1L;
	private ArrayList<IconListener> listener = new ArrayList<IconListener>();
	private Locator locator = new Locator();
	private StatusPanel statusPanel = Factory.getStatusPanel();
	private IconPanel ip = Factory.getIconPanel();
	private ColorPanel cp = Factory.getColorPanel();
	private Icon icon = Factory.getIcon();
	private JLabel lab1 = new JLabel("256x256");
	private JLabel lab2 = new JLabel(" ");
	private JLabel lab3 = new JLabel("Null");
	private JPanel lpan = new JPanel();
	private JMenuBar menu = new JMenuBar();
	private JMenu m1 = new JMenu("File");
	private JMenu m2 = new JMenu("Operation");
	private JMenu m3 = new JMenu("Undo");
	private JMenu m4 = new JMenu("Info");
	private JMenu m5 = new JMenu("Util");
	private JMenu m6 = new JMenu("Filter");
	private JMenuItem m11 = new JMenuItem("Save...");
	private JMenuItem m12 = new JMenuItem("Load...");
	private JMenuItem m13 = new JMenuItem("New...");
	private JMenuItem m14 = new JMenuItem("Exit");
	private JMenuItem m21 = new JMenuItem("SetPixel");
	private JMenuItem m22 = new JMenuItem("FillBox");
	private JMenuItem m23 = new JMenuItem("FillCircle");
	private JMenuItem m24 = new JMenuItem("Rotate");
	private JMenuItem m25 = new JMenuItem("FillEllipse");
	private JMenuItem m26 = new JMenuItem("ChangeColor");
	private JMenuItem m27 = new JMenuItem("ClipBox");
	private JMenuItem m28 = new JMenuItem("EraseBox");
	private JMenuItem m29 = new JMenuItem("ShiftIcon");
	private JMenuItem m210 = new JMenuItem("DrawLine");
	private JMenuItem m211 = new JMenuItem("SwitchColor");
	private JMenuItem m212 = new JMenuItem("FillPolygon");
	private JMenuItem m213 = new JMenuItem("Heller");
	private JMenuItem m214 = new JMenuItem("Dunkler");
	private JMenuItem m215 = new JMenuItem("FillBoxWithImage");
	private JMenuItem m216 = new JMenuItem("InsertImage");
	private JMenuItem m217 = new JMenuItem("Lupe");
	private JMenuItem m218 = new JMenuItem("InsertText");
	private JMenuItem m219 = new JMenuItem("MakeTransparent");
	private JMenuItem m31 = new JMenuItem("Undo");
	private JMenuItem m32 = new JMenuItem("Redo");
	private JMenuItem m41 = new JMenuItem("Version...");
	private JMenuItem m42 = new JMenuItem("Settings...");
	private JMenuItem m43 = new JMenuItem("Protokol...");
	private JMenuItem m44 = new JMenuItem("License...");
	private JMenuItem m51 = new JMenuItem("Resize...");
	private JMenuItem m52 = new JMenuItem("PickColor");
	private JMenuItem m53 = new JMenuItem("SetColor...");
	private JMenuItem m54 = new JMenuItem("Preview...");
	private JMenuItem m61 = new JMenuItem("Rescale...");
	private JMenuItem m62 = new JMenuItem("Invert...");
	private JMenuItem m63 = new JMenuItem("Gaussian Smoothing...");
	private JMenuItem m64 = new JMenuItem("Sobel Edge Detection...");
	private JMenuItem m65 = new JMenuItem("Sharpe with gain...");
	private JMenuItem m66 = new JMenuItem("Median...");
	private JMenuItem m67 = new JMenuItem("ToGray...");
	private JMenuItem m68 = new JMenuItem("FFT...");
	private JMenuItem m69 = new JMenuItem("FFTHighPass...");
	private JMenuItem m610 = new JMenuItem("FFTLowPass...");
	private JToolBar tb = new JToolBar();
	private JButton buttSetPixel = null;
	private JButton buttFillBox = null;
	private JButton buttEraseBox = null;
	private JButton buttFillCircle = null;
	private JButton buttFillEllipse = null;
	private JButton buttChangeColor = null;
	private JButton buttClipBox = null;
	private JButton buttRotate = null;
	private JButton buttShiftIcon = null;
	private JButton buttDrawLine = null;
	private JButton buttSwitchColor = null;
	private JButton buttFillPolygon = null;
	private JButton buttFillBoxWithImage = null;
	private JButton buttInsertImage = null;
	private JButton buttLupe = null;
	private JButton buttInsertText = null;
	private JPanel cpan = new JPanel();
	private Operation aktiveOperation = new SetPixel();
	private Color aktiveColor = cp.getColor();
	private UndoManager undo = Factory.getUndoManager();
	private boolean pickColor = false;
	public IconEditor()
	{
		super("IconEditor");
		buildToolBar();
		icon.setSize(32,32);
		icon.buildRandom();
		undo.init(icon);
		init();
		m11.addActionListener(this);
		m12.addActionListener(this);
		m13.addActionListener(this);
		m14.addActionListener(this);
		m21.addActionListener(this);
		m22.addActionListener(this);
		m23.addActionListener(this);
		m24.addActionListener(this);
		m25.addActionListener(this);
		m26.addActionListener(this);
		m27.addActionListener(this);
		m28.addActionListener(this);
		m29.addActionListener(this);
		m210.addActionListener(this);
		m211.addActionListener(this);
		m212.addActionListener(this);
		m213.addActionListener(this);
		m214.addActionListener(this);
		m215.addActionListener(this);
		m216.addActionListener(this);
		m217.addActionListener(this);
		m218.addActionListener(this);
		m219.addActionListener(this);
		m31.addActionListener(this);
		m32.addActionListener(this);
		m41.addActionListener(this);
		m42.addActionListener(this);
		m43.addActionListener(this);
		m44.addActionListener(this);
		m51.addActionListener(this);
		m52.addActionListener(this);
		m53.addActionListener(this);
		m54.addActionListener(this);
		m61.addActionListener(this);
		m62.addActionListener(this);
		m63.addActionListener(this);
		m64.addActionListener(this);
		m65.addActionListener(this);
		m66.addActionListener(this);
		m67.addActionListener(this);
		m68.addActionListener(this);
		m69.addActionListener(this);
		m610.addActionListener(this);
		m1.add(m13);
		m1.add(m11);
		m1.add(m12);
		m1.add(m14);
		m2.add(m21);
		m2.add(m22);
		m2.add(m28);
		m2.add(m23);
		m2.add(m25);
		m2.add(m26);
		m2.add(m27);
		m2.add(m24);
		m2.add(m29);
		m2.add(m210);
		m2.add(m211);
		m2.add(m212);
		m2.add(m213);
		m2.add(m214);
		m2.add(m215);
		m2.add(m216);
		m2.add(m217);
		m2.add(m218);
		m2.add(m219);
		m3.add(m31);
		m3.add(m32);
		m4.add(m41);
		m4.add(m42);
		m4.add(m43);
		m4.add(m44);
		m5.add(m51);
		m5.add(m52);
		m5.add(m53);
		m5.add(m54);
		m6.add(m61);
		m6.add(m62);
		m6.add(m63);
		m6.add(m64);
		m6.add(m65);
		m6.add(m66);
		m6.add(m67);
		m6.add(m68);
		m6.add(m69);
		m6.add(m610);
		menu.add(m1);
		menu.add(m5);
		menu.add(m6);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		this.setJMenuBar(menu);
		ip.addListener(this);
		cp.addColorListener(this);
		aktiveOperation.pushColor(aktiveColor);
	}
	public void addIconListener(IconListener il)
	{
		listener.add(il);
	}
	public void removeIconListener(IconListener il)
	{
		listener.remove(il);
	}
	public void buildToolBar()
	{
		URL urlSetPixel = locator.getURL("tb01.png");
		ImageIcon iconSetPixel = new ImageIcon(urlSetPixel);
		buttSetPixel = new JButton(iconSetPixel);
		buttSetPixel.setToolTipText("SetPixel");
		buttSetPixel.addActionListener(this);
		//
		URL urlFillBox = locator.getURL("tb02.png");
		ImageIcon iconFillBox = new ImageIcon(urlFillBox);
		buttFillBox = new JButton(iconFillBox);
		buttFillBox.setToolTipText("FillBox");
		buttFillBox.addActionListener(this);
		//
		URL urlEraseBox = locator.getURL("tb03.png");
		ImageIcon iconEraseBox = new ImageIcon(urlEraseBox);
		buttEraseBox = new JButton(iconEraseBox);
		buttEraseBox.setToolTipText("EraseBox");
		buttEraseBox.addActionListener(this);
		//
		URL urlFillCircle = locator.getURL("tb04.png");
		ImageIcon iconFillCircle = new ImageIcon(urlFillCircle);
		buttFillCircle = new JButton(iconFillCircle);
		buttFillCircle.setToolTipText("FillCircle");
		buttFillCircle.addActionListener(this);
		//
		URL urlFillEllipse = locator.getURL("tb05.png");
		ImageIcon iconFillEllipse = new ImageIcon(urlFillEllipse);
		buttFillEllipse = new JButton(iconFillEllipse);
		buttFillEllipse.setToolTipText("FillEllipse");
		buttFillEllipse.addActionListener(this);
		//
		URL urlChangeColor = locator.getURL("tb06.png");
		ImageIcon iconChangeColor = new ImageIcon(urlChangeColor);
		buttChangeColor = new JButton(iconChangeColor);
		buttChangeColor.setToolTipText("ChangeColor");
		buttChangeColor.addActionListener(this);
		//
		URL urlClipBox = locator.getURL("tb07.png");
		ImageIcon iconClipBox = new ImageIcon(urlClipBox);
		buttClipBox = new JButton(iconClipBox);
		buttClipBox.setToolTipText("ClipBox");
		buttClipBox.addActionListener(this);
		//
		URL urlRotate = locator.getURL("tb08.png");
		ImageIcon iconRotate = new ImageIcon(urlRotate);
		buttRotate = new JButton(iconRotate);
		buttRotate.setToolTipText("Rotate");
		buttRotate.addActionListener(this);
		//
		URL urlShiftIcon = locator.getURL("tb09.png");
		ImageIcon iconShiftIcon = new ImageIcon(urlShiftIcon);
		buttShiftIcon = new JButton(iconShiftIcon);
		buttShiftIcon.setToolTipText("ShiftIcon");
		buttShiftIcon.addActionListener(this);
		//
		URL urlDrawLine = locator.getURL("tb10.png");
		ImageIcon iconDrawLine = new ImageIcon(urlDrawLine);
		buttDrawLine = new JButton(iconDrawLine);
		buttDrawLine.setToolTipText("DrawLine");
		buttDrawLine.addActionListener(this);
		//
		URL urlSwitchColor = locator.getURL("tb11.png");
		ImageIcon iconSwitchColor = new ImageIcon(urlSwitchColor);
		buttSwitchColor = new JButton(iconSwitchColor);
		buttSwitchColor.setToolTipText("SwitchColor");
		buttSwitchColor.addActionListener(this);
		//
		URL urlFillPolygon = locator.getURL("tb12.png");
		ImageIcon iconFillPolygon = new ImageIcon(urlFillPolygon);
		buttFillPolygon = new JButton(iconFillPolygon);
		buttFillPolygon.setToolTipText("FillPolygon");
		buttFillPolygon.addActionListener(this);
		//
		URL urlFillBoxWithImage = locator.getURL("tb13.png");
		ImageIcon iconFillBoxWithImage = new ImageIcon(urlFillBoxWithImage);
		buttFillBoxWithImage = new JButton(iconFillBoxWithImage);
		buttFillBoxWithImage.setToolTipText("FillBoxWithImage");
		buttFillBoxWithImage.addActionListener(this);
		//
		URL urlInsertImage = locator.getURL("tb14.png");
		ImageIcon iconInsertImage = new ImageIcon(urlInsertImage);
		buttInsertImage = new JButton(iconInsertImage);
		buttInsertImage.setToolTipText("InsertImage");
		buttInsertImage.addActionListener(this);
		//
		URL urlLupe = locator.getURL("tb15.png");
		ImageIcon iconLupe = new ImageIcon(urlLupe);
		buttLupe = new JButton(iconLupe);
		buttLupe.setToolTipText("Lupe");
		buttLupe.addActionListener(this);
		//
		URL urlInsertText = locator.getURL("tb16.png");
		ImageIcon iconInsertText = new ImageIcon(urlInsertText);
		buttInsertText = new JButton(iconInsertText);
		buttInsertText.setToolTipText("InsertText");
		buttInsertText.addActionListener(this);
		//
		tb.add(buttSetPixel);
		tb.add(buttFillBox);
		tb.add(buttEraseBox);
		tb.add(buttFillCircle);
		tb.add(buttFillEllipse);
		tb.add(buttChangeColor);
		tb.add(buttClipBox);
		tb.add(buttRotate);
		tb.add(buttShiftIcon);
		tb.add(buttDrawLine);
		tb.add(buttSwitchColor);
		tb.add(buttFillPolygon);
		tb.add(buttFillBoxWithImage);
		tb.add(buttInsertImage);
		tb.add(buttLupe);
		tb.add(buttInsertText);
	}
	public int onClose()
	{
		int erg = Menu.dispose;
		int n = listener.size();
		if (n > 0)
		{
			for (int i=0;i<listener.size();i++)
			{
				IconListener il = listener.get(i);
				il.done(icon);
			}
		}
		else
		{
			erg = Menu.exit;
			int rc = JOptionPane.showConfirmDialog(null,"Save Icon?","Save",JOptionPane.YES_NO_CANCEL_OPTION);
			if (rc == JOptionPane.YES_OPTION) //YES
			{
				FileChooser fc = Factory.getFileChooser();
				File file = fc.getWriteFile();
				if (file != null)
				{
					icon.writeToFile(file);
				}
			}
			else if (rc == JOptionPane.CANCEL_OPTION)
			{
				erg = Menu.stayalive;
			}
			if (erg != Menu.stayalive)
			{
				// Protokol.close();
			}
		}
		return erg;
	}
	public void init()
	{
		buildLPAN();
		aktiveColor = cp.getColor();
		ip.setIcon(icon);
		cpan.removeAll();
		cpan.setLayout(new BorderLayout());
		cpan.add(tb,BorderLayout.NORTH);
		//Dimension dip = ip.getPreferredSize();
		//Protokol.write("IconEditor:init:IconPanel Breite:" + dip.width);
		//Protokol.write("IconEditor:init;IconPanel Hoehe :" + dip.height);
		JPanel x0pan = new JPanel();
		JPanel x1pan = new JPanel();
		JPanel x2pan = new JPanel();
		x0pan.setLayout(new BorderLayout());
		x0pan.add(ip,BorderLayout.CENTER);
		x0pan.add(x1pan,BorderLayout.SOUTH);
		x0pan.add(x2pan,BorderLayout.EAST);
		cpan.add(x0pan,BorderLayout.CENTER);
		cpan.add(cp,BorderLayout.WEST);
		cpan.add(statusPanel,BorderLayout.EAST);
		cpan.add(lpan,BorderLayout.SOUTH);
		setContentPane(cpan);
		validate();
		pack();
	}
	public void buildLPAN()
	{
		int width = icon.getSize().width;
		int height = icon.getSize().height;
		lab1.setText(width + "x" + height);
		if (aktiveOperation == null)
		{
			lab3.setText("noOperation");
		}
		else
		{
			lab3.setText(aktiveOperation.getName() + " " + aktiveOperation.getStatus());
		}
		lpan.removeAll();
		lpan.setLayout(new BorderLayout());
		lpan.add(lab1,BorderLayout.WEST);
		lpan.add(lab2,BorderLayout.CENTER);
		lpan.add(lab3,BorderLayout.EAST);
		validate();
	}
	public void clicked(Pixel pixel) 
	{
		if (pickColor)
		{
			Color c = pixel.getColor();
			Protokol.write("IconEditor:pickColor:Color:" + c.toString());
			cp.setColor(c);
			if (aktiveOperation != null)
			{
				aktiveOperation.pushColor(c);
				testOperation();
			}
			pickColor = false;
		}
		else
		{
			if (aktiveOperation != null)
			{
				statusPanel.clicked(pixel);
				aktiveOperation.pushPixel(pixel);
				testOperation();
			}
		}
	}
	public void moved(Pixel pixel)
	{
		statusPanel.moved(pixel);
	}
	public void setIcon(Icon newIcon)
	{
		icon = newIcon.copy();
		undo.init(icon);
		init();
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object quelle = ae.getSource();
		if (quelle == m11) // save
		{
			FileChooser fc = Factory.getFileChooser();
			File file = fc.getWriteFile();
			if (file != null)
			{
				icon.writeToFile(file);
			}
		}
		if (quelle == m12) // load
		{
			FileChooser fc = Factory.getFileChooser();
			File file = fc.getReadFile();
			if (file != null)
			{
				icon.readFromFile(file);
				int width = icon.getSize().width;
				int height = icon.getSize().height;
				boolean resize = false;
				if (width > Parameter.maxIconWidth) resize = true;
				if (height > Parameter.maxIconHeight) resize = true;
				if (resize)
				{
					IconResizer ir = Factory.getIconResizer();
					icon = ir.resize(icon,Parameter.maxIconWidth,Parameter.maxIconHeight);
				}
				undo.init(icon);
				init();
			}
		}
		if (quelle == m13) // new
		{
			SizeChooser sz = Factory.getSizeChooser();
			Dimension dim = sz.getSize();
			if (dim.height != 0)
			{
				icon.setSize(dim.width,dim.height);
				undo.init(icon);
				init();
			}
		}
		if (quelle == m14) // exit
		{
			int ok = onClose();
			if (ok != Menu.stayalive)
			{
				dispose();
				System.exit(0);
			}
		}
		if (quelle == m21 || quelle == buttSetPixel)
		{
			aktiveOperation = new SetPixel();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m22 || quelle == buttFillBox)
		{
			aktiveOperation = new FillBox();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m23 || quelle == buttFillCircle)
		{
			aktiveOperation = new FillCircle();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m24 || quelle == buttRotate)
		{
			aktiveOperation = new Rotate();
			testOperation();
		}
		if (quelle == m25 || quelle == buttFillEllipse)
		{
			aktiveOperation = new FillEllipse();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m26 || quelle == buttChangeColor)
		{
			aktiveOperation = new ChangeColor();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m27 || quelle == buttClipBox)
		{
			aktiveOperation = new ClipBox();
			// aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m28 || quelle == buttEraseBox)
		{
			aktiveOperation = new EraseBox();
			// aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m29 || quelle == buttShiftIcon)
		{
			aktiveOperation = new ShiftIcon();
			// aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m210 || quelle == buttDrawLine)
		{
			aktiveOperation = new DrawLine();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m211 || quelle == buttSwitchColor)
		{
			aktiveOperation = new SwitchColor();
			// aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m212 || quelle == buttFillPolygon)
		{
			aktiveOperation = new FillPolygon();
			// aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m213)
		{
			aktiveOperation = new Heller();
			testOperation();
		}
		if (quelle == m214)
		{
			aktiveOperation = new Dunkler();
			testOperation();
		}
		if (quelle == m215 || quelle == buttFillBoxWithImage)
		{
			aktiveOperation = new FillBoxWithImage();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m216 || quelle == buttInsertImage)
		{
			aktiveOperation = new InsertImage();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m217 || quelle == buttLupe)
		{
			aktiveOperation = new Lupe();
			// aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m218 || quelle == buttInsertText)
		{
			TextDialog td = new TextDialog();
			td.anzeigen();
			aktiveOperation = new InsertText();
			aktiveOperation.pushColor(aktiveColor);
		}
		if (quelle == m219)
		{
			aktiveOperation = new MakeTransparent();
		}
		if (quelle == m31)
		{
			Icon ticon = undo.undo();
			if (ticon != null)
			{
				icon = ticon;
				init();
			}
		}
		if (quelle == m32)
		{
			Icon ticon = undo.redo();
			if (ticon != null)
			{
				icon = ticon;
				init();
			}
		}
		if (quelle == m41)
		{
			JOptionPane.showMessageDialog(null,Parameter.version,"Version",JOptionPane.INFORMATION_MESSAGE);
		}
		if (quelle == m42)
		{
			ParameterDialog pd = new ParameterDialog();
			pd.setModal(true);
			pd.setVisible(true);
			init();
		}
		if (quelle == m43)
		{
			ProtokolMenu pm = new ProtokolMenu();
			pm.anzeigen();
		}
		if (quelle == m44)
		{
			JOptionPane.showMessageDialog(null,Parameter.license,"License",JOptionPane.INFORMATION_MESSAGE);
		}
		if (quelle == m51) // resize
		{
			SizeChooser sz = Factory.getSizeChooser();
			Dimension dim = sz.getSize();
			if (dim.height != 0)
			{
				IconResizer ir = Factory.getIconResizer();
				icon = ir.resize(icon,dim.width,dim.height);
				undo.init(icon);
				init();
			}
		}
		if (quelle == m52) //pickColor
		{
			pickColor = true;
		}
		if (quelle == m53) //setColor
		{
			Color tc = JColorChooser.showDialog(null,"JColorChooser",aktiveColor);
			if (tc != null)
			{
				aktiveColor = tc;
				cp.setColor(tc);
			}
			else
			{
				Protokol.write("IconEditor:m53:Keine Color ausgesucht");
			}
		}
		if (quelle == m54)
		{
			PreviewMenu pm = new PreviewMenu(icon);
			pm.anzeigen();
		}
		if (quelle == m61)
		{
			aktiveOperation = new Rescale();
			operate();
		}
		if (quelle == m62)
		{
			aktiveOperation = new Invert();
			operate();
		}
		if (quelle == m63)
		{
			aktiveOperation = new Gaussian();
			operate();
		}
		if (quelle == m64)
		{
			aktiveOperation = new Sobel();
			operate();
		}
		if (quelle == m65)
		{
			aktiveOperation = new SharpeWithGain();
			operate();
		}
		if (quelle == m66)
		{
			aktiveOperation = new Median();
			operate();
		}
		if (quelle == m67)
		{
			aktiveOperation = new ToGray();
			operate();
		}
		if (quelle == m68) // fast Fourier Transformation
		{
			aktiveOperation = new FFT();
			operate();
		}
		if (quelle == m69) // fast Fourier Transformation - HighPass
		{
			aktiveOperation = new FFTHighPass();
			operate();
		}
		if (quelle == m610) // fast Fourier Transformation - LowPass
		{
			aktiveOperation = new FFTLowPass();
			operate();
		}
		buildLPAN();
	}
	public void newColor(Color c) 
	{
		Protokol.write("IconEditor:newColor:" + c.toString());
		aktiveColor = c;
		if (aktiveOperation != null)
		{
			aktiveOperation.pushColor(aktiveColor);
			testOperation();
		}
	}
	public void testOperation()
	{
		if (aktiveOperation != null)
		{
			buildLPAN();
			if (aktiveOperation.isReady())
			{
				undo.push(aktiveOperation);
				icon = aktiveOperation.operate(icon);
				aktiveOperation.reset();
				init();
			}
		}
	}
	public void operate() // Nur für Operation die keine Pixel benötigen
	{
		if (aktiveOperation != null)
		{
			buildLPAN();
			undo.push(aktiveOperation);
			icon = aktiveOperation.operate(icon);
			init();
		}
	}
}
