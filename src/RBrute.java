import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.lang.String;

import static java.lang.System.exit;


public class RBrute {
    static char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '@', '!'};
    static String hash;
    static String compare;


    public RBrute() {

    }

    public String Brute(String x, int y) throws NoSuchAlgorithmException {
        hash = x.toUpperCase(Locale.ROOT);
        compare = x;
        //create(y);
        return possibleStrings("", y);
    }


    public String possibleStrings(String curr, int maxLength) throws NoSuchAlgorithmException {
        // If the current string has reached its maximum length
        if (curr.length() == maxLength) {
            //System.out.println(curr);

            // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                //System.out.println(curr);
                String md=MD5a(curr);
                String sh=SHA256a(curr);
                if (curr.equals(compare)) {
                    System.out.println("MD5 Hash: "+md);
                    System.out.println("SHA-256 Hash: "+sh);
                    exit(1);
                }
                if (md.equals(compare)) {
                    System.out.println("Plain Text: "+curr);
                    System.out.println("SHA-256 Hash: "+sh);
                    exit(1);
                }
                if (sh.equals(compare)) {
                    System.out.println("Plain Text: "+curr);
                    System.out.println("MD5 Hash: "+md);
                    exit(1);
                }

                possibleStrings(curr, maxLength);
                curr = oldCurr;

            }

        }
        return "bruh";
    }

    public static String MD5a(String P) throws NoSuchAlgorithmException {
        String lower;
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] data = P.getBytes();
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        lower=String.format("%1$032X", i);
        return lower.toLowerCase(Locale.ROOT);
    }

    public static String SHA256a(String L) throws NoSuchAlgorithmException {
        String lower;
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        byte[] data = L.getBytes();
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        lower= String.format("%1$064X", i);
        return lower.toLowerCase(Locale.ROOT);
    }
}






