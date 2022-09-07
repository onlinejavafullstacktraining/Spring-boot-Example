package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

	private JmsTemplate jmsTemplate;
	@Autowired
	public AlertService(JmsTemplate jmsTemplate){
		this.jmsTemplate=jmsTemplate;
	}

	public void sendUserAlert(Registration register) {
		//we are trying to send Registration Object into Active MQ
		jmsTemplate.convertAndSend("spring.boot.alert.name",register);
	}
	
	public Registration getRegisterAlert() {
		return (Registration)jmsTemplate.receiveAndConvert();
	}

	
}
