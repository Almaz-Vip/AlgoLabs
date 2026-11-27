package ru.almazvip.lab6;

public class Diplomas {
    private static boolean canFit(int side, int n, int w, int h) {
        int cols = side / w;
        int rows = side / h;

        if (cols == 0 || rows == 0) return false;
        return cols >= (n + rows - 1) / rows;
    }

    static int search(int w, int h, int n) {
        int left = 0;
        int right = Math.max(w, h) * n;

        while (right - left > 1) {
            int mid = left + (right - left) / 2;

            if (canFit(mid, n, w, h)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }
}
