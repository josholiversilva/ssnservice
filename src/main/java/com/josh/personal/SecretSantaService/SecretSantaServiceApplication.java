package com.josh.personal.SecretSantaService;

import com.josh.personal.SecretSantaService.activities.SelectionActivity;
import com.josh.personal.SecretSantaService.helpers.EmailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SecretSantaServiceApplication {
	@Autowired
	private EmailHelper emailHelper;
	@Autowired
	private SelectionActivity selectionActivity;

	public static void main(String[] args) {
		SpringApplication.run(SecretSantaServiceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void emailSelections() {
		System.out.println("doing selections!");
		selectionActivity.enact();
	}
}
