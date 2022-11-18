import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

public class Brute {
   File MD5 = new File("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\MD5HASH.txt");
   File SHA256 = new File("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\SHA256.txt");
   File plain = new File("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\plaintext.txt");
    public Brute(){

    }

    public String plain(String x) throws IOException {
        String answer;
        String shanswer;
        String md5swer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\plaintext.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                answer=x;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\MD5HASH.txt"))) {
            md5swer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\SHA256HASH.txt"))) {
            shanswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "MD5 Hash: " + md5swer + "\n" + "SHA256 Hash: " + shanswer;
    }
    public String MD5(String x) throws IOException {
        String answer;
        String shanswer;
        String plainswer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\MD5HASH.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                answer=x;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\plaintext.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\SHA256HASH.txt"))) {
            shanswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer + "\n" + "SHA256 Hash: " + shanswer;
    }


    public String SHA256(String x) throws IOException {
        String answer;
        String plainswer;
        String md5swer;
        int lineNumber = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\SHA256HASH.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            if(line.equals(x)){
                answer=x;
                break;
            }
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\MD5HASH.txt"))) {
            md5swer = lines.skip(lineNumber-1).findFirst().get();
        }
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zaid2\\IdeaProjects\\untitled\\src\\plaintext.txt"))) {
            plainswer = lines.skip(lineNumber-1).findFirst().get();
        }
        return "Plaintext: " + plainswer + "\n" + "MD5 Hash: " + md5swer;
    }
    }

