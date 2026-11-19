package com.example;

import java.util.*;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/WS")
public class WebSocket {
	
	Set<Session>  Clients = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen(Session session) {
		Clients.add(session); 
		System.out.println("Client Created") ;
	}
	
	@OnClose
	public void  onClose(Session session) {
		Clients.remove(session);
		System.out.println("Client removed");
	}
	
	@OnMessage 
	public void onMessage(String message ) {
		synchronized(Clients) {
			for(Session client : Clients ) {
				if(client.isOpen()) {
					 client.getAsyncRemote().sendText(message);
				}
			}
		}
	}
	
	@OnError 
	public void onError(Session session , Throwable error ) {
		error.printStackTrace();
	}
	
	
	
	
}

