package com.game;

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {

		char[] board = createBoard();
		Scanner sc = new Scanner(System.in);
		char userLetter = selectLetter(sc);
		char computerLetter = ' ';
		if (userLetter == 'X') {
			computerLetter = 'O';
			System.out.println("Player has chosen " + userLetter + " and Computer has chosen O");
		} else {
			computerLetter = 'X';
			System.out.println("Player has chosen " + userLetter + " and Computer has chosen X");
		}

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
}
