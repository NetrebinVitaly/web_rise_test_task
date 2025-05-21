package com.app.testnetrebin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles(profiles = "test")
@SpringBootTest
@ContextConfiguration(initializers = TestApplicationContext.class)
class TestNetrebinApplicationTests {

    @Test
    void contextLoads() {
    }

}
