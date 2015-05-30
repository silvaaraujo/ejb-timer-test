package br.com.silvaaraujo.timerservice;

import java.text.SimpleDateFormat;
import java.util.Collection;
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
 * Este exemplo exibe a manipulação de um agendamento, desde sua criação, localização e cancelamento.
 * 
 * @author Thiago Silva
 */
@Startup
@Singleton
public class ManipulandoTimers {

	@Resource
	private TimerService timerService;
	
	@PostConstruct
	public void createAndCancelTimer() {
		
		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setInfo("timerTask2");
		timerConfig.setPersistent(true);
		
		ScheduleExpression expression = new ScheduleExpression();
		expression
			.second("*")
			.minute("00")
			.hour("23");
		
		timerService.createCalendarTimer(expression, timerConfig);
		
		try {
			//deixando o processamento aguardando por 10 segundos.
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//cancelando o timer
		Boolean sucesso = this.cancelTimer("timerTask2");
		System.out.println("O timer timerTask2 foi cancelado: " + (sucesso ? "SIM" : "NÃO"));
	}
	
	@Timeout
	public void execute(Timer timer) {
		System.out.println("Message : " + timer.getInfo());
		System.out.println("Execution Time : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
		System.out.println(" ----------- ");
	}
	
	/**
	 * Utilizado para localizar o timer desejado.
	 * 
	 * @param timerName
	 * @return
	 */
	public Timer searchTimer(String timerName) {
		//recupera todos os timers que estão aguardando para serem executados 
		Collection<Timer> allTimers = this.timerService.getAllTimers();
		for (Timer timer : allTimers) {
			if (timer.getInfo().equals(timerName)) {
				return timer;
			}
		}
		return null;
	}
	
	public Boolean cancelTimer(String timerName) {
		Timer timer = searchTimer(timerName);
		if (timer != null) {
			
			//exibe o proximo disparo do timer localizado
			System.out.println("Execução agendada para: " + new SimpleDateFormat("HH:mm:ss").format(timer.getNextTimeout()));
			
			//cancela o agendamento
			timer.cancel();
			
			return true;
		}
		return false;
	}
	
}