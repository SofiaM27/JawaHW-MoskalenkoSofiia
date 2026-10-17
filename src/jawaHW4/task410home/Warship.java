package jawaHW4.task410home;

public abstract class Warship implements Ship {
    private String name;
    private int crew;

    public Warship(String name, int crew) {
        this.name = name;
        this.crew = crew;
    }

    @Override
    public void sail() {
        System.out.println(name + " пливе по морю.");
    }

    @Override
    public void showInfo() {
        System.out.println("Назва корабля: " + name);
        System.out.println("Кількість екіпажу: " + crew);
    }

    public abstract void attack();
}