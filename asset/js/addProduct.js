function addProduct(){

      let pName = $(".pname").val();
      let pBrand = $(".brand").val();
      var pCategory = $("#myselect option:selected").val();
      let pSubCatagory = $(".subcatagory").val();
      let pDescription = $(".pdetails").val();
      let quantity = $(".quant").val();
      let price = $(".price").val();
      let discount = $(".discount").val();

      
      console.log(pName);
      console.log(pBrand);
      console.log(pCategory);
      console.log(pSubCatagory);
      console.log(pDescription);
      console.log(quantity);
      console.log(price);
      console.log(discount);

      var data_uri =
         "{" +
         '"name":"' +
         pName +
         '",' +
         '"brand":"' +
         pBrand +
         '",' +
         '"catagory":"' +
         pCategory +
         '",' +
         '"subcatagory":"' +
         pSubCatagory +
         '",' +
         '"details":"' +
         pDescription +
         '",' +
         '"quantity":"' +
         quantity +
         '",' +
         '"price":"' +
         price +
         '",' +
         '"discount":"' +
         discount +
         '"' +
         "}";

      console.log(data_uri);

      $.ajax({
         url: "http://localhost:8080/insertProduct",
         type: "POST", // http method
         data: data_uri, // data to submit
         headers: { "Access-Control-Allow-Origin": "*" },
         crossDomain: true,
         //dataType: 'jsonp',
         contentType: "application/json; charset=utf-8",
         success: function (data, status, xhr) {
            alert(data);
            // alert(status);
            //$('p').append('status: ' + status + ', data: ' + data);
            console.log(data);
            var allInputs = document.querySelectorAll("input");
            allInputs.forEach((singleInput) => (singleInput.value = ""));

            // if(data=="true"){

            // }
         },
         error: function (jqXhr, textStatus, errorMessage) {
            alert(errorMessage);
            //$('p').append('Error' + errorMessage);
            var allInputs = document.querySelectorAll("input");
            allInputs.forEach((singleInput) => (singleInput.value = ""));
         },
      });
   }
