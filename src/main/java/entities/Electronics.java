package entities;

/**
 * Created by lavi on 3/2/2016.
 */
public class Electronics extends Product{

    /*public Electronics(String article, String productName, String currency, String amount, boolean isInStock, String partialPayment) {
        super(article, productName, currency, amount, isInStock, partialPayment);
    }*/

    @Override
    public String toString() {
        return "Electronics{} " + super.toString();
    }
}
