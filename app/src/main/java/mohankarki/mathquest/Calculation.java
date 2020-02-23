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
}
