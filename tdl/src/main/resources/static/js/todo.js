//! Todo 내용 업데이트
function updateTodo(input) {
  var newValue = input.value;
  console.log("new todo value: " + newValue);
  var row = input.closest("tr"); // 현재 행 찾기
  if (!row) {
    alert("오류 : 현재 행을 찾을 수 없습니다.");
    return;
  }
  var id_select = row.querySelector("input[type='hidden']");
  if (!id_select) {
    alert("오류 : Todo ID를 찾을 수 없습니다.");
    return;
  }
  var id = id_select.value;
  var xhr = new XMLHttpRequest();
  xhr.open("PUT", "/todo/updateTodoName", true);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        console.log("Todo name updated successfully.");
      } else {
        alert("오류 : Todo 내용 업데이트 불가 " + xhr.responseText);
      }
    }
  };
  xhr.send(JSON.stringify({ value: newValue, id: id }));
}
//! Todo 초기화일 업데이트
function dailyWeeklyChange(button) {
  var text = button.textContent;
  console.log("현재 초기화일: " + text);
  var newDailyWeekly = text !== "주간";
  var row = button.closest("tr"); // 현재 행 찾기
  if (!row) {
    alert("오류 : 현재 행을 찾을 수 없습니다.");
    return;
  }
  var id_select = row.querySelector("input[type='hidden']");
  if (!id_select) {
    alert("오류 : Todo ID를 찾을 수 없습니다.");
    return;
  }
  var id = id_select.value;
  var xhr = new XMLHttpRequest();
  xhr.open("PUT", "/todo/dailyWeeklyChange", true);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        button.textContent = newDailyWeekly ? "주간" : "일일";
        console.log("Todo checkbox updated successfully.");
      } else {
        alert("오류 : 초기화일 변경 불가 - " + xhr.responseText);
      }
    }
  };
  xhr.send(JSON.stringify({ dailyWeekly: newDailyWeekly, id: id }));
}
//! Todo 완료 박스 업데이트
function updateTodoStatus(checkbox) {
  var newStatus = checkbox.checked;
  console.log("new todo status: " + newStatus);
  var row = checkbox.closest("tr"); // 현재 행 찾기
  if (!row) {
    alert("오류 : 현재 행을 찾을 수 없습니다.");
    return;
  }
  var id_select = row.querySelector("input[type='hidden']");
  if (!id_select) {
    alert("오류 : Todo ID를 찾을 수 없습니다.");
    return;
  }
  var id = id_select.value;
  var xhr = new XMLHttpRequest();
  xhr.open("PUT", "/todo/updateTodoStatus", true);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        console.log("Todo checkbox updated successfully.");
      } else {
        alert("오류 : 완료버튼 체크(해제) 불가 - " + xhr.responseText);
      }
    }
  };
  xhr.send(JSON.stringify({ status: newStatus, id: id }));
}

//! Todo 삭제
function deleteTodo(button) {
  var row = button.closest("tr"); // 해당 버튼이 속한 행(tr) 가져오기
  if (!row) {
    alert("오류 : 현재 행을 찾을 수 없습니다.");
    return;
  }
  var id_select = row.querySelector("input[type='hidden']");
  if (!id_select) {
    alert("오류 : Todo ID를 찾을 수 없습니다.");
    return;
  }
  var id = id_select.value;
  var confirmDelete = confirm("정말로 삭제하시겠습니까?");
  if (confirmDelete) {
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", "/todo/deleteTodo", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          row.parentNode.removeChild(row);
          console.log("Todo deleted successfully.");
        } else {
          alert("오류 : 삭제 실패 - " + xhr.responseText);
        }
      }
    };
    xhr.send(JSON.stringify({ id: id }));
  }
}

//! Todo 생성
function addNewTodo() {
  console.log("addNewTodo 클릭");
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "/todo/addNewTodo", true);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        console.log("Todo created successfully.");
        window.location.reload();
      } else {
        alert("오류 : Todo 생성 실패 - " + xhr.responseText);
      }
    }
  };
  xhr.send(JSON.stringify({}));
}

//!시계
function updateClock() {
  const clockElement = document.getElementById("clock");
  const now = new Date();

  const hours = now.getHours().toString().padStart(2, "0");
  const minutes = now.getMinutes().toString().padStart(2, "0");
  const seconds = now.getSeconds().toString().padStart(2, "0");

  const timeString = `${hours}:${minutes}:${seconds}`;
  clockElement.textContent = timeString;
}

// 최초 한 번 호출
updateClock();

// 1초마다 업데이트
setInterval(updateClock, 1000);
