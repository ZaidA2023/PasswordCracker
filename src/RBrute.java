import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.*;
import java.lang.String;




public class RBrute {
    static String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static String hash;
    static String plain="No Password Found";

    public RBrute() {

    }

   /* public static void writer(String Z) {
        try (FileWriter total = new FileWriter("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\huge", true);
             BufferedWriter write = new BufferedWriter(total);
             PrintWriter out = new PrintWriter(write)) {
            out.println(Z);
            //more code
            //more code
        } catch (IOException ignored) {

        }
    }

    */
    public String Brute(String x, int y) throws NoSuchAlgorithmException {
        hash=x.toUpperCase(Locale.ROOT);
        create(y);
        return plain;
    }
    static void create(int X) throws NoSuchAlgorithmException {
        String[] characters = arr;

        int count = characters.length;

        // Traverse all possible lengths
        for (int z = 0; z < X - 1; z++) {

            // Stores all combinations
            // of length z
            Vector<String> tmp = new Vector<String>();

            // Traverse the array
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < characters.length; k++) {
                    if (arr[i] != characters[k]) {

                        // Generate all
                        // combinations of length z
                        tmp.add(characters[k] + arr[i]);
                        count += 1;
                    }
                }
            }

            // Print all combinations of length z
            for (int i = 0; i < tmp.size(); i++) {
                //writer(tmp.get(i));
                if(MD5a(tmp.get(i)).equals(hash)){
                    plain=tmp.get(i);
                }else if(SHA256a(tmp.get(i)).equals(hash)) {
                    plain=tmp.get(i);
                }
            }

            // Replace all combinations of length z - 1
            // with all combinations of length z
            characters = tmp.toArray(new String[tmp.size()]);
            if(!plain.equals("No Password Found")){
                break;
            }
        }


    }
    public static String MD5a(String P) throws NoSuchAlgorithmException {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] data = P.getBytes();
            m.update(data,0,data.length);
            BigInteger i = new BigInteger(1,m.digest());
            return String.format("%1$032X", i);
    }
    public static String SHA256a(String L) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        byte[] data = L.getBytes();
        m.update(data,0,data.length);
        BigInteger i = new BigInteger(1,m.digest());
        return String.format("%1$064X", i);
    }
}





