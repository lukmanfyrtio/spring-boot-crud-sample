package com.application.CrudApp;

import com.application.CrudApp.BookDTO.BookDTO;

import lombok.Data;

@Data
public class JsonMessage {
    public static final String MSG_TITLE_INFO = "Information";
	
	
	private String messageTitle;
	private String messageDetail;
	private BookDTO object;
	
    public JsonMessage() {}
    
    public JsonMessage(String messageTitle, String messageDetail, BookDTO object) {
        this.messageTitle = messageTitle;
        this.object = object;
        this.messageDetail = messageDetail;
    }

    public static JsonMessage showInfoMessage(String messageBody, BookDTO object) {
        return new JsonMessage(MSG_TITLE_INFO, messageBody, object);
    }
}
