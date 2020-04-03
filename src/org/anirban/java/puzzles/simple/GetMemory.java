package org.anirban.java.puzzles.simple;

import java.io.*;
import java.util.Arrays;

public class GetMemory {
    public static void main(String args[])
    {
        int numTests=0;
        int numProcesses=0;
        int reqMemory=0;
        int availableMemory=0;
        int memoryConsumed[];
        int killCount=0;
        int lastIndex=0;
        int testsRun=0;
        BufferedReader buffReader = null; 
        String nextBuffer = null;
        String fileName = "./inputProcesses.txt";
        
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
                
                while (testsRun < numTests)
                {
                	nextBuffer = null;
                	while ((nextBuffer == null || nextBuffer.trim().equals("")) && 
                			buffReader.ready())
                		nextBuffer = buffReader.readLine();
                	
                	if (nextBuffer != null) {
						numProcesses = Integer.parseInt(nextBuffer);
					} else {
						throw new NullPointerException("Unexpected end of input file. Invalid INPUTS!");
					}
                	
	                System.out.println("Number of processes " + numProcesses);
	
                	nextBuffer = null;
	                while (nextBuffer == null || nextBuffer.trim().equals("") && 
	                		buffReader.ready())
                		nextBuffer = buffReader.readLine().trim();

                	if (nextBuffer != null) {
                		reqMemory = Integer.parseInt(nextBuffer);
					} else {
						throw new NullPointerException("Unexpected end of input file. Invalid INPUTS!");
					}
                	
	                System.out.println("Required Memory " + reqMemory);                
	                
	                memoryConsumed = new int[numProcesses];
	                //System.out.println(Arrays.toString(memoryConsumed));
	                int i=0;
	                int temp, num;
	                while (i < numProcesses && buffReader.ready())
	                {
	                    temp = num = 0;
	                	while ( (temp = (buffReader.read() - (int)'0')) >= 0) 
	                    {
	                		//if (temp != -16)
	                		//{
	                			num = num*10 + temp;
	                		//} else {	                			
	                		//	continue;
	                		//}
	                    }
	                    memoryConsumed[i++] = num;
	                    //System.out.println(memoryConsumed[(i-1)] + " : ");
	                }
	                System.out.println(Arrays.toString(memoryConsumed));
	                Arrays.sort(memoryConsumed);
	                availableMemory = 0;
	                killCount = 0;
	                lastIndex = numProcesses - 1;
	                
	                while (availableMemory < reqMemory && lastIndex >= 0)
	                {
	                    killCount++;
	                    availableMemory += memoryConsumed[lastIndex--]; 
	                }
	                
	                if (availableMemory >= reqMemory)
	                {
	                    System.out.println("Kill " + killCount + " processes\n");
	                }
	                else
	                {
	                    System.out.println("Insufficient Memory. Cannot cater to request\n-1\n");
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