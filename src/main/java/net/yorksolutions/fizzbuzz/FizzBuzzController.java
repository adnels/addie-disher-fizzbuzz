package net.yorksolutions.fizzbuzz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

    public FizzBuzzService service;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.service = fizzBuzzService;
    }

    @GetMapping("/addUser")
    public void addUser(@RequestParam String username, @RequestParam String password) {
        System.out.println(username);
        System.out.println(password);
        service.addUser(username, password);
    }

    @GetMapping("/play")
    public String fizzBuzz(@RequestParam String username, @RequestParam String password, @RequestParam Integer number)
            throws ResponseStatusException {
        service.fizzBuzz(username, password, number);
        return (service.fizzBuzz(username, password, number));
    }
}