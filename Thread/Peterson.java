import static java.lang.Thread.sleep;

public class Peterson implements Runnable {

    private int count = 0;

    private String name;

    private int change;

    private boolean[] flag = {false,false}; //进程是否希望进入临界区

    private int turn;   //当前优先允许进入的进程

    private int id;

    private int times;

    Peterson() {}

    Peterson(int id,int times,String name,int change) {
        this.id = id;
        this.times = times;
        this.name = name;
        this.change = change;
    }

    public void run() {
        try {
            while(true) {
                flag[id] = true;
                turn = id + 1;
                while(flag[id] && turn == id+1) {
                    int tmp = count;
                    tmp += change;
                    if (change == -1) sleep(2000);
                    count = tmp;
                    System.out.println(name + count);
                    times --;
                    if(times == 0) return;
                }
                //临界区
                flag[id] = false;
                //剩余区
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}