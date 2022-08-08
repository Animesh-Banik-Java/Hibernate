package com.hibernate.learn.ManyToMany;

import java.util.ArrayList;
import java.util.List;
 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(11);
		e1.setName("Raman");
		
		e2.setEid(12);
		e2.setName("Sonam");
		
		
		Project p = new Project();
		Project pp = new Project();
		
		p.setPid(51);
		p.setName("School Management");
		
		pp.setPid(52);
		pp.setName("Library Management");
		
		
		List<Emp> emps = new ArrayList<Emp>();
		List<Project> pro = new ArrayList<Project>();
		
		emps.add(e1);
		emps.add(e2);
		
		pro.add(p);
		pro.add(pp);
		
		e1.setProjects(pro);
		p.setEmps(emps);
		
		Session session = factory.openSession();
		Transaction tr= session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p);
		session.save(pp);
		
		tr.commit();
		
		
		factory.close();
	}

}
