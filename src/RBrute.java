import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.*;
import java.lang.String;
import java.util.stream.Stream;


public class RBrute {
    static String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','1','2', '3', '4', '5', '6', '7', '8', '9','0','@','!'};
    static String hash;
    static String plain = "No Password Found";
    static String compare;

    public RBrute() {

    }
   public static void write(String Z) {
        try (FileWriter total = new FileWriter("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\huge", true);
             BufferedWriter write = new BufferedWriter(total);
             PrintWriter out = new PrintWriter(write)) {
            out.println(Z);

        } catch (IOException ignored) {
        }
    }

    public String Brute(String x, int y) throws NoSuchAlgorithmException, IOException {
        hash = x.toUpperCase(Locale.ROOT);
        compare = x;
        //create(y);
        possibleStrings("",y);
        //int what;
        //if (x.length() == 32) {
        //   return "Plaintext: " + plain + "\n" + "SHA-256 Hash: " + SHA256a(plain).toLowerCase(Locale.ROOT);
        // }else if(x.length() == 64){
        //return "Plaintext: " + plain + "\n" + "MD5 Hash: " + MD5a(plain).toLowerCase(Locale.ROOT);
        // }else{
        //  return "MD5 Hash: " + MD5a(plain).toLowerCase(Locale.ROOT) + "\n" + "SHA-256 Hash: " + SHA256a(plain).toLowerCase(Locale.ROOT);
        // }
        return "done";
        //return "WRONG";
    }



        public void possibleStrings(String curr, int maxLength) throws FileNotFoundException {
            // If the current string has reached it's maximum length
            if (curr.length() == maxLength) {
                //System.out.println(curr);

                // Else add each letter from the alphabet to new strings and process these new strings again
            } else {
                for (int i = 0; i < alphabet.length; i++) {
                    String oldCurr = curr;
                    curr += alphabet[i];

                    if(curr.equals(compare)){
                        System.out.println(curr);
                        //return curr;
                    }
                    possibleStrings(curr,maxLength);
                    curr = oldCurr;
                }
            }

        }
    }

    /*
    static void create(int X) throws NoSuchAlgorithmException, IOException {

        String magico="";
        int count = 0;
        int linecount=26;

        // Traverse all possible lengths
        for (int z = 0; z < X - 1; z++) {


            // Stores all combinations
            // of length z
            // Traverse the array
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < 30; k++) {
                    count++;
                    Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\huge"));
                    magico = lines.skip(count).findFirst().get();
                    if (!arr[i].equals(magico)) {
                        write(magico + arr[i]);
                        linecount++;
                    }
                }
            }
            // Replace all combinations of length z - 1
            // with all combinations of length z

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
    }*/






