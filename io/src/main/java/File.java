import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class File {
    public static void main(String[] args) {
        int n = -1;
        byte[] a = new byte[100];
        char[] tom = new char[10];
        java.io.File file = new java.io.File(File.class.getClassLoader().getResource("text").getPath());
        java.io.File file2 = new java.io.File(File.class.getClassLoader().getResource("text.bak").getPath());
        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out = new FileOutputStream(file2);
             FileReader reader = new FileReader(file);
             FileWriter writer = new FileWriter(file2)) {
            while((n = in.read(a,0,100)) != -1) {
                String s = new String(a,0,n);
                System.out.println(s);
                out.write(a,0,a.length);
            }
            StringBuffer s = new StringBuffer();
            while((n = reader.read(tom,0,10)) != -1) {
                String temp = new String(tom,0,n);
                s.append(temp);
                writer.write(tom,0,tom.length);
            }
            System.out.println(new String(s));
        }catch (Exception e) {

        }
    }
}
