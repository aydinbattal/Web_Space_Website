package ca.sheridancollege.battalay.controller;

import ca.sheridancollege.battalay.data.LoginDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/password/*")
public class PasswordDataController {

    private final Logger logger = LoggerFactory.getLogger(PasswordDataController.class);

    private LoginDataService loginDataService;

    @Autowired
    public PasswordDataController(
            @Qualifier("loginDataServiceJpaImpl") LoginDataService loginDataService) {
        this.loginDataService = loginDataService;
    }

}
