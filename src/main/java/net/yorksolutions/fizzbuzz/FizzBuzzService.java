package net.yorksolutions.fizzbuzz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class FizzBuzzService {

    //can make multiple variables for repositories here below
    UserRepository repository;

//constructor, can accept multiple repositories
    @Autowired
    public FizzBuzzService(UserRepository userRepository) {
        this.repository = userRepository;
    }
//methods
    public void addUser(String username, String password) {

        Optional<UserEntity> existingUser = repository.getByUsername(username);

        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
            UserEntity user = new UserEntity(username, password);
            repository.save(user);
        }

//main method
    public String fizzBuzz(String username, String password, Integer number) throws ResponseStatusException {

        String string = "";

//check username and pass here
    Optional<UserEntity> user = repository.getByUsername(username);
        if (user.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        if (!Objects.equals(user.get().password, password)) {
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        if (number % 3 == 0) {
            string = "Fizz";
        }

        if (number % 5 == 0) {
            string += "Buzz";
        }

        if (string.equals("")) {
            string = number.toString();
        }

        return (string);
        }
}