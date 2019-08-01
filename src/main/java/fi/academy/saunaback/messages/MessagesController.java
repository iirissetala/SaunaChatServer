package fi.academy.saunaback.messages;

import fi.academy.saunaback.users.Users;
import fi.academy.saunaback.users.UsersController;
import fi.academy.saunaback.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

/**
 *  Luokka toimii kontrollerina. Voidaan hakea kaikki viestit, luoda uusi viesti sekä
 *   lisätä asiattomalle viestille löylyä. Iiris
 */

@CrossOrigin
@RequestMapping("/api/messages")
@RestController
public class MessagesController {
/**
 *  Tuodaan kontrollerin käyttöön sekä UsersRepository että UsersController, jotta pystytään
 * kasvattamaan käyttäjän(Users) löylymäärää samalla kun viestille annetaan löylyä. Iiris
 */
    private MessagesRepository mrep;
    private UsersRepository urep;
    private UsersController ucont;

    @Autowired
    public MessagesController(MessagesRepository mrep, UsersRepository urep, UsersController uc){
        this.mrep = mrep;
        this.urep = urep;
        this.ucont = uc;
    }

    /** Haetaan kaikki viestit, jotta saadaan ne näkyviin fronttiin. Lauri */
    @GetMapping()
    public Iterable<Messages>getAllMessages(){
        return mrep.findAll();
    }
    /** lisätään löylyä viestille ja samalla viestin kirjoittajalle . Iiris */

    /*TOIMII MUTTA KOITETAAN SAADA MYÖS KÄYTTÄJÄN LÖYLYMÄÄRÄÄ KASVATETTUA SAMALLA
    @PutMapping("/heat/{id}")
    public Messages retrieveMessages(@PathVariable long id) {
        Optional<Messages> messages = mrep.findById(id);
        messages.get().addMessagesHeat();
        mrep.save(messages.get());

        return messages.get();
    }
     */

    /**
     *  Lisätään viestin löylymäärää yhdellä. Samalla lisätään käyttäjälle löylyä viestin
     * userid:n perusteella. Userid annetaan UsersControllerin löylynlisäysmetodille. Iiris
     */
    @PutMapping("/heat/{id}")
    public Messages retrieveMessages(@PathVariable long id) {
        Optional<Messages> messages = mrep.findById(id);
        messages.get().addMessagesHeat();
        mrep.save(messages.get());

        long uid = messages.get().getUserid();
        ucont.addUserHeat(uid);

        return messages.get();
    }
/** Uuden viestin luonti. Lauri */
    @PostMapping(value = "/newmessage")
    public Messages addMessages(@RequestBody Messages messages){
        return mrep.save(messages);
    }

}
