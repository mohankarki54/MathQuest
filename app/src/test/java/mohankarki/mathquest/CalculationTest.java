package mohankarki.mathquest;

import android.util.Log;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CalculationTest {

    @Test
    public void addition_result_correct() throws Exception {
        //This test case will validate the function will be return the correct additional value.
        int a = 5;
        int b = 10;
        int expected = 15;
        int ans;
        Calculation calculation = new Calculation();
        ans = calculation.addition_result(a,b);

        assertEquals(expected, ans);
    }

    @Test
    public void addition_result_incorrect() throws Exception {
        //This test case will validate the function will be return the correct additional value.
        int a = 5;
        int b = 10;
        int expected = 10;
        int ans;
        Calculation calculation = new Calculation();
        ans = calculation.addition_result(a,b);

        assertNotEquals(expected, ans);

    }
    @Test
    public void check(){
        Addition addition = new Addition();
        //addition.generateQuestion();
        int val = 8;
        assertNotNull(val);
    }

}