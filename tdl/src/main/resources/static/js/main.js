document
  .getElementById("loginForm")
  .addEventListener("submit", function (event) {
    var actionValue = event.submitter.getAttribute("value");
    if ($("#id").val() == "") {
      $("#loginFailReason").text("아이디를 입력해 주세요.");
      $("#loginFailReason").css("color", "red");
      $("#id").focus();
    } else if ($("#pw").val() == "") {
      $("#loginFailReason").text("비밀번호를 입력해 주세요.");
      $("#loginFailReason").css("color", "red");
      $("#pw").focus();
    }
    if (actionValue === "로그인") {
      this.action = "/login";
    } else if (actionValue === "회원가입") {
      this.action = "/register";
    }
  });
