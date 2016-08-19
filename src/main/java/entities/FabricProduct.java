package entities;

/**
 * Created by lavi on 3/2/2016.
 */
public class FabricProduct extends Product{

    private String color;
    private String fabricSize;

    /*public FabricProduct(String article, String productName, String currency, String amount, boolean isInStock, String partialPayment, String color, String fabricSize) {
        super(article, productName, currency, amount, isInStock, partialPayment);
        this.color = color;
        this.fabricSize = fabricSize;
    }*/

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricSize() {
        return fabricSize;
    }

    public void setFabricSize(String fabricSize) {
        this.fabricSize = fabricSize;
    }
}
