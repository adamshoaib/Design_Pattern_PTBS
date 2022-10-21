package Core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataHandler {

    private static final String FOLDER_LOC = "/Users/adamshoaibk/IdeaProjects/PTBSDP/src/Helper/";

    public String fetchPassword(String name, Integer type) throws Exception
    {
        List<String> userDetail;
        if(type == 0) {
            userDetail = getLoginMappings("BuyerInfo.txt").get(name);
        } else {
            userDetail =  getLoginMappings("SellerInfo.txt").get(name);
        }

        if(userDetail == null)
        {
            System.out.println("Invalid Type Provided, Please try to login again..!");
           return " ";
        } else {
            return userDetail.get(0);
        }
    }

    // function to read the txt files and map based on ":".
    public Map<String, List<String>> getLoginMappings(String item) throws Exception
    {
        String splitString;
        HashMap<String, List<String>> keyValueMap = new HashMap<>();
        File retrievedFile = new File(FOLDER_LOC+item);
        BufferedReader reader = new BufferedReader(new FileReader(retrievedFile));
        while((splitString = reader.readLine()) != null)
        {
            List<String> list = new ArrayList<>() ;
            String[] strArr = splitString.split(":");
            boolean containsValue = keyValueMap.containsKey(strArr[0]);
            if(containsValue) {
                list = keyValueMap.get(strArr[0]);
                list.add(strArr[1]);
            } else  {
                list.add(strArr[1]);
            }
            keyValueMap.put(strArr[0], list);
        }
        return keyValueMap;
    }

    // Create buyer or seller info based on the value present in the text file.
    public Person assignPersonObj(String name) throws Exception
    {
        boolean containsValue = getLoginMappings("SellerInfo.txt").containsKey(name);
        return !containsValue ? new Buyer(name) : new Seller(name);
    }

    // get the product list for the user.
    public List<Product> productsForUsers(String user) throws Exception
    {
        Map<String, List<String>> map = getLoginMappings("UserProduct.txt");
        List<String> productList = map.get(user);
        return productList.stream().map(strProduct -> new Product(strProduct)).collect(Collectors.toList());
    }

    public List<Product> productInitilization() throws Exception
    {
        return getLoginMappings("ProductInfo.txt").keySet().stream().map(Product::new).collect(Collectors.toList());
    }
}
