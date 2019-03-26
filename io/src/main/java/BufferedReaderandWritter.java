import java.io.*;

public class BufferedReaderandWritter {
    public static void main(String[] args) {
        String inPath = BufferedReaderandWritter.class.getClassLoader().getResource("text").getPath();
        String outPath = BufferedReaderandWritter.class.getClassLoader().getResource("text.bak").getPath();
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
