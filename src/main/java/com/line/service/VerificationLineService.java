package com.line.service;

public interface VerificationLineService {
	
	boolean checkFromLine(String requestBody, String X_Line_Signature, String channelSecret);
}
