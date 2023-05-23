import java.util.Random;

public class ATactic implements  Tactic {
    @Override
    public int attack() {
        Random random = new Random();
        int randomNumber = random.nextInt(1001);
        return randomNumber;
    }
}
