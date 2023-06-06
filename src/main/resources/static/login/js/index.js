import {HOST} from './constant.js';


// 动态添加
let token = $("meta[name='_csrf']").attr("content");
let header = $("meta[name='_csrf_header']").attr("content");

const app = new Vue({
    el: '#form-container',
    data() {
        return {
            count: 0,
            show: false,
            fields,
            formDatas: []
        }
    },
    methods: {
        // 动态添加表格
        dynamicCreateRows(e, para='insert') {
            this.show = true;
            let obj = {};
            for (let field of this.fields) {
                obj[field] = ''
            }
            this.formDatas.push(obj);
        },
        send(e) {
            e.preventDefault();
            const vm = this;
            fetch(`${HOST}/insertGrade`, {
                method: 'POST',
                body: JSON.stringify(vm.formDatas),
                mode: 'same-origin',
                headers: {
                    [header]: token,
                    'Content-Type': 'application/json'
                }
            },).then(response => {
                if (response.ok) {
                    location.href= "/";
                }
            }).catch(err => {
                console.log(err);
            })
        },
        remove(e) {
            window.location = `/delete/${e.target.dataset.id}`
        },
    },
    mounted() {
        console.log(fields)
    }
});


