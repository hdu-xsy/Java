package aop;

public class PerformanceImpl implements Performance {
    public void perform() {
        System.out.println("perform");
    }

    public void performs(int i) {
        System.out.println("perform" + i);
    }
}
