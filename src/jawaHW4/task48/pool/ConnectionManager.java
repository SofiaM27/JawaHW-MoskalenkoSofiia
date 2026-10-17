package jawaHW4.task48.pool;


public final class ConnectionManager {
    private static final Connection[] CONNECTIONS = new Connection[3];
    private static int nextIndex = 0;

    static {
        for (int i = 0; i < CONNECTIONS.length; i++) {
            CONNECTIONS[i] = new Connection(i + 1);
        }
    }

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (nextIndex >= CONNECTIONS.length) {
            System.out.println("Вільних об'єктів немає. Менеджер завершив роботу.");
            return null;
        }

        return CONNECTIONS[nextIndex++];
    }
}