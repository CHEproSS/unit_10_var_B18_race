package Main;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();

        race.addCar(0, 10);
        race.addCar(5, 8);
        race.addCar(10, 12);
        race.addCar(15, 6);

        System.out.println("Number of overtakes: " + race.countOvertakes());
    }
}