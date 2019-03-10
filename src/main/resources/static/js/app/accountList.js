var accountList = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data = {
            id: $('#accountId').val(),
            password: $('#accountPassword').val(),
            name: $('#accountName').val()
        };

        $.ajax({
            type: 'POST',
            url: '/account',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

accountList.init();
