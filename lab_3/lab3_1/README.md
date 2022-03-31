## lab3_1

[a] - Os método que implementam que usam o AssertJ são:
    - Na classe A_EmployeeRepositoryTest dentro da função givenSetOfEmployees_whenFindAll_thenReturnAllEmployees (linha 63).
    - Na classe D_EmployeeRestControllerIT dentro da função whenValidInput_thenCreateEmployee. (52)

[b] - Na classe C_EmployeeController_WithMockServiceIT dentro da funcão 
whenPostEmployee_thenCreateEmployee (49)
```
        when( service.save(Mockito.any()) ).thenReturn( alex);
```

[c] - O @MockBean é uma anotação que permite adicionar um mock a uma Spring AplicationContect. O mock ira fazer uma substituição de cada *bean* do mesmo tipo por outro que já exista na aplicação, se nao exister um nove será adicionado. Este tipo de mock é bastante util para testes de integração.
O @Mock marca é uma abreviação do Mockito.mock que é usado para criar um objeto mock, este tipo de anotações sao usadas apenas em classes de testes.

[d] - Para que haja ligação com a base de dados durante a execução dos testes.

[e] - 