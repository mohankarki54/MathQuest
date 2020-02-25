package mohankarki.mathquest;

import java.util.Random;

public class Calculation {

    public static int addition_result(int x, int y){
        //This function will return the addition of two number.
        int z = x + y;
        return z;
    }

    public static int get_random_number(int num){
        //This function will generate the random number with the certain range which will be the parameter of the function.
        Random rand = new Random();
        int ans = rand.nextInt(num);
        return ans;
    }

    public static int get_random_number1(int max, int min){
        //This function will generate the random number with the certain range which will be the parameter of the function.
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static int subtraction_result(int x, int y){
        //This function will return the subtraction of two number.
        int z = x - y;
        return z;
    }

    public static int multiplication_result(int x, int y){
        //This function will return the multiplication of two number.
        int z = x * y;
        return z;
    }

    public static int division_result(int x, int y){
        //This function will return the division of two number.
        int z = (int) x / y;
        return z;
    }

    public static int mixed_result(int x, int y, int m){

        int z = x + y - m;
        return z;
    }
}
