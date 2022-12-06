import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        System.out.println("Insert MD5/SHA256/BCrypt Hash or Plaintext");
        //User input is ans
        String ans = input.next();
        //Creating Objects
        Brute common = new Brute();
        Dictionary dic = new Dictionary();
        RBrute brutes = new RBrute();
        //Final answer variable
        String answer;
        //Checks if user input is a hash, if not then encryption ensues
        if(ans.length()!=32 && ans.length()!=64 && ans.length()!=60){
            System.out.println("Encryption Result");
            System.out.println("MD5 Hash: " + RBrute.MD5a(ans));
            System.out.println("SHA-256 Hash: " + RBrute.SHA256a(ans));
            System.out.println("BCrypt Hash (12 Rounds): " + BCrypt.hashpw(ans,BCrypt.gensalt(12)));
            exit(1);
        }
        System.out.println("Common Password Attack Result");


        //Checks length of user input to know which method to run
        if (ans.length() == 32) {
            answer = common.MD5(ans);
            //Checks condition to see if an answer was found, if not... next
            if (Brute.cond == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if (ans.length() == 64) {
            answer = common.SHA256(ans);
            if (Brute.cond == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if(ans.length() == 60){
            answer = common.BC(ans);
            if (Brute.cond == 1){
                System.out.println(answer);
                exit(1);
            }
        }
        //This is when no answer is found so cond stays 0
        if(Brute.cond == 0){
            System.out.println("No result" + "\n");
        }


        System.out.println("Dictionary Attack Result");
        //Checks length of user input to know which method to run
        if (ans.length() == 32) {
            answer = dic.MD5(ans);
            if (Dictionary.cond2 == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if (ans.length() == 64) {
            answer = dic.SHA256(ans);
            if (Dictionary.cond2 == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if(ans.length() == 60){
            answer = dic.BC(ans);
            if (Brute.cond == 1){
                System.out.println(answer);
                exit(1);
            }
        }
        if(Dictionary.cond2 == 0){
            System.out.println("No result" + "\n");
        }
        System.out.println("\n" + "Brute Force Attack Result");
            //Commented code below is for final project, it is not there for demonstration purposes
            //Because I limited pass length to 4 since its quick
            /*
            System.out.println("Insert Max Password Size (Note: Bigger number = longer runtime)");
            int max = wow.nextInt();
            System.out.println("Running... This might take a while, go do something else");
            System.out.println(hi.Brute(ans,max));
             */
            System.out.println("Running... This might take a while, go do something else");
            System.out.println(brutes.Brute(ans,4));
        }


    }






