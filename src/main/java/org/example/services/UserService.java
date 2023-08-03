package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id) throws Exception {
        var res = userRepository.findById(id);
        if(!res.isEmpty()) {
            throw new Exception("No existe el usuario con id=" + id);
        }
        return res.get();
    }
    public User saveUser(User user){
        return userRepository.save(user);

    }
}
