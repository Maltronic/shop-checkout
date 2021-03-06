package io.maltronic.checkout.resources;

import io.maltronic.checkout.entities.Basket;
import io.maltronic.checkout.entities.Product;
import io.maltronic.checkout.services.OffersService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

@Path("/basket")
@Consumes("application/x-www-form-urlencoded")
@Produces({"application/json", "application/xml"})
public class BasketResource {
    @POST
    @Path("/total")
    public Response totalBasket(
            @FormParam("items") String namesCommaString) {

        List<String> itemsByName = Arrays.asList(namesCommaString.split(","));
        Map<String, Product> products = this.getShopProducts();
        List<Product> items = itemsByName.stream().filter(products::containsKey)
                .map(name -> products.get(name).clone()).filter(Product::isActive).collect(Collectors.toList());
        Basket basket = new Basket(1, items);

        double total = new OffersService().getOffersTotal(items);
        return Response.ok(total).build();
    }

    private Map<String, Product> setShopProducts() {

        // @TODO Replace hardcoded products with a service
        Map<String, Product> products = new HashMap<>();
        products.put(Product.TYPE_APPLE, new Product(1, Product.TYPE_APPLE, 0.60, true));
        products.put(Product.TYPE_ORANGE, new Product(2, Product.TYPE_ORANGE, 0.25, true));

        return products;
    }

    private Map<String, Product> getShopProducts() {
        // @TODO Add product management & persistence services
        if (false) {
            // return products
        }

        return setShopProducts();
    }
}
