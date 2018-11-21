package pl.michalkwit.springbootsimpleapp;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User user){
        return user;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public User edit(@RequestBody User user){
        return user;

    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public User confirm(@PathVariable(value = "id") Long id){
        return new User();

    }
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public User add(@RequestBody User user){
        return user;

    }
}
