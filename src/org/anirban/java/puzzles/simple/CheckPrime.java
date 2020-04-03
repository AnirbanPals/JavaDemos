package org.anirban.java.puzzles.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CheckPrime {
	
	private static File primesFile;
	private static FileWriter fw;
	private static BufferedWriter bw;
	private static BufferedReader br;
	private static long[] primesList;
	private static long len;
	
	static
	{
		primesFile = new File("primesFile.txt");
		if ( primesFile.exists() && ((len=((primesFile.length()*8)/Long.SIZE)) > 0) && len <= Integer.MAX_VALUE)
		{
			loadPrimes();
		}
		else
		{
			System.out.println("You need an upgrade or need to have a primesFile.txt! Talk to program Author");
			System.exit(0);
		}
		try {
			fw = new FileWriter(primesFile, true);
			bw = new BufferedWriter(fw);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public static void loadPrimes() 
	{
		primesList = new long[(int)len];
		String tempVal = "";
		int count=0;
		try {
			br = new BufferedReader(new FileReader(primesFile));
			long l = Long.parseUnsignedLong((((tempVal = br.readLine())!=null)?tempVal:"-1"), 10);
			while ( l > -1)
			{
				primesList[count++] = l;
				tempVal = br.readLine();
				if (tempVal == null)
					l = -1L;
				else
					l = Long.parseUnsignedLong(tempVal, 10);
			}
		}
		catch (NullPointerException npe)
		{
			System.err.println("EOF encountered");
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.err.println("Code should not reach here. Check primesFile.txt exists");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			System.err.println("Unexpected EOF or IO Exception");
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally
			{
				br = null;
			}
		}
		
	}
	
	public static void genPrime(long upperLimit) throws IOException
	{
		long i,j;
		int index=0;
		i = primesList[(int)len-1];
		while (i < upperLimit && index < len)
		{
			j = primesList[index];
			while (j <= i/j)
			{
				if (i%j == 0)
				{
					break;
				}
				j = primesList[++index];
			}
			if (j > i/j)
			{
				try {
					bw.write(Long.toString(i));
					bw.newLine();
				}
				catch (IOException e) {
					System.err.println("IO Error in prime generator");
					e.printStackTrace();
					throw e;
				}
			}
			index = 0;
			i++;
		}
	}
	
	public static void main(String a[])
	{
		try
		{
			genPrime(1000000000);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bw.close();
				fw.close();
				System.out.println("Wrote " + primesFile.length()/(1024*1024.0) + " Megabytes\n");
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
			finally
			{
				bw = null;
				fw = null;
			}		
		}
	}
}