package aop; 
import config.AopConfig;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
* PerformanceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 18, 2019</pre> 
* @version 1.0 
*/ 
public class PerformanceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: perform() 
* 
*/ 
@Test
public void testPerform() throws Exception { 
//TODO: Test goes here...
    ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
    Performance performance = context.getBean(Performance.class);
    performance.perform();
    performance.performs(2);
    Encoreable encoreable = (Encoreable)performance;
    encoreable.performEncore();
} 


} 
