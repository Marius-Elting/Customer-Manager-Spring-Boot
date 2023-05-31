package com.marius;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @ComponentScan(basePackages = "com.marius")
// @EnableAutoConfiguration
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // @GetMapping("/")
    // public GreetResponse greet() {
    // return new GreetResponse("Hello");
    // }

    // record GreetResponse(String greet) {
    // }

    @GetMapping("/")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse("Hello", List.of("Java", "Typescript"),
                new Person("Marius", 21, 2300.3));
        return response;
    }

    // class GreetResponse {
    // private final String greet;

    // public GreetResponse(String greet) {
    // this.greet = greet;
    // }

    // public String getGreet() {
    // return greet;
    // }

    // @Override
    // public String toString() {
    // return "GreetResponse [greet=" + greet + "]";
    // }

    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + getEnclosingInstance().hashCode();
    // result = prime * result + ((greet == null) ? 0 : greet.hashCode());
    // return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // GreetResponse other = (GreetResponse) obj;
    // if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
    // return false;
    // if (greet == null) {
    // if (other.greet != null)
    // return false;
    // } else if (!greet.equals(other.greet))
    // return false;
    // return true;
    // }

    // private Main getEnclosingInstance() {
    // return Main.this;
    // }

    // }

    record Person(String nam, int age, double savings) {
    }

    record GreetResponse(String greet, List<String> favProgrammingLanguages, Person person) {

    }

}
