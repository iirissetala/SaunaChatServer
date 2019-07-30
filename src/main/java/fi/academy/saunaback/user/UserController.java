package fi.academy.saunaback.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/*  Tämä toimii kontrollerina. MVP sisältää kaikkien käyttäjien haun ja uuden käyttäjän lisäyksen.
*   Jos lisätään metodeja, lisätään tarvittaessa myös UserRepositoryyn. */
@RequestMapping("/api")
@RestController
public class UserController {

    private UserRepository urep;

    @Autowired
    public UserController(UserRepository urep){
        this.urep = urep;
    }

    @GetMapping("")
    Iterable<User> getAllUsers() {
        return urep.getAll();
    }
/* Uuden käyttäjän luonti. Tehdään mappaus (repoon määritetty path "/users */
    @PostMapping("/newuser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User u = urep.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
