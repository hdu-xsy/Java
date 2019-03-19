package autowiring; 
import config.ComponentScanConfig;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/** 
* MyComponentScanImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 16, 2019</pre> 
* @version 1.0 
*/

/*
* 注解@ContextConfiguration会告诉它需要在ComponentScanConfig中加
* 载配置。 因为ComponentScanConfig类中包含了@ComponentScan， 因
* 此最终的应用上下文中应该包含MyComponentScan bean。
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class MyComponentScanImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: ComponentScan() 
* 
*/

/*@Autowired
private MyComponentScan myComponentScan;*/
@Test
public void testComponentScan() throws Exception { 
//TODO: Test goes here...
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    MyComponentScan myComponentScan = context.getBean(MyComponentScan.class);
    myComponentScan.print();
    assertNotNull(myComponentScan);
} 


} 
