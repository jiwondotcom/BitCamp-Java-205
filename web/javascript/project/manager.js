
// 회원의 정보 : 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의

function Member(id, pw, name) {
    this.userID = id;
    this.userPW = pw;
    this.userName = name;
}

// 객체가 가지는 메소드는 공통으로 사용 -> prototype
Member.prototype.makeHtml = function() {
    return '[ id : ' + this.userID + ', pw : ' + this.userPW + ', name : ' + this.userName + ' ]'
};


////////////////////////////////////////////////////////////////////////

// 회원의 정보를 저장하는 배열
var members = []; // new Array()

// 배열 -> JSON(문자열) -> localStorage에 저장
// 저장
// 수정
// 삭제
// setItem('memebers', JSON.stringify(members))

////////////////////////////////////////////////////////////////////////


// 사용자가 입력한 정보로 Member 객체를 생성
// submit 이벤트 연결

window.onload = function() {

    // localStorage 저장된 데이터가 있는지 확인
    // localStorage.getItem('members') 없으면 -> null값 반환
    if(localStorage.getItem('members') == null) {
        // 배열 members를 저장
        // 객체를 문자열로 변환한다. (JSON)
        localStorage.setItem('members', JSON.stringify(members));
    } else {
        members = JSON.parse(localStorage.getItem('members')); 
        // JSON 문자열 -> 객체로 변환
        // member에 할당해준다.
        console.log(members);
       
        // 테이블 세팅
        setList();
    }

   
        // 사용자가 입력한 값(value)을 반환한다.
        var userID = document.querySelector('#userID');
        var userPW = document.querySelector('#userPW');
        var rePW = document.querySelector('#rePW');
        var userName = document.querySelector('#userName');

        
    // regForm 캐스팅
    // 입력창 아래 메시지 출력
    var regForm = document.getElementById('regForm');
    
    regForm.onsubmit = function() {
       
      
        // 아이디 공백 체크
        if(userID.value.trim().length < 1) {
            document.querySelector('#userID+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userID+div.msg').style.display='block';
            // alert('이름을 입력해주세요.');
            return false;
        }


        // 비밀번호 공백 체크
        if(userPW.value.trim().length < 1) {
            document.querySelector('#userPW+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userPW+div.msg').style.display='block';
            // alert('비밀번호를 입력해주세요.');
            return false;
        }

        // 비밀번호 확인 공백 체크
        if(rePW.value.trim().length < 1) {
            document.querySelector('#rePW+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#rePW+div.msg').style.display='block';
            // alert('비밀번호를 입력해주세요.');
            return false;
        }

        // 비밀번호와 비밀번호 확인의 일치 여부 체크(비교)
        if(userPW.value.trim() != rePW.value.trim()) {
            document.querySelector('#rePW+div.msg').innerHTML = '비밀번호가 일치하지 않습니다. \n다시 확인해주세요.';
            document.querySelector('#rePW+div.msg').style.display='block';
            // alert('비밀번호가 일치하지 않습니다. \n다시 확인해주세요.');
            return false;
        }

        // 사용자 이름 정보
        if(userName.value.trim() < 1) {
            document.querySelector('#userName+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userName+div.msg').style.display='block';
            // alert ('이름을 입력해주세요.');
            return false;
        }

        // console 출력
        console.log(userID.value);
        console.log(userPW.value);
        console.log(rePW.value);
        console.log(userName.value);
       

        // // 객체 생성
        // var member = new Member(userID.value, userPW.value, userName.value);
        // console.log (typeof member, member.makeHtml());
       

        // 배열에 사용자 정보를 추가
        members.push(new Member(userID.value, userPW.value, userName.value));

        alert ('등록 완.')
        console.log('회원리스트', members);

        // 등록버튼을 누르면 화면 입력창 값에 남아있는 내용이 리셋되는 함수
        // form 초기화
        this.reset();

        setList();


        return false;
    }

    // 입력란 공백시 출력되는 안내문 -> 포커스시(재입력 시도시) 삭제하는 함수
    userID.addEventListener('focus', function() {
        document.querySelector("#userID+div.msg").style.display= 'none';
        document.querySelector('#userID+div.msg').innerHTML = '필수항목입니다.';
    });

    userPW.addEventListener('focus', function() {
        document.querySelector("#userPW+div.msg").style.display= 'none';
        document.querySelector('#userPW+div.msg').innerHTML = '필수항목입니다.';
    });
    
    rePW.addEventListener('focus', function() {
        document.querySelector("#rePW+div.msg").style.display= 'none';
        document.querySelector('#rePW+div.msg').innerHTML = '필수항목입니다.';
        rePW.value = '';
    });

    userName.addEventListener('focus', function() {
        document.querySelector("#userName+div.msg").style.display= 'none';
        document.querySelector('#userName+div.msg').innerHTML = '필수항목입니다.';
    });


}


// 배열에 있는 요소를 -> table tr행을 만들어서 출력
function setList () {

    // table의 tbody 캐스팅
    var list = document.querySelector('#list');

    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if(members.length < 1) {

        tbody += '<tr>';
        tbody += '<th colspan = "5"> 데이터가 존재하지 않습니다.</th>';
        tbody += '</tr>';

    } else {

        for(var i = 0; i < members.length; i++) {
            tbody += '<tr>';    
            tbody += '    <th>' + i + '</th>';
            tbody += '    <th>' + members[i].userID + '</th>';
            tbody += '    <th>' + members[i].userPW + '</th>';
            tbody += '    <th>' + members[i].userName + '</th>';
            tbody += '    <th><a href = "javascript:editMember(' + i + ')">수정</a> | <a href = "javascript:deleteMember(' + i + ')">삭제</a></th>';
            tbody += '</tr>';
        }   
     }
    
    // list를 캐스팅
    list.innerHTML = tbody;

}


// 배열의 요소 삭제 함수
function deleteMember(index) {
    // alert (index + ' 인덱스의 요소를 삭제합니다.');

    // var chk = confirm('삭제하시겠습니까?');

    // 배열의 index 요소를 삭제
    // splice (index, count) : index에서 시작해서 count만큼의 요소를 삭제하고 남은 요소의 배열을 반환합니다.
    // splice (index, 1)
    if(confirm('삭제하시겠습니까?')) {
        members.splice(index, 1);
        alert('삭제되었습니다.');
        // 테이블의 리스트를 갱신한다.

        // 저장
        localStorage.setItem('members', JSON.stringify(members));
        setList();
    }
}




// 배열의 요소 수정 함수
function editMember(index) {

    // 수정 폼 영역이 노출되어야 한다.
    document.querySelector('#editFormArea').style.display = 'block';

    // 전달받은 index값으로 members 배열의 객체 하나를 얻을 수 있다.
    console.log(index, members[index]);


    // editForm 태그들의 value값을 세팅
    // 캐스팅
    var editUserID = document.querySelector('#editID');
    var editUserPW = document.querySelector('#editPW');
    var editUserRePW = document.querySelector('#editrePW');
    var editUserName = document.querySelector('#editName');
    var editINDEX = document.querySelector('#index');

    // 이전 데이터를 폼에 세팅
    editUserID.value = members[index].userID;
    editUserPW.value = members[index].userPW;
    editUserRePW.value = members[index].userPW;
    editUserName.value = members[index].userName;
    editINDEX.value = index;


    document.querySelector('#editForm').onsubmit = function() {

        // var member = new Member(editUserID.value, editUserPW.value, editUserName.value);
        // console.log(editINDEX.value, member);


        // 비밀번호와 비밀번호 확인이 같은지 체크
        if (editUserPW.value != editUserRePW.value) {
            alert('비밀번호가 일치하지 않습니다. \n다시 확인해주세요.');
            return false;
        }

        if (!confirm ('수정하시겠습니까?')) {
            return false;
        }
        
        members[editINDEX.value].userPW = editUserPW.value;
        members[editINDEX.value].userName = editUserName.value;
        
        alert ('수정 완.');
        
        //저장
        localStorage.setItem('members', JSON.stringify(members));
        
        // 테이블 세팅
        setList();

        // 수정 창 닫힘
        editMemberClose();

        return false; 
    }


}


// 회원정보 수정창이 닫히는 함수
function editMemberClose() {
    document.querySelector('#editFormArea').style.display = 'none';
}
