package jawaHW4.task411;


public class Directory extends Book {
    private final String topic;

    public Directory(String title, String author, String topic) {
        super(title, author);
        this.topic = topic;
    }

    @Override
    public void printInfo() {
        System.out.print("Довідник. ");
        printBasicInfo();
        System.out.println("Тема: " + topic);
    }
}