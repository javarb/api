package co.org.osso.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiApplicationCalculatorTests {

    Calculator target = new Calculator();

    @LocalServerPort
    int port;

    @Test
    public void checkCalculatorFibonacci(){
        List<Integer> expected = Arrays.asList(1,1,2,3,5);
        List<BigInteger> actual = target.getFibonacci(5);

        for (int i = 0 ; i < expected.size() ; i++) {
            Assert.assertEquals(BigInteger.valueOf(expected.get(i)), actual.get(i));
        }

        for (int i = 0 ; i < actual.size() ; i ++) {
            Assert.assertEquals(BigInteger.valueOf(expected.get(i)), actual.get(i));
        }
    }

    @Test
    public void checkCalculatorFactorial(){
        Assert.assertEquals(BigInteger.valueOf(3_628_800), target.getFactorial(10));
    }

    @Test
    public void checkCalculatorOperationsSum(){
        Assert.assertEquals((double)12.2, target.calculate("sum", 9.1, 3.1),.001);
    }

    @Test
    public void checkCalculatorOperationsSub(){
        Assert.assertEquals((double)6.0, target.calculate("sub", 9.1, 3.1),.001);
    }

    @Test
    public void checkCalculatorOperationsMul(){
        Assert.assertEquals((double)28.21, target.calculate("mul", 9.1, 3.1),.001);
    }

    @Test
    public void checkCalculatorOperationsDiv(){
        Assert.assertEquals((double)3, target.calculate("div", 9.1, 3.1),.1);
    }

    @Test
    public void checkCalculatorOperationsDivByZero(){
        try {
            target.calculate("div", 1, 0);
            Assert.fail();
        } catch (RuntimeException re){
            Assert.assertTrue(re.getMessage().contains("Error:"));
        }
    }

    // look at databasic, this is the same mapper
    private ObjectMapper mapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    private String serialise(final Object object) throws JsonProcessingException {
        return mapper().writeValueAsString(object);
    }

    // HttpUriRequest is an interface parent of HttpPost
    // If I inline http method, what is there, comes to here
    HttpResponse send(final HttpUriRequest req) throws IOException {
        return http().execute(req);
    }

    HttpPost post(final String path, Object payload) throws JsonProcessingException, UnsupportedEncodingException {
        String uri = uri(path);
        final HttpPost req = new HttpPost(uri);
        req.setEntity(new StringEntity(serialise(payload)));
        req.setHeader("Accept", "application/json");
        req.setHeader("Content-type", "application/json");
        return req;
    }

    private CloseableHttpClient http() {
        return HttpClientBuilder.create()
                .build();
    }

    private String uri(final String path) {
        return baseUrl() + path;
    }

    private String baseUrl() {
        return "http://localhost:" + port + "/";
    }

    @Test
    public void testPost() throws Exception{
        Book book = new Book();
        book.setTitle("one");
        book.setYear("2018");
        HttpPost req = post("/api/book", book);
        HttpResponse res = send(req);
        Book bookResponse = deserialise(res, Book.class);
        Assert.assertEquals("one", bookResponse.getTitle());
        Assert.assertNotNull(bookResponse.getBookID());
    }

    // read about generic (try to understand this can be a little advanced)
    <T> T deserialise(final HttpResponse res, final Class<T> type) throws IOException {
        return mapper().readValue(EntityUtils.toString(res.getEntity()), type);
    }


}
