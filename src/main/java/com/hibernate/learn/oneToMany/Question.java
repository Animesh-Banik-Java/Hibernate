package com.hibernate.learn.oneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany; 

@Entity
public class Question {
	@Id
	@Column(name="QId")
	private int questionID;
	@Column(name="Qus")
	private String question;

	@OneToMany(mappedBy="question") 
	private List<Answer> answers;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionID, String question, List<Answer> answers) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", question=" + question + ", answers=" + answers + "]";
	}

}
