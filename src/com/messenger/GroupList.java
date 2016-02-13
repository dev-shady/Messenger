package com.messenger;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class GroupList {
	private Map<String,group> list;
	
	public GroupList() {
		list=new HashMap<String,group>();
	}
	public Map<String, group> getList() {
		return list;
	}
	
	public void addGroup(group grp) {
		System.out.println(grp.getId());
		list.put(grp.getId(), grp);
	}
	public void removeGroup(group grp) {
		list.remove(grp);
	}
	
	public group getGroup(String grp) {
		return list.get(grp);
	}
	public Boolean contains(String group) {
		return list.containsKey(group);
	}
	
}
