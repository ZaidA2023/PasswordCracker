import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.stream.Stream;

public class Brute {
    public static int cond;
    public Brute(){
        cond=0;
    }

    public String plain(String y) throws IOException {
        String x = y.toLowerCase(Locale.ROOT);
        String shanswer;
        String md5swer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\plaintext.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                cond=1;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\MD5HASH.txt"))) {
            md5swer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\SHA256HASH.txt"))) {
            shanswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "MD5 Hash: " + md5swer + "\n" + "SHA256 Hash: " + shanswer + "\n";
    }
    public String MD5(String y) throws IOException {
        String x = y.toLowerCase(Locale.ROOT);
        String shanswer;
        String plainswer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\MD5HASH.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                cond=1;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\plaintext.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\SHA256HASH.txt"))) {
            shanswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer + "\n" + "SHA256 Hash: " + shanswer + "\n";
    }


    public String SHA256(String y) throws IOException {
        String x = y.toLowerCase(Locale.ROOT);
        String plainswer;
        String md5swer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\SHA256HASH.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                cond=1;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\MD5HASH.txt"))) {
            md5swer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\plaintext.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer + "\n" + "MD5 Hash: " + md5swer + "\n";
    }
    }

