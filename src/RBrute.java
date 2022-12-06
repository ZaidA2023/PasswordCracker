

import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.lang.String;

import static java.lang.System.exit;


public class RBrute {
    //List of available chracters in password
    static char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '@', '!'};
    //Initializing
    static String hash;
    static String compare;


    public RBrute() {

    }

    public String Brute(String x, int y) throws NoSuchAlgorithmException {
        hash = x.toUpperCase(Locale.ROOT);
        compare = x;
        return possibleStrings("", y);
    }


    public String possibleStrings(String curr, int maxLength) throws NoSuchAlgorithmException {
        // If the current string has reached its maximum length
        if (curr.length() == maxLength) {
            // Else add each letter from char array to new strings and process these new strings again
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                //Calls compare method for every combination
                if (compares(curr)) {
                    System.out.println("\n"+"Plain Text: "+curr);
                    exit(1);
                }
                //Recursive method to keep adding characters
                possibleStrings(curr, maxLength);
                curr = oldCurr;

            }

        }
        return "Unable to crack or invalid characters";
    }

    //Function to create an MD5 hash from a string
    public static String MD5a(String P) throws NoSuchAlgorithmException {
        String lower;
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] data = P.getBytes();
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        lower=String.format("%1$032X", i);
        return lower.toLowerCase(Locale.ROOT);
    }

    //Function to create a SHA-256 hash from a string
    public static String SHA256a(String L) throws NoSuchAlgorithmException {
        String lower;
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        byte[] data = L.getBytes();
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        lower= String.format("%1$064X", i);
        return lower.toLowerCase(Locale.ROOT);
    }

    //Comparing function, pretty self-explanatory
    public static boolean compares(String x) throws NoSuchAlgorithmException {
        if(compare.length()==64 && SHA256a(x).equals(compare)){
            return true;
        }else if(compare.length()==32 && MD5a(x).equals(compare)){
            return true;
        }else if(compare.length() == 60){
            return BCrypt.checkpw(x, compare);
        }
        return false;
    }
}






