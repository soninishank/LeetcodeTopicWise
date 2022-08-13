package LLD.Java.Encapsulation;

public class Coat {
    // this is wrong
    // use private variables because outside classes can change its value
    public double price;
    public String customer;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (customer.equals("student")) {
            this.price = price * 0.8;
        } else {
            this.price = price;
        }
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
