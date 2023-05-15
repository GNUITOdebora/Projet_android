public class Server {
    public static void main(String[] args) {
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(500);
            
            System.out.println("Server started. Waiting for client...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            
            // Read number from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String numberString = reader.readLine();
            int number = Integer.parseInt(numberString);
            System.out.println("Received number from client: " + number);

            // Perform some math on the number
            int result = number * 2;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;

        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void playGame() {
       int row;
        int column 
        System.out.println("Welcome to Tic-Tac-Toe!");

        while (!gameEnded) {
            System.out.println("Current board:");
            printBoard();

            if (currentPlayer == 'X') {
                System.out.println("Player " + currentPlayer + ", enter your move (row [0-2] and column [0-2]):");
                // ici la sockete venu du app 
                //ici
// The number to be transformed

        // Calculate the matrix position
        row = (number - 1) / 3;
        column = (number - 1) % 3;
               
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;

                    if (hasWon(currentPlayer)) {
                        System.out.println("Congratulations, Player " + currentPlayer + "! You won!");
                        gameEnded = true;
                    } else if (isBoardFull()) {
                        System.out.println("It's a tie!");
                        gameEnded = true;
                    } else {
                        currentPlayer = 'O';
                    }
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } else {
                System.out.println("AI's turn...");
                makeAIMove();

                if (hasWon(currentPlayer)) {
                    System.out.println("AI has won!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    currentPlayer = 'X';
                }
            }
        }

        System.out.println("Game over.");
        printBoard();
        scanner.close();
  int number = row * 3 + column + 1;
            // Send the result back to the client
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(result);
            System.out.println("Sent result to client: " + result);

            // Close the sockets
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void makeAIMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = currentPlayer;
                    int score = minimax(board, 0, false);
                    board[i][j] = ' ';

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
// ici l envoi du deplacment du AI 
        //ici
        board[bestRow][bestCol] = currentPlayer;
    }

    private int minimax(char[][] board, int depth, boolean isMaximizing) {
        if (hasWon('X')) {
            return -1;
        }
        if (hasWon('O')) {
            return 1;
        }
        if (isBoardFull()) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = ' ';

                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = ' ';

                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        return board[row][col] == ' ';
    }

    private boolean hasWon(char player) {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }

            // Check columns
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
    }
}
