package org.anirban.java.puzzles.simple;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IntPermutationsTest {

	private static File outFile;
	private static FileOutputStream fos;
	private static IntPermutations ip;
	private static long counter=0;
	private static int howManyPermutes;
	
	@BeforeAll
	static void setUp()
	{
		howManyPermutes = 10;
		// Note if howmanyPermutes is >= 11 this will generate enormous files in output >120GB and will exhaust disk space
		ip = new IntPermutations(howManyPermutes);
		outFile = new File("outFile.txt");
		try {
			
			fos = new FileOutputStream(outFile);
		} catch (FileNotFoundException fnfe) {
			// TODO Auto-generated catch block
			fnfe.printStackTrace();
		}		
	}
	
	@Test
	void test() {	
		while(ip.hasNext())
		{
			try {
				fos.write( Arrays.toString(ip.next()).getBytes() );
				fos.write("\n".getBytes());
				counter++;
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
		assertEquals(StringPermutation.fact(howManyPermutes), counter, "Unexpected results");
	}
	
	@AfterAll
	static void tearDownAll()
	{
		try
		{
			fos.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			fos = null;
		}		
	}
}
