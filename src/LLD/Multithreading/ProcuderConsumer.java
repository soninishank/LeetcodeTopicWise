//package LLD.Multithreading;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingDeque;
//
//public class ProcuderConsumer {
//    public static void main(String[] args) {
//        BlockingDeque<Item> itemBlockingDeque = new ArrayBlockingQueue<>(10); // multiple producer & consumer can access this thread
//        // Producer
//        final Runnable producer = () -> {
//            while (true) {
//                itemBlockingDeque.add(createItem());
//            }
//        };
//        new Thread(producer).start();
//        new Thread(producer).start();
//
//
//        // consumer
//        final Runnable consumer = () -> {
//            while (true) {
//                Item remove = itemBlockingDeque.remove();
//                process(remove);
//            }
//        };
//        new Thread(consumer).start();
//        new Thread(consumer).start();
//        Thread.sleep(1000);
//    }
//}
