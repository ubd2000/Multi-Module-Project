package com.rest.multimoduleproject;

import com.rest.multimoduleproject.user.entity.User;
import com.rest.multimoduleproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.stream.IntStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//Transactional Annotaion 사용 시 테스트 후 자동으로 RollBack 되므로 데이터 확인을 위하여 삭제
//@Transactional
class ServerApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void signup() throws Exception {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("uid", "dosel2");
            params.add("password", "dosel2");
            params.add("name", "d123123");
            mockMvc.perform(post("/v1/signup").params(params))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    public void singupFor() throws Exception {
        mockMvc.perform(post("/v1/signupfor"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void modifyUser() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("uid", "dosel22");
        params.add("name", "eee123");
        mockMvc.perform(MockMvcRequestBuilders.put("/v1/user").params(params))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void userAllList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/user/dosel2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void pageAllUser() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("page", "0");
        params.add("size", "5");
//        params.add("sort", );
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/pageUsers").params(params))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void insertDummy() {
        IntStream.range(1, 101).forEach(i -> {
            User user = User.builder()
                    .uid("dosel2" + i)
                    .password("dadadad")
                    .name("dakseawe" + i).build();
            userRepository.save(user);
        });
    }

}
