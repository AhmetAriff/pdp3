import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Colony> colonies = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Populations: ");
        String input = scanner.nextLine();
        String[] populations = input.split(" ");

        for (String Population : populations) {
            int population = Integer.parseInt(Population);
            Colony colony = new Colony(population);
            colonies.add(colony);
        }

        Game game = new Game(colonies);
        game.startGame();




        System.out.println("basliyoruz");
    }
}