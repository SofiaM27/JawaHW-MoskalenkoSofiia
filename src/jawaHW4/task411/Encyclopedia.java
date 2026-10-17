package jawaHW4.task411;

public class Encyclopedia extends Book {
    private final int volumes;

    public Encyclopedia(String title, String author, int volumes) {
        super(title, author);
        this.volumes = volumes;
    }

    @Override
    public void printInfo() {
        System.out.print("Енциклопедія. ");
        printBasicInfo();
        System.out.println("Кількість томів: " + volumes);
    }
}