import java.util.*;

// -10 for oponent sink
// 10 for my sink

// negative value for number of oponent orbs
// positive value for number of my orbs

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Hello {

    static final String BOARD_INIT = "BOARD_INIT";
    static final String YOUR_SINK = "YOUR_SINK";
    static final String OPPONENT_SINK = "OPPONENT_SINK";
    static final String MAX_CAPACITY = "MAX_CAPACITY";
    static final String MAKE_MOVE = "MAKE_MOVE";
    static final String OPPONENT_MOVE = "OPPONENT_MOVE";
    static final String VALIDATE_BOARD = "VALIDATE_BOARD";

    static int MAX_CAPACITY_VAL;

    static int ROW;
    static int COL;
    static int board[][];
    static int capacity[][];
    static ArrayList<Pair> all_sink;

    static int checkCellType(int r, int c) {
        // 0 for corner 2
        // 1 for edge 3
        // 2 for middle 4

        if ((r == 0 && c == 0) || (r == ROW - 1 && c == 0) || (r == 0 && c == COL - 1)
                || (r == ROW - 1 && c == COL - 1)) {
            return 2;
        }

        if (r == 0 || r == ROW - 1) {
            return 3;
        }

        if (c == 0 || c == COL - 1) {
            return 3;
        }

        return 4;
    }

    static boolean validCell(int r, int c) {
        if (r >= 0 && r < ROW && c >= 0 && c < COL) {
            return true;
        }
        return false;
    }

    static int move(int r, int c, int type) {

        // true for successfull

        // false for not

        if (board[r][c] == 10 || board[r][c] == -10) {
            if (capacity[r][c] == MAX_CAPACITY_VAL) {
                return 0;
            }
            capacity[r][c] = capacity[r][c] + 1;
            return 1;
        }

        if (board[r][c] == 0) {
            board[r][c] = board[r][c] + type;
            return 1;
        }

        if (board[r][c] < 0) {
            board[r][c] = Math.abs(board[r][c]) * type + type;
        }

        if (board[r][c] > 0) {
            board[r][c] = Math.abs(board[r][c]) * type + type;
        }

        if (type == Math.abs(board[r][c])) {
            // burst it
            int row[] = new int[] { -1, 0, 0, 1 };
            int col[] = new int[] { 0, -1, 1, 0 };

            int total = 0;

            for (int i = 0; i < 4; i++) {
                if (validCell(r + row[i], c + col[i])) {
                    total += move(r + row[i], c + col[i], (board[r][c] > 0 ? 1 : -1));
                }
            }

            board[r][c] = board[r][c] + (board[r][c] > 0 ? -total : +total);

        }

        return 1;
    }

    static void makeMyMove() {
        int find_row = -1;
        int find_col = -1;

        ArrayList<Pair> availablePair = new ArrayList<>();
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] != 10 && board[i][j] >= 0) {
                    availablePair.add(new Pair(i, j));

                    for (Pair sink : all_sink) {
                        if (min > Math.abs(sink.x - i) + Math.abs(sink.y - j)) {
                            min = Math.abs(sink.x - i) + Math.abs(sink.y - j);
                            index = availablePair.size() - 1;
                        }
                    }
                }
            }
        }

        if (index == -1) {
            return;
        }

        find_row = availablePair.get(index).x;
        find_col = availablePair.get(index).y;

        board[find_row][find_col] = board[find_row][find_col] + 1;
        System.out.println(find_row + " " + find_col);

        int type = checkCellType(find_row, find_col);

        if (type == Math.abs(board[find_row][find_col])) {
            // burst it
            // burst it
            int row[] = new int[] { -1, 0, 0, 1 };
            int col[] = new int[] { 0, -1, 1, 0 };

            int total = 0;

            for (int i = 0; i < 4; i++) {
                if (validCell(find_row + row[i], find_col + col[i])) {
                    total += move(find_row + row[i], find_col + col[i], (board[find_row][find_col] > 0 ? 1 : -1));
                }
            }

            board[find_row][find_col] = board[find_row][find_col] + (board[find_row][find_col] > 0 ? -total : +total);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input_code = sc.next();

            switch (input_code) {
            case BOARD_INIT: {
                ROW = sc.nextInt();
                COL = sc.nextInt();
                board = new int[ROW][COL];
                capacity = new int[ROW][COL];
                all_sink = new ArrayList<>();
                System.out.println(0);
                break;
            }
            case YOUR_SINK: {
                int cur_x = sc.nextInt();
                int cur_y = sc.nextInt();
                board[cur_x][cur_y] = 10;
                all_sink.add(new Pair(cur_x, cur_y));
                System.out.println(0);
                break;
            }
            case OPPONENT_SINK: {
                int cur_x = sc.nextInt();
                int cur_y = sc.nextInt();
                board[cur_x][cur_y] = -10;
                System.out.println(0);
                break;
            }
            case MAX_CAPACITY: {
                MAX_CAPACITY_VAL = sc.nextInt();
                System.out.println(0);
                break;
            }
            case MAKE_MOVE: {
                makeMyMove();
                break;
            }
            case OPPONENT_MOVE: {
                int cur_x = sc.nextInt();
                int cur_y = sc.nextInt();
                board[cur_x][cur_y] = board[cur_x][cur_y] - 1;

                int type = checkCellType(cur_x, cur_y);

                if (type == Math.abs(board[cur_x][cur_y])) {
                    // burst it
                    // burst it
                    int row[] = new int[] { -1, 0, 0, 1 };
                    int col[] = new int[] { 0, -1, 1, 0 };

                    int total = 0;

                    for (int i = 0; i < 4; i++) {
                        if (validCell(cur_x + row[i], cur_y + col[i])) {
                            total += move(cur_x + row[i], cur_y + col[i], (board[cur_x][cur_y] > 0 ? 1 : -1));
                        }
                    }
                    board[cur_x][cur_y] = board[cur_x][cur_y] + (board[cur_x][cur_y] > 0 ? -total : +total);
                }

                makeMyMove();
                break;
            }
            case VALIDATE_BOARD: {
                sc.nextLine();
                System.out.println(0);
                break;
            }
            default:
                System.out.println("This is the default case");
            }

        }

    }
}