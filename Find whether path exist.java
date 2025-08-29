import java.util.*;

class Solution {
    public boolean is_Possible(int[][] grid) {
        int n = grid.length;
        int sx = -1, sy = -1; // source coordinates

        // Find source (1) and destination (2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sx = i; sy = j;
                    break;
                }
            }
        }

        if (sx == -1) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // out of bounds
                if (visited[nx][ny] || grid[nx][ny] == 0) continue;   // wall or visited

                if (grid[nx][ny] == 2) return true; // destination reached

                // Traverse blank cell
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }

        return false; // no path found
    }
}
