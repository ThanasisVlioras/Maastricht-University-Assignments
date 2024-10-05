interface Measurer<T> {
    public double measure(T x);
}

interface Filter<T> {
    public boolean accept(T x);
}

class CarDistanceMeasurer implements Measurer<Car> {
    public double measure(Car car) {
        return car.getFuel() / car.getEfficiency();
    }
}

class CarFuelFilter implements Filter<Car> {
    public boolean accept(Car car) {
        return new CarDistanceMeasurer().measure(car) >= 100;
    }
}

class DataSet<T> {
    private double sum = 0;
    private int count = 0;

    public void add(T item, Filter<T> filter, Measurer<T> measurer) {
        if (!filter.accept(item)) return;

        sum += measurer.measure(item);
        count += 1;
    }

    public void reset() {
        sum = 0;
        count = 0;
    }

    public double getAverage() {
        return sum / count;
    }
}

public class Car {
    /** This is in liters/km */
    private double efficiency;

    private double fuel = 0;

    private static int nextMotorNumber = 1;
    private int motorNumber;

    private static String fuelRefills = "";

    public Car(double nEfficiency) {
        efficiency = nEfficiency;
        fuel = 0;

        motorNumber = nextMotorNumber;
        nextMotorNumber++;
    }

    public boolean canDrive(double distance) {
        return distance * efficiency <= fuel;
    }

    public void drive(double distance) {
        fuel = Math.max(fuel - (distance * efficiency), 0);
    }

    public double getEfficiency() {
        return efficiency;
    }
    
    public double getFuel() {
        return fuel;
    }

    public void addFuel(double nFuel) {
        fuel += nFuel;

        String entry = "Car Motor Number " + motorNumber + ": " + nFuel + " liters\n";
        fuelRefills += entry;
    }

    public static String fuelRefills() { return fuelRefills;}

    // public static void main(String[] args) {
    //     Car car1 = new Car(1);
    //     Car car2 = new Car(0.1);
        
    //     car1.addFuel(400);
    //     car2.addFuel(40);

    //     System.out.println(car1.canDrive(400));
    //     System.out.println(car2.canDrive(400));
    //     System.out.println(car1.canDrive(401));
    //     System.out.println(car2.canDrive(401));

    //     car1.drive(400);
    //     car2.drive(200);

    //     System.out.println(car1.getFuel());
    //     System.out.println(car2.getFuel());

    //     System.out.println(Car.fuelRefills());
        
    // }

    public static void main(String[] args) {
        Car car1 = new Car(1);
        Car car2 = new Car(0.1);
        
        DataSet<Car> cars = new DataSet();
        cars.add(car1, new CarFuelFilter(), new CarDistanceMeasurer());
        cars.add(car2, new CarFuelFilter(), new CarDistanceMeasurer());

        System.out.println(cars.getAverage());

        car1.addFuel(400);
        car2.addFuel(40);

        cars.reset();
        cars.add(car1, new CarFuelFilter(), new CarDistanceMeasurer());
        cars.add(car2, new CarFuelFilter(), new CarDistanceMeasurer()); 

        System.out.println(cars.getAverage());

        car1.drive(400);
        car2.drive(200);

        cars.reset();
        cars.add(car1, new CarFuelFilter(), new CarDistanceMeasurer());
        cars.add(car2, new CarFuelFilter(), new CarDistanceMeasurer()); 

        System.out.println(cars.getAverage());
        
    }
}
