import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Scanner wow = new Scanner(System.in);
        System.out.println("Insert MD5/SHA256/Byte Hash or Plaintext");
        String ans = wow.next();
        Brute bob = new Brute();
        Dictionary mary = new Dictionary();
        String answer;
        System.out.println("Common Password Attack Result");

        if (ans.length() == 32) {
            answer=bob.MD5(ans);
            if (Brute.cond == 1) {
                System.out.println(answer);
            }
        } else if (ans.length() == 64) {
            answer=bob.SHA256(ans);
            if (Brute.cond == 1) {
                System.out.println(answer);
            }
        } else {
            answer=bob.plain(ans);
            if (Brute.cond == 1){
                System.out.println(answer);
            }
        }
        if(Brute.cond==0){
            System.out.println("No result" + "\n");
        }


        System.out.println("Dictionary Attack Result");
        if (ans.length() == 32) {
            answer=mary.MD5(ans);
            if (Dictionary.cond2 == 1) {
                System.out.println(answer);
            }
        } else if (ans.length() == 64) {
            answer=mary.SHA256(ans);
            if (Dictionary.cond2 == 1) {
                System.out.println(answer);
            }
        } else {
            answer=mary.plain(ans);
            if (Dictionary.cond2 == 1){
                System.out.println(answer);
            }
        }
        if(Dictionary.cond2==0){
            System.out.println("No result" + "\n");
        }
        System.out.println("\n"+"Brute Force Attack Result");
            RBrute hi = new RBrute();
            System.out.println(hi.Brute(ans,14));
        }



}


