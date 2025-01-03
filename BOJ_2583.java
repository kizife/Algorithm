import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int m;
	static int n;
	static int k;
	static ArrayList<Integer> list;
	static int[][] map;

	static int size;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[m][n];
		list = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int j = y1; j < y2; j++) {
				for (int j2 = x1; j2 < x2; j2++) {
					map[j][j2] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					size = 1;
					dfs(i, j);
					list.add(size);
				}
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (int i : list) {
			System.out.print(i + " ");
		}

	}

	static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		map[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 0) {
				size++;
				dfs(nx, ny);
			}
		}
	}
}
