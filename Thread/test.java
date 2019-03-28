import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) throws Exception{
        //MyThread thread = new MyThread("MyThread : ",100,2);
        //MyThread th = new MyThread("MyThread2 : ",1,1);
        //thread.start();
        //th.start();

        //MyThread2 thread = new MyThread2("MyThread : ",100,2);
        //Thread t = new Thread(thread);
        //MyThread2 thread2 = new MyThread2("MyThread2 : ",1,1);
        //Thread th = new Thread(thread2);
        //t.start();
        //th.start();

        /*ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new MyThread3());
        try {
            System.out.println("waiting thread3");
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        MyThread thread = new MyThread("MyThread : ",100,2);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        //ExecutorService pool = Executors.newCachedThreadPool();
        //ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 40; i++) {
            pool.execute(thread);
        }
        pool.shutdown();
        /*MyThread thread = new MyThread("MyThread : ",100,2);
        MyThread2 thread2 = new MyThread2("MyThread2 : ",1,1);
        Thread th = new Thread(thread2);
        thread.start();
        th.start();*/
    }
}
