package fi.academy.saunaback.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/*  Tämä toimii kontrollerina. MVP sisältää kaikkien käyttäjien haun ja uuden käyttäjän lisäyksen.
*   Jos lisätään metodeja, lisätään tarvittaessa myös UserRepositoryyn. */
@RequestMapping("/api/users")
@RestController
public class UsersController {

    private UsersRepository urep;

    @Autowired
    public UsersController(UsersRepository urep){
        this.urep = urep;
    }

    @GetMapping("")
    Iterable<Users> getAllUsers() {
        return urep.findAll();
    }
/* Uuden käyttäjän luonti. Tehdään mappaus (repoon määritetty path "/users */
    @PostMapping("/newuser")
    public ResponseEntity<?> addUser(@RequestBody Users users){
        Users u = urep.save(users);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(users.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
