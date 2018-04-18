package mypackage;

public class Curve {
    private int a;
    private int b;
    private int p;

    public Curve(int a, int b, int p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public void printCurve() {
        System.out.println(getA() + " " + getB() + " " + getP());
    }
}