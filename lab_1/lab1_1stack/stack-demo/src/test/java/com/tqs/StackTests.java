package com.tqs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class StackTests {

    TqsStack<String> stack;

    @BeforeEach
    public void setUp() {
        stack = new TqsStack<>();
    }

    @DisplayName("Teste para verificar se a pilha está vazia")
    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty(), "A pilha nao está vazia, e deveria");
    }

    @DisplayName("Teste para verificar o tamanho da pilha no inicio")
    @Test
    public void size() {
        assertEquals(0, stack.size(), "O tamanho deveria ser 0, mas não é");
    }

    @DisplayName("Teste para ver se a pilha fica com tamanho superior a 0, depois de inserir elementos")
    @Test
    public void sizeAfterPush() {
        stack.push("Danizinho");
        stack.push("Evinha");
        stack.push("Andrezinho");
        assertEquals(3, stack.size(), "O tamanho deveria ser maior que 0, mas não é");
    }

    @DisplayName("Teste para confirmar se o ultimo elemento inserido é o primeiro a sair")
    @Test
    public void pushAndPop() {
        stack.push("Danizinho");
        stack.push("Evinha");

        String popped = stack.peek();
        assertEquals("Evinha", popped, "O elemento retirado deveria ser o último elemento inserido");
    }

    @DisplayName("Teste para ir ver um elemento da pilha e denotar que o tamanho da mesma nao se altera")
    @Test
    public void peekAndConfirmTheSize() {
        stack.push("Martinha");
        stack.push("Filipinho");
        stack.push("Pedrinho");

        int size = stack.size();
        String peeked = stack.peek();

        assertAll("O tamanho deveria ser 3, e o elemento retirado ser o último elemento inserido (Pedrinho)",
        () -> assertEquals("Pedrinho", peeked, "O elemento retirado deveria ser o último elemento inserido (Pedrinho)"),
        () -> assertEquals(size, stack.size(), "O tamanho deveria ser 3")
        );
    }

    // mvn test jacoco:report
    @DisplayName("Teste para esvaziar a stack e verificar se a mesma se encontra vazia")
    @Test
    public void makeTheStackEmpty() {
        stack.push("Martinha");
        stack.push("Filipinho");
        stack.push("Pedrinho");

        assertEquals(3, stack.size(), "O tamanho deveria ser 3");
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty(), "A pilha nao está vazia, e deveria");
    }

    @DisplayName("Teste para verificar a exceção ao fazer pop de uma pilha vazia")
    @Test
    public void popFromAnEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
    
    @DisplayName("Teste para verificar a exceção ao fazer peek de uma pilha vazia")
    @Test
    public void peekFromAnEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @DisplayName("Teste para verificar a exceção ao adicionar um elemento a uma pilha cheia")
    @Test
    public void boundedStacks() {
        stack = new TqsStack<>(2);
        stack.push("Martinha");
        stack.push("Filipinho");

        assertThrows(IllegalStateException.class, () -> stack.push("Pedrinho"));
    }
    
}