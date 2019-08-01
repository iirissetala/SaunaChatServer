package fi.academy.saunaback.users;

import fi.academy.saunaback.messages.Messages;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

/*  Tämä toimii kontrollerina. MVP sisältää kaikkien käyttäjien haun ja uuden käyttäjän lisäyksen.
 *   Jos lisätään metodeja, lisätään tarvittaessa myös UserRepositoryyn. */
@CrossOrigin
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

    /* Alla on vaihtoehtoinen metodi löylyn lisäämiselle. Ongelmaksi tuli pakollinen
       käyttäjänimi, jolloin se piti syöttää löylymäärän lisäksi.
       Piti myös syöttää löylymäärä käsin eli toteutettu Put metodi (/heat/id) parempi. Iiris

      @PutMapping("/addheat/{id}")
      public ResponseEntity<Object> updateStudent(@RequestBody Users users, @PathVariable long id) {

          Optional<Users> studentOptional = urep.findById(id);

          if (!studentOptional.isPresent())
              return ResponseEntity.notFound().build();

          users.setId(id);

          urep.save(users);

          return ResponseEntity.noContent().build();
      }
      */
    /*  Metodi kasvattaa käyttäjän saamaa löylymäärää yhdellä. Polkuna käytetään id.tä. Iiris*/
    @PutMapping("/heat/{id}")
    public Users retrieveStudent(@PathVariable long id) {
        Optional<Users> users = urep.findById(id);
        users.get().addUsersHeat();
        urep.save(users.get());

        return users.get();
    }


    /* Luo uuden käyttäjän. Pakollisena tietona käyttäjänimi. Iiris*/
    @PostMapping("/newuser")
    public ResponseEntity<?> addUser(@RequestBody Users users){
        Users u = urep.save(users);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(users.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}