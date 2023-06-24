public class Calculator {

    private String level;
    public int sum (int a, int b){
        return a+b;
    }

    public int divInt(int a, int b){
        return a/b;
    }

    public double divDouble(double a, double b){
        return a/b;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
