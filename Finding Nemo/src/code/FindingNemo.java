package code;

import java.util.Scanner;

public class FindingNemo {

    public static boolean flood(char[][] grid, int x, int y) 
    {
        if (x == 'X' || y == 'X' || grid[x][y] != '~') 
        {
            return false;
        }
        if (x == grid.length - 2 && y == grid[0].length - 2) 
        { 
            return true;
        }

        grid[x][y] = 'X';

        return flood(grid, x + 1, y) || flood(grid, x - 1, y) || flood(grid, x, y + 1) || flood(grid, x, y - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int length = input.nextInt();
        int width = input.nextInt();

        String st = "";
		
		char[][] grid = new char[length + 2][width + 2];
			
		for(int x = 0; x < grid[0].length; x++)
		{
			grid[0][x] = 'X';
		}
			
		for(int x = 0; x < grid[0].length; x++)
		{
			grid[grid.length - 1][x] = 'X';
		}
			
		for(int x = 1; x < grid.length - 1; x++)
		{
			st = "X" + input.next() + "X";
			grid[x] = st.toCharArray();
		}
		
		//display
		for(int x = 0; x < grid.length; x++)
		{
			for(int y = 0; y < grid[0].length; y++)
			{
				System.out.print(grid[x][y] + " ");
			}
			System.out.println(" ");
		}

        boolean path = flood(grid, 1, 1);

        System.out.println(path);
    }
}