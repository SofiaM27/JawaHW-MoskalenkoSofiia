package jawaHW4.task410home;

public class AircraftCarrier extends Warship {
    private int aircraftCount;

    public AircraftCarrier(String name, int crew, int aircraftCount) {
        super(name, crew);
        this.aircraftCount = aircraftCount;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Кількість літаків: " + aircraftCount);
    }

    @Override
    public void attack() {
        System.out.println("Авіаносець запускає літаки для атаки.");
    }
}