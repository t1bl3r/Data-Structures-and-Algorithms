// Hasher.java - code for hashing class
// Author: ?????
// Date:   ?????
// Class:  CS165
// Email:  ?????

@FunctionalInterface
interface HashFunction {
    int hash(String key);
}


public class Hasher {

    // Hashing algorithms, see specification

    /**
     * Hashing algorithms, see provided documentation in assignment
     * @param hashFunction FIRST, SUM, PRIME, OR JAVA
     * @return the corresponding HashFunction
     */
    public static HashFunction make(String hashFunction) {
        switch (hashFunction) {
        case "FIRST":
            // YOUR CODE HERE
            return new hash();

        case "SUM":
            // YOUR CODE HERE
            return new HashFunction
            	{@Override
            	
            			
            	}

        case "PRIME":
            // YOUR CODE HERE
            return null;

        case "JAVA":
            // YOUR CODE HERE
            return null;

        default:
            usage();
        }
        return null;
        
        public int hash(String key)
        {
        	return 0;
        }
    }
   


    // Usage message
    private static void usage() {
        System.err.println("Usage: java Hasher <FIRST|SUM|PRIME|JAVA> <word>");
        System.exit(1);
    }



    // Test code for hasher
    public static void main(String[] args) {
        args = Debug.init(args);
        if (args.length != 2)
            usage();

        HashFunction sh = make(args[0]);
        int hashCode = sh != null ? sh.hash(args[1]) : 0;
        System.out.printf("'%s' hashes to %d using %s\n", args[1], hashCode, args[0]);
    }
}
