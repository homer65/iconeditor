package math;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.*;
public class FFT2D 
{
	private static FastFourierTransformer FFT = new FastFourierTransformer(DftNormalization.STANDARD);
	public static void fft(Complex[][] f)
	{
		int n = f.length;
		int m = f[0].length;
		for (int i=0;i<n;i++)
		{
			Complex[] buffer = new Complex[m];
			for (int u=0;u<m;u++)
			{
				buffer[u] = f[i][u];
			}
			Complex[] temp = FFT.transform(buffer,TransformType.FORWARD);
			for (int u=0;u<m;u++)
			{
				f[i][u] = temp[u];
			}
		}
		for (int u=0;u<m;u++)
		{
			Complex[] buffer  = new Complex[n];
			for (int i=0;i<n;i++)
			{
				buffer[i] = f[i][u];
			}
			Complex[] temp = FFT.transform(buffer, TransformType.FORWARD);
			for (int i=0;i<n;i++)
			{
				f[i][u] = temp[i];
			}
		}
	}
	public static void ifft(Complex[][] f)
	{
		int n = f.length;
		int m = f[0].length;
		for (int i=0;i<n;i++)
		{
			Complex[] buffer = new Complex[m];
			for (int u=0;u<m;u++)
			{
				buffer[u] = f[i][u];
			}
			Complex[] temp = FFT.transform(buffer,TransformType.INVERSE);
			for (int u=0;u<m;u++)
			{
				f[i][u] = temp[u];
			}
		}
		for (int u=0;u<m;u++)
		{
			Complex[] buffer  = new Complex[n];
			for (int i=0;i<n;i++)
			{
				buffer[i] = f[i][u];
			}
			Complex[] temp = FFT.transform(buffer,TransformType.INVERSE);
			for (int i=0;i<n;i++)
			{
				f[i][u] = temp[i];
			}
		}
	}
}
