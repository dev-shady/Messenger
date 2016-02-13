package com.messenger;

import java.util.LinkedList;

public class group  {

	
	private String id,groupName;
	LinkedList<String> messages;
	LinkedList<String> members;
   
    public group() {
        super();
        members=new LinkedList<String>();
        messages=new LinkedList<String>();
       
    }

    

	public group(String id,String name){
		 members=new LinkedList<String>();
	     messages=new LinkedList<String>();
    	this.id=id;
    	groupName=name;
    	
    }



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public LinkedList<String> getMessages() {
		return messages;
	}



	public void addMessage(String message) {
		messages.add(message);
	}



	public LinkedList<String> getMembers() {
		return members;
	}



	public void addMember(String member) {
		members.add(member);
	}
	
	

}
