import java.util.concurrent.Callable;

public class MyThread3 implements Callable<String> {

    public String call() throws Exception {
        return "MyThread3";
    }
}
