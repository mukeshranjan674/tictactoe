package com.capgemini.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	private static final int HEADS = 0;

	public enum Players {
		COMPUTER, PLAYER
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[] board = createBoard();
		char computerLetter = ' ';
		int movePosition = 0;

		char userLetter = selectLetter(sc);
		if (userLetter == 'X') {
			computerLetter = 'O';
			System.out.println("Player has chosen " + userLetter + " and Computer has chosen O");
		} else {
			computerLetter = 'X';
			System.out.println("Player has chosen " + userLetter + " and Computer has chosen X");
		}
		Players firstMove = getFirstPlayer();
		showBoard(board);
		movePosition = getMovePosition(sc, board);
		board = makeMove(board, movePosition, userLetter);

	}

	/**
	 * UC1
	 * 
	 * @return
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int cell = 1; cell <= 9; cell++) {
			board[cell] = ' ';
		}
		return board;
	}

	/**
	 * UC2
	 * 
	 * @param sc
	 * @return
	 */
	public static char selectLetter(Scanner sc) {
		System.out.println("Please enter X or O");
		char select = sc.next().charAt(0);
		return select;
	}

	/**
	 * UC3
	 * 
	 * @param board
	 */
	public static void showBoard(char[] board) {
		System.out.println(" " + board[1] + "   |  " + board[2] + "  |  " + board[3]);
		System.out.println("-----+-----+-----");
		System.out.println(" " + board[4] + "   |  " + board[5] + "  |  " + board[6]);
		System.out.println("-----+-----+-----");
		System.out.println(" " + board[7] + "   |  " + board[8] + "  | " + board[9]);
	}

	/**
	 * UC4
	 * 
	 * @param sc
	 * @param board
	 * @return
	 */
	public static int getMovePosition(Scanner sc, char[] board) {
		boolean isSpaceAvailable = false;
		int index = 0;
		do {
			System.out.println("Select the index from 1 to 9 to make the move");
			index = sc.nextInt();
			isSpaceAvailable = isSpaceFree(board, index);
		} while (false);
		return index;
	}

	public static boolean isSpaceFree(char[] board, int index) {
		return (board[index] == ' ') ? true : false;
	}

	/**
	 * UC5
	 * 
	 * @param board
	 * @param index
	 * @param userLetter
	 * @return
	 */
	public static char[] makeMove(char[] board, int index, char userLetter) {
		board[index] = userLetter;
		return board;
	}

	/**
	 * UC6
	 * 
	 * @return
	 */
	public static Players getFirstPlayer() {
		System.out.println("Tossing a coin...");
		int coinValue = (int) (Math.floor(Math.random() * 10) % 2);

		if (coinValue == HEADS) {
			System.out.println("It's Heads. Computer will play first move");
			return Players.COMPUTER;
		} else {
			System.out.println("It's Tails. Player will play first move");
			return Players.PLAYER;
		}
	}

	/**
	 * UC7
	 * 
	 * @param board
	 * @param letter
	 * @return
	 */
	public static String checkStatus(char[] board, char letter) {

		int index = 1;

		if ((board[1] == letter && board[4] == letter && board[7] == letter)
				|| (board[2] == letter && board[5] == letter && board[8] == letter)
				|| (board[3] == letter && board[6] == letter && board[9] == letter)
				|| (board[1] == letter && board[2] == letter && board[3] == letter)
				|| (board[4] == letter && board[5] == letter && board[6] == letter)
				|| (board[7] == letter && board[8] == letter && board[9] == letter)
				|| (board[1] == letter && board[5] == letter && board[9] == letter)
				|| (board[3] == letter && board[5] == letter && board[7] == letter))
			return "win";

		for (; index <= 9; index++) {
			if (board[index] != ' ')
				continue;
			else
				break;
		}
		if (index == 9)
			return "tie";
		else
			return "turn";
	}
	
	/**
	 * UC8
	 * @param board
	 * @param letter
	 * @return
	 */
	public static int getIndexForSuccessfulMove(char[]board , char letter) {
		int index = 1;
		for( ; index <= 9 ; index++) {
			char[]dummyBoard = board;
			if(dummyBoard[index] == ' ') {
				dummyBoard[index] = letter;
				String status = checkStatus(dummyBoard , letter);
				if(status.equals("win"))
					return index;
			}
			else
				continue;
		}
		return 0;
	}
}
