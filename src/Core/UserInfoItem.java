package Core;

public class UserInfoItem {
    public enum USERTYPE { Buyer, Seller }
    public String name;
    public USERTYPE userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public USERTYPE getType() {
        return userType;
    }

    public void setType(USERTYPE userType) {
        this.userType = userType;
    }
}
