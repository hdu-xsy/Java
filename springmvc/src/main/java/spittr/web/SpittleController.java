package spittr.web;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController{


    /*
    * BindException 400 - Bad Request
    ConversionNotSupportedException 500 - Internal Server Error
    HttpMediaTypeNotAcceptableException 406 - Not Acceptable
    HttpMediaTypeNotSupportedException 415 - Unsupported Media Type
    HttpMessageNotReadableException 400 - Bad Request
    HttpMessageNotWritableException 500 - Internal Server Error
    HttpRequestMethodNotSupportedException 405 - Method Not Allowed
    MethodArgumentNotValidException 400 - Bad Request
    MissingServletRequestParameterException 400 - Bad Request
    MissingServletRequestPartException 400 - Bad Request
    NoSuchRequestHandlingMethodException 404 - Not Found
    TypeMismatchException 400 - Bad Request
    * */
    
    //处理查询参数
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam("aa") int aa,@RequestParam("bb") String bb) {
        System.out.println(bb+aa);
        return "spittles";
    }

    //通过路径参数接受输入
    @RequestMapping(value = "/{spittleId}",method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId")String id) {
        System.out.println(id);
        return "spittles";
    }

}
