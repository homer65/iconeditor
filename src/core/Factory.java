package core;
import impl.*;
public class Factory 
{
	public static Initialisierung getInitialisierung()
	{
		return new PreferencesInitialisierung();
	}
	public static Pixel getPixel()
	{
		return new SimplePixel();
	}
	public static Icon getIcon()
	{
		return new AdvancedIcon();
	}
	public static IconPanel getIconPanel()
	{
		//return new SpecialIconPanel();
		//return new ScalableIconPanel();
		return new NonQuadraticIconPanel();
	}
	public static TextImage getTextImage()
	{
		return new SimpleTextImage();
	}
	public static IconPanel getPreviewPanel()
	{
		return new PreviewIconPanel();
	}
	public static FileChooser getFileChooser()
	{
		return new AdvancedFileChooser();
	}
	public static SizeChooser getSizeChooser()
	{
		return new SimpleSizeChooser();
	}
	public static ColorPanel getColorPanel()
	{
		return new SimpleColorPanel();
	}
	public static UndoManager getUndoManager()
	{
		return new SimpleUndoManager();
	}
	public static IconResizer getIconResizer()
	{
		return new SimpleIconResizer();
	}
	public static IconTypFinder getIconTypFinder() 
	{
		return new SimpleIconTypFinder();
	}
	public static ImageLoader getImageLoader()
	{
		return new SimpleImageLoader();
	}
	public static StatusPanel getStatusPanel()
	{
		return new SimpleStatusPanel();
	}
	public static BufferedImageConverter getBufferedImageConverter()
	{
		return new SimpleBufferedImageConverter();
	}
}
