public class MyThread2 implements Runnable{

    private int num;

    private int num2;

    private String name;

    MyThread2() {}

    MyThread2(String name,int num,int num2) {
        this.name = name;
        this.num = num;
        this.num2 = num2;
    }


    public void run() {
        synchronized (Num.class) {
            try {
                Num.i(num);
                if (num == 100) {
                    Thread.sleep(3000);
                }
                Num.j(num2);
                Num.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
