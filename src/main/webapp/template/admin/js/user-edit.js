$('#btnAddUser').click(function () {
  var data= {};
  var listRole=[];
  var formData = $('#formEdit').serializeArray();
  $.each(formData,function (index,v) {
    if (v.name=="listRole"){
      listRole.push(v.value);
    } else{
      data[""+v.name+""] = v.value;
    }

  })
  data['listRole'] = listRole;
  var id = $('#id').val();
  if (id==""){
    addUser(data);
  } else{
    updateUser(data);
  }
})
$('#btnChangeInfo').click(function () {
  var data={};
  var formData = $('#formEdit').serializeArray();
  $.each(formData,function (index,v) {
      data[""+v.name+""] = v.value;
  })
  changeInfo(data);
});
function changeInfo(data) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/user/changeinfo",
    data: JSON.stringify(data),
    dataType: "json",
    contentType:"application/json",
    success: function (response) {
      console.log("add success");
      alert("Change Success !");
      console.log(response);
      window.location.href="http://localhost:8080/logout";
    },
    error: function(response){
      console.log("fail");
      alert("Change fail !");
      console.log(response);
      window.location.href="http://localhost:8080/admin";
    }
  });
}
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
      // alert("Add fail !");
      console.log(response);
      window.location.href="http://localhost:8080/admin/user";
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