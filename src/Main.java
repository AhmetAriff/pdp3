import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        List<Colony> colonies = new ArrayList<>();

        List<Character> uniqueCharacters = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean control = true;

        char character = 0;

        String validSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()-_=+[]{};:,.<>?";

        int length = validSymbols.length();

        System.out.print("Enter Populations: ");
        String input = scanner.nextLine();
        scanner.close();
        String[] populations = input.split(" ");

        for (String Population : populations) {
            int population = Integer.parseInt(Population);
            control = true;
            while(control){
                character = validSymbols.charAt(random.nextInt(length));
                if(!uniqueCharacters.contains(character)){
                    uniqueCharacters.add(character);
                    control=false;
                }
            }
            Colony colony = new Colony(population);
            colony.setSymbol(character);
            colonies.add(colony);
        }

        Game game = new Game(colonies);
        game.startGame();
    }
}