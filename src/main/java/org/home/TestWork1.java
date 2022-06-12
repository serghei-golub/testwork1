package org.home;

public class TestWork1 {
	
	static char [][] map_arr = {
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

	
	static int X =  map_arr[0].length -1;
	static int Y =  map_arr.length -1;
	static int Z = 0;
	
	public static void main(String[] args) {
		print_aray();
		scan_array();
		
		//draw_shape(map_arr[1][1], 1, 1);
		
		print_aray();
		System.out.println(" Shapes found  Z = " + Z);
	}
	
	static void scan_array() {
		for (int y = 1; y < Y; y++) {
			for (int x = 1; x < X; x++) {
				
				if (map_arr[y][x] != '*') {
					//System.out.println("Shape border found at  [" + y + "],["+ x + "]");
					Z++;
					draw_shape(map_arr[y][x], y, x);
				};
				
			}
		}
		
	}
	
	static void draw_shape(final char shape_idx, int y, int x ) {
		//if( map_arr[y][x] == shape_idx)
			map_arr[y][x] ='*';
		//Go right
		if (map_arr[y][x+1] == shape_idx) {
			draw_shape(shape_idx, y, x+1);
		}
		//Go down
		if (map_arr[y+1][x] == shape_idx) {
			draw_shape(shape_idx, y+1, x);
		}
		//Go left
		if (map_arr[y][x-1] == shape_idx) {
			draw_shape(shape_idx, y, x-1);
		}
		//Go up
		if (map_arr[y-1][x] == shape_idx) {
			draw_shape(shape_idx, y-1, x);
		}
		
	}
	
	static void print_aray() {
		System.out.println("X=" + (X-1) + " , Y=" + (Y-1));
		
		for (int y = 1; y < Y; y++) {
			for (int x = 1; x < X; x++) {
				
				System.out.print(map_arr[y][x] + " ");
				
			}
			System.out.println(" ");
		}
	}

}
