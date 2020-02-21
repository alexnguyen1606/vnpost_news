$('#btnEnableNews').click(function (e) {
    e.preventDefault();
    var data={};
    var newsId = $('#newsList').find('tbody input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();
    data['listId'] = newsId;
    enableNews(data)
})
$('#btnDisableNews').click(function (e) {
    e.preventDefault();
    var data ={};
    var newsId = $('#newsList').find('tbody input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();
    data['listId'] = newsId;
    disableNews(data);
})
$('#btnDeleteNews').click(function (e) {
    e.preventDefault();
    if(confirm("Xác nhận xóa bài viết")){
        var data ={};
        var newsId = $('#newsList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['listId'] = newsId;
        deleteNews(data);
    }
})
function enableNews(data) {
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/news/enable",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            alert("Enables Success")
            console.log("success");
            window.location.href="http://localhost:8080/admin/news";
        },error: function(response){
            console.log("fail");
            alert("Enable fail");
            window.location.href="http://localhost:8080/admin/news";
        }
    });
}
function disableNews(data) {
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/news/disable",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            alert("Disable Success")
            console.log("success");
            window.location.href="http://localhost:8080/admin/news";
        },error: function(response){
            console.log("fail");
            alert("Disable fail");
            window.location.href="http://localhost:8080/admin/news";
        }
    });
}
function deleteNews(data) {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/news",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            alert("Delete Success")
            console.log("success");
            console.log(response);
            window.location.href="http://localhost:8080/admin/news";
        },error: function(response){
            console.log("fail");
           // alert("Delete fail");
            console.log(response);
            window.location.href="http://localhost:8080/admin/news";
        }
    });
}