import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.stream.Stream;

public class Dictionary {
    public static int cond2;
    public Dictionary(){
        cond2=0;
    }

    public String plain(String y) throws IOException {
        String x = y.toLowerCase(Locale.ROOT);
        String answer;
        String shanswer;
        String md5swer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\words_alpha.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                answer=x;
                cond2++;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\md5dic.txt"))) {
            md5swer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\sha256dic.txt"))) {
            shanswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "MD5 Hash: " + md5swer + "\n" + "SHA256 Hash: " + shanswer;
    }
    public String MD5(String y) throws IOException {
        String x = y.toLowerCase(Locale.ROOT);
        String answer;
        String shanswer;
        String plainswer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\md5dic.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                answer=x;
                cond2++;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\words_alpha.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\sha256dic.txt"))) {
            shanswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer + "\n" + "SHA256 Hash: " + shanswer;
    }


    public String SHA256(String y) throws IOException {
        String x = y.toLowerCase(Locale.ROOT);
        String answer;
        String plainswer;
        String md5swer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\sha256dic.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                answer=x;
                cond2++;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\md5dic.txt"))) {
            md5swer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\words_alpha.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer + "\n" + "MD5 Hash: " + md5swer;
    }
}

