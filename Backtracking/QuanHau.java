
public class Viet {
    final int N = 8;

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        /* Kiểm tra hàng này ở phía bên trái */
        for (i = 0; i < col; i++) // kiểm tra phần tử trước col
            if (board[row][i] == 1) // Kiểm tra đằng trước nếu bằng 1 thì false
                return false;
        /* Kiểm tra đường chéo phía trên bên trái */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) // giảm i và giảm j là ta có đc vị trí chéo trên
            if (board[i][j] == 1) // tiêp tục kiểm tra nếu ==1 thì false
                return false;
        /* Kiểm tra đường chéo dưới bên trái */
        for (i = row, j = col; j >= 0 && i < N; i++, j--) // chéo dưới thì chỉ cần tăng i và giảm j
            if (board[i][j] == 1) // tiếp tục kiểm tra
                return false;

        return true; // nếu không thì true
    }

    /* Đệ quy để giải bài toán 8 quân hậu */
    boolean solveNQUtil(int board[][], int col) {
        if (col >= N) // nếu đã điền đủ quân hậu vào bàn cờ thì trả về true
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) // gọi hàm kiểm tra điều kiện, nếu true thì vị trí đó đc điền 1
            {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1) == true) // tiếp tục điền quân hậu cho cột kế tiếp col + 1, nếu true thì
                                                         // điền 1
                    return true;
                board[i][col] = 0; // BACKTRACK // nếu false thì giá trị board[i][col]=0, đây chính là bước quay
                                   // lui!!
            }
        }

        return false;
    }

    boolean solveNQ() {
        int board[][] = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String args[]) {
        Viet Queen = new Viet();
        Queen.solveNQ();
    }
}