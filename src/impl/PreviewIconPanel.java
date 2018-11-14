package impl;
import core.*;
import java.awt.*;
public class PreviewIconPanel extends IconPanel
{
	private static final long serialVersionUID = 1L;
	private Icon icon = null;
	private int width = 0;
	private int height = 0;
	public void setIcon(Icon icon) 
	{
		this.removeAll();
		Dimension dim = icon.getSize();
		width = dim.width;
		height = dim.height;
		setPreferredSize(new Dimension(width,height));
		this.icon = icon;
		repaint();
	}
	public void addListener(PixelListener pl)
	{
		
	}
	public void removeListener(PixelListener pl)
	{
		
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
					g.fillRect(i,j,1,1);
				}
			}
		}
	}
	@Override
	public Icon getIcon() 
	{
		return icon;
	}
}
