package csu.csci325;

/*
 *	Student Name:		Christopher Aumen
 *	Program Name:		Hashing
 *	Creation Date:		April 14, 2016
 *	Last Modified Date:	January 28, 2018
 *	CSCI Course:		CSCI-325 Object-Oriented Programming
 *	Grade Received:		150 (50 extra credit points)
 *	Comments Regarding Design:
 *		
 */

/**
 * Created by caumen163119 on 4/14/2016.
 */
public class HashStringMatching {
    public HashStringMatching () {}

    public static int indexOf(String str, String match) {
        int ret = 0;

        if (str == null || match == null){
            return 0;
        }

        if (str == "" || match == ""){
            return 0;
        }

        /*// BRUTE FORCE
        for (int strI = 0; strI < str.length(); strI++){
            for (int matchI = 0; matchI < match.length(); matchI++){
                if (str.charAt(strI + matchI) != match.charAt(matchI)){
                    break;
                }
                if (matchI == match.length() - 1){
                    return strI;
                }
            }
        }*/


        CSCIHashTable<String, String> table = new CSCIHashTable<>();
        int strHash = 0, matchHash = 0;

        for (int i = 0; i < match.length(); i++){
            matchHash += match.charAt(i);
        }

        // O(match.length)
        for (int i = 0; i < match.length(); i++){
            strHash += str.charAt(i);
        }

        /* O(str.length() * match.length()) COMPARE TO ABOVE FOR STATEMENT & below
        for (int i = 0; i < (str.length() - match.length() + 1); i++){
            strHash = 0;
            for (int j = 0; j < match.length(); j++){
                strHash += str.charAt(i + j);
            }
        }
        */

        // O(str.length [until match is found])
        for (int i = 0; i < (str.length() - match.length() + 1); i++){
            if (strHash == matchHash && str.substring(i, i + match.length()).equals(match)){
                return i;
            }
            strHash -= str.charAt(i);
            strHash += str.charAt(i + match.length());
        }

        //O(match.length + str.length IS BETTER THAN match.length * str.length)

        return ret;
    }

    public static void main (String[] args) {
        String match = "789";

        System.out.println(HashStringMatching.indexOf("123456789", match));

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < 1<<24; i++){
            sb.append('a');
        }
        sb.append("xyz");

        String str = sb.toString();
        match = str.substring(1000000, str.length());

        System.out.println("second attempt starting");
        System.out.println(HashStringMatching.indexOf(str, match));
        System.out.println("second attempt ending");

    }
}
