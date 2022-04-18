/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;


    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testConstructorFromBadArrays() {
        assertThrows(IllegalArgumentException.class,
            () -> { instance = new Dip(new int[] { 10, 20, 30, 40, 50 }, new int[] { 1, 2, 3 });} , "Número de estrelas tem de ser igual a 2");
        assertThrows(IllegalArgumentException.class,
            () -> { instance = new Dip(new int[] { 10, 20, 30, 40, 50, 33 }, new int[] { 3, 4 });} , "Numero de numeros (#) não pode ser maior que 5");
        assertDoesNotThrow(() -> {
            instance = new Dip(new int[] { 10, 20, 30, 40, 50 }, new int[] { 3, 4 });} , "Numero de numeros (#) não pode ser maior que 5");
    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

    //2b)
    @DisplayName("Teste para verificar se as estrelas estão dentro do intervalo (1..12)")
    @Test
    public void checkStarRange() {
        instance = new Dip(new int[] { 13, 24, 34, 45, 51 }, new int[] { 12, 23 });
        assertFalse(instance.checkStarRange(), "As estrelas só podem ser números entre 1 e 12");

        instance = new Dip(new int[] { 13, 24, 34, 45, 51 }, new int[] { 1, 2 });
        assertTrue(instance.checkStarRange(), "checkStarRange: wrong star range");
    }

}