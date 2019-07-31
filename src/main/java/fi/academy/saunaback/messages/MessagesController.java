package fi.academy.saunaback.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Messages addMessage(@RequestBody Messages m){
        return mrep.save(m);
    }

}
