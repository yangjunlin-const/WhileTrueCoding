package com.yjl.algorithm.character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in ));
        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int l = 0,r = 0,m = 0;
        int count = 0;
        if (in.hasNext()) {
            l = in.nextInt();
            r = in.nextInt();
            m = in.nextInt();
        }

        if (l > r)
            count = -1;
        for (int i = l; i <= r; i++) {
            if (checkOne(i,m))
                count++;
        }
        if (count == 0)
            count = -1;
        System.out.println("" + count);
    }

    public static boolean checkOne(int n, int m){
        while (n != 0) {
            if ((n&1) == 1)
                m--;
            n = n >> 1;
        }
        if (m == 0)
            return true;
        else
            return false;
    }

}

