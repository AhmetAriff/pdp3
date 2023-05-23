public class Colony {

    public Colony(int population) {
        this.population = population;
        this.foodStock=population*population;
        this.win=0;
        this.lose=0;
        this.tactic = new ATactic();
        this.production = new AProduction();
    }

    public Character symbol;

    public int population;

    public int foodStock;

    public int win;

    public int lose;

    public Tactic tactic;

    public Production production;
}
