# ejb-timer-test
Projeto simples para teste de uso da API EJB TIMER SERVICE

#Documentação e/ou tutorial oficial:
https://docs.oracle.com/javaee/7/tutorial/ejb-basicexamples004.htm#BNBOY

#API JAVAEE7
http://docs.oracle.com/javaee/7/api/

#Exemplos e como executa-los:

OBS: Antes de executar qualquer exemplo é necessario realizar o deploy da 
aplicação em servidor de aplicação que implemente a especificação javaEE 7.

1 - TimerDeclarativo:
<br />
Para executar descomente as linhas comentadas.
É o teste mais simples e tem por finalidade exemplicar o uso do timer de forma declarativa.
Basta informar dentro da anotação o padrão de execução que desejar.
Neste exemplo o timer irá executar a cada segundo exibindo no console o horario atual.

2 - TimerProgramatico:
<br />
Este exemplo tem por finalidade exemplicar o uso do timer de forma programatica, conhecidos como <b>Programmatic Timers</b>.

O timer programatico deve ser criado a partir de uma instancia da classe timer service,  
que é um recurso gerenciado pelo container e por isso podemos injetá-lo. 
Atraves do timer service podemos criar execucoes unicas, em intervalos de tempo ou baseadas no tempo data/hora.

Com uma instancia da classe <b>TimerConfig</b> e possivel definir algumas informacoes referentes ao agendamento 
como pode ser visto abaixo, como por exemplo se esse timer sera persistente ou nao.

O horario de execucao pode ser definido atraves de uma instancia da classe <b>ScheduleExpression</b>.

O agendamento sera disparado quando a horario pre-definido for atingido e o 
metodo que possuir a anotacao <b>@Timeout</b> será executado.

