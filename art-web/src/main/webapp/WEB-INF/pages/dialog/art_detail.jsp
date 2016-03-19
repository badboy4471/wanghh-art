<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
		<div class="row-fluid">
                            <div class="block-content collapse in">
                                <div class="span12">
  									<table class="table table-bordered" class="detail-table">
						              <tbody>
						               <tr>
						                  <td colspan="4"><img src="<%=AliyunUpload.IMAGE_DOMAIN%>/${art.artImage}" style="width: 120px"/></td>
						                </tr>
						                <c:if test="${not empty artAudio }">
									    <tr>
									    <td colspan="4"><div class="title"><audio controls="controls" src="<%=AliyunUpload.AUDIO_DOMAIN%>/${art.artAudio}"></div></td>
									    </tr>
									    </c:if>
						                <tr>
						                  <td>编号</td>
						                  <td>${art.artNumber }</td>
						                  <td>名称</td>
						                  <td>${art.artName }</td>
						                </tr>
						                <tr>
						                  <td>尺寸</td>
						                  <td>${art.artSize }</td>
						                  <td>材质</td>
						                  <td>${art.artMaterial }</td>
						                </tr>
						                <tr>
						                  <td>作者</td>
						                  <td>${art.artAuthor }</td>
						                  <td>证书：</td>
						                  <td>${art.artCert }</td>
						                </tr>
						                <tr>
						                  <td>年份：</td>
						                  <td>${art.artYear }</td>
						                  <td></td>
						                  <td></td>
						                </tr>
						                <tr>
						                  <td colspan="4">描述</td>
						                </tr>
						                <tr>
						                  <td colspan="4">${art.artDesc }</td>
						                </tr>
						              </tbody>
						            </table>
                                </div>
                            </div>
                        </div>

<script>
$('.detail-table').dataTable( {
} );
</script>