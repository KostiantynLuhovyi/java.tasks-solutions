package com.lugowoy.tasks.calculateTotalCostOfOrderingLaptopAtDiscount;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 15.06.2017.
 */

public final class Laptop implements Serializable, Cloneable {

    private long idLaptop;

    private String brandName;

    private BigDecimal price;

    public Laptop() {
    }

    public Laptop(long idLaptop, String brandName, BigDecimal price) {
        //The setters are used in the constructor, since the class is declared with the modifier final.
        this.setIdLaptop(idLaptop);
        this.setBrandName(brandName);
        this.setPrice(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;

        Laptop laptop = (Laptop) o;

        if (idLaptop != laptop.idLaptop) return false;
        if (brandName != null ? !brandName.equals(laptop.brandName) : laptop.brandName != null) return false;
        return price != null ? price.equals(laptop.price) : laptop.price == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idLaptop ^ (idLaptop >>> 32));
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Laptop[" +
                "idLaptop=" + idLaptop +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                ']';
    }

    @Override
    public Laptop clone() {
        Laptop laptop = new Laptop();
        Cloner cloner = new Cloner();
        try {
            laptop = (Laptop) super.clone();
            laptop.setIdLaptop(this.getIdLaptop());
            laptop.setBrandName(cloner.deepClone(this.getBrandName()));
            laptop.setPrice(cloner.deepClone(this.getPrice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return laptop;
    }

    public long getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(long idLaptop) {
        try {
            if (idLaptop > 0) {
                this.idLaptop = idLaptop;
            } else {
                throw new IllegalArgumentException("The value of id laptop passed by argument is less than or equal to 0.");
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        try {
            if (!brandName.equals("")) {
                this.brandName = brandName;
            } else {
                throw new IllegalArgumentException("The value of brand name of laptop passed by argument is equal to empty string.");
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        try {
            if ((price != null) && (price.doubleValue() > 0)) {
                this.price = price;
            } else {
                throw new IllegalArgumentException("The price passed by argument is incorrect.");
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
