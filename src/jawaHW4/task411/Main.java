package jawaHW4.task411;

public class Main {
    public static void main(String[] args) {
        Publication[] publications = {
                new Directory("Довідник Java", "Іваненко", "Програмування"),
                new Encyclopedia("Енциклопедія науки", "Редакція", 5)
        };

        for (Publication publication : publications) {
            publication.printInfo();
            System.out.println();
        }
    }
}