package com.sample.dcs.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.dcs.service.EmployeeCacheService;

/**
 * The listener interface for receiving rabbitMQ events.
 * The class that is interested in processing a rabbitMQ
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addRabbitMQListener<code> method. When
 * the rabbitMQ event occurs, that object's appropriate
 * method is invoked.
 *
 * dummy listener not working
 * 
 * @see RabbitMQEvent
 */
@Component
public class RabbitMQListener {

	/** The employee cache service. */
	@Autowired
	private EmployeeCacheService employeeCacheService;

	@RabbitListener(queues = "SAMPLE.QUEUE")
	public void recievedMessage(String msg) {
		System.out.println("Recieved Message: " + msg);
		
		//TODO some logic depends 
		employeeCacheService.evictAllEmployeeCache();
	}
}
