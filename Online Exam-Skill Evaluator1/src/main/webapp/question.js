    document.addEventListener("DOMContentLoaded", function() {
	const questions = document.querySelectorAll('.question');
	let currentQuestionIndex = 0;

	function showQuestion(index) {
		questions.forEach((question, i) => {
			if (i === index) {
				question.style.display = 'block';
				startTimer(question);
			} else {
				question.style.display = 'none';
			}
		});
	}
   function startTimer(question) {
    const timerElement = question.querySelector('.timer');
    let seconds = parseInt(timerElement.dataset.seconds);

    const timerInterval = setInterval(() => {
        seconds--;
        timerElement.textContent = `Time remaining: ${seconds} seconds`;

        if (seconds <= 0) {
            clearInterval(timerInterval);
            timerElement.textContent = 'Time expired';  
            setTimeout(nextQuestion,1000);
     
        }
    }, 1000);
}
 

   function previousQuestion() {
		if (currentQuestionIndex > 0) {
			currentQuestionIndex--;
			showQuestion(currentQuestionIndex);
		}
	}
	function nextQuestion() {
		if (currentQuestionIndex < questions.length - 1) {
			currentQuestionIndex++;
			showQuestion(currentQuestionIndex);
		} else {

			document.getElementById('submitBtn').style.display = 'block';
		}
	}
	showQuestion(currentQuestionIndex);
	document.querySelector('button[type="button"][onclick="previousQuestion()"]').addEventListener('click', previousQuestion);
	document.querySelector('button[type="button"][onclick="nextQuestion()"]').addEventListener('click', nextQuestion);
    document.getElementById('submitBtn').addEventListener('click', showResults);
});
