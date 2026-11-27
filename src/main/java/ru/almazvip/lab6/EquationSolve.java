package ru.almazvip.lab6;

public class EquationSolve {
    private static double f(double x) {
        return x * x - x + Math.sqrt(x);
    }

    public static double find(int a) {
        double left = 1.0;
        double right = Math.sqrt(a) + 1.0;

        for (int i = 0; i < 100; i++) {
            double mid = left + (right - left) / 2.0;

            if (f(mid) < a) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (left + right) / 2.0;
    }
}