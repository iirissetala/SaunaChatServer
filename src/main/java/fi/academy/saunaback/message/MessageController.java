package fi.academy.saunaback.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageRepository mrep;

    @Autowired
    public MessageController(MessageRepository mrep){
        this.mrep = mrep;
    }

//    @GetMapping()
//    tähän kaikkien viestien haku

//    @PostMapping("/addmessage")
//    uuden viestin postaus

}
