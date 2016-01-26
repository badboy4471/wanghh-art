<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="inc/head.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>${art.artName }</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<meta name="viewport" content="maximum-scale=1,initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">   
<style type="text/css">

@charset "utf-8";
a, abbr, acronym, address, applet, article, aside, audio, b, big, blockquote, body, canvas, caption, center, cite, code, dd, del, details, dfn, div, dl, dt, em, embed, fieldset, figcaption, figure, footer, form, h1, h2, h3, h4, h5, h6, header, hgroup, html, i, iframe, img, ins, kbd, label, legend, li, mark, menu, nav, object, ol, output, p, pre, q, ruby, s, samp, section, small, span, strike, strong, sub, summary, sup, table, tbody, td, tfoot, th, thead, time, tr, tt, u, ul, var, video {
  margin:0;
  padding:0;
  border:0;
  font:inherit;
  vertical-align:baseline;
  word-wrap:break-word
}
table {
  border-collapse:collapse;
  border-spacing:0;
  border-radius:0.5rem;
}

li, ol, ul {
  list-style:none
}
html {
  font-size:62.5%
}
@media only screen and (min-width:481px) {
html {
  font-size:94%!important
}
}
@media only screen and (min-width:561px) {
html {
  font-size:109%!important
}
}
@media only screen and (min-width:641px) {
html {
  font-size:125%!important
}
}
@media only screen and (min-width:800px) {
html {
  font-size:150%!important
}
}
a {
  text-decoration:none;
  color:#666
}
body {
  font-size:1.4rem;
  font-family:"微软雅黑";
  background-color:#fff;
  margin:.5rem;
}
html, body {
  position: relative;
  height: 100%;
}
.cfix:after {
  content: ".";
  display: block;
  clear: both;
  visibility: hidden;
  line-height: 0;
  height: 0
}
.cfix {
  zoom: 1;
}

.main{ border-radius:5px;  }
td{border:1px solid #eee; color:#666; font-size:14px; padding:.3rem;  }
tr td:nth-child(odd){ color:#999;}
.des{ color:#666; line-height:2rem; border-top:1px solid #eee; padding:.5rem 0;}
 
.title img{ width:100%}

</style>
</head>

<body>

<div class="main">




<table width="100%" border="1" cellpadding="1" cellspacing="1">
  <tr>
    <td colspan="4"><div class="title"><img src="<%=AliyunUpload.IMAGE_DOMAIN%>/${art.artImage}"></div></td>
    </tr>
    <tr>
  <td colspan="4"><div class="title">描述</div>
<div class="des">${art.artDesc }</div></td>
  </tr>
  <tr>
    <td nowrap><div>编号</div></td>
    <td nowrap><div>${art.artNumber }</div></td>
    <td nowrap><div>名称</div></td>
    <td><div>${art.artName }</div></td>
  </tr>
  <tr>
    <td><div>尺寸</div></td>
    <td><div>${art.artSize }</div></td>
    <td><div>材质</div></td>
    <td><div>${art.artMaterial }</div></td>
  </tr>
  <tr>
    <td><div>作者</div></td>
    <td nowrap><div>${art.artAuthor }</div></td>
    <td><div>证书</div></td>
    <td><div>${art.artCert }</div></td>
  </tr>
  <tr>
    <td><div>年份</div></td>
    <td><div>${art.artYear }</div></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
   <tr>
    <td colspan="4">
    
    </td>
    </tr>
</table>


 

</div>
</body>
</html>
