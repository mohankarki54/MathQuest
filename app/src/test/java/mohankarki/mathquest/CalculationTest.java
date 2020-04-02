package mohankarki.mathquest;
import org.junit.Test;
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
    public void subtraction_result_correct() throws Exception {
        //This test case will validate the function will be return the correct subtraction value.
        int a = 10;
        int b = 5;
        int expected = 5;
        int ans;
        Calculation calculation = new Calculation();
        ans = calculation.subtraction_result(a,b);
        assertEquals(expected, ans);
    }

    @Test
    public void subtraction_result_incorrect() throws Exception {
        //This test case will validate the function will be return the correct subtraction value.
        int a = 5;
        int b = 10;
        int expected = 10;
        int ans;
        Calculation calculation = new Calculation();
        ans = calculation.subtraction_result(a,b);
        assertNotEquals(expected, ans);
    }

    @Test
    public void multiplication_result_correct() throws Exception {
        //This test case will validate the function will be return the multiplication additional value.
        int a = 5;
        int b = 10;
        int expected = 50;
        int ans;
        Calculation calculation = new Calculation();
        ans = calculation.multiplication_result(a,b);
        assertEquals(expected, ans);
    }

    @Test
    public void multiplication_result_incorrect() throws Exception {
        //This test case will validate the function will be return the correct multiplication value.
        int a = 5;
        int b = 10;
        int expected = 10;
        int ans;
        Calculation calculation = new Calculation();
        ans = calculation.multiplication_result(a,b);
        assertNotEquals(expected, ans);
    }


}