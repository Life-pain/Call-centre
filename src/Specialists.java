public class Specialists {
    private static final int WORKING_TIME = 3500;

    public static void workingWithClient() {
        Client client;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                client = Client.getQueueClients().take();
                System.out.printf("Клиента номер %d обслуживает специалист %s\n",
                        client.getNumber(), Thread.currentThread().getName());
                Thread.sleep(WORKING_TIME);
                if (Client.getQueueClients().isEmpty() && Client.TOTAL_COUNT_CLIENTS <= Client.clientCount)
                    Thread.currentThread().interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
