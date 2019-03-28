import java.io.RandomAccessFile;

public class Ramdon {

    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        java.io.File file = new java.io.File(Ramdon.class.getClassLoader().getResource("text.bak").getPath());
        try(RandomAccessFile inAndOut = new RandomAccessFile(file,"rw");) {
            for (int i = 0; i < data.length; i++) {
                inAndOut.writeInt(data[i]);
            }
            for (long i = data.length-1; i >= 0; i--) {
                inAndOut.seek(i*4);
                System.out.println(inAndOut.readInt());
            }
        } catch(Exception e) {

        }
    }
}
