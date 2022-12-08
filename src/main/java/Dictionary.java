import at.favre.lib.crypto.bcrypt.BCrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.stream.Stream;

public class Dictionary {
    //Create variable cond that tells Main if an answer was found
    public static int cond2;
    public Dictionary(){
        //Refresh variable
        cond2 = 0;
    }

    public String BC(String y) throws IOException {
        //Opens file (basically)
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\PasswordCracker\\src\\main\\java\\words_alpha.txt"));
        String line;
        //Reads through all lines of file
        while ((line = br.readLine()) != null) {
            //Compares plaintext with BCrypt hash
            BCrypt.Result result = BCrypt.verifyer().verify(line.toCharArray(), y);
            if(result.verified){
                cond2++;
                break;
            }
        }
        return "Plaintext: " + line;
    }
    public String MD5(String y) throws IOException {
        //Makes user input hash lowercase because my rainbow table uses lowercase
        String x = y.toLowerCase(Locale.ROOT);
        //Return variable
        String plainswer;
        //Counts number of lines that are travelled
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\PasswordCracker\\src\\main\\java\\md5dic.txt"));
        String line;
        //Reads through all of file
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                cond2++;
                break;
            }
        }
        //Jumps to the same number line from the MD5 file to the plaintext file
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\PasswordCracker\\src\\main\\java\\words_alpha.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer;
    }

    //The same as MD5, just changed it to look through the SHA-256 file
    public String SHA256(String y) throws IOException {
        String x = y.toLowerCase(Locale.ROOT);
        String plainswer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\PasswordCracker\\src\\main\\java\\sha256dic.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                cond2++;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\PasswordCracker\\src\\main\\java\\words_alpha.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer;
    }
}

