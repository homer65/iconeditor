package impl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import core.*;
public class SimpleColorPanel extends ColorPanel implements MouseListener
{
	private int size = 16;
	private ArrayList<ColorListener> al = new ArrayList<ColorListener>(); 
	private Color c = Color.red;
	private static final long serialVersionUID = 1L;
	public SimpleColorPanel()
	{
		setPreferredSize(new Dimension(size,size));
		this.addMouseListener(this);
	}
	@Override
	public void addColorListener(ColorListener listener) 
	{
		al.add(listener);		
	}
	@Override
	public Color getColor() 
	{
		return c;
	}
	@Override
	public void removeColorListener(ColorListener listener) 
	{
		al.remove(listener);		
	}
	@Override
	public void setColor(Color c)
	{
		this.c = c;		
		for (int i=0;i<al.size();i++)
		{
			ColorListener cl = al.get(i);
			cl.newColor(c);
		}
		repaint();
		validate();
	}
	public void paint(Graphics g)
	{
		g.setColor(c);
		g.fillRect(0,0,size,size);
	}
	public void mouseClicked(MouseEvent arg0) 
	{
		Color erg = JColorChooser.showDialog(null,"JColorChooser",c);
		if (erg != null)
		{
			setColor(erg);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
