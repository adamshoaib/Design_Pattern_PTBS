package Core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Facade implements VisitableItem {

    private Integer userType;
    private Product theSelectedProduct;

    private Integer nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;
    private DataHandler dh;

    Scanner scanner= new Scanner(System.in); //System.in is a standard input stream
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public boolean login(String userName, String password) throws FileNotFoundException {
        System.out.println("**** Inside Facade Login Function ****");
        try {
            if(dh.fetchPassword(userName).equals(password)) {
                thePerson = createUser(userName);
                attachProductToUser(thePerson);
                //  productOperation();
                this.theSelectedProduct = selectProduct();
                this.theSelectedProduct = selectProductLevel();
                this.displayMenu();
            }
        }
        catch(Exception ex) {
            System.out.println("Incorrect credentials Provided.");
            System.out.println("or Please check the file path in Data Handler java file.");
        }
        return true;
    }

    void attachProductToUser(Person person) throws Exception {
        person.addProduct(dh.productsForUsers(person.userName));
    }

    private Person createUser(String userName) throws Exception {
        System.out.println("*** Creating New User ***");
        return dh.assignPersonObj(userName);
    }

    void menuDisplay() throws Exception {
        thePerson.showMenu();
    }
    ClassProductList getAllProducts() {
        return theProductList;
    }
    @Override
    public void accept(NodeVisitor visitor) {
        System.out.println("*** VISITOR PATTERN ***");
        visitor.visit(this);
    }

    public void addTrading() {}

    public void viewTrading() {}

    public void decideBidding() {}

    public void discussBidding() {}

    public void submitBidding() {}

    public void remind() {
        accept(new VisitAllNodeVisitor());
    }

    public void createProductList() {
        try {
            theProductList = new ClassProductList(dh.productInitilization());
            for (Object product : theProductList) {
                ((Product) product).addTrading(new Trading(new Date()));
            }
        } catch(Exception exception) {
            ArrayList<Product> pl = new ArrayList<Product>();
            this.theProductList.addAll(pl);
        }
    }

    public void viewOffering() {}

    public void markOffering() {}

    public void submitOffering() {}

    public void attachProductToUser() {}
    public Product selectProduct() {
        System.out.println("**** Iterator pattern ****");
        System.out.println("**** Product Iterator : Iterator Pattern ****");
        ProductIterator itr = (ProductIterator) thePerson.getListOfProductsAdded().iterator();
        int index = 0;
        while(itr.hasNext()) {
            System.out.println("Index : " + index + ": Id :" + itr.next().id);
            index++;
        }
        System.out.println("Please Enter the product :");
        try {
            index = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        Product prod = (Product) thePerson.getListOfProductsAdded().get(index);
        return prod;
    }

    public void productOperation() {
        if(thePerson!=null) {
            thePerson.createProductMenu(nProductCategory);
        }
    }

    void showMenu() throws Exception {
        thePerson.getListOfProductsAdded();
    }

    public int productLevelSelection() {
        System.out.println("Enter the type of Product:");
        System.out.println("0 for Meat Product Menu");
        System.out.println("1 for Produce Product Menu");
        try {
            int index = Integer.parseInt(bufferedReader.readLine());
            return index;
        } catch (IOException ioe) {
            System.out.println("OOPS something went wrong : " + ioe);
        }
        return 0;
    }

}