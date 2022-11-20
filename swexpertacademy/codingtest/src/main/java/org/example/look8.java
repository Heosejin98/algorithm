package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class look8 {


	public void look8(){
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		boolean[] check2 = new boolean[T];
		Arrays.fill(check2, true);

		for (int test_case = 0; test_case < T; test_case++) {
			boolean[] check = new boolean[8];
			Arrays.fill(check, false);
			int cnt = 0;
			for (int row = 0; row < 8; row++) {

				String str = sc.next();
				int col = 0;
				boolean colcheck = false;

				for (char c : str.toCharArray()) {
					if (c == 'O') {
						cnt++;
						if (check[col] || colcheck) {
							check2[test_case] = false;
							break;
						}
						colcheck = true;
						check[col] = true;
					}
					if (!check2[test_case])
						break;
					col++;
				}
			}
			if (cnt != 8) {
				check2[test_case] = false;
			}
		}

		for (int test_case = 0; test_case < T; test_case++) {
			if (check2[test_case])
				System.out.println("#"+ test_case + " yes");
			else
				System.out.println("#" + test_case + " no");
		}
	}
}
