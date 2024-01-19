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

// document.addEventListener("DOMContentLoaded", function () {
//     let currentPath = window.location.pathname; // Lấy đường dẫn hiện tại
//
//     // Lấy tất cả các thẻ <a> có class "menu-link"
//     let menuLinks = document.querySelectorAll(".menu-link");
//
//     // Đặt sự kiện click cho mỗi thẻ <a>
//     menuLinks.forEach(function (link) {
//         let linkPath = link.getAttribute("href");
//
//         // So sánh đường dẫn hiện tại với href của từng thẻ <a>
//         if (currentPath === linkPath) {
//             link.classList.add("active");
//         }
//     });
// });

document.addEventListener("DOMContentLoaded", function () {
    let currentPath = new URL(window.location.href).pathname; // Lấy đường dẫn hiện tại

    // Lấy tất cả các thẻ <a> có class "menu-link"
    let menuLinks = document.querySelectorAll(".menu-link");

    // Đặt sự kiện click cho mỗi thẻ <a>
    menuLinks.forEach(function (link) {
        let linkPath = link.getAttribute("href");

        // Kiểm tra xem đường dẫn hiện tại có chứa cụm từ trong href của từng thẻ <a> không
        if (currentPath.startsWith(linkPath)) {
            link.classList.add("active");
        }
    });
});

function showUser(element){

    let id = element.getAttribute("data-user-id");
    let name = element.getAttribute("data-user-name");
    let phone = element.getAttribute("data-user-phone");
    let email = element.getAttribute("data-user-email");
    let address = element.getAttribute("data-user-address");
    let username = element.getAttribute("data-user-username");
    let status = element.getAttribute("data-user-status");
    let created = element.getAttribute("data-user-create");
    let updated = element.getAttribute("data-user-update");



    // Sử dụng thông tin người dùng để điều chỉnh nội dung của modal
    let modal = document.querySelector(".modal");
    let usernameInput = modal.querySelector("input[name='username']");
    let nameInput = modal.querySelector("input[name='name']");
    let phoneInput = modal.querySelector("input[name='phone']");
    let emailInput = modal.querySelector("input[name='email']");
    let  addressInput = modal.querySelector("input[name='address']");
    let  statusInput = modal.querySelector("input[name='status']");
    let  createInput = modal.querySelector("input[name='created']");
    let  updateInput = modal.querySelector("input[name='updated']");
    //
    usernameInput.value = username;
    nameInput.value = name;
    phoneInput.value = phone;
    emailInput.value = email;
    addressInput.value = address;
    statusInput.value = status;
    createInput.value = created;
    updateInput.value = updated;
    modal.classList.add("show");
}

function showPro(element){

    let id = element.getAttribute("data-pro-id");
    let title = element.getAttribute("data-pro-title");
    let brand = element.getAttribute("data-pro-bran");
    let category = element.getAttribute("data-pro-category");
    let cpu = element.getAttribute("data-pro-cpu");
    let trc = element.getAttribute("data-pro-camtrc");
    let sau = element.getAttribute("data-pro-camsau");
    let kt = element.getAttribute("data-pro-kt");
    let rom = element.getAttribute("data-pro-rom");
    let ram = element.getAttribute("data-pro-ram");
    let pin = element.getAttribute("data-pro-pin");


    let modal = document.querySelector(".modal");
    let titleInput = modal.querySelector("input[name='title']");
    let brandInput = modal.querySelector("input[name='brand']");
    let cateInput = modal.querySelector("input[name='category']");
    let cpuInput = modal.querySelector("input[name='cpu']");
    let trcInput = modal.querySelector("input[name='camera_truoc']");
    let sauInput = modal.querySelector("input[name='camera_sau']");
    let ktInput = modal.querySelector("input[name='KTmanHinh']");
    let romInput = modal.querySelector("input[name='rom']");
    let ramInput = modal.querySelector("input[name='ram']");
    let pinInput = modal.querySelector("input[name='pin']");
    //
    titleInput.value = title;
    brandInput.value = brand;
    cateInput.value = category;
    cpuInput.value = cpu;
    trcInput.value = trc;
    sauInput.value = sau;
    ktInput.value = kt;
    romInput.value = rom;
    ramInput.value = ram;
    pinInput.value = pin;
    modal.classList.add("show");
}

function hide(){
    let modal = document.querySelector(".modal");
    modal.classList.remove("show");
}