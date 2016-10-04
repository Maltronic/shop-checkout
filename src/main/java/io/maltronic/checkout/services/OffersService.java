package io.maltronic.checkout.services;

import io.maltronic.checkout.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OffersService {
    public double getOffersTotal(List<Product> items) {
        double total = 0;

        List<Product> apples = items.stream().filter(item -> item.getName().equals(Product.TYPE_APPLE)).collect(Collectors.toList());
        List<Product> oranges = items.stream().filter(item -> item.getName().equals(Product.TYPE_ORANGE)).collect(Collectors.toList());

        // Apples offer
        total += offer1(apples);

        // Oranges offer
        total += offer2(oranges);

        return total;
    }

    private double offer1(List<Product> items) {
        List<Product> offerItems = items.stream().collect(Collectors.toList());
        List<Product> nonOfferItems = new ArrayList<>();

        if (offerItems.size() % 2 != 0) {
            nonOfferItems.add(offerItems.get(offerItems.size() - 1));
            offerItems.remove(offerItems.size() - 1);
        }

        return (offerItems.stream().mapToDouble(Product::getPrice).sum()/2) + (nonOfferItems.stream().mapToDouble(Product::getPrice).sum());
    }

    private double offer2(List<Product> items) {
        List<Product> offerItems = items.stream().collect(Collectors.toList());
        List<Product> nonOfferItems = new ArrayList<>();

        while (offerItems.size() % 3 != 0) {
            nonOfferItems.add(offerItems.get(offerItems.size() - 1));
            offerItems.remove(offerItems.size() - 1);
        }

        return (offerItems.stream().mapToDouble(Product::getPrice).sum()/1.5) + (nonOfferItems.stream().mapToDouble(Product::getPrice).sum());
    }
}
