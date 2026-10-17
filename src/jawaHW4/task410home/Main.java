package jawaHW4.task410home;

public class Main {
    public static void main(String[] args) {
        AircraftCarrier carrier = new AircraftCarrier("Мрія", 1200, 40);

        carrier.showInfo();
        carrier.sail();
        carrier.attack();

        System.out.println();

        Ship ship = new AircraftCarrier("Океан", 1000, 30);

        ship.showInfo();
        ship.sail();

        System.out.println();

        Warship warship = new AircraftCarrier("Перемога", 900, 25);

        warship.showInfo();
        warship.attack();
    }
}