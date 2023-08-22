package org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDto;
import org.example.model.UserAccount;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserDto getUser(Long id) throws Exception {
        var res = userRepository.findById(id);
        if(res.isEmpty()) {
            throw new Exception("No existe el usuario con id=" + id);
        }
        log.info("Se ha devuelto el usuario: " + res.get());
        return mapper.map(res.get(), UserDto.class);
    }

//    public User saveUser(User user){
//        return userRepository.save(user);
//    }

//    public void updateUser(User user, Long id) throws Exception {
//        if (!userRepository.existsById(id)){
//            throw new Exception("No existe el usuario con id=" + id);
//        } else {
//            userRepository.save(user);
//        }
//    }

    public void saveOrUpdate(UserDto user) throws Exception {
        // Este caso es el update, porque especificamos id pero ese id no existe
        if(!Objects.isNull(user.getId()) && !userRepository.existsById(user.getId())) {
            throw new Exception("No se puede actualizar el usuario porque no existe un usuario con id=" + user.getId());
        }
        userRepository.save(mapper.map(user, UserAccount.class));
    }
    public void  deleteUser(Long id) throws Exception {
        if(!userRepository.existsById(id)){
            throw new Exception("No existe el usuario con id=" + id);
        }
        userRepository.deleteById(id);
    }
}
