package jawaHW4.task48.pool;

public class Connection {
    private final int id;

    Connection(int id) {
        this.id = id;
    }

    public void connect() {
        System.out.println("Працює Connection №" + id);
    }
}