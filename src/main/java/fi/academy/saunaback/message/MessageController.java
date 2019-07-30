package fi.academy.saunaback.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageRepository mrep;

    @Autowired
    public MessageController(MessageRepository mrep){
        this.mrep = mrep;
    }

    @GetMapping()
    public Iterable<Message>getAllMessages(){
        return mrep.findAll();
    }

    @PostMapping(value = "/addmessage")
    public Message addMessage(@RequestBody Message m){
        return mrep.save(m);
    }
//    @GetMapping()
//    tähän kaikkien viestien haku

//    @PostMapping("/addmessage")
//    uuden viestin postaus

}
