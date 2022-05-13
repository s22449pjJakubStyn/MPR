package pl.edu.pjatk.pjatkwej;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.edu.pjatk.pjatkwej.Models.Sandwich;
import pl.edu.pjatk.pjatkwej.Models.SandwichSize;
import pl.edu.pjatk.pjatkwej.Repositories.SandwichRepository;
import pl.edu.pjatk.pjatkwej.Services.SandwichService;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
public class SandwichServiceIT {
@Autowired
    @MockBean
    private SandwichRepository sandwichRepository;
    @InjectMocks
    private SandwichService sandwichService;


    @Test
  public void shouldAddSuffixToSandwichName() throws Exception{
        Sandwich sandwich= new Sandwich(null, "testNameABC", 190, 20.0, null, SandwichSize.MEDIUM);
        sandwichService.changeName(sandwich);
        assertThat(sandwich.getName()).isEqualTo("testName");
    }
}
