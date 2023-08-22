package org.example.service;


import lombok.SneakyThrows;
import org.example.dto.UserDto;
import org.example.model.UserAccount;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAccountServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;
    @Mock
    ModelMapper modelMapper;

    @Test
    @SneakyThrows
    void shouldReturnUserWhenIdExists(){
        UserAccount mockUserAccount = new UserAccount();
        UserDto mockUserDto = UserDto.builder().id(2L).name("pepito").password("123").build();
        when(userRepository.findById(any())).thenReturn(Optional.of(mockUserAccount));
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

    @Test
    @SneakyThrows
    void shouldSaveUserWhenUserNoExists(){
        UserAccount mockUserAccount = new UserAccount();
        UserDto mockUserDto = UserDto.builder().name("pepito").password("123").build();

        when(modelMapper.map(any(), any())).thenReturn(mockUserAccount);
        when(userRepository.save(any())).thenReturn(mockUserAccount);

        userService.saveOrUpdate(mockUserDto);

        verify(userRepository).save(any());
        verify(modelMapper).map(any(),any());
    }

    @Test
    @SneakyThrows
    void shouldThrowExceptionWhenIdExists(){
        UserAccount mockUserAccount = new UserAccount();
        UserDto mockUserDto = UserDto.builder().id(2L).name("pepito").password("123").build();

        when(userRepository.existsById(any())).thenReturn(false);


        assertThrows(Exception.class, () -> userService.saveOrUpdate(mockUserDto));



        verify(userRepository).existsById(any());





    }

    @Test
    @SneakyThrows
    void shouldUpdateUserWhenIdExists() {
        UserAccount mockUserAccount = new UserAccount();
        UserDto mockUserDto = UserDto.builder().id(2L).name("pepito").password("123").build();

        when(userRepository.existsById(any())).thenReturn(true);
        when(modelMapper.map(any(), any())).thenReturn(mockUserAccount);
        when(userRepository.save(any())).thenReturn(mockUserAccount);


        userService.saveOrUpdate(mockUserDto);


        verify(userRepository).existsById(any());
        verify(modelMapper).map(any(),any());
        verify(userRepository).save(any());

    }

    @Test
    @SneakyThrows
    void shouldDeleteUserWhenIdExists(){
        when(userRepository.existsById(any())).thenReturn(true);

        userService.deleteUser(1L);

        verify(userRepository).existsById(any());
    }

    @Test
    void shouldThrowExceptionWhenNoExists(){
        when(userRepository.existsById(any())).thenReturn(false);

        assertThrows(Exception.class, () -> userService.deleteUser(2L));

    }
}
