package com.rany.service.client;

import com.rany.service.MasterServiceApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MasterServiceApplication.class)
public class AdminClientApiTest {

    private static final String master = "localhost";
    private static AdminClient client;

    @Before
    public void setUp() throws Exception {
        client = new AdminClient(master, 8080);
        client.init();
    }


    @After
    public void tearDown() throws Exception {
        client.shutdown();
    }

    @Test
    public void ping() {
        while (true) {
            System.out.println("holding");
        }
    }
}