package pl.michalkwit.springbootsimpleapp.service;

import pl.michalkwit.springbootsimpleapp.model.UserDTO;
import pl.michalkwit.springbootsimpleapp.persistence.model.User;
import pl.michalkwit.springbootsimpleapp.persistence.repository.UserRepo;

public interface UserService extends BaseService<User, Long, UserRepo> {

    public UserDTO createUser(UserDTO userDTO);

    public UserDTO editUser(UserDTO userDTO);

}
