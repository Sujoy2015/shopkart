function adminRegistration(){
  console.log("Hello World");
  let username = $("#username").val();
  let email = $("#email").val();
  let password = $("#password").val();
  let confirmpassword = $("#confirmpassword").val();
  let phone = $("#phone").val();
  // let dob = $("#datepicker").val();
  let country = $("#countrySelect").val();
  let address = $("#address").val();
  let pincode = $("#pincode").val();
  // let check = $("#check").val();
  // let flag=flase;

  console.log(username);
  console.log(email);
  console.log(password);
  console.log(confirmpassword);
  console.log(phone);
  console.log(address);
  console.log(pincode);
  console.log(country);
  // console.log(dob);
  // console.log(check);

 
  //   if (username == "") {
  //     $("#usernameError").html("**Please Enter UserName**");
  //     $("#usernameError").css("color","red");
  //     return false;
  //   }
  //   if (email == "") {
  //     $("#emailError").html("**Please Enter Email**");
  //     $("#emailError").css("color","red")
  //     return false;
  //   }
  //   if (password == "" || password.length()>=5) {
  //     $("#passwordError").html("**Please Enter Password**");
  //     $("#passwordError").css("color","red")
  //     return false;
  //   }
  //   if (confirmpassword == "" ||  confirmpassword.length()>=5) {
  //     $("#cnfirmpasswordError").html("**Please Enter Confirm Password**");
  //     $("#cnfirmpasswordError").css("color","red")
  //     return false;
  //   }
  //   if (phone == "") {
  //     $("#phoneError").html("**Please Enter Phone**");
  //     $("#phoneError").css("color","red")
  //     return false;
  //   }

  //   if (address == "") {
  //     $("#addressError").html("**Please Enter Address**");
  //     $("#addressError").css("color","red")
  //     return false;
  //   }
  //   if (pincode == "") {
  //     $("#pincodeError").html("**Please Enter Pincode**");
  //     $("#pincodeError").css("color","red")
  //     return false;
  //   }

  //   if (country == "") {
  //     $("#countryError").html("**Please Enter Country**");
  //     $("#countryError").css("color","red")
  //     return false;
  //   }

  //   if (dob == "") {
  //     $("#dobError").html("**Please Enter Date Of Birth**");
  //     $("#dobError").css("color","red")
  //     return false;
  //   }
  // }

  var data_uri = "{" +
       
  "\"name\":\"" + username + "\"," +
  "\"email\":\"" + email + "\"," +
  "\"password\":\"" + password + "\"," +
   "\"confirm_password\":\"" + confirmpassword + "\"," +
  "\"phone\":\"" + phone + "\"," +
  "\"country\":\"" + country+ "\"," +
  "\"address\":\"" + address + "\"," +
  "\"pincode\":\"" + pincode + "\"" +
    "}";

    console.log(data_uri);
    $.ajax({
        url: "http://localhost:8080/insertDataAdmin",
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
            
            var allInputs = document.querySelectorAll('input');
            var checkInput = document.querySelector('checkbox');
            allInputs.forEach(singleInput => singleInput.value = '');
            checkInput.value = '';

        },
        error: function (jqXhr, textStatus, errorMessage) {
            alert(errorMessage);
            //$('p').append('Error' + errorMessage);
            var allInputs = document.querySelectorAll('input');
            checkInput = document.querySelector('checkbox');
            allInputs.forEach(singleInput => singleInput.value = '');
            checkInput.value = '';
        }
    });

  


}
