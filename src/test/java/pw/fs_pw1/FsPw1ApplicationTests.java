package pw.fs_pw1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class FsPw1ApplicationTests {

    @Autowired
    private CarController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
