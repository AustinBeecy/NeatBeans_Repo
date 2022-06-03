package grocery;

/**
 *
 * @author Jd3ab
 */
public class Inventory {

    String areaID;
    String productID;
    int productQuant;

    public Inventory (String areaID, String productID, int productQuant) {
        this.areaID = areaID;
        this.productID = productID;
        this.productQuant = productQuant;
    }
    
    public String getAreaID() {
        return this.areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public String getProduct_ID() {
        return this.productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getProductQuant() {
        return this.productQuant;
    }

    public void setProductQuant(int productQuant) {
        this.productQuant = productQuant;
    }
}
