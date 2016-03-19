<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="inc/head.jsp" %>
<!DOCTYPE html>
<html>
    
    <head>
        <title>艺术品添加</title>
        <!-- Bootstrap -->
        <link href="${ctx }/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/assets/styles.css" rel="stylesheet" media="screen">
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="${ctx }/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="${ctx }/vendors/jquery-1.9.1.js"></script>
		<link rel="stylesheet" type="text/css" href="${ctx }/uploadify/uploadify.css">
		 <c:set var="local" value="art.add"></c:set>
    </head>
    
    <body>
        <%@ include file="inc/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="inc/menu.jsp" %>
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->

                     <!-- validation -->
                    <div class="row-fluid">
                         <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">添加艺术品</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
					<!-- BEGIN FORM-->
					<form action="${ctx }/admin/art/save.form" id="form_sample_1" class="form-horizontal" method="post">
						<fieldset>
							<div class="alert alert-error hide">
								<button class="close" data-dismiss="alert"></button>
								表单有误！请认真检查！
							</div>
							<div class="alert alert-success hide">
								<button class="close" data-dismiss="alert"></button>
								Your form validation is successful!
							</div>
								<!-- id -->
							 <input type="hidden" name="id" id="id" value="${art.id }"/>
							<div class="control-group">
                                <label class="control-label" for="fileInput">图片*</label>
                                <div class="controls">
                                	<input class="input-file uniform_on span6 m-wrap" id="artImage" multiple="true" type="file">
                                	<div id="showImage">
                                	<c:if test="${ not empty art.artImage }">
                                		<img src="<%=AliyunUpload.IMAGE_DOMAIN %>${art.artImage}" width="50" height="50"/>
                                	</c:if>
                                	</div>
                                	<input type="hidden" name="artImage" id="imageUrl" value="${art.artImage }"/>
                            	</div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="fileInput">语音播报</label>
                                <div class="controls">
                                	<input class="input-file uniform_on" id="artAudio" type="file"  multiple="true">
                                	<div id="playAudio">
                                	<c:if test="${ not empty art.artAudio }">
                                		<audio controls="controls" src="<%=AliyunUpload.AUDIO_DOMAIN %>${art.artAudio}">
                                			你的浏览器不支持
                                		</audio>
                                	</c:if>
                                	</div>
                                	<input type="hidden" name="artAudio" id="audioUrl" value="${art.artAudio }"/>
                            	</div>
                            </div>
                            
  							<div class="control-group">
  								<label class="control-label">编号<span class="required">*</span></label>
  								<div class="controls">
  									<input type="text" name="artNumber" id="artNumber" value="${art.artNumber }" data-required="1" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">内部编号<span class="required">*</span></label>
  								<div class="controls">
  									<input type="text" name="artInnerNumber" id="artInnerNumber" value="${art.artInnerNumber }" data-required="1" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">名称<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artName" type="text" value="${art.artName }" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">尺寸<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artSize" type="text" value="${art.artSize }" class="span6 m-wrap"/> e.g: 80*60
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">材质<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artMaterial" type="text" value="${art.artMaterial }" class="span6 m-wrap"/> e.g: 瓷板.陶瓷颜料
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">作者<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artAuthor" type="text" value="${art.artAuthor }" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">证书<span class="required">*</span></label>
  								<div class="controls">
  									<input name="artCert" type="text" value="${art.artCert }" class="span6 m-wrap"/>
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">年份</label>
  								<div class="controls">
  									<input name="artYear" type="text" value="${art.artYear }" class="span6 m-wrap"/> e.g: 2014年7月
  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">描述</label>
  								<div class="controls">
  									<textarea rows="3" cols="120" name="artDesc">${art.artDesc }</textarea>
  								</div>
  							</div>
  							<div class="form-actions">
  								<button type="submit" class="btn btn-primary">提交</button>
  								<button type="button" class="btn">重置</button>
  							</div>
						</fieldset>
					</form>
					<!-- END FORM-->
				</div>
			    </div>
			</div>
                     	<!-- /block -->
		    </div>
                     <!-- /validation -->


                </div>
            </div>
            <hr>
            <%@ include file="inc/footer.jsp" %>
        </div>
        <!--/.fluid-container-->
        <link href="${ctx }/vendors/uniform.default.css" rel="stylesheet" media="screen">
        <script src="${ctx }/bootstrap/js/bootstrap.min.js"></script>
        <script src="${ctx }/vendors/jquery.uniform.min.js"></script>
        <script src="${ctx }/vendors/chosen.jquery.min.js"></script>
		<script type="text/javascript" src="${ctx }/vendors/jquery-validation/dist/jquery.validate.min.js"></script>
		<script src="${ctx }/assets/form-validation.js"></script>
		<script src="${ctx }/assets/scripts.js"></script>
		<script src="${ctx }/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
	    <script>
			jQuery(document).ready(function() {   
			   FormValidation.init();
			   $('#artImage').uploadify({
				   	'buttonText':'选择文件',
				   	'fileObjName':'file',
				   	'fileTypeExts' : '*.gif; *.jpg; *.png',
				   	'fileSizeLimit' : '1024KB',
				   	'formData':{"type":"image"},
					'swf'      : '${ctx}/uploadify/uploadify.swf',
					'uploader' : '${ctx}/admin/art/file/upload.form',
					'onUploadSuccess' : function(file, data, response) {
						var json = $.parseJSON(data);
						var imageSrc = json.data.fullUrl;
						$("#showImage").html("<img src='"+imageSrc+"' width='50' height='50'/>");
						$("#imageUrl").val(json.data.url);
				    }
				});
			   
			   $('#artAudio').uploadify({
				   	'buttonText':'选择文件',
				   	'fileObjName':'file',
				   	'fileTypeExts' : '*.mp3; *.wav',
				   	'fileSizeLimit' : '10240KB',
				   	'formData':{"type":"audio"},
					'swf'      : '${ctx}/uploadify/uploadify.swf',
					'uploader' : '${ctx}/admin/art/file/upload.form',
					'onUploadSuccess' : function(file, data, response) {
						var json = $.parseJSON(data);
						$("#playAudio").html("<audio src='"+json.data.fullUrl+"'>您的浏览器不支持 audio 标签。</audio>");
						$("#audioUrl").val(json.data.url);
				    }
				});
			});
	        $(function() {
	            $(".uniform_on").uniform();
	        });
	    </script>
    </body>
</html>