/**
 * 
 */
 // 변수 선언
 var id = document.querySelector('#user_id');
 
 var pw1 = document.querySelector('#user_pw');
 var pw2 = document.querySelector('#user_pw_check');
 
 var error = document.querySelectorAll('.error');
 var message = document.querySelector('.message');
 
 // 이벤트 핸들러 연결
 id.addEventListener("focusout", checkId);
 pw1.addEventListener("focusout", checkPw);
 pw2.addEventListener("focusout", comparePw);
 message.addEventListener("focus", pwMessage);

 /*message.addEventListener("focus", function() {
	this.value = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
});*/

 
 // 아이디 확인
  function checkId() {
    if(id.value === "") {
        error[0].innerHTML = "필수 입력 항목 입니다";
        error[0].style.display = "block";
    } else {
      //  error[0].innerHTML = "";
    }
}

  // 비밀번호 메세지
 function pwMessage() {
	message[0].innerHTML = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
}

  // 비밀번호 확인
 function checkPw() {
    if(pw1.value === "") {
        error[1].innerHTML = "필수 입력 항목 입니다";
        error[1].style.display = "block";
	 } else {
     
    }
}
  
  // 비밀번호 재확인
  function comparePw() {
      if(pw2.value === "") {
        error[2].innerHTML = "필수 입력 항목 입니다";
        error[2].style.display = "block";
    }
}