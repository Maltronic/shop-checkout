package io.maltronic.checkout.resources;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketResourceTest {
    private BasketResource basketResource;

    @Before
    public void setup() {
        basketResource = new BasketResource();
    }

    @Test
    public void testTotalBasic() throws Exception {
        String input = "Apple";
        Response result = basketResource.totalBasket(input);
        assertThat(result.getEntity()).isEqualTo(0.60);
    }

    @Test
    public void testTotalWithTwoTypes() throws Exception {
        String input = "Apple,Orange";
        Response result = basketResource.totalBasket(input);
        assertThat(result.getEntity()).isEqualTo(0.85);
    }

    @Test
    public void testTotalWithMultiples() throws Exception {
        String input = "Apple,Apple";
        Response result = basketResource.totalBasket(input);
        assertThat(result.getEntity()).isEqualTo(1.20);
    }
}