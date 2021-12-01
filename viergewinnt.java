import java.util.Scanner;

public class viergewinnt {

	/**
	 * @author Milena Jerotijevic-Viergewinnt
	 */
	public static void anzeige(String str) {

		System.out.print(str);
	}

	public static void main(String argvs[]) {
		spiel();
	}

	public static void spiel() {
		int a, counter = 0, x, xi, y, xMax = 0, yMax = 0;
		String spieler1, spieler2, eingabe = "";
		Scanner input = new Scanner(System.in);
		anzeige("Spieler 1, bitte ihren Namen eingeben: ");
		spieler1 = input.nextLine();
		anzeige("Spieler 2, bitte ihren Namen eingeben: ");
		spieler2 = input.nextLine();
		anzeige("Bitte gib die Abmessungen des Spielfeldes an:\nSpalten: ");
		while (xMax * yMax <= 16) {
			xMax = input.nextInt();
			anzeige("Zeilen: ");
			yMax = input.nextInt();

		}
		int h[] = new int[xMax];
		String feld[][] = new String[xMax][yMax + 1];

		for (y = yMax; y >= 0; y--) {
			for (x = 0; x <= (xMax - 1); x++) {
				feld[x][y] = "  ";
			}
		}
		for (x = 0; x <= (xMax - 1); x++) {
			if (x + 1 <= 9)
				feld[x][0] = (" " + (x + 1));
			else
				feld[x][0] = "" + (x + 1);
		}
		anzeige("\n-");
		for (x = 1; x <= xMax; x++) {
			anzeige("-----");
		}
		anzeige("\n-");
		for (x = 1; x <= xMax; x++) {
			anzeige("-----");
		}
		anzeige("\n");
		for (y = yMax; y >= 0; y--) {
			for (x = 0; x <= (xMax - 1); x++) {
				anzeige("| " + feld[x][y] + " ");
			}
			anzeige("|\n-");
			for (x = 1; x <= xMax; x++) {
				anzeige("-----");
			}
			anzeige("\n");
		}
		while (counter <= ((yMax * xMax) - 1)) {
			a = counter % 2;
			if (a == 0) {
				xi = -1;
				do {
					xi = -1;
					anzeige(spieler1 + ", welche Spalte waehlst du?");
					while (((xi >= 0) && (xi <= (xMax - 1)) && (h[xi] != yMax)) == false) {
						xi = -1;
						anzeige("\nx= ");
						xi = input.nextInt() - 1;
						if ((xi < 0) || (xi > (xMax - 1))) {
							anzeige("\n-");
							for (x = 1; x <= xMax; x++) {
								anzeige("-----");
							}
							anzeige("\n-");
							for (x = 1; x <= xMax; x++) {
								anzeige("-----");
							}
							anzeige("\n");
							for (y = yMax; y >= 0; y--) {
								for (x = 0; x <= (xMax - 1); x++) {
									anzeige("| " + feld[x][y] + " ");
								}
								anzeige("|\n-");
								for (x = 1; x <= xMax; x++) {
									anzeige("-----");
								}
								anzeige("\n");
							}
							anzeige("Wert Ungueltig\nBitte neu eingeben");
							xi = -1;
						} else {
							if (h[xi] == yMax) {
								anzeige("\n-");
								for (x = 1; x <= xMax; x++) {
									anzeige("-----");
								}
								anzeige("\n-");
								for (x = 1; x <= xMax; x++) {
									anzeige("-----");
								}
								anzeige("\n");
								for (y = yMax; y >= 0; y--) {
									for (x = 0; x <= (xMax - 1); x++) {
										anzeige("| " + feld[x][y] + " ");
									}
									anzeige("|\n-");
									for (x = 1; x <= xMax; x++) {
										anzeige("-----");
									}
									anzeige("\n");
								}
								anzeige("Spalte voll, such dir 'ne andere!\n" + spieler1
										+ ", welche Spalte waehlst du?");
							}
						}
					}
				} while (feld[xi][h[xi] + 1] != "  ");
				{
					counter++;
					feld[xi][h[xi] + 1] = (" X");
					h[xi]++;
				}
			} else {
				xi = -1;
				do {
					xi = -1;
					anzeige(spieler2 + ", welche Spalte waehlst du?");
					while (((xi >= 0) && (xi <= (xMax - 1)) && (h[xi] != yMax)) == false) {
						xi = -1;
						anzeige("\no= ");
						xi = input.nextInt() - 1;
						if ((xi < 0) || (xi > (xMax - 1))) {
							anzeige("\n-");
							for (x = 1; x <= xMax; x++) {
								anzeige("-----");
							}
							anzeige("\n-");
							for (x = 1; x <= xMax; x++) {
								anzeige("-----");
							}
							anzeige("\n");
							for (y = yMax; y >= 0; y--) {
								for (x = 0; x <= (xMax - 1); x++) {
									anzeige("| " + feld[x][y] + " ");
								}
								anzeige("|\n-");
								for (x = 1; x <= xMax; x++) {
									anzeige("-----");
								}
								anzeige("\n");
							}
							anzeige("Wert Ungueltig\nBitte neu eingeben");
							x = -1;
						} else {
							if (h[xi] == yMax) {
								anzeige("\n-");
								for (x = 1; x <= xMax; x++) {
									anzeige("-----");
								}
								anzeige("\n-");
								for (x = 1; x <= xMax; x++) {
									anzeige("-----");
								}
								anzeige("\n");
								for (y = yMax; y >= 0; y--) {
									for (x = 0; x <= (xMax - 1); x++) {
										anzeige("| " + feld[x][y] + " ");
									}
									anzeige("|\n-");
									for (x = 1; x <= xMax; x++) {
										anzeige("-----");
									}
									anzeige("\n");
								}
								anzeige("Spalte voll, such dir 'ne andere!\n" + spieler2
										+ ", welche Spalte waehlst du?");
							}
						}
					}
				} while (feld[xi][h[xi] + 1] != "  ");
				counter++;
				feld[xi][h[xi] + 1] = (" O");
				h[xi]++;
			}
			anzeige("\n-");
			for (x = 1; x <= xMax; x++) {
				anzeige("-----");
			}
			anzeige("\n-");
			for (x = 1; x <= xMax; x++) {
				anzeige("-----");
			}
			anzeige("\n");
			for (y = yMax; y >= 0; y--) {
				for (x = 0; x <= (xMax - 1); x++) {
					anzeige("| " + feld[x][y] + " ");
				}
				anzeige("|\n-");
				for (x = 1; x <= xMax; x++) {
					anzeige("-----");
				}
				anzeige("\n");
			}
		}
	}
}