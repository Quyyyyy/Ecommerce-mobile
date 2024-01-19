const thuongHieu = {
    apple: 'IPHONE',
    coolpad: 'COOLPAD',
    xiaomi: 'XIAOMI',
    huawei: 'HUAWEI',
    samsung: 'SAMSUNG',
    oppo: 'OPPO',
    nokia: 'NOKIA',
    realme: 'REALME'
};
const minprice = {

}
const gia = {
    duoi2trieu: 'Dưới 2 triệu',
    tu2den4trieu: 'Từ 2 - 4 triệu',
    tu4den7trieu: 'Từ 4 - 7 triệu',
    tu7den13trieu: 'Từ 7 - 13 triệu',
    tren13trieu: 'Trên 13 triệu'
};
const khuyenMai = {
    giamgia: 'Giảm giá',
    tragop: 'Trả góp',
    moiramat: 'Mới ra mắt'
};
const sort = {
    asc: 'Giá tăng dần',
    desc: 'Giá giảm dần'
};

let thuongHieuActive = null;
let giaActive = null;
let khuyenMaiActive = null;
let sapXepActive = null;

document.querySelector(".pageNum.currentPage").setAttribute("disabled", true);


locGia();
locThuongHieu();
locKhuyenMai();
locSapXep();

function locThuongHieu() {
    thuongHieuActive = layUrlParameter('thuong-hieu');
    if (!thuongHieuActive) {
        return 0;
    }
    let html = '';
    html += '<div class="choose-filter-container">';
    html += `<button class="choose-filter-btn">`;
    html += `<p style="margin: 0px 0px;">`;
    html += thuongHieu[thuongHieuActive];
    html += `</p>`;
    html += `</button>`;
    html += `</div>`;
    document.querySelector('.filter').innerHTML += html;
}

function locGia() {
    giaActive = layUrlParameter('gia');
    if (!giaActive) {
        return 0;
    }
    let html = '';
    html += '<div class="price-filter-container">';
    html += `<button class="choose-filter-btn">`;
    html += gia[giaActive];
    html += `</p>`;
    html += `<p style="margin: 0px 0px;">`;
    html += `</button>`;
    html += `</div>`;
    document.querySelector('.filter').innerHTML += html;
}

function locKhuyenMai() {
    khuyenMaiActive = layUrlParameter('khuyen-mai');
    if (!khuyenMaiActive) {
        return 0;
    }
    let html = '';
    html += '<div class="sale-filter-container">';;
    html += `<button class="choose-filter-btn">`;;
    html += `<p style="margin: 0px 0px;">`;
    html += khuyenMai[khuyenMaiActive];
    html += `</p>`;
    html += `</button>`;
    html += `</div>`;
    document.querySelector('.filter').innerHTML += html;
}

function locSapXep() {
    sapXepActive = layUrlParameter('sort');
    if (!sapXepActive) {
        return 0;
    }
    let html = '';
    html += '<div class="sort-filter-container">';
    html += `<button class="choose-filter-btn">`;
    html += `<p style="margin: 0px 0px;">`;
    html += sort[sapXepActive];
    html += `</p>`;
    html += `</button>`;
    html += `</div>`;
    document.querySelector('.filter').innerHTML += html;
}

if (((thuongHieuActive !== null) || (giaActive !== null)
        || (khuyenMaiActive !== null)||(sapXepActive !== null))
    && (!document.querySelector('.delete-filter-container'))) {
    let html = '';
    html += '<div class="delete-filter-container">';
    html += '<a href="/filter"><button class="delete-filter-btn">Xóa bộ lọc</button></a>';
    html += '</div>';
    document.querySelector('.filter').innerHTML += html;
}


function layUrl(key, value) {
    const url_string = window.location.href;
    const url = new URL(url_string);
    url.searchParams.set(key, value);
    window.location.href = url.href;
}

function layUrlParameter(key) {
    let url_string = window.location.href;
    let url = new URL(url_string);
    let value = url.searchParams.get(key);
    return value;
}

function addUrl(key, value,key1,value1) {
    const url_string = window.location.href;
    const url = new URL(url_string);
    url.searchParams.set(key, value);
    url.searchParams.set(key1, value1);
    window.location.href = url.href;
}

function deleteUrl(key){
    const url_string = window.location.href;
    const url = new URL(url_string);
    url.searchParams.delete(key);
    window.location.href = url.href;
}
function deleteUrl1(key,key1){
    const url_string = window.location.href;
    const url = new URL(url_string);
    url.searchParams.delete(key);
    url.searchParams.delete(key1);
    window.location.href = url.href;
}

