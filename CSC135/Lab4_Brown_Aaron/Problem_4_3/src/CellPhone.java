
import java.text.NumberFormat;


public class CellPhone {
    
    private String manufacturer, modelName; private double retailPrice;
    
    public CellPhone(String manufact, String model, double price) {
        manufacturer = manufact;
        modelName = model;
        retailPrice = price;
    }
    public CellPhone(){}
    
    public void setManufacturer(String manufact) {
        manufacturer = manufact;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setModel(String model) {
        modelName = model;
    }
    public String getModel(){
        return modelName;
    }
    
    public void setPrice(double price){
        retailPrice = price;
    }
    public double getPrice() {
        return retailPrice;
    }
    
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(); // converts number into a dollar amount
        String description = "Manufacturer: " + manufacturer + "\nModel: " + modelName + "\nRetail Price: " + fmt.format(retailPrice);
                
        return description;
    }
}
