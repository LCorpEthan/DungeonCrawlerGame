/**
 * Tracks the player's progress through the dungeon using a 2D Array.
 * Student Starter Code.
 */
public class DungeonMap {
    private String[][] map;
    private int bossRow;
    private int bossCol;

    /**
     * Constructor for DungeonMap. Fully provided.
     */
    public DungeonMap(int rows, int cols) {
        map = new String[rows][cols];
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                map[r][c] = "[  ?  ]";
            }
        }
        
        // Set the starting position
        map[0][0] = "[START]";
        
        // Place boss randomly, ensuring it does not spawn on the starting cell
        bossRow = 0;
        bossCol = 0;
        while (bossRow == 0 && bossCol == 0) {
            bossRow = (int)(Math.random() * rows);
            bossCol = (int)(Math.random() * cols);
        }
    }

    /**
     * Checks if a proposed move is within bounds and adjacent to a visited room.
     */
    public boolean isValidMove(int row, int col) {
        // TODO: Check if row and col are out of bounds. If so, return false.
        if(row >= map.length || col >= map[0].length || row < 0 || col < 0){
            return false;
        }
        // TODO: Check if the room at row, col is ALREADY visited (not equal to "[  ?  ]"). If so, return false.
        if(map[row][col] != "[  ?  ]"){
            return false;
        }
        
        // TODO: Check if the proposed room is adjacent (up, down, left, right) to a room that is NOT "[  ?  ]".
        // Return true if it is adjacent, false otherwise.
        if(row == 0){
            if(col == map[0].length-1){
                if(map[row+1][col] != "[  ?  ]" || map[row][col-1] != "[  ?  ]"){
                    return true;
                }
            }else{
                if(map[row+1][col] != "[  ?  ]" || map[row][col+1] != "[  ?  ]" || map[row][col-1] != "[  ?  ]"){
                    return true;
                }
            }
            return false;
        }
        
        if(row == map.length-1){
            if(col == map[0].length-1){
                if(map[row-1][col] != "[  ?  ]" || map[row][col-1] != "[  ?  ]"){
                    return true;
                }
            }else if(col == 0){
                if(map[row-1][col] != "[  ?  ]" || map[row][col+1] != "  ?  "){
                    return true;
                }
            }else{
                if(map[row-1][col] != "[  ?  ]" || map[row][col+1] != "[  ?  ]" || map[row][col-1] != "[  ?  ]"){
                    return true;
                }
            }
            return false;
        }
        
        if(col == 0){
            if(map[row+1][col] != "[  ?  ]" || map[row][col+1] != "[  ?  ]" || map[row-1][col] != "[  ?  ]"){
                return true;
            }
            return false;
        }
        
        if(col == map[0].length-1){
            if(map[row+1][col] != "[  ?  ]" || map[row][col-1] != "[  ?  ]" || map[row-1][col] != "[  ?  ]"){
                return true;
            }
            return false;
        }
        
        if(map[row+1][col] != "[  ?  ]" || map[row][col-1] != "[  ?  ]" || map[row-1][col] != "[  ?  ]" || map[row][col+1] != "[  ?  ]"){
            return true;
        }
    
        return false;
    }

    /**
     * Checks if the given coordinates match the Boss's hidden location.
     */
    public boolean isBossRoom(int row, int col) {
        // TODO: Return true if the row and col match the bossRow and bossCol.
        if(row == bossRow && col == bossCol){
            return true;
        }
        return false;
    }

    /**
     * Updates a specific cell in the 2D array to show it has been visited.
     */
    public void markVisited(int row, int col, String result) {
        // TODO: Update the cell at map[row][col] with the formatted result string.
        // Make sure you add the brackets so it stays 7 characters long. Example: "[" + result + "]"
        map[row][col] = "[" + result + "]";
        
    }

    /**
     * Builds and returns a String representation of the entire map grid.
     */
    public String printMap() {
        // TODO: Use a nested for loop to build a String showing the grid.
        // Hint: Use '\n' to move to the next line at the end of each row.
        String thingy ="";
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[r].length; c++){
                thingy += (map[r][c] + " ");
            }
            thingy += "\n";
        }
        return thingy;
    }

    /**
     * Traverses the 2D array and counts how many cells are marked exactly "[CLEAR]".
     */
    public int countCleared() {
        // TODO: Traverse the map and return the count of "[CLEAR]" rooms.
        int count = 0;
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[r].length; c++){
                if(map[r][c] == "[CLEAR]"){
                    count++;
                }
            }
        }
        return count;
    }
}