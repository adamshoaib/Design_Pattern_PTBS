package Core;

public class MeatProductMenu implements ProductMenu{
    @Override
    public void showMenu() {
        System.out.println("___ MeatProductMenu : Show menu button ___");
    }
    @Override
    public void showAddButton() {
        System.out.println("___ MeatProductMenu : Show Add button ___");
    }
    @Override
    public void showViewButton() {
        System.out.println("___ MeatProductMenu : Show View button ___");
    }
    @Override
    public void showRadioButton() {
        System.out.println("___ MeatProductMenu : Show Radio button ___");
    }
    @Override
    public void showLabels() {
        System.out.println("___ MeatProductMenu : Show Labels ___");
    }
    @Override
    public void showComboxes() {
        System.out.println("___ MeatProductMenu : showComboxes ___");
    }
}
