package jawaHW4.task411;


public abstract class Book implements Publication {
    private final String title;
    private final String author;

    protected Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    protected void printBasicInfo() {
        System.out.println("Назва: " + title + ", автор: " + author);
    }
}