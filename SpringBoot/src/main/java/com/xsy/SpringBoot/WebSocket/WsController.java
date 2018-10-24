package com.xsy.SpringBoot.WebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {
    @MessageMapping("/welcome") //浏览器向服务端发送请求时，通过@MessageMapping映射地址
    @SendTo("/topic/getResponse")   //当服务端有消息时,会对订阅了@SentTo中的路径的浏览器发送消息
    public xsyResponse say(xsyMessage message) throws Exception {
        Thread.sleep(3000);
        return new xsyResponse("Welcome " + message.getName() + "!");
    }

    //通过SimpMessagingTemplate向浏览器发送信息
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    //在参数中获得principal，包含当前用户的信息
    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg) {
        //
        if(principal.getName().equals("xsy")) {
        //通过messagingTemplate.convertAndSentToUser向用户发送消息,第一次个参数是接收消息的用户,第二个是浏览器订阅的地址,第三个是消息
            messagingTemplate.convertAndSendToUser("springboot","/queue/notifications",principal.getName() + "-send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("xsy","/queue/notifications",principal.getName() + "-send:" + msg);
        }
    }
}
