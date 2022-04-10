package lesson5;

import java.util.concurrent.ArrayBlockingQueue;

public class Tunnel extends Stage {
    ArrayBlockingQueue<Car> abq = new ArrayBlockingQueue<>(MainClass.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            abq.put(c);
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            abq.take();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
