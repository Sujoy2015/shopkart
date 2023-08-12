function adminLogout(){
 console.log("Hello World");
 let email=$("#email").val();
 let password=$("#password").val();

 console.log(email);
 console.log(password);

 var data_uri = "{" +

 "\"email\":\"" + email + "\"," +
 "\"password\":\"" + password + "\"," +

 "}";

 $.ajax({
    url: "http://localhost:8080/logoutAdmin",
    type: "POST",  // http method
    data: data_uri,  // data to submit
    headers: {  'Access-Control-Allow-Origin': '*'},
    crossDomain: true,
    //dataType: 'jsonp',
    contentType: "application/json; charset=utf-8",
    success: function (data, status, xhr) {
        alert(data);
        // alert(status);
        //$('p').append('status: ' + status + ', data: ' + data);
        console.log(data);
        var allInputs = document.querySelectorAll('input');
        allInputs.forEach(singleInput => singleInput.value = '');

        // if(data=="true"){

        // }

    },
    error: function (jqXhr, textStatus, errorMessage) {
        alert(errorMessage);
        //$('p').append('Error' + errorMessage);
        var allInputs = document.querySelectorAll('input');
        allInputs.forEach(singleInput => singleInput.value = '');
    }
});

}
