

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSearchPuzzle {

	static List<String> lines = new ArrayList<String>();

	static String[] wordlist = null;
	static String[] arr1 = null;
	static int rows = 0;
	static int columns = 0;

	public static void wordlisttoarray() throws FileNotFoundException {
		File one = new File(
				"WordList.txt");
		Scanner sc = new Scanner(one);
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		wordlist = lines.toArray(new String[0]);
	}

	public static void wordsearchtoarray() throws FileNotFoundException {
		File two = new File(
				"WordSearch.txt");
		Scanner sc = new Scanner(two);
		lines.clear();
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		arr1 = lines.toArray(new String[0]);
	}

	public static void findwords() {
		boolean result = false;
		char ch;
		rows = arr1.length;
		columns = arr1[0].length();

		for (int i = 0; i < wordlist.length; ++i) {
			wordlist[i] = wordlist[i].toUpperCase();
			ch = wordlist[i].charAt(0);
			found: for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					if (ch == arr1[j].charAt(k)) {
						
						//righttoleft
						result = righttoleft(wordlist[i], 0,
								wordlist[i].length(), j, k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "RL, found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}

						// lefttoright
						result = lefttoright(wordlist[i], 0,
								wordlist[i].length(), j, k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "LR,found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}

						// Up
						result = up(wordlist[i], 0, wordlist[i].length(), j, k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "U, found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}

						// Down
						result = down(wordlist[i], 0, wordlist[i].length(), j,
								k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "D, found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}

						// diagonalUpLeft
						result = diagonalUpLeft(wordlist[i], 0,
								wordlist[i].length(), j, k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "DUL, found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}

						// diagonalUpRight
						result = diagonalUpRight(wordlist[i], 0,
								wordlist[i].length(), j, k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "DUR, found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}

						// diagonalDownLeft
						result = diagonalDownLeft(wordlist[i], 0,
								wordlist[i].length(), j, k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "DDL, found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}

						// diagonalDownRight
						result = diagonalDownRight(wordlist[i], 0,
								wordlist[i].length(), j, k);
						if (result != false) {
							System.out.println(wordlist[i] + ","
									+ "DDR, found at row " + (j + 1)
									+ ", column " + (k + 1));
							break found;
						}
					}
				}
			}
		}
	}

	public static boolean righttoleft(String word, int ch_position, int len,
			int j, int k) {
		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (k > 0 && word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = righttoleft(word, ch_position + 1, len, j, k - 1);
		}
		return result;
	}

	public static boolean lefttoright(String word, int ch_position, int len,
			int j, int k) {

		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (k < columns && word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = lefttoright(word, ch_position + 1, len, j, k + 1);
		}
		return result;
	}

	public static boolean up(String word, int ch_position, int len, int j, int k) {
		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (0 <= (j - 1) && word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = up(word, ch_position + 1, len, j - 1, k);
		}
		return result;
	}

	public static boolean down(String word, int ch_position, int len, int j,
			int k) {
		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (rows > (j + 1) && word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = down(word, ch_position + 1, len, j + 1, k);
		}
		return result;
	}

	public static boolean diagonalUpLeft(String word, int ch_position, int len,
			int j, int k) {
		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (0 < k && 0 < j && word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = diagonalUpLeft(word, ch_position + 1, len, j - 1, k - 1);
		}
		return result;
	}

	public static boolean diagonalUpRight(String word, int ch_position,
			int len, int j, int k) {
		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (columns > k && 0 < j
				&& word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = diagonalUpRight(word, ch_position + 1, len, j - 1, k + 1);
		}
		return result;
	}

	public static boolean diagonalDownLeft(String word, int ch_position,
			int len, int j, int k) {
		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (rows > (j) && 0 < k
				&& word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = diagonalDownLeft(word, ch_position + 1, len, j + 1, k - 1);
		}
		return result;
	}

	public static boolean diagonalDownRight(String word, int ch_position,
			int len, int j, int k) {
		boolean result = false;
		if (ch_position == len) {
			return true;
		}

		if (rows > (j) && columns > k
				&& word.charAt(ch_position) == arr1[j].charAt(k)) {
			result = diagonalDownRight(word, ch_position + 1, len, j + 1, k + 1);
		}
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		wordlisttoarray();
		wordsearchtoarray();
		findwords();
	}

}
