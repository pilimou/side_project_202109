package com.line.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.line.service.VerificationLineService;
import com.line.vo.in.LineMessageIn;

@RestController
@RequestMapping("/line")
public class LineBotController {
	
	@Autowired
	VerificationLineService verificationLineService;
	
	@Value("${lineBot.callBackReplyUrl}")
	private String callBackReplyUrl;
	
	@Value("${lineBot.broadcastUrl}")
	private String broadcastUrl;
	
	@Value("${lineBot.nike.channelSecret}")
	private String channelSecret;
	
	@Value("${lineBot.nike.channelToken}")
	private String channelToken;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/receiveEvent")
	public ResponseEntity<String> receiveEvent(@RequestBody String requestBody,
			@RequestHeader("X-Line-Signature") String line_headers)
			throws RestClientException, JsonProcessingException {
		logger.info(requestBody);
		
		/**
		 *text
		{"destination":"U1d49ac7eee92d3818b492876623de152",
			"events":[
				{"type":"message",
				 "message":{"type":"text","id":"14800812590655","text":"123"},
				 "timestamp":1632476608449,
				 "source":{"type":"user","userId":"Uaae19ff20461f35d3db44135adfe2e56"},
				 "replyToken":"f387d247c00f4bf7bbe8e672c5f54325",
				 "mode":"active"}
			]
		}
		 
		 */
		
		/**
		 * image
		 {"destination":"U1d49ac7eee92d3818b492876623de152",
		 	"events":[
		 		{"type":"message",
		 		"message":{"type":"image","id":"14800837669640","contentProvider":{"type":"line"}},
		 		"timestamp":1632476906984,
		 		"source":{"type":"user","userId":"Uaae19ff20461f35d3db44135adfe2e56"},
		 		"replyToken":"e3623aadcbf24f4b9d456baca2dd714e",
		 		"mode":"active"}
		 	]
		 }
		 */
		
		if(!verificationLineService.checkFromLine(requestBody, line_headers, channelSecret)) {
			logger.error("checkFromLine Error");
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			LineMessageIn lineMessageIn = new ObjectMapper().readValue(requestBody, LineMessageIn.class);
			
		}
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@RequestMapping("/test")
	public String test() {
		logger.info(channelSecret);
		logger.info(channelToken);
		logger.info(callBackReplyUrl);
		logger.info(broadcastUrl);
		return "dddddd";
	}
}
