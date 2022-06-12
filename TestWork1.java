public class TestWork1 {

	static String[][] map_arr;

	static int M, N, K;
	static int Z = 0;

	public static void main(String[] args) {
		if (args == null || args.length < 3) {
			System.out.println("ERROR! Not enough arguments.");
			System.out.println(" ");
			System.out.println(" ");
			print_help();
			return;
		}

		try {
			M = Integer.valueOf(args[0]);
			N = Integer.valueOf(args[1]);
			K = Integer.valueOf(args[2]);

		} catch (NumberFormatException e) {
			System.out.println("ERROR! Incorrect type of arguments.");
			System.out.println(" ");
			System.out.println(" ");
			print_help();
			return;
		}

		init_map(M, N, K);

		// Display generated array
		print_aray();

		scan_map();

		System.out.println("Countries found  Z = " + Z);
	}

	static void scan_map() {
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (!map_arr[y][x].equals("*")) {
					Z++;
					draw_country(map_arr[y][x], y, x);
				}
				;
			}
		}
	}

	static void draw_country(final String shape_idx, int y, int x) {
		map_arr[y][x] = "*";
		// Go right
		if (map_arr[y][x + 1].equals(shape_idx)) {
			draw_country(shape_idx, y, x + 1);
		}
		// Go down
		if (map_arr[y + 1][x].equals(shape_idx)) {
			draw_country(shape_idx, y + 1, x);
		}
		// Go left
		if (map_arr[y][x - 1].equals(shape_idx)) {
			draw_country(shape_idx, y, x - 1);
		}
		// Go up
		if (map_arr[y - 1][x].equals(shape_idx)) {
			draw_country(shape_idx, y - 1, x);
		}
	}

	static void init_map(int m, int n, int k) {
		// Define map array larger by border size
		map_arr = new String[n + 2][m + 2];

		// Fill map background with border character
		for (int y = 0; y < map_arr.length; y++) {
			for (int x = 0; x < map_arr[0].length; x++) {
				map_arr[y][x] = "*";
			}
		}
		// Generate randomized map
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				map_arr[y][x] = Integer.toString((int) (Math.random() * (K + 1)), 10);
			}
		}
	}

	static void print_aray() {
		System.out.println("M=" + M + " , N=" + N);
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				System.out.print(map_arr[y][x] + " ");
			}
			System.out.println(" ");
		}
	}

	static void print_full_aray() {
		for (int y = 0; y < map_arr.length; y++) {
			for (int x = 0; x < map_arr[0].length; x++) {
				System.out.print(map_arr[y][x] + " ");
			}
			System.out.println(" ");
		}
	}

	static void print_help() {
		System.out.println("Detect countries count on  map.");
		System.out.println("Command line arguments are : M N K");
		System.out.println("	M - horizontal map dimentsion > 0");
		System.out.println("	N - vertical map dimension > 0");
		System.out.println("	K - signs for countries [0...K] ");
		System.out.println("");
		System.out.println("EXAMPLE: java TestWork1 3 3 2");
		System.out.println("- generates a map with dimension 3x3 with 3 possible country codes.");

	}

}
