var BASE_URL = 'js/plugins/webuploader';

$(document).ready(function () {
	loadSelect();
    $("#userForm").validate({
        rules: {
        	query: {required: true, minlength:1},
        	content: {required: true, minlength:1},
        	execution: {required: true, minlength:1, maxlength:10},
        	dataSource: {required: true, maxlength:40},
        	overdueresults:{required: true, maxlength:40},
        	queryresults:{required: false, maxlength:40}
        },
        submitHandler:function(){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/submission/saveEdit",
                data: $("#userForm").serialize(),
                success: function(ret){
                    if(ret.success){
                        layer.msg("修改SQL成功！", {time: 1500,icon:1},function(){
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

function loadSelect(){
	$("select[name=dataSource]").empty();      //清空 
	$("select[name=dataSource]").append("<option value=\"\">请选择数据库</option>")
	var dbcs = $('#dbcs').val();
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "/submission/loadSelect",
        success: function(data){
            var modelList = data.dbList;  
            if(modelList && modelList.length != 0){  
                for(var i=0; i<modelList.length; i++){ 
                	if (dbcs == modelList[i].dataSource) {  
                		var option="<option value=\""+modelList[i].dataSource+"\" selected ";  
                        option += ">"+modelList[i].dbname+"</option>";  //动态添加数据  
                        $("select[name=dataSource]").append(option); 
                    } else {  
                    	 var option="<option value=\""+modelList[i].dataSource+"\"";  
                         option += ">"+modelList[i].dbname+"</option>";  //动态添加数据  
                         $("select[name=dataSource]").append(option);  
                    }  
                     
                }  
            }  
        }
    });
}
function populated(){
	$.ajax({
        type: "POST",
        dataType: "json",
        data:{db:$('#content').val()},
        url: "/submission/populated",
        success: function(data){
            var modelList = data.sql;  
            $("#query").val(modelList); 
        }
    });
	
}
function doquery(){
	
	var options=$("#dataSource option:selected");
	if($('#query').val()==null||$('#query').val()==""){
		layer.alert('预查询语句不能为空！');
		 return false;
	}
	if(options.val()==null||options.val()==""){
		layer.alert('数据源不能为空！');
		 return false;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        data:{db:options.val(),query:$('#query').val()},
        url: "/submission/doquery",
        success: function(data){
            var modelList = data.count;  
            $("#queryresults").val(modelList); 
        }
    });
}
function dbchose(){
	var options=$("#dataSource option:selected");
	$.ajax({
        type: "POST",
        dataType: "json",
        data:{db:options.val()},
        url: "/submission/dbchose",
        success: function(data){
            var modelList = data.dbList;  
            $("#dbdriver").val(modelList.drive); 
        	$("#dburl").val(modelList.url);
        	$("#dbusername").val(modelList.username);
        	$("#dbpassword").val(modelList.password);
        }
    });
}

function hideDeptTree() {
    var tree = $('#deptTree').css('display');
    if(tree == 'none'){
        $('#deptTree').show();
    }else{
        $('#deptTree').hide();
    }
}