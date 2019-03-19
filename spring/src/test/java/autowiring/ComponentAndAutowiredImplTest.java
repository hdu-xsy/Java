package autowiring; 
import config.ComponentScanConfig;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* ComponentAndAutowiredImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 16, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class ComponentAndAutowiredImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setMyComponentScan(MyComponentScan myComponentScan) 
* 
*/ 
@Test
public void testSetMyComponentScan() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: print() 
* 
*/

@Autowired
@Qualifier("ComponentAndAutowired")
private ComponentAndAutowired componentAndAutowired;

@Test
public void testPrint() throws Exception { 
//TODO: Test goes here...
    componentAndAutowired.print();
    Assert.assertNotNull(componentAndAutowired);
} 


} 
