document
  .getElementById("loginForm")
  .addEventListener("submit", function (event) {
    let actionValue = event.submitter.getAttribute("value");
    if (actionValue === "로그인") {
      this.action = "/login";
    } else if (actionValue === "회원가입") {
      this.action = "/register";
    }
  });
