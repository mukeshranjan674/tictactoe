package com.game;

public class TicTacToeGame {

	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 1; i <= 9; i++) {
			board[i] = ' ';
		}
		return board;
	}
	
	
	public static void main(String[] args) {
		
		char[] board = createBoard();
	}

}
