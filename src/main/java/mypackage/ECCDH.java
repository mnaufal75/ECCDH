package mypackage;

import java.util.*;
import java.awt.Point;
import java.math.BigInteger;

public class ECCDH {
    int charToNumber(Character ch) {
        if (Character.isDigit(ch)) {
            return (int) ch - 48;
        } else if (Character.isAlphabetic(ch)) {
            return (int) ch - 54;
        }
    }

    Character numberToChar(int number) {
        if (number <= 9) {
            return Character.toString((char) (number + 48));
        } else {
            return Character.toString((char) (number + 54));
        }
    }

    Point additionPoint(Point p, Point q, Curve c) {
        int xr, yr;
        int gradien = (p.getY() - q.getY()) / (p.getX() - q.getX());
        xr = gradien * gradien - p.getX() - q.getX();
        yr = gradien * (p.getX() - xr) - p.getY();
        return new Point(xr, yr);
    }

    Point doublePoint(Point p, Curve c) {
        int xr, yr;
        int gradien = (3 * p.getX() * p.getX() + c.getA()) / (2 * p.getY());
        xr = gradien * gradien - 2 * p.getX();
        yr = gradien * (p.getX() - xr) - p.getY();
        return new Point(xr, yr);
    }

    Point multiplePoint(Point p, int k, Curve c) {
        if (k == 1) {
            return p;
        } else if (k == 2) {
            return doublePoint(p, c);
        } else {
            return additionPoint(doublePoint(p, c), multiplePoint(p, k - 2, c), c);
        }
    }

    // Point residueModulo(int chNumber, Curve c, int koblitzBase) {
    //     boolean found = false;
    //     int i = 1;
    //     Point p = new Point();

    //     while (i < koblitzBase && !found) {
    //         int x = chNumber * koblitzBase + i;
    //         int y = 0;
    //         while (y < c.getP() && !found) {
    //             if (y*y % c.getP() == (x*x*x + c.getA()*x + c.getB()) % c.getP()) {
    //                 found = true;
    //                 p = new Point(x, y);
    //             }
    //             y++;
    //         }
    //         i++;
    //     }
    //     return p;
    // }

    // List<Point> koblitzEncoding(String messages, Curve c, int koblitzBase) {
    //     List<Point> myList = new ArrayList<>();

    //     for (Character message : messages.toCharArray()) {
    //         myList.add(new ECCDH().residueModulo(charToNumber(message), c, koblitzBase));
    //     }

    //     return myList;
    // }

    // String koblitzDecoding(List<Point> decoded, Curve c, int koblitzBase) {
    //     String message = "";

    //     for (Point points : decoded) {
    //         Char a = new ECCDH().numberToChar(points.getX());
    //     }

    //     return message;
    // }

    // public int encrypt(String messages, Curve c, Point basePoint) {
    //     return 0;
    // }

    // public int decrypt(String messages, Curve c, Point basePoint) {
    //     return 0;
    // }

    public static void main(String[] args) {
        System.out.println("Hello world");
        Point p = new Point(2, 4);
        Point q = new Point(0, 2);
        Curve c = new Curve(-1, 188, 751);
        ECCDH ecc = new ECCDH();
        // ecc.additionPoint(p, q, c).printPoint();
        // ecc.doublePoint(p, c).printPoint();
        // a.multiplePoint(p, 10, c).printPoint();
        List<Point> hoho = ecc.koblitz("Hello", c, 4);
        for (Point po: hoho) {
            po.printPoint();
        }
    }
}