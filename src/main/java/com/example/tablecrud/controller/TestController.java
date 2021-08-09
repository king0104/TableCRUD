package com.example.tablecrud.controller;

import com.example.tablecrud.entity.SearchParamVO;
import com.example.tablecrud.entity.SearchVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/test", method = RequestMethod.GET)
public class TestController {

    @PostMapping("/postMethod")
    public String postMethod() {
        return "Hello Spring";
    }

    @PostMapping(value = "/search")
    public SearchVO search(@RequestBody SearchVO searchVO) {
        return searchVO;
    }

    @GetMapping("/user")
    public String getRequest() {
        return "hello";
    }

    @GetMapping("/getParam")
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd) {
        return "ID: " + id + " PW : " + pwd;
    }

    @GetMapping("/getMultiParam")
    public String getMultiParameter(SearchParamVO vo) {
        return vo.toString();
    }

    @GetMapping("/returnJson")
    public SearchParamVO returnJson(SearchParamVO vo) {
        return vo;
    }




}
