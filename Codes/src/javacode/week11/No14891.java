package javacode.week11;

import java.io.*;
import java.util.*;

public class No14891 {
    static Chain chain1 = new Chain();
    static Chain chain2 = new Chain();
    static Chain chain3 = new Chain();
    static Chain chain4 = new Chain();
    static List<Chain> chains = Arrays.asList(chain1, chain2, chain3, chain4);
    static List<TurnChain> turnList = new ArrayList<>();
    static List<TurnChain> turnAtOnce = new ArrayList<>();

    static class Chain {
        Deque<Character> leftQue = new ArrayDeque<>();
        Deque<Character> rightQue = new ArrayDeque<>();
    }

    static class TurnChain {
        int chainNumber;
        int direction;
        public TurnChain(int chainNumber, int direction) {
            this.chainNumber = chainNumber;
            this.direction = direction;
        }
    }

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i < 4 ; i++) {
            initChain(chains.get(i), bf.readLine().toCharArray());
        }

        int turnCount = Integer.parseInt(bf.readLine());
        for (int i = 0 ; i < turnCount ; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            turnList.add(
                    new TurnChain(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
            );
        }
    }

    static void initChain(Chain chain, char[] charArray) {
        for (int i =2; i <= 5 ; i++) {
            chain.rightQue.offerLast(charArray[i]);
        }
        for (int i = 6 ; i<=7 ; i++) {
            chain.leftQue.offerLast(charArray[i]);
        }
        for (int i = 0 ; i <= 1 ; i++) {
            chain.leftQue.offerLast(charArray[i]);
        }
    }

    static void findTurns(TurnChain turn) {
        for (TurnChain turnChain : turnAtOnce) {
            if (turn.chainNumber == turnChain.chainNumber) {
                return;
            }
        }
        turnAtOnce.add(turn);
        if (getLeftTurn(turn) != null && isTurnLeft(turn.chainNumber, turn.chainNumber-1)) {
            findTurns(getLeftTurn(turn));
        }
        if (getRightTurn(turn) != null && isTurnRight(turn.chainNumber, turn.chainNumber+1)) {
            findTurns(getRightTurn(turn));
        }
    }

    static void turnChain(TurnChain turn) {
        Chain chain = getChain(turn.chainNumber);
        if (turn.direction == 1) {
            turnClockSide(chain);
        } else if (turn.direction == -1) {
            turnNonClockSide(chain);
        }
    }

    static boolean isTurnLeft(int chainNumber1, int chainNumber2) {
        return getChain(chainNumber1).leftQue.peek() != getChain(chainNumber2).rightQue.peek();
    }

    static boolean isTurnRight(int chainNumber1, int chainNumber2) {
        return getChain(chainNumber1).rightQue.peek() != getChain(chainNumber2).leftQue.peek();
    }

    static Chain getChain(int number) {
        if (number == 1)    return chain1;
        if (number == 2)    return chain2;
        if (number == 3)    return chain3;
        if (number == 4)    return chain4;
        return null;
    }

    static TurnChain getLeftTurn(TurnChain turnChain) {
        if (turnChain.chainNumber - 1 < 1) {
            return null;
        }
        int chainNumber = turnChain.chainNumber - 1;
        int direction = turnChain.direction==1 ? -1 : 1;
        return new TurnChain(chainNumber,  direction);
    }

    static TurnChain getRightTurn(TurnChain turnChain) {
        if (turnChain.chainNumber + 1 > 4) {
            return null;
        }
        int chainNumber = turnChain.chainNumber + 1;
        int direction = turnChain.direction==1 ? -1 : 1;
        return new TurnChain(chainNumber,  direction);
    }

    static void turnClockSide(Chain chain) {
        chain.rightQue.offerFirst(chain.leftQue.pollLast());
        chain.leftQue.offerFirst(chain.rightQue.pollLast());
    }

    static void turnNonClockSide(Chain chain) {
        chain.rightQue.offerLast(chain.leftQue.pollFirst());
        chain.leftQue.offerLast(chain.rightQue.pollFirst());
    }

    public static void main(String[] args) throws IOException {
        input();
        for(TurnChain turn : turnList) {
            turnAtOnce = new ArrayList<>();
            findTurns(turn);
            for (TurnChain turn1 : turnAtOnce) {
                turnChain(turn1);
            }
        }
        System.out.println(sumAllChainTop());
    }

    static int sumAllChainTop() {
        int sum = 0;
        for (int j = 0 ; j < 4 ; j++) {
            Chain chain = chains.get(j);
            int val = (int)Math.pow(2, j);
            int top = 0;
            for (int i = 0 ; i < 3 ; i++) {
                top = Character.getNumericValue(chain.leftQue.pollFirst()) * val;
            }
            sum += top;
        }
        return sum;
    }
}
