package br.com.silvaaraujo.timerservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;

//@Startup
@Stateless
public class TimerDeclarativo {

	//@Schedule(second="*", minute="*", hour="*")
	public void hello() {
		System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}
	
}