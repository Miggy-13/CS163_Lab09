import java.util.ArrayList;

public class ShippingManifest {

    ArrayList<Product> productList = new ArrayList<Product>();

    int currentLocation = 80521;

    public void addProduct(Product prod) {
        productList.add(prod);
    }

    public void printManifest() {
        for(Product p: productList) {
            System.out.println(p.toString());
        }
        if(productList.isEmpty()) System.out.println("Manifest is empty and ready to be disposed.");
    }

    public void distributeProducts() {
        int distributeCount = 0;
        ArrayList<Product> toRemove = new ArrayList<Product>();

        for(Product p: productList) {
            if(p.getDestination() == currentLocation) {
                toRemove.add(p);
                distributeCount++;
                System.out.println(p.getName() + " is being distributed to its address!");
            }
        }
        productList.removeAll(toRemove);

        System.out.println("Current Zip Code, " + currentLocation + ", had " + distributeCount + " distributions.");
    }

    public void forwardProducts(int destination) {
        int forwardCount = 0;
        ArrayList<Product> toRemove = new ArrayList<Product>();

        for(Product p: productList) {
            if(p.getDestination() == destination) {
                toRemove.add(p);
                forwardCount++;
                System.out.println(p.getName() + " is being forwarded to its destination!");
            }
        }
        productList.removeAll(toRemove);
        
        System.out.println("Provided destination of " + destination + " had " + forwardCount + " forwards.");
    }
}
