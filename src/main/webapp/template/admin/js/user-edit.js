$('#btnAddUser').click(function () {
  var data= {};
  var formData = $('#formEdit').serializeArray();
  $.each(formData,function (index,v) {
    data[""+v.name+""] = v.value;
  })
  var id = $('#id').val();
  if (id==""){
    addUser(data);
  } else{
    updateUser(data);
  }
})
function addUser(data) {
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/api/user",
    data: JSON.stringify(data),
    dataType: "json",
    contentType:"application/json",
    success: function (response) {
      console.log("add success");
      alert('Add Success !');
      console.log(response);
      window.location.href="http://localhost:8080/admin/user";
    },
    error: function(response){
      console.log("fail");
      alert("Add fail !");
      console.log(response);
    }
  });
}
function updateUser(data) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/user",
    data: JSON.stringify(data),
    dataType: "json",
    contentType:"application/json",
    success: function (response) {
      console.log("add success");
      alert('Add Success !');
      console.log(response);
      window.location.href="http://localhost:8080/admin/user";
    },
    error: function(response){
      console.log("fail");
      alert("Add fail !");
      console.log(response);
    }
  });
}