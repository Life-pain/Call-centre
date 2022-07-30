public class Specialists {
    private static final int WORKING_TIME = 3500;

    public static void workingWithClient() {
        Client client;
        try {
            while (true) {
                client = Client.getQueueClients().take();
                System.out.printf("Клиента номер %d обслуживает специалист %s\n",
                        client.getNumber(), Thread.currentThread().getName());
                Thread.sleep(WORKING_TIME);
                if (Client.getQueueClients().isEmpty() && Client.TOTAL_COUNT_CLIENTS <= Client.clientCount)
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
