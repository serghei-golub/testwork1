package org.home;

public class TestWork1 {
	
	static String [][] map_arr;
	
	//static int X;// =  map_arr[0].length -1;
	//static int Y;// =  map_arr.length -1;
	
	static int M, N, K;
	static int Z = 0;
	
	static void init(int m, int n, int k) {
		map_arr = new String[n+2][m+2];
		
		//Fill map background with border character
		for (int y = 0; y < map_arr.length; y++) {
			for (int x = 0; x < map_arr[0].length; x++) {
				map_arr[y][x] = "*";
			}
		}
		//Generate randomized map
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				map_arr[y][x] =Integer.toString((int)(Math.random() * (K+1)), 10);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		if (args == null || args.length < 3) {
			System.out.println("ERROR! Not enough arguments.");
			print_help();
			return;
		}
		
		M = Integer.valueOf(args[0]);
		N = Integer.valueOf(args[1]);
		K = Integer.valueOf(args[2]);
		
		init(M,N,K);
		
		print_aray();
		scan_array();
		System.out.println("Countries found  Z = " + Z);
	}
	
	static void scan_array() {
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (!map_arr[y][x].equals("*")) {
					Z++;
					draw_shape(map_arr[y][x], y, x);
				};
			}
		}
	}
	
	static void draw_shape(final String shape_idx, int y, int x ) {
		map_arr[y][x] ="*";
		//Go right
		if (map_arr[y][x+1].equals(shape_idx) ) {
			draw_shape(shape_idx, y, x+1);
		}
		//Go down
		if (map_arr[y+1][x].equals(shape_idx)) {
			draw_shape(shape_idx, y+1, x);
		}
		//Go left
		if (map_arr[y][x-1].equals(shape_idx)) {
			draw_shape(shape_idx, y, x-1);
		}
		//Go up
		if (map_arr[y-1][x].equals(shape_idx)) {
			draw_shape(shape_idx, y-1, x);
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
		for (int y = 0; y <  map_arr.length; y++) {
			for (int x = 0; x <  map_arr[0].length; x++) {
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
	
	static char [][] map_arr1 = {
			{'*','*','*','*','*','*','*','*'},
			{'*','0','1','1','1','1','1','*'},
			{'*','1','0','1','1','1','1','*'},
			{'*','1','1','0','1','1','1','*'},
			{'*','1','1','1','0','1','1','*'},
			{'*','1','1','1','1','0','0','*'},
			{'*','*','*','*','*','*','*','*'}
	};

	static char [][] map_arr0 = {
			{'*','*','*','*','*','*','*','*'},
			{'*','1','1','1','1','1','0','*'},
			{'*','0','0','1','0','0','0','*'},
			{'*','0','1','1','1','1','2','*'},
			{'*','0','2','1','0','0','0','*'},
			{'*','2','0','1','0','0','0','*'},
			{'*','*','*','*','*','*','*','*'}
	};

}
