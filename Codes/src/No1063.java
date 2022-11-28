import java.io.*;
import java.util.*;

public class No1063 {
    private static Map<String, int[]> move = new HashMap<>();
    private static char[][] board = new char[8][8];
    private static int[] kingCoordinate = new int[2];
    private static String[] commands;
    public static void main(String[] args) throws IOException {
        move.put("R", new int[]{0, 1});
        move.put("L", new int[]{0, -1});
        move.put("B", new int[]{1, 0});
        move.put("T", new int[]{-1, 0});
        move.put("RT", new int[]{-1, 1});
        move.put("LT", new int[]{-1, -1});
        move.put("RB", new int[]{1, 1});
        move.put("LB", new int[]{1, -1});
        input();
        for (String command : commands) {
            kingCoordinate = move(command, kingCoordinate);
        }
        int[] king = new int[2];
        int[] stone = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'k') {
                    king[0] = i;
                    king[1] = j;
                }
                if (board[i][j] == 's') {
                    stone[0] = i;
                    stone[1] = j;
                }
            }
        }
        System.out.println(convert(king));
        System.out.println(convert(stone));
    }
    private static String convert(int[] coordinate) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)('A' + (char)coordinate[1]));
        sb.append(8 - coordinate[0]);
        return sb.toString();
    }

    private static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String kingSite = tokenizer.nextToken();
        kingCoordinate = convert(kingSite);
        String stoneSite = tokenizer.nextToken();
        int[] tmp = convert(kingSite);
        board[tmp[0]][tmp[1]] = 'k';
        tmp = convert(stoneSite);
        board[tmp[0]][tmp[1]] = 's';
        int commandCount = Integer.parseInt(tokenizer.nextToken());
        commands = new String[commandCount];
        for (int i = 0; i < commandCount; i++) {
            commands[i] = reader.readLine();
        }
    }

    private static int[] convert(String boardSite) {
        int y = boardSite.charAt(0) - 'A';
        int x = 8 - Character.getNumericValue(boardSite.charAt(1));
        return new int[]{x, y};
    }

    private static int[] move(String command, int[] coordinate) {
        int[] movedCoordinate = executeCommand(command, coordinate);
        if (isOut(movedCoordinate)) {
            return coordinate;
        }
        int movedX = movedCoordinate[0];
        int movedY = movedCoordinate[1];
        if (board[movedX][movedY] == 's') {
            int[] stoneMoved = executeCommand(command, movedCoordinate);
            if (isOut(stoneMoved)) {
                return coordinate;
            }
            board[movedX][movedY] = '0';
            board[stoneMoved[0]][stoneMoved[1]] = 's';
        }
        board[coordinate[0]][coordinate[1]] = '0';
        board[movedX][movedY] = 'k';
        return movedCoordinate;
    }

    private static int[] executeCommand(String command, int[] coordinate) {
        int[] coordinateMove = move.get(command);
        int movedX = coordinate[0] + coordinateMove[0];
        int movedY = coordinate[1] + coordinateMove[1];
        return new int[]{movedX, movedY};
    }

    private static boolean isOut(int[] coordinate) {
        int x = coordinate[0];
        int y = coordinate[1];
        return x >= 8 || x <0 || y >= 8 || y < 0;
    }

}
