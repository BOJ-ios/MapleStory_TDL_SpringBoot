document.addEventListener("DOMContentLoaded", function () {
  // HTML이 완전히 로딩된 후에 실행할 코드 작성
  var imgElements = document.querySelectorAll(".quest_img, .simball");

  imgElements.forEach(function (imgElement) {
    var parentDiv = imgElement.parentElement;
    var hiddenInput = parentDiv.querySelector('input[type="hidden"]');
    if (hiddenInput) {
      var value = hiddenInput.value;
      if (value === "1") {
        imgElement.classList.add("toBlack");
      }
    }
  });
});

function toggleImage(imgElement) {
  var parentDiv = imgElement.parentElement;
  var hiddenInput = parentDiv.querySelector('input[type="hidden"]');
  if (hiddenInput) {
    var value = hiddenInput.value;
    if (value === "0") {
      imgElement.classList.add("toBlack"); // 흑백 클래스 추가
      hiddenInput.value = "1";
    } else if (value === "1") {
      imgElement.classList.remove("toBlack"); // 흑백 클래스 제거
      hiddenInput.value = "0";
    }
  }
}
