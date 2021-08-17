package solutions;

public class ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int rows = M.length;
        if (rows == 0) return new int[0][];
        int cols = M[0].length;

        int[][] result = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                int sum = 0;
                for (int incR : new int[]{-1, 0, 1}) {
                    for (int incC : new int[]{-1, 0, 1}) {
                        if (isValid(row + incR, col + incC, rows, cols)) {
                            count++;
                            sum += M[row + incR][col + incC];
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }

        return result;

    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
