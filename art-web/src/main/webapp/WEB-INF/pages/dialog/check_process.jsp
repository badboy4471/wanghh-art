<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
		<div class="row-fluid">
                            <div class="block-content collapse in">
                                <div class="span12">
  									<table class="table table-bordered" class="detail-table">
						              <tbody>
						               <tr>
						                  <th>编号</th>
						                  <th>审核人</th>
						                  <th>审核时间</th>
						                  <th>审核结果</th>
						                  <th>审核备注</th>
						                </tr>
						              <c:forEach items="${process }" var="node">
						                <tr>
						                  <td>${node.id }</td>
						                  <td>${node.nickName }</td>
						                  <td>${node.checkTime }</td>
						                  <td>
						                  <c:if test="${node.status == -1}">
						                  	前面审核不通过
						                  </c:if>
						                  <c:if test="${node.status == 0}">
						                  	待审核
						                  </c:if>
						                  <c:if test="${node.status == 1}">
						                  	通过
						                  </c:if>
						                  <c:if test="${node.status == 2}">
						                  	不通过
						                  </c:if>
						                  </td>
						                  <td>${node.checkMemo }</td>
						                </tr>
						              </c:forEach>
						              </tbody>
						            </table>
                                </div>
                            </div>
                        </div>

<script>
$('.detail-table').dataTable( {
} );
</script>