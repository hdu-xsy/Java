package javaconfig; 
import config.JavaConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* UseJavaConfigServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 16, 2019</pre> 
* @version 1.0 
*/ 
public class UseJavaConfigServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setJavaConfigService(JavaConfigService javaConfigService) 
* 
*/ 
@Test
public void testSetJavaConfigService() throws Exception { 
//TODO: Test goes here... 
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
    UseJavaConfigService useJavaConfigService = context.getBean(UseJavaConfigService.class);
    useJavaConfigService.print();
    Assert.assertNotNull(useJavaConfigService);
}

/** 
* 
* Method: print() 
* 
*/ 
@Test
public void testPrint() throws Exception { 
//TODO: Test goes here... 
} 


} 
