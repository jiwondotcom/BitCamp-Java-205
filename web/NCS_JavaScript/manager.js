// 회원의 정보 : 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의

function Member(userID, userPW, userName) {
    this.userID = userID;
    this.userPW = userPW;
    this.userName = userName;
}

// 객체가 가지는 메소드는 공통으로 사용 -> prototype
Member.prototype.makeHtml = function () {
    return '[ userID : ' + this.userID + ', userPW : ' + this.userPW + ', userName : ' + this.userName + ' ]'
};


// 회원의 정보를 저장하는 배열
var members = []; // new Array()


// 사용자가 입력한 정보로 Member 객체를 생성
// submit 이벤트 연결

$(document).ready(function () {
    // localStorage 저장된 데이터가 있는지 확인
    // localStorage.getItem('members') 없으면 -> null값 반환
    if (localStorage.getItem('members') == null) {
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


    // 사용자가 입력한 값(val())을 반환한다.

    // regForm 캐스팅
    // 입력창 아래 메시지 출력


    $('#regForm').submit(function () {

        var idPattern = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;
        var pwPattern = /^[A-za-z0-9]{4,20}$/g;
        var namePattern = /^[가-힣a-zA-Z]{2,10}$/;


        // 아이디(이메일) 공백 체크
        // 아이디(이메일) 형식 체크
        if ($('#userID').val().trim().length < 1) {
            $('#userID+div.msg').html('필수항목입니다.');
            $('#userID+div.msg').css('display', 'block');
            // alert('이름을 입력해주세요.');
            return false;
        } else if (!idPattern.test($('#userID').val())) {
            $('#userID+div.msg').html('아이디는 이메일 형식으로만 가능합니다.');
            $('#userID+div.msg').css('display', 'block');
            return false;
        }


        // 비밀번호 공백 체크
        // 비밀번호 형식 체크
        if ($('#userPW').val().trim().length < 1) {
            $('#userPW+div.msg').html('필수항목입니다.');
            $('#userPW+div.msg').css('display', 'block');
            // alert('비밀번호를 입력해주세요.');
            return false;
        } else if (!pwPattern.test($('#userPW').val())) {
            $('#userPW+div.msg').html('비밀번호는 4~20자 사이의 영문 대소문자+숫자만 가능합니다.');
            $('#userPW+div.msg').css('display', 'block');
            return false;
        }


        // 사용자 이름 공백 체크
        // 이름 형식 체크
        if ($('#userName').val().trim().length < 1) {
            $('#userName+div.msg').html('필수항목입니다.');
            $('#userName+div.msg').css('display', 'block');
            // alert ('이름을 입력해주세요.');
            return false;
        } else if (!namePattern.test($('#userName').val())) {
            $('#userName+div.msg').html('이름은 2~10자 사이의 한글/영문만 사용 가능합니다.');
            $('#userName+div.msg').css('display', 'block');
            return false;
        }


        // 배열에 사용자 정보를 추가
        members.push(new Member($('#userID').val(), $('#userPW').val(), $('#userName').val()));

        // 로컬스토리지에 저장(반영)
        localStorage.setItem('members', JSON.stringify(members));

        alert('등록되었습니다.');

        // 콘솔 출력
        console.log('회원리스트', members);

        // 등록버튼을 누르면 화면 입력창 값에 남아있는 내용이 리셋되는 함수
        // form 초기화
        this.reset();

        // 테이블 세팅
        setList();

    });

    // 배열의 요소 수정 함수
    $('#editForm').submit(function () {

        var pwPattern = /^[A-za-z0-9]{4,20}$/g;
        var namePattern = /^[가-힣a-zA-Z]{2,10}$/;


        // 비밀번호 공백 체크
        // 비밀번호 형식 체크
        if ($('#editPW').val().trim().length < 1) {
            alert('비밀번호를 입력해주세요.');
            return false;
        } else if (!pwPattern.test($('#editPW').val())) {
            alert('비밀번호는 4~20자 사이의 영문 대소문자+숫자만 가능합니다.');
            return false;
        }


        // 사용자 이름 공백 체크
        // 이름 형식 체크
        if ($('#editName').val().trim().length < 1) {
            alert('이름을 입력해주세요.');
            return false;
        } else if (!namePattern.test($('#editName').val())) {
            alert('이름은 2~10자 사이의 한글/영문만 사용 가능합니다.');
            return false;
        }


        if (!confirm('수정하시겠습니까?')) {
            return false;
        }

        // 로컬스토리지에 저장(반영)
        members[$('#index').val()].userPW = $('#editPW').val();
        members[$('#index').val()].userName = $('#editName').val();
        localStorage.setItem('members', JSON.stringify(members));
        // 테이블 세팅
        setList();

        alert('수정 완료되었습니다.');

        // 수정 창 닫힘
        editMemberClose();

        return false;

    });

    // 입력란 공백시 출력되는 안내문 -> 포커스시(재입력 시도시) 삭제하는 함수
    $('#userID').focus(function () {
        $('#userID+div.msg').css('display', 'none');
        $('#userID+div.msg').html('필수항목입니다.');
    });


    $('#userPW').focus(function () {
        $('#userPW+div.msg').css('display', 'none');
        $('#userPW+div.msg').html('필수항목입니다.');
    });


    $('#rePW').focus(function () {
        $('#rePW+div.msg').css('display', 'none');
        $('#rePW+div.msg').html('필수항목입니다.');
    });


    $('#userName').focus(function () {
        $('#userName+div.msg').css('display', 'none');
        $('#userName+div.msg').html('필수항목입니다.');
    });

}); // ready 끝




// 배열에 있는 요소를 -> table tr행을 만들어서 출력
function setList() {

    var list = $('#list');

    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if (members.length < 1) {

        tbody += '<tr>';
        tbody += '<th colspan = "5"> 데이터가 존재하지 않습니다.</th>';
        tbody += '</tr>';

    } else {
        for (var i = 0; i < members.length; i++) {
            tbody += '<tr>';
            tbody += '    <th>' + i + '</th>';
            tbody += '    <th>' + members[i].userID + '</th>';
            tbody += '    <th>' + members[i].userPW + '</th>';
            tbody += '    <th>' + members[i].userName + '</th>';
            tbody += '    <th><a href = "javascript:editMember(' + i + ')">수정</a>  |  <a href = "javascript:deleteMember(' + i + ')">삭제</a></th>';
            tbody += '</tr>';
        }
    }

    // list를 캐스팅
    $('#list').html(tbody);

}


// 배열의 요소 삭제 함수
function deleteMember(index) {

    // 배열의 index 요소를 삭제
    // splice (index, count) : index에서 시작해서 count만큼의 요소를 삭제하고 남은 요소의 배열을 반환합니다.
    if (confirm('삭제하시겠습니까?')) {
        members.splice(index, 1);
        alert('삭제되었습니다.');
        // 테이블의 리스트를 갱신한다.

        // 저장
        localStorage.setItem('members', JSON.stringify(members));
        setList();
    }
}



function editMember(index) {

    // 수정 폼 영역이 노출되어야 한다.
    $('#editFormArea').css('display', 'block');

    // 이전 데이터를 폼에 세팅
    $('#editID').val(members[index].userID);
    $('#editPW').val(members[index].userPW);
    $('#editrePW').val(members[index].userPW);
    $('#editName').val(members[index].userName);
    $('#index').val(index);
}


// 회원정보 수정창이 닫히는 함수
function editMemberClose() {
    $('#editFormArea').css('display', 'none');
}