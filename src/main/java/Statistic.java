public class Statistic {
    public String typeOfStat;
    public String category;
    public int sum;
    public Statistic(String typeOfStat, String category, int sum) {
        this.typeOfStat = typeOfStat;
        this.category = category;
        this.sum = sum;
    }

    public Statistic(){}
    public String toString(){
        return typeOfStat + ": " + category + " - " + sum + "руб.";
    }
}
