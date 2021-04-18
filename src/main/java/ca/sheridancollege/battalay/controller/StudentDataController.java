package ca.sheridancollege.battalay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentDataController {
    @GetMapping(value={"/", "/Private"})
    public String index(){
        return "students/Private";
    }
}
