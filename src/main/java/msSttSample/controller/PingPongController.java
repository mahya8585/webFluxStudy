package msSttSample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ishida.m
 */
@Controller
public class PingPongController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Ping表示.
     *
     * @return テンプレートHTML
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewIndex() {
        return "index";
    }


}
