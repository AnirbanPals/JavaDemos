package org.anirban.java.puzzles.simple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BuildBridges {
	
	private static int MAX_TESTS_PERMITTED = 50;
	
	public static interface BridgeStandards {
		int MAX_BRIDGE_LENGTH = 10000;
		int MAX_BRIDGES = 10000;
	}

    public static void main(String args[])
    {
        int numTests=0;
        int numBridges=0;
        int bridgeLengths[];
        int currentSegmentLength=0;
        int nextSegmentLength=0;
        int nextBridgeLength=0;
        int totalCost=0;
        int totalLength=0;
        int lastIndex=0;
        int testsRun=0;
        BufferedReader buffReader = null; 
        String nextBuffer = null;
        String fileName = "./inputBridges.txt";
        
        try
        {
            if ( args!= null && args.length>0 )
            {
            	fileName = args[0];
            }
        	buffReader = new BufferedReader(new FileReader(new File(fileName)));
            if (buffReader != null && buffReader.ready())
            {
                numTests = Integer.parseInt(buffReader.readLine().trim());
                System.out.println("Number of tests " + numTests + "\n");
                if (numTests > MAX_TESTS_PERMITTED)
                {
                	System.err.println("Sorry cannot run a bulk test!");
                	throw new IllegalArgumentException("Exiting...too many tests!");
                }
                
                while (testsRun < numTests)
                {
                	nextBuffer = null;
                	while ((nextBuffer == null || nextBuffer.trim().equals("")) && 
                			buffReader.ready())
                		nextBuffer = buffReader.readLine();
                	
                	if (nextBuffer != null) {
						numBridges = Integer.parseInt(nextBuffer);
					} else {
						throw new NullPointerException("Unexpected end of input file. Invalid INPUTS!");
					}
                	System.out.println("Number of bridges " + numBridges);
                    if (numBridges > BridgeStandards.MAX_BRIDGES)
                    {
                    	System.err.println("Sorry cannot run a bulk test!");
                    	throw new IllegalArgumentException("Exiting...too many bridges!");
                    }
                	
	                
                	bridgeLengths = new int[numBridges];
	                //System.out.println(Arrays.toString(bridgeLengths));
	                int i=0;
	                int temp, num;
	                while (i < numBridges && buffReader.ready())
	                {
	                    temp = num = 0;
	                	while ( (temp = (buffReader.read() - (int)'0')) >= 0) 
	                    {
	                		num = num*10 + temp;
	                    }
	                	bridgeLengths[i++] = num;
	                    //System.out.println(bridgeLengths[(i-1)] + " : ");
	                    if (num > BridgeStandards.MAX_BRIDGE_LENGTH)
	                    {
	                    	System.err.println("Sorry cannot build such a long bridge!");
	                    	throw new IllegalArgumentException("Exiting...too large bridge found!");
	                    }	                	
	                }
	                System.out.println(Arrays.toString(bridgeLengths));     
	                Arrays.sort(bridgeLengths);
	                System.out.println(Arrays.toString(bridgeLengths));

	                totalLength = 0;
	                currentSegmentLength = 0;
	                nextSegmentLength = 0;
	                nextBridgeLength = 0;
	                totalCost = 0;
	                lastIndex = numBridges - 1;
	                
	                i=0;
	                currentSegmentLength = bridgeLengths[i];
	                
	                while (totalLength < BridgeStandards.MAX_BRIDGE_LENGTH && 
	                		i < lastIndex )
	                {
	                	nextSegmentLength = bridgeLengths[++i];
	                    nextBridgeLength = currentSegmentLength + nextSegmentLength;
	                    currentSegmentLength = nextBridgeLength;
	                    totalLength = nextBridgeLength;
	                    totalCost += currentSegmentLength;
	                    System.out.print(totalCost + ", ");
	                }
	                
	                /**
	                 * 
	                 * 3 7 8 8 5 6 9 12 5 12
	                 * 3 5 5 6 7 8 8 9 12 12
	                 * 3 8 13 19 26 34 42 51 63 75
	                 * 
	                 * 3 5 5 6 7 8 8 9 12 12
	                 * 8   11  15  17  12 12
	                 *   8 11 12 12 15 17
	                 *    19  24 15 17
	                 *       15 17 19 24
	                 *          32  43
	                 *            75
	                 * 
	                 */
	                	                
	                if (totalLength <= BridgeStandards.MAX_BRIDGE_LENGTH)
	                {
	                    System.out.println(" Longest Bridge " + totalLength + " \n");
	                    System.out.println(" Total cost " + totalCost + " \n");
	                }
	                else
	                {
	                    System.out.println("Construction exceeds MAX Length. Cannot cater to request\n-1\n");
	                }
	                testsRun++;
                }
            }
            else
                throw new IllegalArgumentException("Inputs invalid");
        }
        catch (FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (RuntimeException rte)
        {
            System.err.println("One of the many illegal inputs was detected. See below for details.");
        	rte.printStackTrace();
        }        
        finally 
        {
            try
            {
                if (buffReader != null)
                   buffReader.close();
            }
            catch (Exception e)
            {
            	System.out.println("Unexpected error");
            	e.printStackTrace();
            }
        }        
    }
}