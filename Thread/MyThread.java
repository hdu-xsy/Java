public class MyThread extends Thread {

    private int count = 0;

    private String name;

    private int change;

    MyThread() {}

    MyThread(String name) {
        this.name = name;
    }

    MyThread(String name,int change) {
        this.name = name;
        this.change = change;
    }

    @Override
    public void run(){
        try {
            int tmp = count;
            tmp += change;
            if (change == -1) sleep(3000);
            count = tmp;
            System.out.println(name + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
