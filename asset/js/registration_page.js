function registration() {
    console.log("Hello World");
    var name = $("#fname").val();
    var email = $("#email").val();
    var password = $("#password").val();
    var phone = $("#number").val();
    var gender = $("#gender").val();
    var address = $("#address").val();
    var country = $("#country").val();
    var pincode = $("#pincode").val();
    console.log(name);
    console.log(email);
    console.log(password);
    console.log(phone);
    console.log(gender);
    console.log(address);
    console.log(country);
    console.log(pincode);


    var data_uri = "{" +
        "\"userName\":\"" + name + "\"," +
        "\"userEmail\":\"" + email + "\"," +
        "\"userPassword\":\"" + password + "\"," +
        "\"userPhone\":\"" + phone + "\"," +
        "\"userGender\":\"" + gender + "\"," +
        "\"userCountry\":\"" + country + "\"," +
        "\"userAddress\":\"" + address + "\"," +
        "\"userPincode\":\"" + pincode + "\"" +
        // "\"password\":\""+password+"\"" +
        "}";
    console.log(data_uri);
    
    


    $.ajax({
        url: "http://localhost:8080/insertLogin",
        type: "POST",  // http method
        data: data_uri,  // data to submit
        headers: {  'Access-Control-Allow-Origin': '*'},
        crossDomain: true,
        //dataType: 'jsonp',
        contentType: "application/json; charset=utf-8",
        success: function (data, status, xhr) {
            alert("AJAX request successfully completed");
            // $("#alert").append('<div class="alert alert-success">'+'Registration Successfully</div>');
            //$('p').append('status: ' + status + ', data: ' + data);

            console.log(data);
            
            const userdata = JSON.parse(data);
            console.log(userdata);


            window.location.href = "/pages/signin_page.html";
            let name = localStorage.setItem("name",email);
            console.log(name);
                
    
          
    


        },
        error: function (jqXhr, textStatus, errorMessage) {
            alert(errorMessage);
            //$('p').append('Error' + errorMessage);
        }
    });


}     