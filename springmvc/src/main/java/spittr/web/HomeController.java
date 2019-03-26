package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller //声明为一个控制器
@RequestMapping({"/","/homepage"})
public class HomeController {

    @RequestMapping(method = GET)
    public String home() {
        System.out.println("home");
        return "home";
    }

}
