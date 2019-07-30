package fi.academy.saunaback.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository urep;

    @Autowired
    public UserController(UserRepository urep){
        this.urep = urep;
    }

//    @GetMapping()
//    tähän kaikkien käyttäjien haku

//    @PostMapping("/adduser")
//    uuden käyttäjän luonti

    //iiris kommentoi commitia varten

}
