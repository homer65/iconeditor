package impl;
import core.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SpecialIconPanel extends IconPanel implements MouseListener,MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	private ArrayList<PixelListener> alPL = new ArrayList<PixelListener>();
	private Icon icon = null;
	private int width = 0;
	private int height = 0;
	private int size = 0;
	private Color c1 = new Color(0,0,0,255);
	private Color c2 = new Color(255,255,255,255);
	public SpecialIconPanel()
	{
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	public void addListener(PixelListener listener) 
	{
		alPL.add(listener);	
	}
	public void removeListener(PixelListener listener) 
	{
		alPL.remove(listener);
	}
	public void setIcon(Icon icon) 
	{
		this.removeAll();
		Dimension dim = icon.getSize();
		width = dim.width;
		height = dim.height;
		int max = width;
		if (max < height) max = height;
		size = Parameter.iconPanelSize / max;
		if (size == 0) size = 1;
		setPreferredSize(new Dimension(width*size,height*size));
		this.icon = icon;
		repaint();
	}
	public void paint(Graphics g)
	{
		if (icon != null)
		{
			boolean ib = true;
			boolean jb = true;
			for (int i=0;i<width;i++)
			{
				if (ib) ib = false;
				else ib = true;
				jb = true;
				for (int j=0;j<height;j++)
				{
					if (jb) jb = false;
					else jb = true;
					if ((ib & jb)||((!ib) & (!jb)))
					{
						g.setColor(c1);
					}
					else
					{
						g.setColor(c2);
					}
					g.fillRect(i*size,j*size,size,size);
					Pixel p = icon.getPixel(i,j);
					Color c = p.getColor();
					int blue = c.getBlue();
					int red = c.getRed();
					int green = c.getGreen();
					int x = blue + green + red;
					if (x > 0)
					{
						g.setColor(c);
						g.fillRect(i*size,j*size,size,size);
					}
				}
			}
		}
	}
	@Override
	public Icon getIcon() 
	{
		return icon;
	}
	public void mouseClicked(MouseEvent me) 
	{

	}
	public void mouseEntered(MouseEvent arg0) 
	{
	
	}
	public void mouseExited(MouseEvent arg0) 
	{
	
	}
	public void mousePressed(MouseEvent arg0) 
	{
				
	}
	public void mouseReleased(MouseEvent me)
	{
		int x = me.getX() / size;
		int y = me.getY() / size;
		Pixel pixel = icon.getPixel(x,y);
		for (int i=0;i<alPL.size();i++)
		{
			PixelListener ppl = alPL.get(i);
			ppl.clicked(pixel);
		}		
	}
	//
	public void mouseMoved(MouseEvent me)
	{
		int x = me.getX() / size;
		int y = me.getY() / size;
		Pixel pixel = icon.getPixel(x,y);
		for (int i=0;i<alPL.size();i++)
		{
			PixelListener ppl = alPL.get(i);
			ppl.moved(pixel);
		}
	}
	public void mouseDragged(MouseEvent me)
	{
		
	}
}
