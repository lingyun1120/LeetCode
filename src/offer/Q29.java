package offer;

public class Q29 {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int[] ret = new int[(right + 1) * (bottom + 1)];
        int index = 0;
        while (top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                ret[index++] = matrix[top][i];
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                ret[index++] = matrix[i][right];
            }
            right--;
            for(int i = right; i >= left && top <= bottom; i--) {
                ret[index++] = matrix[bottom][i];
            }
            bottom --;
            for(int i = bottom; i >= top && left <= right; i--){    //从下到上
                ret[index++] = matrix[i][left];
            }
            left ++;
        }

        return ret;
    }
}
