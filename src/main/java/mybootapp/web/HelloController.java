package mybootapp.web;

import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Service("/hello")
public class HelloController implements Controller {

    @PostConstruct
    private void init() {
        logger.info("HelloController initialized");
    }

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning hello view");
        String now = (new Date()).toString();
        return new ModelAndView("hello", "now", now).addObject("message", "message test") ;
    }

}