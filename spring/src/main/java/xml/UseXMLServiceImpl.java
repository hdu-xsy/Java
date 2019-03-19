package xml;

public class UseXMLServiceImpl implements UseXMLService {

    XMLService xmlService;

    public void setXmlService(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    UseXMLServiceImpl(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    public void print() {
        System.out.println("use XMLService");
        xmlService.print();
    }
}
