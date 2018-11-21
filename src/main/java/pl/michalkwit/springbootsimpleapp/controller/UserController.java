package pl.michalkwit.springbootsimpleapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.michalkwit.springbootsimpleapp.model.UserDTO;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDTO register(@RequestBody UserDTO userDTO){
        return userDTO;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public UserDTO edit(@RequestBody UserDTO userDTO){
        return userDTO;

    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public UserDTO confirm(@PathVariable(value = "id") Long id){
        return new UserDTO();

    }
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public UserDTO add(@RequestBody UserDTO userDTO){
        return userDTO;

    }
}
