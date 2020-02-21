$('#btnAddCategory').click(function () {
    var data={};
    var formData = $('#formEdit').serializeArray();
    $.each(formData,function (index,v) {
        data[""+v.name+""] = v.value;
    })
    var id =$('#id').val();
    if (id==""){
        addCategory(data)
    } else {
        updateCategory(data)
    }
})
function addCategory(data) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/category",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            console.log("add success");
            alert('Add Success !');
            console.log(response);
            window.location.href="http://localhost:8080/admin/category";
        },
        error: function(response){
            console.log("fail");
            alert("Add fail !");
            console.log(response);
        }
    });
}
function updateCategory(data) {
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/category",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            console.log("add success");
            alert("Update Success !");
            console.log(response);
            window.location.href="http://localhost:8080/admin/category";
        },
        error: function(response){
            console.log("fail");
            alert("Update fail !");
            console.log(response);
        }
    });
}