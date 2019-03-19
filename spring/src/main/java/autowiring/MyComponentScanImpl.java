package autowiring;


import org.springframework.stereotype.Component;

@Component("MyComponentScan")
public class MyComponentScanImpl implements MyComponentScan{

    private String output = "From ComponentScan";

    public void print() {
        System.out.println(output);
    }
}
