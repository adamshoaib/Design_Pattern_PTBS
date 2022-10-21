package Core;

public class UserInfoItem {
    public enum USERTYPE { Buyer, Seller }
    public String name;
    public USERTYPE type;
    public void setName(String name) {
        this.name = name;
    }
    public void setType(USERTYPE type) {
        this.type = type;
    }
}
