package pl.edu.pjatk.pjatkwej;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.pjatk.pjatkwej.Services.SandwichService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SandwichRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

  //  @MockBean
  //  private SandwichService sandwichService;

    @Test
    public void shouldReturnSucces_helloWorld() throws Exception {
        mockMvc.perform(get("/sandwich"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }

    @Test
    public void shouldReturnSucces_prepareSandwich() throws Exception {

        mockMvc.perform(get("/sandwich/prepare").param("sandwichName","bida"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"test\",\"baseCalories\":1550,\"basePrice\":54.0,\"ingredients\":[{\"id\":1,\"name\":\"black bread\",\"calories\":1500,\"price\":50.0}],\"size\":\"SMALL\"}"));

    }


}
