package com.edu.hibernateapp.model;

public class AppMain {
	
	public static void main(String[] args) {
		NoticeDAO dao= new NoticeDAO();
		dao.insert();
	}

}
