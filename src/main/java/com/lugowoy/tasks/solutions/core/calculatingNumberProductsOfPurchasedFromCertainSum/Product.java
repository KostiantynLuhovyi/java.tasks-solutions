package com.lugowoy.tasks.solutions.core.calculatingNumberProductsOfPurchasedFromCertainSum;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 11-Feb-17.
 */

public final class Product implements Serializable, Cloneable {

    private BigDecimal price;

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice());
    }

    @Override
    public String toString() {
        return "Product[" +
                "price=" + price +
                ']';
    }

    @Override
    public Product clone() {
        Product product = new Product();
        try {
            product = (Product) super.clone();
            product.setPrice(new Cloner().deepClone(this.getPrice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if ((price != null) && (price.doubleValue() > 0)) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("The value of price passed by argument is incorrect.");
        }
    }

}
