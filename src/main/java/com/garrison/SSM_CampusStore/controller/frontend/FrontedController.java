package com.garrison.SSM_CampusStore.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/frontend")
public class FrontedController {
    @RequestMapping(value="/index", method = RequestMethod.GET)
    private String index(){
        return "frontend/index";
    }
}
