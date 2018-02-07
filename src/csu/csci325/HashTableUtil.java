package csu.csci325;

import java.util.*;

/*
 *	Student Name:		Christopher Aumen
 *	Program Name:		Hashing
 *	Creation Date:		April 12, 2016
 *	Last Modified Date:	January 28, 2018
 *	CSCI Course:		CSCI-325 Object-Oriented Programming
 *	Grade Received:		150 (50 extra credit points)
 *	Comments Regarding Design:
 *		
 */

/**
 * Created by CAumen163119 on 4/12/2016.
 */
public class HashTableUtil {
    public HashTableUtil() {}

    public static <T> T[] removeDuplicates(T[] array) {
        CSCIHashTable<T, T> table = new CSCIHashTable<>();

        for (int i = 0; i < array.length; i++) {
                table.put(array[i], array[i]);
        }

        T[] ret = (T[]) new Object[table.values().size()];
        Iterator<T> it = table.values().iterator();

        int j = 0;

        while (it.hasNext()){
            ret[j++] = it.next();
        }

        return ret;
    }

    public static void main(String[] args){
        int[] array = {3, 5, 8, 0, 1, 4, 6, 2, 7, 9};

        System.out.println(sumPairs(array, 9));

        //CSCIHashTable<Integer, Integer> table2 = new CSCIHashTable<>();

        //table2.put(-1, -1);
        //System.out.println(-1%113);
    }

    public static int sumPairs(int[] array, int sum){
        int ret = 0;

        if (array == null)
            return ret;

        /* BRUTE FORCE
        int valueToFind;
        for (int i = 0; i < array.length; i++){
            valueToFind = sum - array[i];
            for (int j = i + 1; j < array.length; j++){
                if (array[j] == valueToFind) {
                    ret++;
                }
            }
        }*/

        CSCIHashTable<Integer, Integer> table1 = new CSCIHashTable<>();

        for (int i = 0; i < array.length; i++){
            table1.put(array[i], array[i]);
        }

        for (int i = 0; i <= sum/2; i++)
            if(table1.get(i) != null && table1.get(sum - i) != null)
                ret++;

        return ret;
    }
}
