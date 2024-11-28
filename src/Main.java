public class Main {
    public static void main(String[] args) {
        Race race = new Race();

        // Add cars to the race
        race.addCar(0, 10);  // Car 1: position 0, speed 10
        race.addCar(5, 8);   // Car 2: position 5, speed 8
        race.addCar(10, 12); // Car 3: position 10, speed 12
        race.addCar(15, 6);  // Car 4: position 15, speed 6

        // Calculate and print the number of overtakes
        System.out.println("Number of overtakes: " + race.countOvertakes());
    }
}