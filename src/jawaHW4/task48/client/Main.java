package jawaHW4.task48.client;


import jawaHW4.task48.pool.Connection;
import jawaHW4.task48.pool.ConnectionManager;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Connection connection = ConnectionManager.getConnection();

            if (connection == null) {
                break;
            }

            connection.connect();
        }
    }
}