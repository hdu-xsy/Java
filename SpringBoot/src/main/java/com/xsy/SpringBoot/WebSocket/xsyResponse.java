package com.xsy.SpringBoot.WebSocket;

public class xsyResponse {
    private String responseMessage;
    public xsyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
}
