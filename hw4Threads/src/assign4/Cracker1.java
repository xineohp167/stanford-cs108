package assign4;

//Cracker.java
/*
Generates SHA hashes of short strings in parallel.
*/

import java.security.*;
import java.util.Collection;
import java.util.LinkedList;

public class Cracker1 {
     // Array of chars used to produce strings
     public static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789.,-!".toCharArray();
     
     
     /**
      Given a byte[] array, produces a hex String,
      such as "234a6f". with 2 chars for each byte in the array.
      (provided code)
     */
     public static String hexToString(byte[] bytes) {
             StringBuffer buff = new StringBuffer();
             for (int i=0; i<bytes.length; i++) {
                     int val = bytes[i];
                     val = val & 0xff;  // remove higher bits, sign
                     if (val<16) buff.append('0'); // leading 0
                     buff.append(Integer.toString(val, 16));
             }
             return buff.toString();
     }
     
     /**
      Given a string of hex byte values such as "24a26f", creates
      a byte[] array of those values, one byte value -128..127
      for each 2 chars.
      (provided code)
     */
     public static byte[] hexToArray(String hex) {
             byte[] result = new byte[hex.length()/2];
             for (int i=0; i<hex.length(); i+=2) {
                     result[i/2] = (byte) Integer.parseInt(hex.substring(i, i+2), 16);
             }
             return result;
     }
     
     /**
      * Thread class responsible for cracking things and printing possibilities.
      */
     public class CrackerWorker extends Thread
     {
             int maxLength;
             String[] prefixes;
             MessageDigest digester;
             
             /**
              * Creates a CrackerWorker that will work with the provided array of prefixes.
              * This is a slightly more flexible than passing in a range of characters,
              * though of course not the most mathematical.  Elegence is of course
              * not the prime factor here, since we are performing a brute force search.
              * @param prefixes
              * @param maxlength max length of input strings to try
              */
             CrackerWorker(String[] prefixes, int maxlength)
             {
                     super();
                     this.prefixes = prefixes;
                     this.maxLength = maxlength;
                     try {
                             digester = MessageDigest.getInstance("SHA");
                     } catch (NoSuchAlgorithmException e) {
                             e.printStackTrace();
                     }
             }
             
             /**
              * @param string
              * @return a SHA1 digest for the given string
              */
             public byte[] computeDigestForString(String string)
             {
                     digester.reset();
                     digester.update(string.getBytes());
                     return digester.digest();
             }
             
             /**
              * Performs a depth-first recursive search for over inputs up to length
              * prefix.length + depth for a SHA1 digest that matches soughtDigest.
              * @param prefix prefix for inputs to test
              * @param depth maximum number of characters to append onto prefix
              * @param soughtDigest sought SHA1 digest
              * @param printMode true if we should print out results as we go
              */
             public void runUntilDepth0(String prefix, int depth, byte[] soughtDigest, boolean printMode)
             {
                     byte[] digest = computeDigestForString(prefix);
                     if (soughtDigest != null && MessageDigest.isEqual(digest, soughtDigest))
                     {
                             System.out.println("match:" + prefix + " " + hexToString(digest));
                             recordMatchingInput(prefix);
                     }
                     
                     if (printMode)
                             System.out.println(prefix + " " + hexToString(digest));
                     
                     if (depth == 0)
                             return;
                     
                     for (int i=0; i < CHARS.length; i++)
                             runUntilDepth0(prefix + CHARS[i], depth - 1, soughtDigest, printMode);
             }
             
             public void run()
             {
                     for (int i=0; i < prefixes.length; i++)
                     {
                             int startDepth = maxLength - prefixes[i].length();
                             runUntilDepth0(prefixes[i], startDepth, soughtDigest, printMode);
                     }
             }
     }
     

     protected int inputLength;
     protected boolean printMode;
     protected byte[] soughtDigest;
     protected Collection<CrackerWorker> workers;
     protected Collection<String> validInputStrings;
     
     
     public Cracker1()
     {
             validInputStrings = new LinkedList<String>();
     }
     
     protected void recordMatchingInput(String s) {
             validInputStrings.add(s);
     }
     
     protected Collection<String> getFoundInputs()
     {
             return validInputStrings;
     }
     
     public void setConfiguration(boolean printMode, byte[] soughtDigest, int inputLength)
     {
             this.soughtDigest = soughtDigest;
             this.printMode = printMode;
             this.inputLength = inputLength;
     }
     
     protected String[][] partitionPrefixes(int numPartitions)
     {
             String[][] partitions = new String[numPartitions][];
             int[] indexes = createPartitionIndexes(numPartitions, CHARS.length);
             for (int i=0; i < numPartitions; i++)
             {
                     int span = indexes[i + 1] - indexes[i];
                     String[] prefixes = new String[span];
                     for (int j = 0; j < prefixes.length; j++)
                             prefixes[j] = Character.toString(CHARS[indexes[i] + j]);
                     partitions[i] = prefixes;
             }
             return partitions;
     }

     /**
      * Returns a set of indexes into an array of length 'length' that will
      * evenly partition the array into numPartitions partitions.
      * @param numPartitions
      * @param length
      * @return
      */
     protected static int[] createPartitionIndexes(int numPartitions, int length)
     {
             int[] indexes = new int[numPartitions + 1];
             int lowerBoundPartitionSize = length / numPartitions;
             int remainder = length % numPartitions; // try to get this down to 0
             int currentIndexPosition = 0;
             indexes[0] = 0;
             for (int i=1; i < indexes.length; i++)
             {
                     currentIndexPosition += lowerBoundPartitionSize;
                     if (remainder != 0)
                     {
                             ++currentIndexPosition;
                             --remainder;
                     }
                     indexes[i]  = currentIndexPosition;
             }
             return indexes;
     }
     
     public void runThreads(int numThreads) throws InterruptedException
     {
             workers = new LinkedList<CrackerWorker>();
             String[][] prefixes = partitionPrefixes(numThreads);
             for (int i=0; i < numThreads; i++)
             {
                     CrackerWorker worker = new CrackerWorker(prefixes[i], inputLength);
                     workers.add(worker);
                     worker.start();
             }
             
             for (CrackerWorker worker : workers)
             {
                     worker.join();
             }
             workers = null;
     }
     
     public static void main(String[] args) throws InterruptedException {
             if (args.length < 2) {
                     System.out.println("Args: target length [workers]");
                     System.exit(1);
             }
             // args: targ len [num]
             String targ = args[0];
             int len = Integer.parseInt(args[1]);
             int numWorkers = 1;
             if (args.length>2) {
                     numWorkers = Integer.parseInt(args[2]);
             }
             boolean printMode = targ.equalsIgnoreCase("print");
             byte[] soughtDigest = printMode ? null : hexToArray(targ);
             Cracker1 cracker = new Cracker1();
             cracker.setConfiguration(printMode, soughtDigest, len);
             cracker.runThreads(numWorkers);
             // a! 34800e15707fae815d7c90d49de44aca97e2d759
             // xyz 66b27417d37e024c46526c2f6d358a754fc552f3
             
             // YOUR CODE HERE
     }
     
}