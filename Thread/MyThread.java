public class MyThread extends Thread {

    private int num;

    private int num2;

    private String name;

    MyThread() {}

    MyThread(String name,int num,int num2) {
        this.name = name;
        this.num = num;
        this.num2 = num2;
    }

    @Override
    public synchronized void run(){
        try {
            Num.i(num);
            if (num == 100) {
                wait(3000);
                //Thread.sleep(3000);
            }
            Num.j(num2);
            Num.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
