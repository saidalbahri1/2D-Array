package javaapplication1;
import java.util.*;
public class Main 
{
    public static boolean isItMultByMidElement(int n, int midElement)
    {
        while (n > 0)
        {
            n -= midElement;
        }
        while (n < 0)
        {
            n += midElement;
        }
        return n == 0;
    }
    
    public static void getNeighbors(int[][] grid)
    {
        int x = 0;
        int y = 0;
        ArrayList<Integer> nbors = new ArrayList<Integer>();
        //find central element
        int[] list = new int[grid.length*grid[0].length];
        int listPos = 0;
        for(int i = 0 ; i < grid.length; i++) 
        {
            for(int j = 0; j < grid[i].length; j++) 
            {
                list[listPos++] = grid[i][j];
            }
        }
        int middle = list.length/2;
        System.out.println("Middle Element Is: ");
        System.out.println(list[middle]);
        
        //find coordinates of mid element
        //x, y are the indices where the element is located
        for(int k = 0; k < grid.length; k++)
        {
            for(int z = 0; z < grid[k].length; z++)
            {
                if(grid[k][z] == list[middle])
                {
                    x = k;
                    y = z;
                }
            }
        }
        System.out.println("Coordinates of Centeral Element:");
        System.out.printf("[%d,%d]", x, y);
        System.out.printf("\n");
        
        //Find neighbors and Add them to a 1-Dimensional Array
        int rowStart  = Math.max( x - 1, 0   );
        int rowFinish = Math.min( x + 1, grid.length - 1 );
        int colStart  = Math.max( y - 1, 0   );
        int colFinish = Math.min( y + 1, grid.length - 1 );

        for ( int curRow = rowStart; curRow <= rowFinish; curRow++ ) 
        {
            for ( int curCol = colStart; curCol <= colFinish; curCol++ ) 
            {
                if((curRow != x || curCol != y))
                {
                    if(isItMultByMidElement(grid[curRow][curCol], list[middle]) == true)
                    {
                       nbors.add(grid[curRow][curCol]); 
                    }
                }
            }
        }
        System.out.println("Immediate Neighbours Multiple By Mid Element Are:");
        System.out.println(nbors);
        
    }

    public static void main(String[] args) 
    {
        int row = 0;
        int col = 0;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Size of Matrix in Format X Y: ");
        row = scn.nextInt();
        col = scn.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("Fill Array With Numbers:");
        Scanner scn2 = new Scanner(System.in);
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                arr[i][j] = scn2.nextInt();
            }
        }
        System.out.println("The array is the following:");
        for (int k = 0; k < arr.length; k++)
        {
            System.out.println(Arrays.toString(arr[k]));
        }
        
        //find neighbours
        getNeighbors(arr);
    }   
}
