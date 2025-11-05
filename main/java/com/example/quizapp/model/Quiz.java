package com.example.quizapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;
    private String correct_answer;
    private String category;  // ✅ THIS FIELD MUST EXIST

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getOptiona() { return optiona; }
    public void setOptiona(String optiona) { this.optiona = optiona; }

    public String getOptionb() { return optionb; }
    public void setOptionb(String optionb) { this.optionb = optionb; }

    public String getOptionc() { return optionc; }
    public void setOptionc(String optionc) { this.optionc = optionc; }

    public String getOptiond() { return optiond; }
    public void setOptiond(String optiond) { this.optiond = optiond; }

    public String getCorrect_answer() { return correct_answer; }
    public void setCorrect_answer(String correct_answer) { this.correct_answer = correct_answer; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
