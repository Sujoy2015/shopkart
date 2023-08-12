var swiper = new Swiper(".brand_card", {

    spaceBetween: 5,
    loop: true,
    speed: 1000,
    autoplay: {
        delay: 1000,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    breakpoints: {
        320: {
            slidesPerView: 2,

        },
        480: {
            slidesPerView: 2,

        },
        768: {
            slidesPerView: 3,

        },

        1024: {
            slidesPerView: 5,
        },
        1400: {
            slidesPerView: 7,

        },


    },
});

var swiper = new Swiper(".swiper-products", {
    spaceBetween: 15,
    loop: true,
    speed: 3000,
    autoplay: {
        delay: 1000,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    breakpoints: {
        320: {
            slidesPerView: 1,
            spaceBetween: 1,
        },
        480: {
            slidesPerView: 1,
            spaceBetween: 1,
        },
        768: {
            slidesPerView: 2,
            spaceBetween: 1,
        },

        1024: {
            slidesPerView: 3,
            spaceBetween: 1,
        },
        1400: {
            slidesPerView: 4,

        },


    },
});