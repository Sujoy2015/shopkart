function login(){
                
    // var email = document.getElementById("form3Example3").value;
    // var password = document.getElementById("form3Example4").value;
    // if((email!=" " && password!=" ")){
    //     window.alert("Login Successful");
    // }
    // else{
    //     window.alert("Login Unsuccessful and Register your account");
    // }

    localStorage.removeItem("name");

    console.log("Hello World");
    let email = $('#email').val();
    let password = $('#password').val();

    console.log(email);
    console.log(password);

    var data_uri = "{" +
    "\"userEmail\":\"" + email + "\"," +
    "\"userPassword\":\"" + password + "\"" +
   
    "}";
console.log(data_uri);

$.ajax({
    url: "http://localhost:8080/checkLogin",
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
        
        if (data=="successfully Login"){
            window.location.href = "/pages/landingPage.html";
            let name = localStorage.setItem("name",email);
            console.log(name);

        }

        
    },
    error: function (jqXhr, textStatus, errorMessage) {
        alert(errorMessage);
        //$('p').append('Error' + errorMessage);
    }
});

    
}




