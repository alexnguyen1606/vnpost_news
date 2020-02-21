$('#image').change(function () {
    var paragraph = {};
        var files = $(this)[0].files[0];
        if (files!=undefined){
            var reader = new FileReader();
            reader.onload = function (e) {
                paragraph['base64'] = e.target.result;
                paragraph['image'] = files.name;
            };
            reader.readAsDataURL(files);
        }
    upload(paragraph);

})
function upload(data) {
    $.ajax({
        url:'http://localhost:8080/api/news/test',
        type:'POST',
        data:JSON.stringify(data),
        dataType:'json',
        contentType:'application/json',
        success:function (response) {
            console.log(response);
        },
        error:function (response) {
            console.log(response);
        }

    })
}