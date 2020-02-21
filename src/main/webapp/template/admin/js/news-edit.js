function openModalParapraph(){
    $('#myModal').modal();
}
$('#btnAddNews').click(function () {
    var data = {};
    var formData = $('#formEdit').serializeArray();

    var paragraph ={};
    $.each($('#formEdit'),function (index,v) {
        if (v.name == "image" ){
            $('#image').change(function () {
                var files = $(this)[0].files[0];
                if (files!=undefined){
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        paragraph['base64'] = e.target.result;
                        paragraph['image'] = files.name;
                    };
                    reader.readAsDataURL(files);
                }
            })
        }else if(v.name == "content"){
            paragraph['content'] = v.value;
        }else if (v.name == "titleImage"){
            paragraph['titleImage'] = v.value;
        }
        else {
            data[""+v.name+""] = v.value;
        }
    });
    data['paragraph'] = paragraph;
    var id = $('#id').val();
    if (id==""){
        addNews(data);
    } else {
        updateNews(data);
    }
})

function addNews(data) {
    $.ajax({
        url:'http://localhost:8080/api/news',
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
function updateNews(data) {
    $.ajax({
        url:'http://localhost:8080/api/news',
        type:'PUT',
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
function upload(data) {
    $.ajax({
        url:'',
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