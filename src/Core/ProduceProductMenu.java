package Core;

public class ProduceProductMenu implements ProductMenu {
    @Override
    public void showMenu() {
        System.out.println("___ ProduceProductMenu : Show menu button ___");
    }
    @Override
    public void showAddButton() {
        System.out.println("___ ProduceProductMenu : Show Add button ___");
    }
    @Override
    public void showViewButton() {
        System.out.println("___ ProduceProductMenu : Show View button ___");
    }
    @Override
    public void showRadioButton() {
        System.out.println("___ ProduceProductMenu : Show Radio button ___");
    }
    @Override
    public void showLabels() {
        System.out.println("___ ProduceProductMenu : Show Labels ___");
    }
    @Override
    public void showComboxes() {
        System.out.println("___ ProduceProductMenu : showComboxes ___");
    }
}
