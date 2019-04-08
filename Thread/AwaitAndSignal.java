import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitAndSignal {

    private static Lock lock = new ReentrantLock();

    private static Condition c1 = lock.newCondition();

    private static Condition c2 = lock.newCondition();

    public static void run1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("c2 --- signal");
                c2.signal();
                try {
                    System.out.println("c1 --- wait");
                    c1.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("c1 ---- work");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void run2() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("c1 --- signal");
                c1.signal();
                try {
                    System.out.println("c2 --- wait");
                    c2.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("c2 ---- work");
            }
        } finally {
            lock.unlock();
        }
    }


}
