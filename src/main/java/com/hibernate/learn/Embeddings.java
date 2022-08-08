package com.hibernate.learn;

 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embeddings {
	public static void main(String ar[]) {
		Configuration con = new Configuration();
		SessionFactory fact = con.configure("hibernate.cfg.xml").buildSessionFactory(); 
		Session session = fact.openSession();
		
		Student student = new Student();
		student.setId(1002);
		student.setName("Rahul");
		student.setCity("mumbai");
		Certificate certi = new Certificate();
		certi.setCourse("Android");
		certi.setDuration("1.2 months");
		student.setCerti(certi);
		
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		
		System.out.println(student.toString());
		
		
		session.close();
		fact.close();
	}
}
