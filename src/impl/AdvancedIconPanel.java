package impl;
import core.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class AdvancedIconPanel extends IconPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	private ArrayList<PixelListener> alPL = new ArrayList<PixelListener>();
	private Icon icon = null;
	private int width = 0;
	private int height = 0;
	private int size = 0;
	public AdvancedIconPanel()
	{
		this.addMouseListener(this);
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
			for (int i=0;i<width;i++)
			{
				for (int j=0;j<height;j++)
				{
					Pixel p = icon.getPixel(i,j);
					Color c = p.getColor();
					g.setColor(c);
					g.fillRect(i*size,j*size,(i+1)*size,(j+1)*size);
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
		int x = me.getX() / size;
		int y = me.getY() / size;
		Pixel pixel = icon.getPixel(x,y);
		for (int i=0;i<alPL.size();i++)
		{
			PixelListener ppl = alPL.get(i);
			ppl.clicked(pixel);
		}
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
	public void mouseReleased(MouseEvent arg0)
	{
				
	}
}
