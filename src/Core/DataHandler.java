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

    private static final String FILEPATH = "/Users/adamshoaibk/IdeaProjects/PTBSDP/src/Helper/";

    public String fetchPassword(String name) throws Exception
    {
        List<String> userDetail =  getLoginMappings("SellerInfo.txt").get(name) ;
        if(userDetail == null)
        {
            userDetail = getLoginMappings("BuyerInfo.txt").get(name);
        }
        return userDetail.get(0);
    }
    private Map<String, List<String>> getLoginMappings(String name) throws Exception
    {
        String splitString;
        HashMap<String, List<String>> keyValueMap = new HashMap<>();
        File retrievedFile = new File(FILEPATH+name);
        BufferedReader reader = new BufferedReader(new FileReader(retrievedFile));
        while((splitString = reader.readLine()) != null)
        {
            List<String> values = new ArrayList<>() ;
            String[] strArr = splitString.split(":");
            if(strArr.length == 2) {
                boolean containsValue = keyValueMap.containsKey(strArr[0]);
                if(containsValue) {
                    values = keyValueMap.get(strArr[0]);
                    values.add(strArr[1]);
                } else  {
                    values.add(strArr[1]);
                }
            }
            keyValueMap.put(strArr[0], values);
        }
        return keyValueMap;
    }

    public Person assignPersonObj(String name) throws Exception
    {
        boolean containsValue = getLoginMappings("SellerInfo.txt").containsKey(name);
        if(!containsValue)
        {
            return new Buyer(name);
        } else {
            return new Seller(name);
        }
    }

    public List<Product> productsForUsers(String user) throws Exception
    {
        Map<String, List<String>> map =  getLoginMappings("UserProduct.txt");
        List<String> productList = map.get(user);
        return productList.stream().map(strProduct -> new Product(strProduct)).collect(Collectors.toList());
    }

    public List<Product> productInitilization() throws Exception
    {
        return getLoginMappings("ProductInfo.txt").keySet().stream().map(Product::new).collect(Collectors.toList());
    }
}
