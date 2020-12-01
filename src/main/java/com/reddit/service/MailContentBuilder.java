package com.reddit.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailContentBuilder {
	
	private final TemplateEngine template;
	
	String build(String message) {
		Context cxt=new Context();
		cxt.setVariable("message", message);
		return template.process("mailTemplate", cxt);
	}

}
