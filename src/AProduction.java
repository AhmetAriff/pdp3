import java.util.Random;

public class AProduction implements  Production {
    @Override
    public int produce() {
        Random random = new Random();
        int randomNumber = random.nextInt(10)+1;
        return randomNumber;
    }
}
