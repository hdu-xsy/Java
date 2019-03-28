import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Scanner;

public class Lock {
    public static void main(String[] args) {
        java.io.File file = new java.io.File(Ramdon.class.getClassLoader().getResource("text.bak").getPath());
        Scanner scanner = new Scanner(System.in);
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            FileLock lock = channel.tryLock();
            while (scanner.hasNext()) {
                int m = scanner.nextInt();
                lock.release();
                for (int i = 1; i <= m; i++) {
                    String str = randomAccessFile.readLine();
                    System.out.println(str);
                }
                lock = channel.tryLock();
                System.out.println("11111");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
