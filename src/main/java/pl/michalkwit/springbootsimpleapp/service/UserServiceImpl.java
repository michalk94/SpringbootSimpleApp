package pl.michalkwit.springbootsimpleapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalkwit.springbootsimpleapp.model.UserDTO;
import pl.michalkwit.springbootsimpleapp.persistence.model.User;
import pl.michalkwit.springbootsimpleapp.persistence.repository.UserRepo;

@Service
public class UserServiceImpl  extends BaseServiceImpl<User, Long, UserRepo> implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserRepo getRepository() {
        return userRepo;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User u = save(Mapper.dtoToUser(userDTO));
        return Mapper.userToDTO(u);
    }

    @Override
    public UserDTO editUser(UserDTO userDTO) {
        User u = save(Mapper.dtoToUser(userDTO));
        return Mapper.userToDTO(u);
    }
}
