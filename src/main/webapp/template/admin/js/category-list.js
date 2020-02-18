$('#btnDeleteCategory').click(function (e) {
    e.preventDefault();
    if (confirm("Bạn có muốn xóa danh mục hay không")){
        var data={};
        var categoryIds = $('#categoryId').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['idDelete'] = categoryIds;
        deleteCategory(data);
    }
})
function deleteCategory(data) {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/category",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            alert("Delete Success")
            console.log("success");
            window.location.href="http://localhost:8080/admin/category";
        },error: function(response){
            console.log("fail");
            alert("Delete fail");
            window.location.href="http://localhost:8080/admin/category";
        }
    });
}
