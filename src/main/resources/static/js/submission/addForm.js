var BASE_URL = 'js/plugins/webuploader';

$(document).ready(function () {
    //初始化部门树
    //initDeptTree();

    $("#userForm").validate({
        rules: {
        	query: {required: true, minlength:1},
        	content: {required: true, minlength:1},
        	auditorid: {required: true, minlength:1},
        	execution: {required: true, minlength:1, maxlength:10},
        	dataSource: {required: false, maxlength:40},
        	overdueresults:{required: false, maxlength:40}
        },
        messages: {},
        submitHandler:function(){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/submission/saveAdd",
                data: $("#userForm").serialize(),
                success: function(ret){
                    if(ret.success){
                         layer.msg("新增SQL成功！", {time: 1500,icon:1},function(){
                             var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                             parent.layer.close(index);
                         });
                     }else{
                        layer.msg(ret.message, {time: 1500,icon:2},null);
                     }
                }
            });
        }
    });
});

//保存
function saveUser() {
    $("#userForm").submit();
}
//取消
function cancel() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index);
}
function populated(){
	$("#query").val("select count(*) from jq_sys_user"); 
}
function dbchose(){
	$("#dbdriver").val("com.mysql.jdbc.Driver"); 
	$("#dburl").val("jdbc:mysql://localhost:3306/test1?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8");
	$("#dbusername").val("root");
	$("#dbpassword").val("root");
}
function hideDeptTree() {
    var tree = $('#deptTree').css('display');
    if(tree == 'none'){
        $('#deptTree').show();
    }else{
        $('#deptTree').hide();
    }
}