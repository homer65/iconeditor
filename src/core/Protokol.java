package core;
import java.util.*;
import java.text.*;
public class Protokol 
{
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
	private static ArrayList<String> msg = new ArrayList<String>();
	public static void write(String s)
	{
		String prefix = sdf.format(new Date());
		System.out.println(prefix + s);
		msg.add(prefix + s);
	}
	public static ArrayList<String> getMessages()
	{
		return msg;
	}
}
