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

@Startup
@Singleton
public class TimerProgramatico {

	@Resource
	private TimerService timerService;
	
	@PostConstruct
	public void programaticHello() {
		
		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setInfo("--- EJB TIMER SERVICE - PROGRAMATIC WAY ---");
		timerConfig.setPersistent(true);
		
		ScheduleExpression expression = new ScheduleExpression();
		expression
			.second("00,15,30,45")
			.minute("*")
			.hour("*");
		
		timerService.createCalendarTimer(expression, timerConfig);
		
	}
	
	@Timeout
	public void execute(Timer timer) {
		System.out.println("Message : " + timer.getInfo());
		System.out.println("Execution Time : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
		System.out.println(" ----------- ");
	}
	
}