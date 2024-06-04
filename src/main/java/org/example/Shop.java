package org.example;

import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public void update(Product product) {
        // Decrement sellIn
        product.setSellIn(product.getSellIn() - 1);

        // Handle quality adjustment based on product type
        switch (product.getType()) {
            case "normal":
                updateNormalProduct(product);
                break;
            case "brie":
                updateBrieProduct(product);
                break;
            case "dairy":
                updateDairyProduct(product);
                break;
            default:
                throw new IllegalArgumentException("Unknown product type: " + product.getType());
        }

        // Ensure quality is within bounds
        if (product.getQuality() < 0) {
            product.setQuality(0);
        }
        if (product.getQuality() > 50) {
            product.setQuality(50);
        }
    }

    private void updateNormalProduct(Product product) {
        if (product.getSellIn() >= 0) {
            product.setQuality(product.getQuality() - 1);
        } else {
            product.setQuality(product.getQuality() - 2);
        }
    }

    private void updateBrieProduct(Product product) {
        if (product.getSellIn() >= 0) {
            product.setQuality(product.getQuality() + 1);
        } else {
            product.setQuality(product.getQuality() + 2);
        }
    }

    private void updateDairyProduct(Product product) {
        if (product.getSellIn() >= 0) {
            product.setQuality(product.getQuality() - 2);
        } else {
            product.setQuality(product.getQuality() - 4);
        }
    }



    public void updateAllProducts() {
        for (Product product : products) {
            update(product);
        }
    }
}
