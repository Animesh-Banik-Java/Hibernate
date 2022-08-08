package com.hibernate.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		Configuration con = new Configuration();
		SessionFactory fact = con.configure("hibernate.cfg.xml").buildSessionFactory(); 
		Session session = fact.openSession();
		Student ss = session.get(Student.class, 1001);
		Address ass = session.load(Address.class, 1);
		System.out.print(ss);
		System.out.println(ass);
		session.close();
		fact.close();

	}

}
