package com.example.quizapp.controller;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    // ✅ Get all quizzes
    @GetMapping
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Quiz> getQuizByCategory(@PathVariable String category) {
        List<Quiz> allQuizzes = quizRepository.findByCategoryIgnoreCase(category);
        return allQuizzes.stream().limit(10).toList();  // ✅ returns only first 10
    }


    // ✅ Add a new quiz
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
