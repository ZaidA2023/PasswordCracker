import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner wow = new Scanner(System.in);
        System.out.println("Insert MD5/SHA256/Byte Hash or Plaintext");
        String ans = wow.next();
        Brute bob = new Brute();
        System.out.println(ans.length());
        if (ans.length() == 32) {
            System.out.println(bob.MD5(ans));
        } else if (ans.length() == 64) {
            System.out.println(bob.SHA256(ans));
        } else {
            System.out.println(bob.plain(ans));
        }
    }
}
