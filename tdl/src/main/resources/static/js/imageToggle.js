document.addEventListener("DOMContentLoaded", function () {
  // HTML이 완전히 로딩된 후에 실행할 코드 작성
  let imgElements = document.querySelectorAll(".quest_img, .simball");

  imgElements.forEach(function (imgElement) {
    let parentDiv = imgElement.parentElement;
    let hiddenInput = parentDiv.querySelector('input[type="hidden"]');
    if (hiddenInput) {
      let value = hiddenInput.value;
      if (value === "1") {
        imgElement.classList.add("toBlack");
      }
    }
  });
});

function toggleImage(imgElement) {
  let parentDiv = imgElement.parentElement;
  let hiddenInput = parentDiv.querySelector('input[type="hidden"]');
  if (hiddenInput) {
    let value = hiddenInput.value;
    if (value === "0") {
      imgElement.classList.add("toBlack"); // 흑백 클래스 추가
      hiddenInput.value = "1";
    } else if (value === "1") {
      imgElement.classList.remove("toBlack"); // 흑백 클래스 제거
      hiddenInput.value = "0";
    }
  }
}
