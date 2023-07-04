public class Statistic {
    public String typeOfStat;
    public String category;
    public int sum;

    public Statistic(String typeOfStat, String category, int sum) {
        this.typeOfStat = typeOfStat;
        this.category = category;
        this.sum = sum;
    }

    public Statistic() {
    }

    public String toString() {
        return typeOfStat + ": " + category + " - " + sum + "руб.";
    }

    @Override
    public boolean equals(Object o) {
        Statistic statistic = (Statistic) o;
        if (this.typeOfStat.equals(statistic.getTypeOfStat())
                & this.category.equals(statistic.getCategory())
                & this.sum == statistic.getSum()) {
            return true;
        }
        return false;
    }

    public String getTypeOfStat() {
        return typeOfStat;
    }

    public String getCategory() {
        return category;
    }

    public int getSum() {
        return sum;
    }

}
