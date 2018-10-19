$().ready(function() {
    $('.summernote').summernote({
        height : '220px',
        lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
    });
    validateRule();
    selectBook();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    var stuBookId=document.getElementById("bookName").value;
    var chapterName=document.getElementById("chapterName").value;
    var heart = $("#content_sn").summernote('code');
    $("#content").val(heart);
    var BookChapterDO={
        "stuBookId"	:stuBookId,
        "chapterName":chapterName,
        "heart":heart
	}
	$.ajax({
		cache : true,
		type : "POST",
        contentType:"application/json; charset=utf-8",
		url : "/book/bookChapter/save",
		data :JSON.stringify(
			BookChapterDO
		),
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}
function selectBook() {
	$("#bookName").empty();
	$.ajax({
		url:"/book/bookChapter/selectBook",
		type:"get",
        async: false,
		success:function (data) {
			if (data != null) {
				if (data.code==0){
					var dataInfo=data.data;
                    var html="";
                    $("#getName").html('<select id="bookName"class="form-control"></select>')
                    for (var i = 0; i < dataInfo.length; i++) {
						html=html+'<option value="' + dataInfo[i].stuBookId + '">' + dataInfo[i].bookName + '</option>'
                    }
					$("#bookName").append(html);
				}
                $("#bookName").html(html);
			}
        }

	})
  }