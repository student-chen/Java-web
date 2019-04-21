package com.bjpowernode.system.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.bjpowernode.system.vo.Client;

/**
 * 对在线用户的管理
 */
public class ClientManager {
	
	private static ClientManager instance = new ClientManager();
	
	private ClientManager(){
		
	}
	
	public static ClientManager getInstance(){
		return instance;
	}
	
	private Map<String,Client> map = new HashMap<String, Client>();
	
	/**
	 * 
	 * @param sessionId
	 * @param client
	 */
	public void addClinet(String sessionId,Client client){
		map.put(sessionId, client);
	}
	/**
	 * sessionId
	 */
	public void removeClinet(String sessionId){
		map.remove(sessionId);
	}
	/**
	 * 
	 * @param sessionId
	 * @return
	 */
	public Client getClient(String sessionId){
		return map.get(sessionId);
	}
	/**
	 * 
	 * @return
	 */
	public Collection<Client> getAllClient(){
		return map.values();
	}

}
