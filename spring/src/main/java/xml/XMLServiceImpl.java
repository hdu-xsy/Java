package xml;

import java.util.List;

public class XMLServiceImpl implements XMLService {

    private String s1;
    private String s2;

    private List<String> ss;

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public void setSs(List<String> ss) {
        this.ss = ss;
    }

    public XMLServiceImpl(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public XMLServiceImpl(String s1, String s2, List<String> ss) {
        this.s1 = s1;
        this.s2 = s2;
        this.ss = ss;
    }

    public void print() {
        System.out.println("From XML says" + s1 + s2);
        System.out.println("has" + ss.size());
    }
}
