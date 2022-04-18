/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
class SetOfNaturalsTest {
    private SetOfNaturals setA;
    private SetOfNaturals setB;
    private SetOfNaturals setC;
    private SetOfNaturals setD;
    private SetOfNaturals setE;

    @BeforeEach
    public void setUp() {
        setA = new SetOfNaturals();
        setB = SetOfNaturals.fromArray(new int[] { 10, 20, 30, 40, 50, 60 });

        setC = new SetOfNaturals();
        for (int i = 5; i < 50; i++) {
            setC.add(i * 10);
        }
        setD = SetOfNaturals.fromArray(new int[] { 30, 40, 50, 60, 10, 20 });
        setE = new SetOfNaturals();
    }

    @AfterEach
    public void tearDown() {
        setA = setB = setC = setD = null;
    }

    @Test
    public void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        setB.add(11);
        assertTrue(setB.contains(11), "add: added element not found in set.");
        assertEquals(7, setB.size(), "add: elements count not as expected.");
    }

    @Test
    public void testAddBadArray() {
        int[] elems = new int[] { 10, 20, -30 };

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));
    }

    @Test
    public void testIntersectForNoIntersection() {
        assertFalse(setA.intersects(setB), "no intersection but was reported as existing");

    }

    //2d)
    @Test
    @DisplayName("Teste para verificar se há excepções lançadas quando há elementos repetidos")
    public void addTheSameElement() {
        assertThrows(IllegalArgumentException.class, () -> setB.add(20),
                "Não é possivel adicionar elementos repetidos");
    }

    @Test
    @DisplayName("Teste para verificar o tamanho de um conjunto")
    public void checkSizeOfSet() {
        assertEquals(6, setB.size(), "O tamanho do conjunto não é 6, e deveria");
    }

    @Test
    @DisplayName("Teste para verificar se há excepções lançadas quando há uma array repetido a ser inserido")
    public void testAddingDuplicateArrayToASet() {
        int[] elems = new int[] { 10, 20, 30, 40, 50, 60 };
        assertThrows(IllegalArgumentException.class, () -> setB.add(elems),
                "Não é possivel adicionar arrays repetidos");
    }

    @Test
    @DisplayName("Teste para verificar se um determinado elemento já existe num conjunto")
    public void verifyIfAnElementAlreadyExistsOnSet() {
        assertTrue(setD.contains(50), "O elemento 50 não existe no conjunto");
        assertFalse(setA.contains(22), "O elemento 22 existe no conjunto");
    }

    @Test
    @DisplayName("Teste para confirmar que o conjunto é criado vazio")
    public void checkIfTheSetIsEmptyOnStart() {
        assertEquals(0, setA.size(), "O conjunto não está vazio");
    }
}
