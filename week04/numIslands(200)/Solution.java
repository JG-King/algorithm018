class Solution {
    /**
     * 岛屿数量
     * https://leetcode-cn.com/problems/number-of-islands/
     * 时间复杂度 O(mn)  m n  行数 列数
     * 空间复杂度 O(mn)
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int r, int c){
        if(!inArea(grid, r , c)){
            return;
        }
        if(grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '2';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

    }

    private boolean inArea(char[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}