var FormValidation = function () {

    var handleValidation1 = function() {
        // for more info visit the official plugin documentation: 
            // http://docs.jquery.com/Plugins/Validation

            var form1 = $('#form_sample_1');
            var error1 = $('.alert-error', form1);
            var success1 = $('.alert-success', form1);

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    artName: {
                        required: true
                    },
                    artNumber: {
                        required: true,
                        remote:{
                        	type:"POST",
                        	url:"/admin/art/number/valid.form",
                        	data:{
                        		id:function(){return $("#id").val()},
                        		artNumber:function(){return $("#artNumber").val()}
                        	}
                        }
                    },
                    artSize: {
                        required: true
                    },
                    artMaterial: {
                        required: true
                    },
                    artAuthor: {
                        required: true
                    },
                    artCert: {
                    	required: true
                    },
                    artYear: {
                        required: true
                    },
                    artDesc: {
                        required: true
                    }
                },
                
                messages:{
                	artName: {
                        required: "请输入作品名称"
                    },
                    artNumber: {
                        required: "请输入作品编号",
                        remote:jQuery.format("该编号已经被使用，请更换一个！")
                    },
                    artSize: {
                        required: "请输入作品尺寸"
                    },
                    artMaterial: {
                        required: "请输入作品材质"
                    },
                    artAuthor: {
                        required: "请输入作品作者"
                    },
                    artCert: {
                    	required: "请输入作品证书"
                    },
                    artYear: {
                        required: "请输入作品年份"
                    },
                    artDesc: {
                        required: "请输入作品介绍"
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success1.hide();
                    error1.show();
                    FormValidation.scrollTo(error1, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.help-inline').removeClass('ok'); // display OK icon
                    $(element)
                        .closest('.control-group').removeClass('success').addClass('error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.control-group').removeClass('error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .addClass('valid').addClass('help-inline ok') // mark the current input as valid and display OK icon
                    .closest('.control-group').removeClass('error').addClass('success'); // set success class to the control group
                },

                submitHandler: function (form) {
                    success1.show();
                    error1.hide();
                    $.ajax({
                        type:"POST",
                        url:"/art/admin/art/save.form",
                        data:form1.serialize(),
                        success: function(data){
                        	alert("["+data.code+"]:"+data.message);
                        }
                    });
                }
            });
    }

    return {
        //main function to initiate the module
        init: function () {

            handleValidation1();

        },

	// wrapper function to scroll to an element
        scrollTo: function (el, offeset) {
            pos = el ? el.offset().top : 0;
            jQuery('html,body').animate({
                    scrollTop: pos + (offeset ? offeset : 0)
                }, 'slow');
        }

    };

}();