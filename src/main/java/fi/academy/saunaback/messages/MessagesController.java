package fi.academy.saunaback.messages;

import fi.academy.saunaback.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RequestMapping("/api/messages")
@RestController
public class MessagesController {

    private MessagesRepository mrep;

    @Autowired
    public MessagesController(MessagesRepository mrep){
        this.mrep = mrep;
    }

    @GetMapping()
    public Iterable<Messages>getAllMessages(){
        return mrep.findAll();
    }

    @PostMapping(value = "/newmessage")
    public Messages addMessages(@RequestBody Messages messages){
        return mrep.save(messages);
    }


}
