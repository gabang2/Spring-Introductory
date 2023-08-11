package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "김가영의 test spring project!!");
        return "hello"; //templates의 hello.html을 실행하여라.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public List<Hello> helloApi(@RequestParam("name") String name) {
        List<Hello> helloList = new ArrayList<Hello>();
        helloList.add(new Hello("gayeong"));
        helloList.add(new Hello("gayeong2"));

        return helloList; // 객체가 오면 json방식으로 데이터를 만들어서 http응답을 하는 것이 기본 정책임
        // httpMessageConverter가 동작
        // 객체 -> JsonConverter(Jackson or gson)
        // 문자열 -> StringConverter
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Hello(String name) {
            this.name = name;
        }
    }
}
