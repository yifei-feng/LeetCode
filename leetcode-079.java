class Solution {
    
    private char[][] board;
    private boolean[][] visited;
    private String word;
    private int rows, columns;
    private int wordLength;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.columns = board[0].length;
        this.wordLength = word.length();
        // skip checking the 2D board length for each dimension
        // skip checking the length of given word

        this.visited = new boolean[rows][columns];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(board[i][j]==word.charAt(0)){
                    if(find(i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean find(int row, int column, int targetIndex){
        // when called, current (row, column) match target char
        
        // recursion termination
        if(targetIndex==wordLength-1){
            return true;
        }
        
        visited[row][column]=true;
        
        // up
        boolean up = false;
        if(row-1>=0 && !visited[row-1][column]){
            if(board[row-1][column]==word.charAt(targetIndex+1)){
                up = find(row-1, column,targetIndex+1);
                if(up){
                    return true;
                }
            }
        }
        
        // right 
        boolean right = false;
        if(column+1 <columns && !visited[row][column+1]){
            if(board[row][column+1]==word.charAt(targetIndex+1)){
                right = find(row, column+1,targetIndex+1);
                if(right){
                    return true;
                }
            }            
        }
        
        // down
        boolean down = false;
        if(row+1 < rows && !visited[row+1][column]){
            if(board[row+1][column]==word.charAt(targetIndex+1)){
                down = find(row+1, column,targetIndex+1);
                if(down){
                    return true;
                }
            }
        }
        
        // left
        boolean left = false;
        if(column-1 >= 0 && !visited[row][column-1]){
            if(board[row][column-1]==word.charAt(targetIndex+1)){
                left = find(row, column-1,targetIndex+1);
                if(left){
                    return true;
                }
            }
        }
        
        visited[row][column]=false;
        return false;
        //return up || right || down || left;
    }
}
