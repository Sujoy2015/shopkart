
// import {login } from "./signin_page.js";
// how to do the localstorage must be nothing after sign in there can be present the item

// var s = localStorage.getItem("name");
if(localStorage.getItem("name")!= null)
{
    document.getElementById("signin").innerHTML = localStorage.getItem("name"); 
}



// class Swiper{
//     Swiper
// }


var swiper =new Swiper(".slide-content1", {
    slidesPerView: 3,
    spaceBetween: 25,
    loop: true,
    centerSlide: 'true',
    fade: 'true',
    grabCursor: 'true',
    pagination: {
        el: ".swiper-pagination ",
        clickable: true,
        dynamicBullets: true,
    },
    navigation: {
        nextEl: ".swiper-button-next ",
        prevEl: ".swiper-button-prev ",
    },

    breakpoints: {
        0: {
            slidesPerView: 1,
        },
        520: {
            slidesPerView: 2,
        },
        950: {
            slidesPerView: 3,
        },
    },
});



let slider = tns({
    container: ".my-slider ",
    "slideBy ": "1 ",
    "speed ": 400,
    "nav ": false,
    autoplay: true,
    controls: false,
    autoplayButtonOutput: false,
    responsive: {
        1600: {
            items: 5,
            gutter: 8
        },
        1024: {
            items: 4,
            gutter: 8
        },



        768: {
            items: 2,
            gutter: 8
        },

        480: {
            items: 1
        }
    }
})



// Example starter JavaScript for disabling form submissions if there are invalid fields
// function checkSubmitForm(){
  
//     // Fetch all the forms we want to apply custom Bootstrap validation styles to
//     const forms = document.querySelectorAll('.needs-validation');
  
//     // Loop over them and prevent submission
//     Array.prototype.slice.call(forms).forEach((form) => {
//       form.addEventListener('submit', (event) => {
//         if (!form.checkValidity()) {
//           event.preventDefault();
//           event.stopPropagation();
//         }
//         form.classList.add('was-validated');
//       }, false);
//     });
//   };

function useOwlCarousel(){
    $('.owl-carousel').owlCarousel({
        stagePadding: 0,
        loop: true,
        margin: 15,
        nav: true,
        responsive: {
            0: {
                stagePadding: 23,
                items: 1
            },
            600: {
    
                items: 2
            },
            1000: {
    
                items: 4
            }
    
    
        }
    })
}
function getProductList() {
    $("#electronicsCatagory").html("");
    $("#FashionCatagory").html("");
    $("#babiesAndToysCatagory").html("");
    $("#homeOrganizationCatagory").html("");
    $("#popularItems").html("");
    $.ajax({
        url: "http://localhost:8080/getProduct",
        type: "GET",  // http method
        crossDomain: true,
        //dataType: 'jsonp',
        //contentType: "application/json; charset=utf-8",
        success: function (data, status, xhr) {
            var productList = data;
            console.log(productList);
            var ElectronicsList ="";
            var FasionList = "";
            var babyToyList="";
            var homeOrgList="";
            var popularItemList="";
            var user_email =localStorage.getItem("name"); 
            for (var i=0 ; i<productList.length;i++){
                console.log(productList[i]);
                console.log(productList[i].id);
                var productCategory = productList[i].productCatagory;
                console.log(productCategory);
                if(productCategory == "Electronics"){
                    ElectronicsList +=" <div class='item'><div class='card border-0 shadow electronicsItem'><img src='https://sonimobiles.com/wp-content/uploads/2021/09/61NoYt2pvpS._SX679_.jpg'class='card-img-top'><div class='card-body electronicsItemBody'><div class='card-title text-center'><h4 id='product_price'>&#8377;"+productList[i].productPrice+"</h4><p id='product_details'>"+productList[i].productDetails+"</p> <p class='text-warning'><i class='bi bi-star-fill></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-half'></i></p><button class='btn btn-outline-primary' onclick='addToCart(\""+user_email+"\","+productList[i].id+",1);'><i class='bi bi-cart-plus'></i>Add To Cart</button></div> </div> </div></div> ";
			
                }
              

              if(productCategory=="Clothing_Shoes_and_Accesories")
              {
                FasionList+="<div class='item'><div class='card border-0 shadow fashionItem'><img src='https://rukminim1.flixcart.com/image/880/1056/kyrlifk0/dress/7/b/2/xl-385-aania-original-imagax79zgagsbq3.jpeg?q=50'alt='' class='card-img-top'><div class='card-body fashionItemBody'><div class='card-title text-center'><h4 id='product_price'>&#8377;"+productList[i].productPrice+"</h4><p id='product_details'>"+productList[i].productDetails+"</p><p class='text-warning'><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-half'></i></p><button class='btn btn-outline-primary' onclick='addToCart(\""+user_email+"\","+productList[i].id+",1);'><i class='bi bi-cart-plus'></i>Add To Cart</button></div></div></div></div>"
              }

              if(productCategory=="Baby_and_Toys")
              {
                 babyToyList+="<div class='item'><div class='card border-0 shadow toysItem'><img src='https://rukminim1.flixcart.com/image/416/416/kxdl3m80/doll-doll-house/q/n/q/60th-anniversary-original-barbie-original-imag9ugnt4gzfhgy.jpeg?q=70' alt='' class='card-img-top'><div class='card-body toysItemBody'><div class='card-title text-center'> <h4 id='product_price'>&#8377;"+productList[i].productPrice+"</h4><p id='product_details'>"+productList[i].productDetails+"</p><p class='text-warning'><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-half'></i></p><button class='btn btn-outline-primary' onclick='addToCart(\""+user_email+"\","+productList[i].id+",1);'><i class='bi bi-cart-plus'></i>Add To Cart</button></div></div></div></div>"
              }

                if(productCategory=="Home_Improvement"){
                    homeOrgList+="<div class='item'><div class='card border-0 shadow homeOrganization'><img src='https://rukminim1.flixcart.com/image/416/416/kybvo280/mixer-grinder-juicer/d/y/y/-original-imagah5993djj6cz.jpeg?q=70' alt='' class='card-img-top'><div class='card-body'><div class='card-title text-center'><h4 id='product_price'>&#8377;"+productList[i].productPrice+"</h4><p id='product_details'>"+productList[i].productDetails+"</p><p class='text-warning'><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-half'></i></p><button class='btn btn-outline-primary' onclick='addToCart(\""+user_email+"\","+productList[i].id+",1);'><i class='bi bi-cart-plus'></i>Add To Cart</button></div></div></div></div>"
                }
                // onclick='addToCart();'       

                if(popularItemList=="PopularItems"){
                    popularItemList+="<div class=' card swiper-slide'><div class='image-content'><span class='overlay'></span><div class='card-image'><img src='/asset/images/LandingPagePhoto/wintershirt.png' alt='' class='card-img'></div></div><div class='card-content'><h2 class='name' id='product_price'>&#8377;"+productList[i].product_price+"</h2><p class='description' id='product_details'>"+productList[i].product_details+"</p><p class='description'><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-fill'></i><i class='bi bi-star-half'></i></p><button class='button' onclick='addToCart(\""+user_email+"\","+productList[i].id+",1);'><i class='bi bi-cart-plus'></i>Add To Cart</button></div></div>"
                }
            }
            $("#electronicsCatagory").html(ElectronicsList);

            $("#FashionCatagory").html(FasionList);

            $("#babiesAndToysCatagory").html(babyToyList);

            $("#homeOrganizationCatagory").html(homeOrgList);

            $("#popularItems").html(popularItemList);


            // call 
            useOwlCarousel();

           
            // swiper js class cannot work in popularItemList
            // useSwiperJs();

            var swiper =new Swiper(".slide-content1", {
                slidesPerView: 3,
                spaceBetween: 25,
                loop: true,
                centerSlide: 'true',
                fade: 'true',
                grabCursor: 'true',
                pagination: {
                    el: ".swiper-pagination ",
                    clickable: true,
                    dynamicBullets: true,
                },
                navigation: {
                    nextEl: ".swiper-button-next ",
                    prevEl: ".swiper-button-prev ",
                },
            
                breakpoints: {
                    0: {
                        slidesPerView: 1,
                    },
                    520: {
                        slidesPerView: 2,
                    },
                    950: {
                        slidesPerView: 3,
                    },
                },
            });
            
            
  
        },
        error: function (jqXhr, textStatus, errorMessage) {
            // alert(errorMessage);
            //$('p').append('Error' + errorMessage);
        }
    });
} 


function clickCart(){
    
    window.location.href="/pages/AddToCart.html";
}

//add to cart
function addToCart(useremail,productid,quantity){
  

    var data_uri = "{" +
    "\"product_id\":" +productid+ "," +
    "\"quantity\":" + quantity + "," +
    "\"userEmail\":\"" + useremail + "\"" +
    "}";
console.log(data_uri);


$.ajax({
    url: "http://localhost:8080/insertProductBusket",
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
        
    //    if(data_uri["userEmail"]=="null")
    //     {
    //        window.location.href="/pages/signin_page.html";
    //     }

        
    },
    error: function (jqXhr, textStatus, errorMessage) {
        alert(errorMessage);
        //$('p').append('Error' + errorMessage);
    }


    
    
});






    
}

function signOut(){
    window.location.href="/pages/signin_page.html";
    localStorage.clear();
}