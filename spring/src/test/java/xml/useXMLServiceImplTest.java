package xml; 
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/** 
* useXMLServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 18, 2019</pre> 
* @version 1.0 
*/ 
public class useXMLServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setXmlService(XMLService xmlService) 
* 
*/ 
@Test
public void testSetXmlService() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: print() 
* 
*/ 
@Test
public void testPrint() throws Exception { 
//TODO: Test goes here... 
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
    UseXMLService useXMLService = (UseXMLService)context.getBean("useXMLService");
    useXMLService.print();
    Assert.assertNotNull(useXMLService);
}


} 
