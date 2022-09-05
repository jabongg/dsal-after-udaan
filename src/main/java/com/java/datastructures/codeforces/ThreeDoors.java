package com.java.datastructures.codeforces;

import java.util.Scanner;
/*
There are three doors in front of you, numbered from 1 to 3
from left to right. Each door has a lock on it, which can only be opened with a key with the same number on it as the number on the door.
There are three keys — one for each door. Two of them are hidden behind the doors, so that there is no more than one key behind each door. So two doors have one key behind them, one door doesn't have a key behind it. To obtain a key hidden behind a door, you should first unlock that door. The remaining key is in your hands.

Can you open all the doors?
Input

The first line contains a single integer 𝑡
(1≤𝑡≤18

) — the number of testcases.

The first line of each testcase contains a single integer 𝑥
(1≤𝑥≤3

) — the number on the key in your hands.

The second line contains three integers 𝑎,𝑏
and 𝑐 (0≤𝑎,𝑏,𝑐≤3) — the number on the key behind each of the doors. If there is no key behind the door, the number is equal to 0

Values 1,2
and 3 appear exactly once among 𝑥,𝑎,𝑏 and 𝑐

Output

For each testcase, print "YES" if you can open all the doors. Otherwise, print "NO".
Example
Input
Copy

4
3
0 1 2
1
0 3 2
2
3 1 0
2
1 3 0

Output
Copy

YES
NO
YES
NO


 */
public class ThreeDoors {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int k = 0; k < t; k++) {
            int keyNumberInHand = scan.nextInt();

            int[] keys = new int[3];


            for (int i = 0; i < keys.length; i++) {
                keys[i] = scan.nextInt();
            }

            canOpenDoors(keyNumberInHand, keys);
            //System.out.println(canOpenAllDoors(keyNumberInHand, keys));
        }
    }

    // accepted on the codeforces : another developer's version
    private static void canOpenDoors(int x, int[] a) {
        if (a[x - 1] != 0 && a[a[x - 1] - 1] != 0)
            System.out.println("YES\n");
        else System.out.println("NO\n");
    }

    // accepted on the codeforces : my version
    private static String canOpenAllDoors(int keyNumberInHand, int[] keys) {
        int openedDoor = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[keyNumberInHand - 1] == 0 && openedDoor != 2) {
                return "NO";
            } else if (keys[keyNumberInHand - 1] != 0) {
                ++openedDoor;
                keyNumberInHand = keys[keyNumberInHand - 1];
            } else if (keys[keyNumberInHand - 1] == 0 && openedDoor == 2) {
                return "YES";
            }
        }
        return "YES";
    }
}