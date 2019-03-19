package autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Primary")
@Primary
public class PrimaryService implements ComponentAndAutowired{

    @Autowired
    private MyComponentScan myComponentScan;

    public void setMyComponentScan(MyComponentScan myComponentScan) {
        this.myComponentScan = myComponentScan;
    }

    public PrimaryService(MyComponentScan myComponentScan) {
        this.myComponentScan = myComponentScan;
    }

    public void print() {
        myComponentScan.print();
        System.out.println("Primary");
    }
}
