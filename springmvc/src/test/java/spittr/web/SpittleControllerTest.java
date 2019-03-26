package spittr.web; 
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/** 
* SpittleController Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 19, 2019</pre> 
* @version 1.0 
*/ 
public class SpittleControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: spittles(Model model) 
* 
*/ 
@Test
public void testSpittles() throws Exception { 
//TODO: Test goes here...
    SpittleController spittleController = new SpittleController();
    MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(
            new InternalResourceView("/WEB-INF/spittles.jsp")
    ).build();

    mockMvc.perform(get("/spittles/11")).andExpect(view().name("spittles"));
}


} 
