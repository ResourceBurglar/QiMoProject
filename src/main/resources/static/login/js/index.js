// 动态添加

$('#addStudents').on('click', dynamicCreateRows);

$('#add-bar').on('click', dynamicCreateRows);

let token = $("meta[name='_csrf']").attr("content");
let header = $("meta[name='_csrf_header']").attr("content");
let count = 0;



$('#form-container').append('<button id="send" class="btn mt-3 btn-primary none">提交</button>');
$('#send').on('click', insert);
function dynamicCreateRows(e, para='insert') {
    $('#send').removeClass('none');
    if (para === 'insert') {
        let str = createForm();
        $(str).insertBefore('#send');
    } else if (para === 'update') {
        let index = parseInt((e.target.dataset.id));
        console.log(index);
        let str = createForm($('tr').eq(index)[0].cells);
        $('tr').eq(index).html(`<td colspan="8">${str}</td>`)
    }
}

function insert(e) {
    e.preventDefault();
    fetch('http://localhost:8080/insertGrade', {
        method: 'POST',
        body: JSON.stringify(getFormData()),
        mode: 'same-origin',
        headers: {
            [header]: token,
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (response.ok) {
            location.href= "/";
        }
    }).catch(err => {
        console.log(err);
    })

}

//
function getFormData() {
    let arr = [];
    let forms = document.querySelectorAll('#form-container form[id^=form]');
    for (let form of forms) {
        let formData = new FormData(form);
        let obj = {};
        for (let f of formData.entries()) {
            obj[f[0]] = f[1];
        }
        arr.push(obj);
    }
    return arr;
}

function createForm(arr1 = []) {
    let arr = [...arr1];
    arr.pop();
    let str = `<form id="form${count++}"><table class="table table-bordered"><tr>`;
    for (let i = 0; i < fields.length; i++) {
        // value="${arr[i].innerHTML}"
        str += `<td><input type="text" class="w-75 border-0" name="${fields[i]}" ></td>`;
    }
    str += '<td>占位</td></tr></table></form>';
    return str;
}

$('.remove-btn').on('click', function () {
    window.location = `/delete/${$(this).attr('data-id')}`
})

$('.change-btn').on('click', (e) => {
    dynamicCreateRows(e, 'update');
});

