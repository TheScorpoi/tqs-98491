# lab_6

## Como correr o docker do SonarQube no Mac M1
 - docker pull davealdon/sonarqube-with-docker-and-m1-macs
 - docker run -p 9000 davealdon/sonarqube-with-docker-and-m1-macs
 - localhost:????? esta porta é sempre uma diferente (fazer docker ps -a ou ir ao docker desktop para ver qual é)

Nova password: admin1

## lab6_2

![Imagem do SonarQube](./img2.png)


| Issue  | Problem Description  | How to solve  |
|---|---|---|
| BUG: "Save and re-use this "Random" " | cada vez que é necessário criar um numero random não é eficiente e pode gerar numeros que nao sao realmente aleatórios |  Criar unicamente um random, guardar esse mesmo numero e a partir dai reutiliza-lo |
| SECURITY HOTSPOTS: "Make sure that using this pseudorandom number generator is safe here." | Neste caso em especifico nao se trata de um problema, uma vez que o problema nao pede que seja sempre um valor imprevisivel todas as vezes que é chamado  | Gerar numero aleatorios so uma vez, ou usar a biblioteca java.security.SecureRandom  |
| CODE SMELLS: "Remove this unused import 'java.util.function.BooleanSupplier'."  |  Está a ser feito um import que nunca é usado | Apagar a linha de código que está a fazer o import |
| CODE SMELLS: "Refactor the code in order to not assign to this loop counter from within the loop body."  |  O contador do loop neste caso a variável "i" é atribuido dentro do loop | Adicionar o contador do loop na definição do loop for (..., i++)|