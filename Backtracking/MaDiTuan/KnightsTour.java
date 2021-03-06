

public class KnightsTour {

	public static final int N = 8;
	
	private int[][] chessBoardArray = new int[8][8];
	private int[] xKnightMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yKnightMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) {
    	KnightsTour tour = new KnightsTour();
        tour.run(false);        
    }
	
	public KnightsTour() {
		initialize_board();
        chessBoardArray[0][0] = 0;
	}
	
	public int[][] run(boolean isSilent) {
		if (walk_board(0, 0, 1) == false) {
			if (!isSilent) {
				System.out.println("No solution. :(");
			}
		} else {
			if (!isSilent) {
				print_board();
			}
		}
		return chessBoardArray;
	}

	private boolean can_move(int x, int y) {
		return ((x >= 0) && (x < N) 
				&& (y >= 0) && (y < N) 
				&& (chessBoardArray[x][y] == -1));
	}

	private boolean walk_board(int x, int y, int m) {
		int next_x;
		int next_y;

		if (m == N * N) {
			return true;
		}

		for (int i = 0; i < N; i++) {
			next_x = x + xKnightMoves[i];
			next_y = y + yKnightMoves[i];
			if (can_move(next_x, next_y)) {
				chessBoardArray[next_x][next_y] = m;
				if (walk_board(next_x, next_y, m + 1) == true) {
					return true;
				} else {
					chessBoardArray[next_x][next_y] = -1;
				}
			}
		}
		return false;
	}

	private void print_board() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d", chessBoardArray[i][j]);
			}
			System.out.println();
		}
	}

	private void initialize_board() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chessBoardArray[i][j] = -1;
			}
		}
	}
}


            
