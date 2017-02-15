package org.asaph.happynumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static int nextNumber(int number) {
		int sum = 0;
		while (number != 0) {
			int digit = number % 10;
			sum += digit * digit;
			number = (number - digit) / 10;
		}
		return sum;
	}

	public static boolean isHappy(int number) {
		return isHappy(number, new HashSet<Integer>());
	}

	public static boolean isHappy(int number, Set<Integer> numbersSoFar) {
		int next = nextNumber(number);
		if (next == 1) {
			return true;
		}
		if (numbersSoFar.contains(next)) {
			return false;
		}
		numbersSoFar.add(next);
		return isHappy(next, numbersSoFar);
	}

	public static void main(String[] args) {
		for (int i=1; i<=1000; i++) {
			if (isHappy(i)) {
				System.out.println(i);
			}
		}
	}
}
