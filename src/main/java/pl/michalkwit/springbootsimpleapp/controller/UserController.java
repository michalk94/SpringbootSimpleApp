package pl.michalkwit.springbootsimpleapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.michalkwit.springbootsimpleapp.exception.WrongIdException;
import pl.michalkwit.springbootsimpleapp.model.UserDTO;
import pl.michalkwit.springbootsimpleapp.service.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDTO register(@RequestBody UserDTO userDTO) {
        if (idExist(userDTO))
            throw new WrongIdException("User should not have id");
        return userService.createUser(userDTO);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public UserDTO edit(@RequestBody UserDTO userDTO) {
        if (!idExist(userDTO))
            throw new WrongIdException("User should have id");
        return userService.editUser(userDTO);

    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public UserDTO confirm(@PathVariable(value = "id") Long id) {
        return new UserDTO();

    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public UserDTO add(@RequestBody UserDTO userDTO) {
        if (idExist(userDTO))
            throw new WrongIdException("User should not have id");
        return userService.createUser(userDTO);

    }

    private boolean idExist(UserDTO userDTO) {
        return userDTO.getId() != null;
    }
}
