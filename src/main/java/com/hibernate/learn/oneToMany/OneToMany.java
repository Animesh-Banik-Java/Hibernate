package com.hibernate.learn.oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Program Started...!");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		// first record
		Question qus = new Question();
		qus.setQuestionID(1001);
		qus.setQuestion("what is java?");
		
		Answer ans = new Answer();
		ans.setAnswerID(101);
		ans.setAnswer("Java is a programming language");
		 
		Answer ans1 = new Answer();
		ans1.setAnswerID(102);
		ans1.setAnswer("I love java programming");
		 
		Answer ans2 = new Answer();
		ans2.setAnswerID(103);
		ans2.setAnswer("java is popular language");
		 
		List<Answer> answerList = new ArrayList<Answer>();
		answerList.add(ans);
		answerList.add(ans1);
		answerList.add(ans2);
		qus.setAnswers(answerList);
		
		Transaction tx =session.beginTransaction();
		session.save(qus);
		session.save(ans);
		session.save(ans1);
		session.save(ans2);
		tx.commit();
		 
		session.close();
		factory.close();		
	}

}
