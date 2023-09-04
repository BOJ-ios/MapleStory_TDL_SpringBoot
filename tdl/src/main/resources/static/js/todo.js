function updateTodo(input) {
  var newValue = input.value;
  console.log("new todo value: " + newValue);
  var row = input.closest("tr"); // 현재 행 찾기

  if (!row) {
    console.error("Row not found");
    return;
  }

  var todoIdInput = row.querySelector("input[type='hidden']");
  if (!todoIdInput) {
    console.error("Todo ID input not found");
    return;
  }

  var todoId = todoIdInput.value;

  var xhr = new XMLHttpRequest();
  xhr.open("PUT", "/updateTodoName/" + todoId, true);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        console.log("Todo name updated successfully.");
      } else {
        console.error("Error updating todo name: " + xhr.responseText);
      }
    }
  };

  xhr.send(JSON.stringify({ newValue: newValue }));
}

function updateTodoStatus(checkbox) {
  var newStatus = checkbox.checked;
  console.log("new todo status: " + newStatus);
  var row = checkbox.closest("tr"); // 현재 행 찾기
  if (!row) {
    console.error("Row not found");
    return;
  }

  var todoIdInput = row.querySelector("input[type='hidden']");
  if (!todoIdInput) {
    console.error("Todo ID input not found");
    return;
  }

  var todoId = todoIdInput.value;
  // Send an AJAX request to update the todo's status
  var xhr = new XMLHttpRequest();
  xhr.open("PUT", "/updateTodoStatus/" + todoId, true);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status !== 200) {
        alert("Error updating todo status: " + xhr.responseText);
      }
    }
  };
  xhr.send(JSON.stringify({ newStatus: newStatus }));
}

function deleteTodo(button) {
  var row = button.closest("tr"); // 해당 버튼이 속한 행(tr) 가져오기
  var todoId = row.querySelector("input[type='hidden']").value; // hidden 필드에서 todoId 가져오기

  // Confirm deletion with the user
  var confirmDelete = confirm("Are you sure you want to delete this todo?");
  if (confirmDelete) {
    // Send an AJAX request to delete the todo
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", "/deleteTodo/" + todoId, true);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          // Remove the row from the table on success
          row.parentNode.removeChild(row);
        } else {
          alert("Error deleting todo: " + xhr.responseText);
        }
      }
    };
    xhr.send();
  }
}

function addNewTodo() {
  // Send an AJAX request to insert the new record
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "/insertTodo", true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      // Handle the successful response (e.g., refresh the page)
      window.location.reload();
    }
  };
  xhr.send(JSON.stringify());
}
