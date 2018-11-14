package impl;
import core.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class NonQuadraticIconPanel extends IconPanel implements MouseListener,MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	private ArrayList<PixelListener> alPL = new ArrayList<PixelListener>();
	private Icon oicon = null;
	private Icon picon = null;
	private int owidth = 0;
	private int oheight = 0;
	private int pwidth = 0;
	private int pheight = 0;
	private float faktorx = 1;
	private float faktory = 1;
	public NonQuadraticIconPanel()
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
		this.oicon = icon.copy();
		this.picon = icon.copy();
		Dimension dim = picon.getSize();
		owidth = dim.width;
		oheight = dim.height;
		//Protokol.write("NonQuadraticIconPanel:owidth :" + owidth);
		//Protokol.write("NonQuadraticIconPanel:oheight:" + oheight);
		pwidth = dim.width;
		pheight = dim.height;
		float pfaktor = ((float) Parameter.iconPanelSize) / ((float) pwidth);
		if (pheight > pwidth)
		{
			pfaktor = ((float) Parameter.iconPanelSize) / ((float) pheight);
		}
		pwidth = (int) (pfaktor * pwidth);
		pheight = (int) (pfaktor * pheight);
		IconResizer ir = Factory.getIconResizer();
		picon = ir.resize(picon,pwidth,pheight);
		dim = picon.getSize();
		pwidth = dim.width;
		pheight = dim.height;
		faktorx = ((float) owidth) / ((float) pwidth);
		faktory = ((float) oheight) / ((float) pheight);
		setPreferredSize(new Dimension(pwidth,pheight));
		this.setSize(new Dimension(pwidth,pheight));
		//Protokol.write("NonQuadraticIconPanel:pwidth :" + pwidth);
		//Protokol.write("NonQuadraticIconPanel:pheight:" + pheight);
		repaint();
	}
	public void paint(Graphics g)
	{
		if (picon != null)
		{
			for (int i=0;i<pwidth;i++)
			{
				for (int j=0;j<pheight;j++)
				{
					Pixel p = picon.getPixel(i,j);
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
		return oicon;
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
		int x = me.getX();
		int y = me.getY();
		int ox = (int) (faktorx * x);
		int oy = (int) (faktory * y);
		if (ox > owidth) ox = owidth;
		if (oy > oheight) oy = oheight;
		Pixel pixel = oicon.getPixel(ox,oy);
		for (int i=0;i<alPL.size();i++)
		{
			PixelListener ppl = alPL.get(i);
			ppl.clicked(pixel);
		}		
	}
	//
	public void mouseMoved(MouseEvent me)
	{
		int x = me.getX();
		int y = me.getY();
		int ox = (int) (faktorx * x);
		int oy = (int) (faktory * y);
		if (ox > owidth) ox = owidth;
		if (oy > oheight) oy = oheight;
		Pixel pixel = oicon.getPixel(ox,oy);
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
