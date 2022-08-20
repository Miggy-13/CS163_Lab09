import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShippingTester {
    public static boolean testCreateProduct() {
        File testFile = new File("ShipmentFolder/Product1.txt");
        try {
            Scanner testScnr = new Scanner(testFile);

            Product testProd = ShippingMain.createProduct(testScnr);

            String actual = testProd.toString();
            String expected = "22 Berk's Salt Lamps, weighing 22.5 kilograms: To be shipped to 83128, SKU: 90435765";

            if(expected.equals(actual)) return true;
            else return false;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Testing createProduct(): " + testCreateProduct() + ", should return true when implemented.");
    }
}
