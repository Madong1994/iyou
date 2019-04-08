var imgObj = null;
var bob = null;
function changeFile() {
    var fileImg = $("#fileImg");
    var files = fileImg[0].files;
    for (var i = 0; i < files.length; i++) {
        bob = files[i];
        imgObj = window.URL.createObjectURL(files[i]);;
        $("#img").attr("src", imgObj);
    }
}
function uploadImg(token) {
    var config = {
        useCdnDomain: false,
        region: null
    };
    var putExtra = {
        fname: "",
        params: {},
        mimeType: [] || null
    };
    var observer = {
        next(res){
            // ...
            console.log(res)
        },
        error(err){
            // ...
            console.log(err)
        },
        complete(res){
            // ...
            console.log(res)
            $("#img1").attr("src", "http://pnzcoor3o.bkt.clouddn.com/demo.jpg?e=1648252730820&token=" + token)
        }
    }
    var observable = qiniu.upload(bob, "d1.jpg", token, putExtra, config)
    var subscription = observable.subscribe(observer) // 上传开始
}
function initVue() {
    var vueObj = new Vue({
        el:'#app',
        data:{},
        mounted:function() {

        },
        methods: {
            init: function() {

            },
            uploadImg: function() {
                this.$http.post("/iyou/get/token",null,{emulateJSON:true}).then(function (res) {
                    var resuest = res.bodyText
                    uploadImg(resuest)
                })
            }
        }
    })
}