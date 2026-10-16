package jawaHW4.task46.base;

public class BaseItem {
    protected void showProtected() {
        System.out.println("Викликано protected-метод.");
    }

    public void showPublic() {
        System.out.println("Викликано public-метод.");
    }

    public static void checkInsidePackage() {
        BaseItem item = new BaseItem();
        item.showProtected();
    }
}