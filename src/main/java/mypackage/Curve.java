import java.math.BigInteger;

public class Curve {
    private BigInteger a = new BigInteger("1");
    private BigInteger b = new BigInteger("1");
    private BigInteger p = new BigInteger("1");

    public Curve(BigInteger a, BigInteger b, BigInteger p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }

    public BigInteger getA() {
        return a;
    }

    public BigInteger getB() {
        return b;
    }

    public BigInteger getP() {
        return p;
    }

    public void printCurve() {
        System.out.println(getA() + " " + getB() + " " + getP());
    }

    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(128);
        BigInteger p = BigInteger.valueOf(3);
        System.out.println(b.multiply(BigInteger.valueOf(2)));
    }
}