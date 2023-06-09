package com.marius;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @ComponentScan(basePackages = "com.marius")
// @EnableAutoConfiguration
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

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

    @GetMapping
    public List<Customer> getCustomers() {
        System.out.println(customerRepository.findAll());
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customer.setId(id);
        customerRepository.save(customer);
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

    static record NewCustomerRequest(
            String name,
            String email,
            int age) {

    }

}
