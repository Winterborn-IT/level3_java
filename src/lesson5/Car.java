package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {

    public static int getCarsCount() {
        return CARS_COUNT;
    }
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.cyclicBarrier.await();
            MainClass.cyclicBarrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            if (atomicBoolean.get()) {
                System.out.println(this.name + " - WIN");
                atomicBoolean.getAndSet(false);
            }

            MainClass.cyclicBarrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
