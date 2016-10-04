package io.maltronic.checkout.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketEndpointTest {

    @ClassRule
    public static final ResourceTestRule testResources = ResourceTestRule.builder()
            .addResource(new BasketResource())
            .build();

    @Test
    public void testTotalBasic() throws Exception {
        String input = "Apple,Orange,Apple";
        Form fromData = new Form().param("items", input);

        assertThat(testResources.client().target("/basket/total").request().post(Entity.form(fromData)).getStatus())
                .isEqualTo(200);
    }
}