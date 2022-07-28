public class Main {

    public static void main(String[] args) {
        Thread ATC = new Thread(null, Client::putClient, "Звонки");
        ATC.start();
        new Thread(null, Specialists::workingWithClient, "Иван").start();
        new Thread(null, Specialists::workingWithClient, "Олег").start();
        try {
            ATC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
