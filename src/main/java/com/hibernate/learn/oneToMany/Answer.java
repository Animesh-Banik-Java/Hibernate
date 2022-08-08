package com.hibernate.learn.oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
@Entity
public class Answer {
	@Id 
	@Column(name="AnsId")
	private int answerID;
	@Column(name="Ans")
	private String answer;
	
	@ManyToOne
	private Question question;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int answerID, String answer) {
		super();
		this.answerID = answerID;
		this.answer = answer;
	}
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [answerID=" + answerID + ", answer=" + answer + "]";
	}
	
	
}
