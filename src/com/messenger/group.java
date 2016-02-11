package com.messenger;

import java.util.LinkedList;

public class group  {

	
	String id,groupName;
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
	
	

}
