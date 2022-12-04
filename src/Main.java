import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static Scanner wow = new Scanner(System.in);
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        System.out.println("Insert MD5/SHA256/Byte Hash or Plaintext");
        String ans = wow.next();
        Brute bob = new Brute();
        Dictionary mary = new Dictionary();
        RBrute hi = new RBrute();
        String answer;
        if(ans.length()!=32&&ans.length()!=64){
            System.out.println("Encryption Result");
            System.out.println("MD5 Hash: " + hi.MD5a(ans));
            System.out.println("SHA-256 Hash: " + hi.SHA256a(ans));
            exit(1);
        }
        System.out.println("Common Password Attack Result");



        if (ans.length() == 32) {
            answer=bob.MD5(ans);
            if (Brute.cond == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if (ans.length() == 64) {
            answer=bob.SHA256(ans);
            if (Brute.cond == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else {
            answer=bob.plain(ans);
            if (Brute.cond == 1){
                System.out.println(answer);
                exit(1);
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
                exit(1);
            }
        } else if (ans.length() == 64) {
            answer=mary.SHA256(ans);
            if (Dictionary.cond2 == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else {
            answer=mary.plain(ans);
            if (Dictionary.cond2 == 1){
                System.out.println(answer);
                exit(1);
            }
        }
        if(Dictionary.cond2==0){
            System.out.println("No result" + "\n");
        }
        System.out.println("\n"+"Brute Force Attack Result");
            //System.out.println("Insert Max Password Size (Note: Bigger number = longer runtime)");
            //int max = wow.nextInt();
            System.out.println("Running... This might take a while, go do something else");
            System.out.println(hi.Brute(ans,4));
        }


    }






