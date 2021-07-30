$(document).ready(function () {

    $('#userID').focusin(function () {
        $('#msg').addClass('display_none');
        $('#msg').removeClass('color_blue');
        $('#msg').removeClass('color_red');

        $(this).val('');
    });

    $('#userID').focusout(function () {
        // ajax 비동기 통신 > id를 서버로 보내고 사용 가능 유무의 응답 코드를 받는다 -> 화면에 메시지 출력

        $.ajax({
            url: 'idcheck.do',
            type: 'post',
            data: {
                mid: $(this).val()
            },
            beforeSend: function () {
                $('#loadingImg').removeClass('display_none');
            },
            success: function (data) {
                // data : Y / N
                if (data == 'Y') {
                    $('#msg').html('멋진 아이디네요!');
                    $('#msg').addClass('color_blue');
                    $('#msg').removeClass('display_none');
                } else {
                    $('#msg').html('이미 사용하고 있는 아이디입니다.');
                    $('#msg').addClass('color_red');
                    $('#msg').removeClass('display_none');
                }
            },
            error: function (request, status, error) {
                alert('서버 통신에 문제가 발생했습니다. \n다시 실행해주세요.');
                console.log(request);
                console.log(status);
                console.log(error);
            },
            complete: function () {
                $('#loadingImg').addClass('display_none');
            }
        });

    });

});

