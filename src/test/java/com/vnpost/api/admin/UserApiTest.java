package com.vnpost.api.admin;

import com.vnpost.dto.UserDTO;
import com.vnpost.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(UserApi.class)
public class UserApiTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @MockBean
    private UserApi userApi;
    @Test
    public void saveUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setFullName("Nguyễn Anh Tuấn");
        userDTO.setUserName("natuan1606");
        userDTO.getListRole().add("ADMIN");
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setFullName("Nguyễn Anh Tuấn");
        userDTO1.setUserName("natuan1606");
        userDTO1.getListRole().add("ADMIN");
        userDTO1.setId(10L);
        given(userApi.save(userDTO)).willReturn(userDTO1);
    }
}
