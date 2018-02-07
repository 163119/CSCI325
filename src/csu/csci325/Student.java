package csu.csci325;

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
 * Created by pwest on 1/21/16.
 */
public class Student {
    private String mFirstName;
    //private long[] mNumbers;
    private String mSSN = "";

    public Student() {
        //mNumbers = new long[100000000];
    }

    public Student(String name)
    {
        mFirstName = name;
    }

    public void setFirstName(String name) {
        if (name == null || name.length() < 1) {return;}
        mFirstName = name;
    }
    public String getFirstName() {
        return mFirstName;
    }

    public void setSSN(int ssn) {
        Integer inputSSN = new Integer(ssn);
        String ssnAsString = new String (inputSSN.toString());

        if (ssnAsString.length() == 9){
            mSSN = ssnAsString;
            return;
        }

        mSSN = "";
        for (int i = 0; i < 9; i++){
            if (ssnAsString.length() + i < 9){
                mSSN += "0";
            } else {
                for (int j = 0; j < ssnAsString.length(); j++){
                    mSSN += ssnAsString.charAt(j);
                }
                return;
            }
        }
    }

    public String getSSN(){
        return mSSN;
    }

    @Override
    public int hashCode(){
        if (mSSN.length() != 9)
            return -1;

        int ret;

        int sub1, sub2, sub3;

        sub1 = Integer.parseInt(mSSN.substring(0,3));
        sub2 = Integer.parseInt(mSSN.substring(3,6));
        sub3 = Integer.parseInt(mSSN.substring(6,9));

        ret = sub1 + sub2 + sub3;

        return ret;
    }

    public static void main(String[] args){

    }
}
