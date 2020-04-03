package org.anirban.java.puzzles.simple;

public class StringPermutation {
	
	static private long count = 0;
	static private int trimCount = 0;
	static private long totalLength = 0;
	static private int currentBufferLength = 0;
	static private int currentCapacity = 0;
	static private long cumulativeCapacity = 0;
	static private int MAX_LEN = 16 * 1024 * 1024;
	static private StringBuilder sb = new StringBuilder(MAX_LEN);
	
	// Function for swapping the characters at position i with character at position
	// j
	public static String swapString(String a, int i, int j) {
		char[] b = a.toCharArray();
		char ch;
		ch = b[i];
		b[i] = b[j];
		b[j] = ch;
		return String.valueOf(b);
	}

	public static long fact(int n)
	{
		if (n <= 1)
			return 1L;
		else
			return n * fact(n-1);
	}
	
	public static void main(String[] args) {
		String str = "0123456789ABCD";
		int len = str.length();
		System.out.format("Total permutes are : %-,15d%n", fact(len));
		System.out.println("All the permutations of the string are: \n");
		long start = System.nanoTime();
		generatePermutation(str, 0, len, len);
		long end = System.nanoTime();
		System.out.format("Total time : %,6.3f second(s) %n", (end-start)/1000000000.0 );
		System.out.format("Current Buffer Length : %-,12d chars%n", sb.length() );
		System.out.format("Current Buffer alloc  : %-,8.2f MB and last alloc %-,15d%n", sb.capacity()/(1024*1024.0), currentCapacity );
		System.out.println("\n");
		
		System.out.format("Current Buffer uses   : %,-8.2f MB (UTF-8)%n", (sb.length() * 8)/(1024*1024.0) );
		System.out.format("Current Buffer consume: %,-8.2f MB (UTF-8)%n", (sb.capacity() * 8)/(1024*1024.0) );
		System.out.println("-------------Above 2 values must be the same--------------\n");
		
		System.out.format("Total Allocated memory: %,-8.2f MB %n", ( (cumulativeCapacity + sb.capacity()) / (1024*1024.0) ) );
		System.out.format("Alt Total Memory alloc: %-,8.2f MB %n", ( ((trimCount+1)*currentCapacity) / (1024*1024.0) ) ); 
		System.out.println("-------------Above 2 values must be the same--------------\n");		

		System.out.format("Total Length - Permute: %,-15d chars %n", (totalLength + sb.length() ) );
		System.out.format("Alt Total Buffer Len  : %,-15d chars (UTF-8)%n", (sb.length() + ((trimCount+1) * (long)MAX_LEN)) );		
		System.out.println("-------------Above 2 valuesmust be the same--------------\n");

		System.out.format("Total Untrim  Mem Used: %-,8.2f MB %n", ( ((((long) MAX_LEN * (trimCount+1)) + sb.length()) * 8)/(1024*1024.0) ) ); 
		System.out.format("Permute count: %,-15d%nTrim Count: %,8d%n", count, trimCount);
		//System.out.println(sb.toString());
	}

	// Function for generating different permutations of the string
	public static void generatePermutation(String str, int start, int end, int len)
	{
		// Prints the permutations
		if (start == end - 1)
		{
			count++;
			//if (count%1000 == 0)
				/*System.out.print(sb.toString());*/
			currentBufferLength=sb.length();
			currentCapacity = sb.capacity();
			if ( currentBufferLength <= (MAX_LEN-len-1) )
			{
				sb.append(str + " ");
			}
			else
			{
				trimCount++;
				cumulativeCapacity += currentCapacity;
				totalLength += currentBufferLength;
				//totalLength = (long)currentBufferLength*trimCount;
				//sb.delete(0, currentBufferLength);
				if (trimCount%10000 == 1)
				{
					System.out.format("Trim    : %,-8d%n", trimCount);
					System.out.format("len:%d * count:%-,15d = %,-12d%n", (len+1), count, (len+1)*count);
					System.out.format("TempLen : %,-15d%n", currentBufferLength);
					System.out.format("Capacity: %,-15d%n", currentCapacity);
					System.out.format("Tot Len : %,-15d%n", totalLength);
					//System.out.format("Alt Len : %,-15d%n", ((long)currentBufferLength*trimCount));
					System.out.format("Tot Cap : %,-15d%n", cumulativeCapacity);
					//System.out.format("Alt Cap : %,-15d%n", ((long)currentCapacity*trimCount));					
					System.out.println("-----------------------------------\n");
				}
				sb = new StringBuilder(MAX_LEN);
				sb.append(str + " ");
			}
		}
		else
		{
			for (int i = start; i < end; i++)
			{
				// Swapping the string by fixing a character
				str = swapString(str, start, i);
				// Recursively calling function generatePermutation() for rest of the characters
				generatePermutation(str, start + 1, end, len);
				// Backtracking and swapping the characters again.
				str = swapString(str, start, i);
			}
		}
	}
}