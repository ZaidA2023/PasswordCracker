import at.favre.lib.crypto.bcrypt.BCrypt;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[]args) throws IOException, NoSuchAlgorithmException {
        //System.out.println("Insert MD5/SHA256/BCrypt Hash or Plaintext");
        //User input is ans
        String type = args[0];
        String type2= args[1];
        String ans = args[2];
        int max=4;
        //Creating Objects
        Brute common = new Brute();
        Dictionary dic = new Dictionary();
        RBrute brutes = new RBrute();
        //Final answer variable
        String answer;
        //Checks if user input is a hash, if not then encryption ensues
        if(type.equals("-e")){
            if(type2.equals("-m")){
                System.out.println("Encryption Result");
                System.out.println("MD5 Hash: " + RBrute.MD5a(ans));
            }
            if(type2.equals("-s")){
                System.out.println("Encryption Result");
                System.out.println("SHA-256 Hash: " + RBrute.SHA256a(ans));
            }
            if(type2.equals("-b")){
                System.out.println("Choose number of encryption rounds (Minimum 4)");
                max=input.nextInt();
                System.out.println("Encryption Result");
                System.out.println("BCrypt Hash ("+ max+" Rounds): " + BCrypt.withDefaults().hashToString(max,ans.toCharArray()));
            }
            exit(1);
        }
        System.out.println("Common Password Attack Result");

        if(type.equals("-d"))
        //Checks length of user input to know which method to run
        if (type2.equals("-m")) {
            answer = common.MD5(ans);
            //Checks condition to see if an answer was found, if not... next
            if (Brute.cond == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if (type2.equals("-s")) {
            answer = common.SHA256(ans);
            if (Brute.cond == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if(type2.equals("-b")){
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
        if (type2.equals("-m")) {
            answer = dic.MD5(ans);
            if (Dictionary.cond2 == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if (type2.equals("-s")) {
            answer = dic.SHA256(ans);
            if (Dictionary.cond2 == 1) {
                System.out.println(answer);
                exit(1);
            }
        } else if(type2.equals("-b")){
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

            System.out.println("Insert Max Password Size (Note: Bigger number = longer runtime)");
            max = input.nextInt();
            System.out.println("Running... This might take a while, go do something else");
            System.out.println(brutes.Brute(ans,max));
        }


    }






