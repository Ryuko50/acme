package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id) throws Exception {
        var res = userRepository.findById(id);
        if(res.isEmpty()) {
            throw new Exception("No existe el usuario con id=" + id);
        }
        return res.get();
    }
    public User saveUser(User user){
        return userRepository.save(user);

    }

    public void updateUser(User user, Long id) throws Exception {
        if (!userRepository.existsById(id)){
            throw new Exception("No existe el usuario con id=" + id);
        } else {
            saveUser(user);
        }
    }

    public void saveOrUpdate(User user) throws Exception {
        // Este caso es el update, porque especificamos id pero ese id no existe
        if(!Objects.isNull(user.getId()) && !userRepository.existsById(user.getId())) {
            throw new Exception("No se puede actualizar el usuario porque no existe un usuario con id=" + user.getId());
        }
        userRepository.save(user);
    }
}
