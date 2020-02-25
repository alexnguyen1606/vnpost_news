function openModalSubcrib() {
    $('#myModalSubcrib').modal();
}
$('#btnAddSubcrib').click(function () {
    var data = {};
  //  if (ValidateEmail($('#email').val())){
        var formData = $('#formSubcrib').serializeArray();
        $.each(formData,function (index,v) {
            data[""+v.name+""] = v.value;
        });
        addSubcrib(data);
        $('#myModalSubcrib').modal('hide');
    //}

})
function addSubcrib(data) {
    $.ajax({
        url:'http://localhost:8080/api/dang-ky',
        type:'POST',
        data:JSON.stringify(data),
        dataType:'json',
        contentType:'application/json',
        success:function (response) {
            alert("Đăng ký thành công");
            console.log(response);
        },
        error:function (response) {
            console.log(response);
        }
    })
}
function ValidateEmail(inputText)
{
    var mailformat = "/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/";
    if(inputText.value.match(mailformat))
    {
       // document.formSubcrib.email.focus();
        return true;
    }
    else
    {
        alert("You have entered an invalid email address!");
        document.formSubcrib.email.focus();
        return false;
    }
}
