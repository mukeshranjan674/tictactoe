package com.capgemini.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

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
		showBoard(board);
		movePosition = getMovePosition(sc, board);
		board = makeMove(board , movePosition , userLetter);

	}

	/**
	 * UC1
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
	 */
	public static char selectLetter(Scanner sc) {
		System.out.println("Please enter X or O");
		char select = sc.next().charAt(0);
		return select;
	}

	/**
	 * UC3
	 */
	public static void showBoard(char[] board) {
		System.out.println(" " + board[1] + "   |  " + board[2] + "  |  " + board[3]);
		System.out.println("-----|-----|-----");
		System.out.println(" " + board[4] + "   |  " + board[5] + "  |  " + board[6]);
		System.out.println("-----|-----|-----");
		System.out.println(" " + board[7] + "   |  " + board[8] + "  | " + board[9]);
	}

	/**
	 * UC4
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
		return (board[index] == ' ') ?  true : false;
	}
	
	/**
	 * UC5
	 */
	public static char[] makeMove(char[]board,int index, char userLetter) {
		board[index] = userLetter;
		return board;
	}
}