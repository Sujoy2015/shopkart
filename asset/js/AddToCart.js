
if (localStorage.getItem("name") != null) {
  var s = localStorage.getItem("name");
  document.getElementById("signin").innerHTML = localStorage.getItem("name");
}

const cartItems = document.getElementById("cart-items");
const totalPriceElement = document.getElementById("total-price");
const checkoutButton = document.getElementById("checkout-button");

// function updateTotalPrice() {
//   let totalPrice = 0;
//   const rows = cartItems.querySelectorAll('tr');
//   console.log(rows);
//   for (let i = 0; i < rows.length; i++) {
//     const row = rows[i];
//     const quantity = row.querySelector(".productQuantity").value;
//     const price = parseFloat(row.querySelector(".productPriceInTable").innerText.replace("₹", ""));
//     const total = quantity * price;
//     totalPrice += total;
//     row.querySelector(".productTotalPrice").innerText = "₹" + total.toFixed(2);
//   }
//   totalPriceElement.innerText = "₹" + totalPrice.toFixed(2);
// }
function mainPageRedirect() {
  window.location.href = "/pages/landingPage.html";
}

// localStorage.removeItem("name");
// var s = localStorage.getItem("name");
// document.getElementById("signin").innerHTML =s ;

function getBusketData() {
  // $("#tablerowdata").html("")
  var table = document.getElementById("tablerowdata");

  $.ajax({
    url: "http://localhost:8080/getProductBucket/" + s,
    type: "GET", // http method
    crossDomain: true,
    //dataType: 'jsonp',
    //contentType: "application/json; charset=utf-8",
    success: function (data, status, xhr) {
      var productData = data;
      
      var totalPrice =0;
      var row = ""; // Define addTocartTable as an empty string

      $.ajaxSetup({ async: false });
      for (var i = 0; i < productData.length; i++) {
        // console.log(productData[i].productId);
        var pId = productData[i].productId;
        var cartId =  productData[i].cartId;
      console.log(cartId);
        console.log("product id :" + pId);
        $.ajax({
          url: "http://localhost:8080/getProductId/" + pId,
          type: "GET", // http method
          crossDomain: true,
          //dataType: 'jsonp',
          //contentType: "application/json; charset=utf-8",
          success: function (data, status, xhr) {
            var productInfo = data;
            console.log("product informztion :" + productInfo);
            row =
              row +
              "<tr><td><img src='/asset/images/LandingPagePhoto/LedTv.jpg' alt='Product 1' id='cart-img-1'></td><td>" +
              productInfo["productDetails"] +
              "</td><td id='productPriceInTable'>₹" +
              productInfo["productPrice"] +
              "</td><td><input type='number' min='1' max='10' value='" +
              productInfo["productQuantity"] +
              "'></td><td><button class='delete-button' onclick='deleteBusketId("+cartId+");''>Delete</button></td></tr>";

              totalPrice = totalPrice + parseInt(productInfo["productPrice"]);
          },



          error: function (jqXhr, textStatus, errorMessage) {
            // alert(errorMessage);
            //$('p').append('Error' + errorMessage);
          },
        });
      }
      console.log("total Row data :" + row);
      $("#addToCartData").html(row);
      $("#total-price").html(totalPrice);
      $.ajaxSetup({ async: true });
    },
    error: function (jqXhr, textStatus, errorMessage) {
      // alert(errorMessage);
      //$('p').append('Error' + errorMessage);
    },
  });
}

cartItems.addEventListener('input', updateTotalPrice);

function deleteBusketId(cartId){
    $.ajax({
      url: "http://localhost:8080/deleteBucketData/" + cartId,
      type: "DELETE", // http method
      crossDomain: true,
      //dataType: 'jsonp',
      //contentType: "application/json; charset=utf-8",
      success: function (data, status, xhr) {
        alert(data);
        location.reload();
      },

      error: function (jqXhr, textStatus, errorMessage) {
        // alert(errorMessage);
        //$('p').append('Error' + errorMessage);
      },
    });
}

function signOut(){
  window.location.href="/pages/signin_page.html";
  localStorage.clear();
}
