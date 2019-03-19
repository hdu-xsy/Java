package config; 
import javaconfig.JavaConfigService;
import javaconfig.UseJavaConfigService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* JavaConfigProfile Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 18, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaConfigProfile.class})
@ActiveProfiles("DEV")
public class JavaConfigProfileTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: javaConfigService() 
* 
*/ 
@Test
public void testJavaConfigService() throws Exception {
//TODO: Test goes here...
    ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigProfile.class);
    JavaConfigService javaConfigService = context.getBean(JavaConfigService.class);
    Assert.assertNotNull(javaConfigService);
}

/** 
* 
* Method: useJavaConfigService() 
* 
*/ 
@Test
public void testUseJavaConfigService() throws Exception { 
//TODO: Test goes here...
    assert 1 == 1;
} 


} 
