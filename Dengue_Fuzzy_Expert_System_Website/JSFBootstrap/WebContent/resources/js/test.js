const question = document.querySelector("#question");
const choices = Array.from(document.querySelectorAll(".choice-text"));
const progressText = document.querySelector("#progressText");
const scoreText = document.querySelector("#score");
const progressBarFull = document.querySelector("#progressBarFull");

let currentQuestion = {};
let acceptingAnswers = true;
let score = 0;
let questionCounter = 0;
let availableQuestions = [];

let questions = [
  {
    question:
      "Do you have any body parts feel aches and pains ? For examples, eye pain, typically behind the eyes, muscle, joint, or bone pain.",
    choice1: "Yes",
    choice2: "Maybe",
    choice3: "No",
    answer: 2,
    answer: 1,
    answer: 3,
  },
  {
    question:
      "Are you having fever (37.5 degree celsius above) continuously more than three days ?",
    choice1: "Yes",
    choice2: "Maybe",
    choice3: "No",
    answer: 2,
    answer: 1,
    answer: 3,
  },
  {
    question:
      "Do you have any hemorrhagic manifestation at any part of your body ? (The most common hemorrhagic manifestations are mild and include a positive tourniquet test, skin hemorrhages (petechiae, hematomas), epistaxis (nose bleed), gingival bleeding (gum bleed), and microscopic hematuria.)",
    choice1: "Yes",
    choice2: "Maybe",
    choice3: "No",
    answer: 2,
    answer: 1,
    answer: 3,
  },
  {
    question:
      "Do you feel rash ? (Rash in dengue fever is a maculopapular or macular confluent rash over the face, thorax, and flexor surfaces, with islands of skin sparing. The rash typically begins on day 3 and persists 2-3 days.)",
    choice1: "Yes",
    choice2: "Maybe",
    choice3: "No",
    answer: 2,
    answer: 1,
    answer: 3,
  },
];

const SCORE_POINTS = 1;
const MAX_QUESTIONS = 4;

startGame = () => {
  questionCounter = 0;
  score = 0;
  availableQuestions = [...questions];
  getNewQuestion();
};

getNewQuestion = () => {
  if (availableQuestions.length === 0 || questionCounter > MAX_QUESTIONS) {
    localStorage.setItem("mostRecentScore", score);

    return window.location.assign("/end.html");
  }

  progressText.innerText = `Question ${questionCounter} of ${MAX_QUESTIONS}`;
  progressBarFull.style.width = `${(questionCounter / MAX_QUESTIONS) * 100}%`;

  currentQuestion = availableQuestions[0];
  question.innerText = currentQuestion.question;

  choices.forEach((choice) => {
    const number = choice.dataset["number"];
    choice.innerText = currentQuestion["choice" + number];
  });

  availableQuestions.splice(0, 1);
  questionCounter++;

  acceptingAnswers = true;
};

choices.forEach((choice) => {
  choice.addEventListener("click", (e) => {
    if (!acceptingAnswers) return;

    acceptingAnswers = false;
    const selectedChoice = e.target;
    const selectedAnswer = selectedChoice.dataset["number"];

    let classToApply =
      selectedAnswer == currentQuestion.answer ? "correct" : "incorrect";

    if (classToApply === "correct") {
      incrementScore(SCORE_POINTS);
    }

    selectedChoice.parentElement.classList.add(classToApply);

    setTimeout(() => {
      selectedChoice.parentElement.classList.remove(classToApply);
      getNewQuestion();
    }, 10);
  });
});

incrementScore = (num) => {
  score += num;
  scoreText.innerText = score;
};

startGame();
