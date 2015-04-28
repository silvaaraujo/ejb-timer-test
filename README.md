# ejb-timer-test
Projeto para testes de uso da API EJB TIMER SERVICE

#Documentação e/ou tutorial oficial:
https://docs.oracle.com/javaee/7/tutorial/ejb-basicexamples004.htm#BNBOY

#API JavaEE7
http://docs.oracle.com/javaee/7/api/

#Exemplos e como executa-los:

OBS: Antes de executar qualquer exemplo é necessário realizar o deploy da aplicação em servidor de aplicação que implemente a especificação javaEE 7.
Os testes foram realizados utilizando o servidor de aplicação glassfish 4.1 que pode ser baixado gratuitamente em:
https://glassfish.java.net/download.html

1 - TimerDeclarativo:
<br />
É o teste mais simples e tem por finalidade exemplicar o uso do timer de forma declarativa.
Basta informar dentro da anotação o padrão de execução que desejar.
Neste exemplo o timer irá executar a cada segundo exibindo no console o horário atual.

2 - TimerProgramatico:
<br />
Este exemplo tem por finalidade exemplicar o uso do timer de forma programática, conhecido como <b>Programmatic Timers</b>.

O timer programático deve ser criado a partir de uma instância da classe timer service,  
que é um recurso gerenciado pelo container e por isso podemos injetá-lo. 
Através do timer service podemos criar execuções unicas, em intervalos de tempo ou baseadas no tempo data/hora.

Com uma instância da classe <b>TimerConfig</b> e possível definir algumas informações referentes ao agendamento,
como por exemplo se esse timer será persistente ou não.

O horário de execução pode ser definido através de uma instância da classe <b>ScheduleExpression</b>.

O agendamento será disparado quando o horário pré-definido for atingido e o método que possuir a anotacao <b>@Timeout</b> será executado.
