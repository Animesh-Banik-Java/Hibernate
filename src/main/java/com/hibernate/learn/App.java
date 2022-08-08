package com.hibernate.learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Programming in progress..!");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Student student = new Student();
		student.setId(1001);
		student.setName("Banik");
		student.setCity("Shakti"); 
		System.out.println(student);
		
		Address ad = new Address();
		ad.setStreet("Gali no.112");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(6464.46);
		
		FileInputStream fi = new FileInputStream("src/main/java/pic.jpg");
		byte data[]= new byte[fi.available()];  
		fi.read(data);
		ad.setImage(data);

		System.out.println(ad);
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(student);
		session.save(ad);
		session.getTransaction().commit();
		session.close();
		System.out.println("Done");
	}
}
