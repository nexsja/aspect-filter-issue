package com.example.aspectfilterissue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public ControllerResponse index() {
        return new ControllerResponse("someContent");
    }
}
