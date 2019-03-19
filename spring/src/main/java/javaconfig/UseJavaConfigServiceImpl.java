package javaconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class UseJavaConfigServiceImpl implements UseJavaConfigService {

    @Autowired
    JavaConfigService javaConfigService;

    public void setJavaConfigService(JavaConfigService javaConfigService) {
        this.javaConfigService = javaConfigService;
    }

    public UseJavaConfigServiceImpl(JavaConfigService javaConfigService) {
        this.javaConfigService = javaConfigService;
    }

    public void print() {
        System.out.println("*** From JavaConfig ***");
        javaConfigService.print();
        System.out.println("***********************");
    }
}
