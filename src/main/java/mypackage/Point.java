// package mypackage;

import java.math.BigInteger;

public class Point {
    private BigInteger x;
    private BigInteger y;

    public Point() {
        this.x = BigInteger.ZERO;
        this.y = BigInteger.ZERO;
    }

    public Point(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }

    public void printPoint() {
        System.out.println(getX() + " " + getY());
    }
}