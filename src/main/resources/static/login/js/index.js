// 动态添加

$('#addStudents').on('click', dynamicCreateRows);

let token = $("meta[name='_csrf']").attr("content");
let header = $("meta[name='_csrf_header']").attr("content");
let count = 0;



$('#form-container').append('<button id="send" class="btn mt-3 btn-primary none">提交</button>');
$('#send').on('click', send);
function dynamicCreateRows() {
    $('#send').removeClass('none');
    let str = `<form id="form${count++}"><table class="table table-bordered"><tr>`;
    for (let field of fields) {
        str += `<td><input type="text" class="w-75 border-0" name=${field}></td>`;
    }
   str += '</tr></table></form>';
    $(str).insertBefore('#send');
}

function send(e) {
    e.preventDefault();
    fetch('http://127.0.0.1:8080/insertGrade', {
        method: 'POST',
        body: JSON.stringify(getFormData()),
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



