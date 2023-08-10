package org.example.service;


import lombok.SneakyThrows;
import org.example.dto.UserDto;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;
    @Mock
    ModelMapper modelMapper;

    @Test
    @SneakyThrows
    void shouldReturnUserWhenIdExists(){
        User mockUser = new User();
        UserDto mockUserDto = UserDto.builder().id(2L).name("pepito").password("123").build();
        when(userRepository.findById(any())).thenReturn(Optional.of(mockUser));
        when(modelMapper.map(any(), any())).thenReturn(mockUserDto);

        UserDto res = userService.getUser(2L);

        assertThat(res, is(mockUserDto));
        assertThat(res.getName(), is("pepito"));
    }
    @Test
    @SneakyThrows
    void shouldThrowExceptionWhenIdNoExists(){
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> userService.getUser(2L));
    }
}
