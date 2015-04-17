package br.com.silvaaraujo.timerservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
- TimerProgramatico: <br />
Este exemplo tem por finalidade exemplicar o uso do timer de forma programatica, conhecidos como <b>Programmatic Timers</b>.<br />
<br />
O timer programatico deve ser criado a partir de uma instancia da classe timer service,  
que é um recurso gerenciado pelo container e por isso podemos injetá-lo. <br />
Atraves do timer service podemos criar execucoes unicas, em intervalos de tempo ou baseadas no tempo data/hora.
<br />
Com uma instancia da classe <b>TimerConfig</b> e possivel definir algumas informacoes referentes ao agendamento 
como pode ser visto abaixo, como por exemplo se esse timer sera persistente ou nao.
<br />
O horario de execucao pode ser definido atraves de uma instancia da classe <b>ScheduleExpression</b>.
<br />
O agendamento sera disparado quando a horario pre-definido for atingido e o 
metodo que possuir a anotacao <b>@Timeout</b> será executado.
@author 
	Thiago Silva

@see 
	https://docs.oracle.com/javaee/7/tutorial/ejb-basicexamples004.htm#BNBOY

@see
	capitulo: 34.4.2 Programmatic Timers
	
 * */
@Startup
@Singleton
public class TimerProgramatico {

	@Resource
	private TimerService timerService;
	
	@PostConstruct
	public void programaticHello() {
		
		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setInfo("timerTask1");
		timerConfig.setPersistent(true);
		
		ScheduleExpression expression = new ScheduleExpression();
		expression
			.second("*")
			.minute("35")
			.hour("23");
		
		timerService.createCalendarTimer(expression, timerConfig);
	}
	
	@Timeout
	public void execute(Timer timer) {
		System.out.println("Message : " + timer.getInfo());
		System.out.println("Execution Time : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
		System.out.println(" ----------- ");
	}
	
}