const API_URL = "http://localhost:8080/api/quiz";
let questionsList = [];

async function loadQuiz() {
    const res = await fetch(API_URL);
    questionsList = await res.json();

    const quizContainer = document.getElementById("quiz-container");
    quizContainer.innerHTML = "";

    questionsList.forEach((q, index) => {
        quizContainer.innerHTML += `
            <div class="card">
                <p><strong>${index + 1}. ${q.question}</strong></p>
                <input type="radio" name="q${q.id}" value="${q.optionA}"> ${q.optionA}<br>
                <input type="radio" name="q${q.id}" value="${q.optionB}"> ${q.optionB}<br>
                <input type="radio" name="q${q.id}" value="${q.optionC}"> ${q.optionC}<br>
                <input type="radio" name="q${q.id}" value="${q.optionD}"> ${q.optionD}<br>
            </div>
        `;
    });
}

function submitQuiz() {
    let score = 0;
    questionsList.forEach(q => {
        const selected = document.querySelector(`input[name="q${q.id}"]:checked`);
        if (selected && selected.value === q.correctAnswer) {
            score++;
        }
    });
    document.getElementById("result").innerText = `Your Score: ${score} / ${questionsList.length}`;
}

// Load quiz on page open
loadQuiz();
