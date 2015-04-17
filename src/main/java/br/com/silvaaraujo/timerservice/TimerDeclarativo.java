package br.com.silvaaraujo.timerservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;


/**
- TimerDeclarativo: <br />
Para executar descomente as linhas comentadas.<br />
É o teste mais simples e tem por finalidade exemplicar o uso do timer de forma declarativa, conhecidos como <b>Timers Automaticos</b>.<br />
Basta informar dentro da anotação o padrão de execução que desejar.<br />
Neste exemplo o timer irá executar a cada segundo exibindo no console o horario atual.<br />

@author 
	Thiago Silva

@see 
	https://docs.oracle.com/javaee/7/tutorial/ejb-basicexamples004.htm#BNBOY

@see
	capitulo: 34.4.3 Automatic Timers
 * */
//@Startup
@Stateless
public class TimerDeclarativo {

	//@Schedule(second="*", minute="*", hour="*")
	public void hello() {
		System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}
	
}