package Core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Facade implements VisitableItem {

    private Integer userType;
    private UserInfoItem user;
    private Product theSelectedProduct;
    private Integer nProductCategory;
    private ClassProductList theProductList = new ClassProductList();
    private Person thePerson = null;
    private DataHandler dh;
    public Facade() {
        dh = new DataHandler();
        createProductList();
    }
    Scanner scanner= new Scanner(System.in); //System.in is a standard input stream
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public boolean login(String userName, String password, Integer type) throws FileNotFoundException {
        System.out.println("**** Inside Facade Login Function ****");

        try {
            System.out.println("Password" + dh.fetchPassword(userName).equals(password));
            if(dh.fetchPassword(userName).equals(password)) {
                user = new UserInfoItem();
                this.user.setName(userName);
                if(type == 0) {
                    this.user.setType(UserInfoItem.USERTYPE.Buyer);
                } else {
                    this.user.setType(UserInfoItem.USERTYPE.Seller);
                }
                thePerson = createUser(this.user);
                attachProductToUser(thePerson);
                this.theSelectedProduct = selectProduct();
                this.nProductCategory = productLevelSelection();
                this.optionSelection(this.user);
            }
        }
        catch(Exception ex) {
            System.out.println("Exception : " + ex);
            System.out.println("Incorrect credentials Provided.");
            System.out.println("or Please check the file path in Data Handler java file.");
        }
        return true;
    }
    private Person createUser(UserInfoItem userInfo) throws Exception {
        System.out.println("*** Creating New User in Facade ***");
        return dh.assignPersonObj(userInfo.name);
    }
    void optionSelection(UserInfoItem user) throws Exception {
        System.out.println("Select :");
        System.out.println("1. Create Product menu");
        System.out.println("2. Display Product menu");
        System.out.println("3. Remind");
        System.out.println("4. Exit");

        try {
            int userIp = Integer.parseInt(bufferedReader.readLine());
            switch(userIp) {
                case 1: {
                    productOperation();
                    optionSelection(user);
                    break;
                }
                case 2: {
                    showMenu();
                    break;
                }
                case 3: {
                    remind();
                    break;
                }
                default : {
                    System.out.println("Looks like you have selected wrong option.");
                    System.exit(1);
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println("OOPS... Something went Wrong!, Please try again Later.");
        }
    }
    void attachProductToUser(Person person) throws Exception {
        List<Product> ls = dh.productsForUsers(person.userName);
        person.addProduct(ls);
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
            System.out.println("Exception :" + exception);
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
        System.out.println("currentUser.getAddedProducts() :" + thePerson.getListOfProductsAdded());

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
        if(thePerson != null) {
            thePerson.createProductMenu(nProductCategory);
        }
    }
    void showMenu() throws Exception {
       ClassProductList cp = thePerson.getListOfProductsAdded();
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