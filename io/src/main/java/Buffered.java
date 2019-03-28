import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        String inPath = Buffered.class.getClassLoader().getResource("text").getPath();
        String outPath = Buffered.class.getClassLoader().getResource("text.bak").getPath();
        //try-with-resources
        try (BufferedReader in = new BufferedReader(new FileReader(inPath));
             BufferedWriter out = new BufferedWriter(new FileWriter(outPath))) {
            String line;
            while ((line = in.readLine())!=null) {
                System.out.println(line);
                out.write(line);
                out.newLine();
                out.flush();
            }

        } catch (IOException e) {

        }
    }
}
