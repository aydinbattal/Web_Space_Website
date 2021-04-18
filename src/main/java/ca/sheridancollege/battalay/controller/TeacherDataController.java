package ca.sheridancollege.battalay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeacherDataController {
    @GetMapping(value={"/", "/Private"})
    public String index(){
        return "teachers/Private";
    }
}
