import java.util.concurrent.ArrayBlockingQueue;

public class Client {
    public static final int TOTAL_COUNT_CLIENTS = 60;
    static final int TIME_OF_ADD_CLIENT = 1000;
    private static ArrayBlockingQueue<Client> queueClients = new ArrayBlockingQueue<>(TOTAL_COUNT_CLIENTS, true);
    public static int clientCount = 0;

    private int number;

    public Client() {
        this.number = ++clientCount;
    }

    public static void putClient() {
        Client client = new Client();
        try {
            queueClients.put(client);
            System.out.println("В очередь добавлен клиент номер " + client.number);
            Thread.sleep(TIME_OF_ADD_CLIENT);
            if (clientCount < TOTAL_COUNT_CLIENTS) putClient();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ArrayBlockingQueue<Client> getQueueClients() {
        return queueClients;
    }

    public int getNumber() {
        return number;
    }

}
