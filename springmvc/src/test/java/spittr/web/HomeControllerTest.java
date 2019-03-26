package spittr.web; 

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/** 
* HomeController Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 19, 2019</pre> 
* @version 1.0 
*/ 
public class HomeControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: home() 
* 
*/ 
@Test
public void testHome() throws Exception { 
//TODO: Test goes here...
    HomeController homeController = new HomeController();
    MockMvc mockMvc = standaloneSetup(homeController).build();
    mockMvc.perform(get("/")).andExpect(view().name("home"));
}

}
