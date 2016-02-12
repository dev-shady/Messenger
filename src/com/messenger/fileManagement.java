package com.messenger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileManagement {
	
	BufferedReader br;
	BufferedWriter bw;
	File f;
	FileWriter fw;
	
	public void fWrite(String groupId){
		
		try {
			f=new File("abc.txt");
			if (!f.exists()) {
				f.createNewFile();
			}
			fw=new FileWriter(f.getAbsoluteFile());
			bw=new BufferedWriter(fw);
			bw.write(groupId+"\n");
			System.out.println("groupId "+groupId+" saved.");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean fRead(String groupId){
		try {
			br=new BufferedReader(new FileReader("abc.txt"));
			String temp;
			while((temp=br.readLine())!=null){
				if(temp.equals(groupId)){
					System.out.println("groupId "+groupId+" exists.");
					return true;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}
	
	

}
