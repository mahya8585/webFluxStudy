package msSttSample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ishida.m
 */
@Controller
public class MinutesPageController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 非同期応答表示システム.
     *
     * @return テンプレートHTML
     */
    @RequestMapping(value = "/meeting", method = RequestMethod.GET)
    public String meeting() {
        return "meeting";
    }

}
