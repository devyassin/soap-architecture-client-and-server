import proxy.Product;
import proxy.ProductServiceImpl;
import proxy.ProductWS;

public class ClientWS {
    public static void main(String[] args) {

        ProductServiceImpl stub=new ProductWS().getProductServiceImplPort();

        // Test selling price calculation
        System.out.println("Selling Price for 100.00: " + stub.sellingPrice(100.00));
        System.out.println("----------- Products list before addition -------");

        // Get and display all products before adding a new one
        showProducts(stub);

        // Add a new product
        Product productOne = new Product();
        productOne.setCode(780);
        productOne.setName("Bureau");
        productOne.setPrice(350.00);

        boolean isAdded = stub.addProduct(productOne);
        System.out.println("Product added successfully: " + isAdded);

        // Verify products after addition
        System.out.println("----------- Products list after addition -------");
        showProducts(stub);

        // Test deletion of a product by code
        System.out.println("Deleting product with code 44...");
        boolean isDeleted = stub.deleteProduct(44);
        System.out.println("Product deleted successfully: " + isDeleted);

        // Verify products after deletion
        System.out.println("----------- Products list after deletion -------");
        showProducts(stub);

        Product productNew = new Product();
        productNew.setCode(780);
        productNew.setName("New Product");
        productNew.setPrice(35040.00);

        stub.updateProduct(productNew);
        System.out.println("----------- Products list after Update -------");
        showProducts(stub);
    }

    private static void showProducts(ProductServiceImpl stub) {
        stub.getAllProducts().forEach(product -> {
            System.out.println("Code: " + product.getCode());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("------------------------");
        });
    }
}
