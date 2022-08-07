package com.carboard.center.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @RequestMapping("api/test")
    public String test() {
        return "이거나 먹어!";
    }
}
