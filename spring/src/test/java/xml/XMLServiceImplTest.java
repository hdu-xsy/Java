package xml; 
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* XMLServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 16, 2019</pre> 
* @version 1.0 
*/ 
public class XMLServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
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
    XMLService xmlService = (XMLService) context.getBean("xmlService");
    xmlService.print();
} 


} 
