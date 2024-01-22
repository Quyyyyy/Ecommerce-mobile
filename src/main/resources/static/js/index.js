let slideIndex = 0;
hienthiSlides();


function hienthiSlides() {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1;}
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "contents";
    dots[slideIndex-1].className += " active";
    setTimeout(hienthiSlides, 2000);
}

// Back to top
let mybutton = document.getElementById("back-to-top");

window.onscroll = function() {scrollFunction();};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}

function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

function showEditForm(){
    let elements = document.getElementsByClassName('col2_content');
    for (let i = 0; i < elements.length; i++) {
        let currentDisplay = elements[i].style.display;
        elements[i].style.display = (currentDisplay === 'none') ? 'block' : 'none'; 
    }
}

function showModal() {
    showEditForm();
    let modal = document.querySelector('.modal');
    modal.style.opacity = '1';
    modal.style.pointerEvents = 'auto';
}

function hide(){
    let modal = document.querySelector('.modal');
    modal.style.opacity = '0';
    modal.style.pointerEvents = 'none';
}
