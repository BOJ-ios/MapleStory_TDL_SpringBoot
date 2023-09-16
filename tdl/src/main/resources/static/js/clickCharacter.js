function clickCharacter(element) {
  let hiddenInput = element.querySelector('input[type="hidden"]');
  let characterValue = hiddenInput.value;
  let url = "/todo?character=" + encodeURIComponent(characterValue);
  window.location.href = url;
}
