public class Request {
    private String title;
    private String date;
    private int sum;


    public Request(){}
    public Request(String title, String date, int sum){
        this.title = title;
        this.date = date;
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public int getSum() {
        return sum;
    }
}
