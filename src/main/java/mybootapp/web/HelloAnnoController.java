package mybootapp.web;

import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping("/tests")
public class HelloAnnoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        String now = (new Date()).toString();
        logger.info("Running " + this);
        return new ModelAndView("hello", "now", now);
    }
    @RequestMapping(value = "/counter", method = RequestMethod.GET)
    public ModelAndView count(HttpServletRequest request,HttpSession session){
        String now = (new Date()).toString();
        logger.info("Running " + this);
        int counter = getOrCreateCounter(request);
        session.setAttribute("counter", counter+1);
        return new ModelAndView("hello", "now", now).addObject("counter", counter);
    }

    private int getOrCreateCounter(HttpServletRequest request) {
        var session = request.getSession();
        var object =   session.getAttribute("counter");
        if (session.getAttribute("counter") instanceof Integer) {
           return (Integer) object;
        }
        int counter = 0;
        session.setAttribute("counter", counter);
        return counter;
    }

    @PostConstruct
    private void init() {
        logger.info("HelloAnnoController initialized");
    }

    @RequestMapping(value = "/plus10", method = RequestMethod.GET)

    public ModelAndView plus10(
            @RequestParam(value = "num", defaultValue = "100") Integer value,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        logger.info("Running plus10 controler with param = " + value);
        return new ModelAndView("hello", "now", value + 10).addObject("date", date);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ModelAndView date(
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        return new ModelAndView("hello").addObject("date", date);
    }

    @RequestMapping(value = "/voir/{param}", method = RequestMethod.GET)
    public ModelAndView voir(@PathVariable("param") Integer param) {
        logger.info("Running param controler with param=" + param);
        return new ModelAndView("hello", "now", param);
    }

    // Pour avoir un controller different sur une meme format d'adresse
    @RequestMapping(value = "/voir/{param}/{param2}", method = RequestMethod.GET)
    @GetMapping("")
    public ModelAndView voirPlus(@PathVariable("param") Integer param,@PathVariable("param2") String param2) {
        logger.info("Running param controler with param=" + param);

        return new ModelAndView("hello", "now", param).addObject("param2", param2);
    }


    @RequestMapping(value = "/matrix/{param}", method = RequestMethod.GET)
    @ResponseBody
    public String testMatrix(//
                             @PathVariable("param") String param, //
                             @MatrixVariable(name = "a", defaultValue = "A") String a, //
                             @MatrixVariable(name = "b", defaultValue = "1") Integer b//
    ) {
        return String.format("param=%s, a=%s, b=%d", param, a, b);
    }

}