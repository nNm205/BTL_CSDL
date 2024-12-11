const btn1 = document.getElementById("button1");
const btn2 = document.getElementById("button2");
const btn3 = document.getElementById("button3");
const btn4 = document.getElementById("button4");
const backButtons = document.querySelectorAll(".backButton");
const editButton = document.getElementById("editButton");
const editForm = document.getElementById("editForm-container");
const saveButton = document.getElementById("saveButton");

editButton.addEventListener("click", (event) => {
   editForm.style.display = 'block';
});

saveButton.addEventListener("click", (event) => {
   editForm.style.display = 'none';
});

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

function showStudentList() {
   document.getElementById("student-container").style.display = "block";
   document.getElementById("score-container").style.display = "none";
}

function showScoreList() {
   document.getElementById("student-container").style.display = "none";
   document.getElementById("score-container").style.display = "block";
}

function showEditStudentForm(studentId) {
   $.ajax({
      url: '/getStudent/' + studentId,
      type: 'GET',
      success: function(student) {
         $('#studentId').val(student.id);
         $('#studentName').val(student.name);
         $('#editStudentModal').modal('show');
      },
      error: function() {
         alert('Lỗi khi lấy thông tin sinh viên');
      }
   });
}

$('#editStudentForm').submit(function(event) {
   event.preventDefault();

   $.ajax({
      url: '/updateStudent',
      type: 'POST',
      data: $(this).serialize(),
      success: function() {
         alert('Cập nhật thông tin sinh viên thành công');
         $('#editStudentModal').modal('hide');
         // Tải lại danh sách sinh viên hoặc cập nhật thông tin trên trang
      },
      error: function() {
         alert('Lỗi khi cập nhật thông tin sinh viên');
      }
   });
});