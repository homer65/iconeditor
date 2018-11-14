package impl;
import java.awt.*;
import java.awt.image.BufferedImage;

import core.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class SimpleTextImage extends JPanel implements TextImage
{
	private int textWidth = 0;
	private int textHeight = 0;
	private BufferedImage bi = null;
	@Override
	public BufferedImage getImage() 
	{
		return bi;
	}
	public int getTextWidth()
	{
		return textWidth;
	}
	public int getTextHeight()
	{
		return textHeight;
	}
	@Override
	public void setText(String text,int size,Color color) 
	{
		bi = new BufferedImage(2000,200,BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bi.getGraphics();
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.setPaint(color);
		g2d.setFont(new Font("Serif", Font.BOLD,size));
		FontMetrics fm = g2d.getFontMetrics();
		textWidth = fm.stringWidth(text);
		textHeight = fm.getHeight();
		bi = new BufferedImage(textWidth,textHeight,BufferedImage.TYPE_INT_RGB);
		graphics = bi.getGraphics();
		g2d = (Graphics2D) graphics;
		g2d.setPaint(color);
		g2d.setFont(new Font("Serif", Font.BOLD,size));
		fm = g2d.getFontMetrics();
		g2d.drawString(text,0,textHeight);
		g2d.dispose();
	}
}
