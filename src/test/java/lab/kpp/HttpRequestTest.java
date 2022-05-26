package lab.kpp;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/Data?words=what&symbol=a",
                String.class)).contains("The words \" what \" have 1 symbols \"a\"");
    }
    @Test
    public void ReturnEmpty() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/Data?words=&symbol=",
                String.class)).contains("Empty param sended");
    }
    @Test
    public void ReturnBadWord() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/Data?wordss=&symbol=",
                String.class)).contains("Bad name");
    }
}