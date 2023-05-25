public class Colony {

    public Colony(int population) {
        this.population = population;
        this.foodStock=population*population;
        this.win=0;
        this.lose=0;
        if(population%2==0){
            this.tactic = new ATactic();
            this.production = new AProduction();
        }
        else {
            this.tactic = new BTactic();
            this.production = new BProduction();
        }
    }
    public Character symbol;

    public int population;

    public int foodStock;

    public int win;

    public int lose;

    public Tactic tactic;

    public Production production;

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
