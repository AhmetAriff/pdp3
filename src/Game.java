
import java.util.List;
import java.util.Random;

public class Game {

    public Game (List<Colony> colonies) {
            this.colonies = colonies;
            this.numberOfColonies=colonies.size();
        }
        private int tour;
        private final List<Colony> colonies;
        private  int numberOfColonies = 0;

        public void startGame(){
        while(!isItGameOver()){
            startTour();
            produceFood();

            for(int i = 0;i<numberOfColonies-1;i++){
                for(int j = i+1;j<numberOfColonies;j++){
                    startWar(colonies.get(i),colonies.get(j));
                }
            }
            clearConsole();
            System.out.println(toString());
            }
        }

        private boolean isItGameOver(){
        int count = 0;
        int i = 0;
        while (i<numberOfColonies) {
            if(colonies.get(i).population <=0  || colonies.get(i).foodStock<=0)
            {
                count++;
            }
            i++;
        }
        return count >= numberOfColonies - 1;
    }
    private void startTour(){
        for(int i =0;i<numberOfColonies;i++){
            increasePopulation(colonies.get(i));
            decreaseFoodStock(colonies.get(i));
        }
        tour++;
    }
    private void increasePopulation(Colony colony){
        if(colony.population>0 && colony.foodStock>0)
            colony.population+=(colony.population/5);
    }
    private void decreaseFoodStock(Colony colony){
        if(colony.population>0 && colony.foodStock>0)
            colony.foodStock-=(colony.population*2);
    }
    private void produceFood(){
        for(int i =0;i<numberOfColonies;i++){
            if(colonies.get(i).population>0 && colonies.get(i).foodStock>0){
                colonies.get(i).foodStock+=(colonies.get(i).production.produce());
            }
        }
    }
    private void winWar(Colony winner,Colony loser,int difference){
        int percentage = (difference/10);
        loser.population-=((loser.population/100)*percentage);
        int foodWillChange = ((loser.foodStock/100)*percentage);
        winner.foodStock+=foodWillChange;
        winner.win++;
        loser.foodStock-=foodWillChange;
        loser.lose++;

    }
    private void startWar(Colony left,Colony right){
        if(left.population>0 && right.population>0 && left.foodStock>0 && right.foodStock>0){
            int leftDamage = left.tactic.attack();
            int rightDamage = right.tactic.attack();

            if(leftDamage>rightDamage){
                int difference = leftDamage-rightDamage;
                winWar(left,right,difference);
            }
            else if(rightDamage>leftDamage){
                int difference = rightDamage-leftDamage;
                winWar(right,left,difference);
            }
            else{
                if(left.population>right.population){
                    winWar(left,right,100);//eşit değer dönmesi haline popülasyonu fazla olan kazanır 100 olarak random fark değeri verdim.
                }
                else if(right.population>left.population){
                    winWar(right,left,100);
                }
                else{
                    Random random = new Random();
                    int randomWinner = random.nextInt(2) + 1;// popülasyon sayıları da  eşitse zar atılır.
                    if(randomWinner==1){
                        winWar(left,right,100);
                    }
                    else{
                        winWar(right,left,100);
                    }
                }
            }
        }

    }
    @Override
    public String toString() {
        String str = "-----------------------------------------" +
                "\n Tour :" + tour +
                "\n Colony     Population     FoodStock       Win        Lose";
        for (int i = 0; i < numberOfColonies; i++) {

            if (colonies.get(i).population <= 0 || colonies.get(i).foodStock <= 0) {
                str += "\n  " + colonies.get(i).symbol + "             --            --            --          --   ";
            } else {
                str += "\n  "
                        + colonies.get(i).symbol
                        + "\t\t" + colonies.get(i).population
                        + "\t     " + colonies.get(i).foodStock
                        + "\t    " + colonies.get(i).win
                        + "\t\t" + colonies.get(i).lose;
            }
        }
        return str;
    }
    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
