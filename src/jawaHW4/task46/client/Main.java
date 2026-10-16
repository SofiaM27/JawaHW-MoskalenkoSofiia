package jawaHW4.task46.client;


import jawaHW4.task46.base.BaseItem;

public class Main {
    public static void main(String[] args) {
        BaseItem item = new BaseItem();

        item.showPublic();

        BaseItem.checkInsidePackage();

        ChildItem child = new ChildItem();
        child.checkFromSubclass();


    }
}
