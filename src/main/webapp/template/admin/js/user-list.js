$('#btnEnableUser').click(function (e) {
  e.preventDefault();
  var data={};
  var newsId = $('#userList').find('tbody input[type=checkbox]:checked').map(function () {
    return $(this).val();
  }).get();
  data['listId'] = newsId;
  enableUser(data);
})
$('#btnDisableUser').click(function (e) {
  e.preventDefault();
  var data ={};
  var newsId = $('#userList').find('tbody input[type=checkbox]:checked').map(function () {
    return $(this).val();
  }).get();
  data['listId'] = newsId;
  disableUser(data);
})
$('#btnDeleteUser').click(function (e) {
  e.preventDefault();
  var data ={};
  var newsId = $('#userList').find('tbody input[type=checkbox]:checked').map(function () {
    return $(this).val();
  }).get();
  data['listId'] = newsId;
  deleteUser(data);
})
$('#btnResetUser').click(function (e) {
  e.preventDefault();
  var data={};
  var newsId = $('#userList').find('tbody input[type=checkbox]:checked').map(function () {
    return $(this).val();
  }).get();
  data['listId'] = newsId;
  resetPassword(data);
})
function resetPassword(data) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/user/reset",
    data: JSON.stringify(data),
    dataType: "json",
    contentType:"application/json",
    success: function (response) {
      alert("Reset Success")
      console.log("success");
      window.location.href="http://localhost:8080/admin/user";
    },error: function(response){
      console.log("fail");
      alert("Reset fail");
      window.location.href="http://localhost:8080/admin/user";
    }
  });
}
function enableUser(data) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/user/enable",
    data: JSON.stringify(data),
    dataType: "json",
    contentType:"application/json",
    success: function (response) {
      alert("Enables Success")
      console.log("success");
      window.location.href="http://localhost:8080/admin/user";
    },error: function(response){
      console.log("fail");
      alert("Enable fail");
      window.location.href="http://localhost:8080/admin/user";
    }
  });
}
function disableUser(data) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/user/disable",
    data: JSON.stringify(data),
    dataType: "json",
    contentType:"application/json",
    success: function (response) {
      alert("Disable Success")
      console.log("success");
      window.location.href="http://localhost:8080/admin/user";
    },error: function(response){
      console.log("fail");
     // alert("Disable fail");
      window.location.href="http://localhost:8080/admin/user";
    }
  });
}
function deleteUser(data) {
  $.ajax({
    type: "DELETE",
    url: "http://localhost:8080/api/user",
    data: JSON.stringify(data),
    dataType: "json",
    contentType:"application/json",
    success: function (response) {
      alert("Delete Success")
      console.log("success");
      window.location.href="http://localhost:8080/admin/user";
    },error: function(response){
      console.log("fail");
      alert("Delete fail");
      window.location.href="http://localhost:8080/admin/user";
    }
  });
}