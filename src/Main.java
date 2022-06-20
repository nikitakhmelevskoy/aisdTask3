import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        LinkedListQueue<Integer> queueFirst = new LinkedListQueue<>();
        addElementsInQueue(queueFirst, 1);
        LinkedListQueue<Integer> queueSecond = new LinkedListQueue<>();
        addElementsInQueue(queueSecond, 2);

        LinkedListQueue<Integer> queueFirstFirst = new LinkedListQueue<>();
        LinkedListQueue<Integer> queueFirstSecond = new LinkedListQueue<>();
        copyElementsInQueues(queueFirstFirst, queueFirstSecond, queueFirst);

        LinkedListQueue<Integer> queueSecondFirst = new LinkedListQueue<>();
        LinkedListQueue<Integer> queueSecondSecond = new LinkedListQueue<>();
        copyElementsInQueues(queueSecondFirst, queueSecondSecond, queueSecond);

        System.out.println("Преобразование очередей на основе LinkedList: ");

        LinkedListQueue<Integer> resultQueueFirst = transformQueues(queueFirstFirst, queueSecondFirst, 1);

        LinkedListQueue<Integer> resultQueueSecond = transformQueues(queueFirstSecond, queueSecondSecond, 2);

        printListQueue(resultQueueFirst, 1);
        printListQueue(resultQueueSecond, 2);

        System.out.println("Преобразование очередей с использованием стандартной библиотеки языка Java: ");
        StandardMain.standardMain();
    }

    private static void addElementsInQueue(LinkedListQueue<Integer> listQueue, int numberQueue) {
        if (numberQueue == 1) {
            System.out.println("Введите количество элементов первой очереди: ");
        } else {
            System.out.println("Введите количество элементов второй очереди: ");
        }
        Scanner scanner = new Scanner(System.in);
        int countOfElements = scanner.nextInt();

        if (numberQueue == 1) {
            System.out.println("Введите " + countOfElements + " элементов первой очереди: ");
        } else {
            System.out.println("Введите " + countOfElements + " элементов второй очереди: ");
        }
        for (int i = 0; i < countOfElements; i++) {
            int element = scanner.nextInt();
            listQueue.addElement(element);
        }
    }

    public static LinkedListQueue<Integer> transformQueues(LinkedListQueue<Integer> queueFirst,
                                                           LinkedListQueue<Integer> queueSecond,
                                                           int numberResultQueue) throws Exception {
        LinkedListQueue<Integer> queueFirstListFirst = new LinkedListQueue<>();
        LinkedListQueue<Integer> queueFirstListSecond = new LinkedListQueue<>();

        copyElementsInQueues(queueFirstListFirst, queueFirstListSecond, queueFirst);

        LinkedListQueue<Integer> queueSecondListFirst = new LinkedListQueue<>();
        LinkedListQueue<Integer> queueSecondListSecond = new LinkedListQueue<>();

        copyElementsInQueues(queueSecondListFirst, queueSecondListSecond, queueSecond);

        LinkedListQueue<Integer> resultQueueFirst = formResultQueue(queueFirstListFirst, queueSecondListFirst);
        LinkedListQueue<Integer> resultQueueSecond = formResultQueue(queueSecondListSecond, queueFirstListSecond);

        if (numberResultQueue == 1) {
            return resultQueueFirst;
        } else {
            return resultQueueSecond;
        }
    }

    public static void copyElementsInQueues(LinkedListQueue<Integer> queueListFirst,
                                            LinkedListQueue<Integer> queueListSecond,
                                            LinkedListQueue<Integer> queue) throws Exception {
        int count = queue.count();
        for (int i = 0; i < count; i++) {
            queueListFirst.addElement(queue.getFirstElement());
            queueListSecond.addElement(queue.getFirstElement());
            queue.removeFirstElement();
        }
    }

    private static LinkedListQueue<Integer> formResultQueue(LinkedListQueue<Integer> queueFirst,
                                                            LinkedListQueue<Integer> queueSecond) throws Exception {
        int count = queueSecond.count();
        for (int i = 0; i < count; i++) {
            queueFirst.addElement(queueSecond.getFirstElement());
            queueSecond.removeFirstElement();
        }

        return queueFirst;
    }

    private static void printListQueue(LinkedListQueue<Integer> listQueue, int numberQueue) throws Exception {
        if (numberQueue == 1) {
            System.out.print("Первая очередь: ");
        } else {
            System.out.print("Вторая очередь: ");
        }

        int count = listQueue.count();
        for (int i = 0; i < count - 1; i++) {
            System.out.print(listQueue.getFirstElement() + ", ");
            listQueue.removeFirstElement();
        }
        System.out.println(listQueue.getFirstElement());
    }
}