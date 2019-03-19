package autowiring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ComponentAndAutowired")
public class ComponentAndAutowiredImpl implements ComponentAndAutowired{

    @Autowired
    private MyComponentScan myComponentScan;

    public void setMyComponentScan(MyComponentScan myComponentScan) {
        this.myComponentScan = myComponentScan;
    }

    public ComponentAndAutowiredImpl(MyComponentScan myComponentScan) {
        this.myComponentScan = myComponentScan;
    }

    public void print() {
        System.out.println("***from component and autowired***");
        myComponentScan.print();
        System.out.println("**********************************");

    }
}
