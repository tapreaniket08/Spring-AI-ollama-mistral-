package com.bootai.controller;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {
	
	private OllamaChatClient client;
	
	private static final String PROMPT="What is java programming";
	
	public AiController(OllamaChatClient client) {
		this.client=client;
	}

	@GetMapping("/prompt")
	public Flux<String> promptresponce(@RequestParam("prompt") String prompt) {
		Flux<String> responce = client.stream(prompt);
		return responce;
	}
}
