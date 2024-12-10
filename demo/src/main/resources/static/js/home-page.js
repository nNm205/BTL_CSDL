const btn1 = document.getElementById("button1");
const btn2 = document.getElementById("button2");
const btn3 = document.getElementById("button3");
const btn4 = document.getElementById("button4");
const backButtons = document.querySelectorAll(".backButton");

const studentContainer = document.getElementById("student-container");
const scoreContainer = document.getElementById("score-container");
const subjectTable = document.getElementById("subject-table");
const scoreTable = document.getElementById("score-table");
const classTable = document.getElementById("class-table");
for (let i = 0; i < backButtons.length; i++) {
   backButtons[i].addEventListener("click", (event) => {
      studentContainer.style.display = 'none';
      scoreContainer.style.display = 'none';
   });
}

btn1.addEventListener("click", (event) => {
   studentContainer.style.display = 'block';
   scoreContainer.style.display = 'none';
});

btn2.addEventListener("click", (event) => {
   studentContainer.style.display = 'none';
   scoreContainer.style.display = 'block';
});

btn3.addEventListener("click", (event) => {
   subjectTable.style.display = 'table';
});

btn4.addEventListener("click", (event) => {
   classTable.style.display = 'table';
});

/* search bar */
$(document).ready(function() {
   $("#searchType").change(function() {
      var selectedOption = $(this).find(':selected');
      var placeholderText = selectedOption.data('placeholder') || "Hãy nhập kiểu tìm kiếm";
      $("#searchBar").attr("placeholder", placeholderText);
   });
});
