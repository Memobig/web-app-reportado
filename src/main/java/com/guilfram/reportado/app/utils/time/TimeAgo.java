package com.guilfram.reportado.app.utils.time;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.guilfram.reportado.app.controllers.UsuarioController;

@Component
public class TimeAgo {
	public static final List<Long> times = Arrays.asList(TimeUnit.DAYS.toMillis(365), TimeUnit.DAYS.toMillis(30),
			TimeUnit.DAYS.toMillis(1), TimeUnit.HOURS.toMillis(1), TimeUnit.MINUTES.toMillis(1),
			TimeUnit.SECONDS.toMillis(1));
	public static final List<String> timesString = Arrays.asList("año", "mes", "dia", "hora", "minuto", "segundo");

	public static final Logger log = LoggerFactory.getLogger(UsuarioController.class);  
	
	public static String toDuration(String timestamp) {

		timestamp = timestamp.substring(0, timestamp.indexOf('.'));
		
		long currentTime = System.currentTimeMillis();
		
		long duration = currentTime - convertTime(timestamp);
		
		
		log.info("Timestamp: " + timestamp);
		log.info("Timestampo a milisegundos: " + duration);
		log.info("Currenttime en milisegundos: " + currentTime);
		
		StringBuffer res = new StringBuffer();
		res.append("Publicado hace ");
		for (int i = 0; i < TimeAgo.times.size(); i++) {
			Long current = TimeAgo.times.get(i);
			long temp = duration / current;
			if (temp > 0) {
				if(i == 1) {
					res.append(temp).append(" ").append(TimeAgo.timesString.get(i)).append(temp != 1 ? "es" : "");
					break;
				}
				res.append(temp).append(" ").append(TimeAgo.timesString.get(i)).append(temp != 1 ? "s" : "");
				break;
			}
		}
		if ("".equals(res.toString()))
			return "0 seconds ago";
		else
			return res.toString();
	}
	
	public static long convertTime(String timeStamp) {
		
		Timestamp timestamp = Timestamp.valueOf(timeStamp);
		
		long tsTime = timestamp.getTime();
		
		return tsTime;
	}

}