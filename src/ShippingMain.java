import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ShippingMain {
    /**
     * Self Explanation
     * 
     * 
     * 
     */
    public static Product createProduct(Scanner fileScanner) {
        String name = "";
        int sku = -1;
        double price = -1;
        double weight = -1;
        int destination = -1;
        int quantity = -1;

        // TODO COMPLETED

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            if (line.contains("NAME:")) {
                name = line.substring(line.indexOf(":") + 2, line.length());
            }

            if (line.contains("SKU:")) {
                sku = Integer.parseInt(line.substring(line.indexOf(":") + 2, line.length()));

            }

            if (line.contains("PRICE:")) {
                price = Double.parseDouble(line.substring(line.indexOf(":") + 2, line.length()));

            }

            if (line.contains("WEIGHT:")) {
                weight = Double.parseDouble(line.substring(line.indexOf(":") + 2, line.length()));

            }

            if (line.contains("DESTINATION:")) {
                destination = Integer.parseInt(line.substring(line.indexOf(":") + 2, line.length()));

            }

            if (line.contains("QUANTITY:")) {
                quantity = Integer.parseInt(line.substring(line.indexOf(":") + 2, line.length()));

            }

        }

        return new Product(name, sku, price, weight, destination, quantity);
    }

    public static ShippingManifest createManifest(ArrayList<File> fileList) {
        FileHelper fileHelper = new FileHelper();
        ShippingManifest shipManifest = new ShippingManifest();

        for (File file : fileList) {
            Scanner fileScanner = fileHelper.getFileScanner(file);

            Product newProd = createProduct(fileScanner);
            shipManifest.addProduct(newProd);

            fileScanner.close();
        }

        return shipManifest;
    }

    public static void printSplash() {
        System.out.println("Please type:");
        System.out.println("\"X\" to exit program.");
        System.out.println("\"D\" to distribute products to addresses.");
        System.out.println("\"F-ZIPCODE\" to forwards products to destinations.");
        System.out.println("\"P\" to print current manifest.");
    }

    /**
     * Self Explanation
     * 
     * 
     * 
     */
    public static void go(Scanner scnr, ShippingManifest shipManifest) {
        printSplash();

        String input = scnr.nextLine();

        // TODO Student

        while ((!input.equals("X")) && (!input.equals("x"))) {
            if ((input.equals("D")) || (input.equals("d"))) {
                shipManifest.distributeProducts();
            }

            else if ((input.contains("F")) || (input.contains("f"))) {

                int argument = Integer.parseInt(input.substring(input.indexOf("-") + 1, input.length()));

                shipManifest.forwardProducts(argument);
            }

            else if ((input.equals("P")) || (input.equals("p"))) {

                shipManifest.printManifest();
            }

            else {
                System.out.println("Unrecognized command.");
            }

            input = scnr.nextLine();
        }

    }

    public static void main(String[] args) {
        String directoryPath = "ShipmentFolder";
        FileHelper fileHelper = new FileHelper();
        ArrayList<File> fileList = fileHelper.getFileDirectory(directoryPath);

        ShippingManifest shipManifest = createManifest(fileList);
        System.out.println("Manifest created from " + directoryPath + "!");

        shipManifest.printManifest();

        Scanner scnr = new Scanner(System.in);
        go(scnr, shipManifest);

    }
}