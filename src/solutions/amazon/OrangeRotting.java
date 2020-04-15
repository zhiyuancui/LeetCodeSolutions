package solutions.amazon;

class OrangeRotting {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int total = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i =0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2 || grid[i][j] == 1) {
                    total++;
                }
            }
        }

        int rotten = -1;
        while(true) {

            int next = isRotten(grid);
            if(next == total) {
                break;
            } else if(next == rotten) {
                return -1;
            }
            grid = simulate(grid);
            rotten = next;
            count++;
        }

        return count;
    }



    private int isRotten(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int rotten = 0;

        for(int i =0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    rotten++;
                }
            }
        }

        return rotten;
    }


    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{1,-1,0,0};

    private int[][] simulate(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] newgrid = new int[row][col];
        //copy
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                newgrid[i][j] = grid[i][j];
            }
        }

        for(int i =0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    for(int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                            System.out.println("("+nx+","+ny+") : " + grid[nx][ny]);
                            newgrid[nx][ny] = 2;
                        }
                    }
                }
            }
        }
        return newgrid;
    }
}
