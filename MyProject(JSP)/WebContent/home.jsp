<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ë°ì¹´ë¥´í¸ ííì´ì§</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
/* ì¬ì©ì ì ì í¨ì  */
function login_window(){
	// ìë¡ì´ ì°½ì ì´ë¼ë ëªë ¹ì´
	window.open("../login/login.html","ë¡ê·¸ì¸","width=300px,height=250px") // ì´ê¸°  ì¬ì´ì¦ ìí
	//window.open("íì¼ëª", "ì°½ì ì´ë¦", "í­/ëì´")
}
function signUp_window() {
	window.open("../signup/signup.html","íì ê°ì","width=500px,height=800px") // ì´ê¸°  ì¬ì´ì¦ ìí
}
</script>
</head>
<body>
	<div id="container">
		<header> <!-- ë¨¸ë¦¿ë§ ìì­ -->
			<div id="login">
			<a href="index.html">í</a>
			<a href="#" onclick="login_window()">ë¡ê·¸ì¸</a>
			<a href="#" onclick="signUp_window()">íìê°ì</a>
			</div> <!-- id="login" end  -->
			<hgroup> <!-- hgroup ì ëª©ê³¼ ë¶ì ëª©ì ê·¸ë£¹ì¼ë¡ ë¬¶ì´ì£¼ë ì­í    -->
				<h1>ë°ì¹´ë¥´í¸, íë ê·¼ëì² íì ì°½ìì</h1>
				<h2>Rene Decartes, 1596~1650</h2>	
			</hgroup>
		</header>
			<!-- ë¤ë¹ê²ì´ì ìì­  -->
		<nav id ="nav">
			<ul>
				<li> <a href="birth.html">í ì</a></li> 
				<li> <a href="../writing/writing.html">ì  ì</a></li> 
				<li> <a href="../philosophy/philosophy.html">ì²  í</a></li> 
				<li> <a href="../saying/saying.html">ëª ì¸</a></li> 
			</ul>
		</nav>
		<!-- ë¬¸ìì ì : ì¬ë¬ ê° ì¬ì©  -->
		<section id="content">
			<h2>ë°ì¹´ë¥´í¸ ìê°</h2>
			<article> <!-- ë¬¸ìì ë³¸ë¬¸ ë´ì© -->
			<h3>"ë°ì¹´ë¥´í¸ì íì"</h3>
				<p>ì¶ ì: 1596ë 3ì 31ì¼ </p>
				<p>ë³¸ ëª: RenÃ© Descartes </p>
				<p>ì¶ìì§: íëì¤ ë°êºíë¨</p>
				<p>ë°ì¹´ë¥´í¸ë 1596ë 3ì 31ì¼ í¬ë  ì§ë°©ì í¬ë¥´ ì¸ê·¼ì ìë</p>
				<p>ìëì ë¼ìì ë²ê´ ê·ì¡± ê°ë¬¸ìì íì´ë¬ë¤</p>
				<p>1606ë ê·¸ë ììíê° ì´ìíë ë¼ íë ì¬ ì½ë ì£¼(CollÃ¨ge la FlÃ¨che)ì ìííì¬ 1614ëê¹ì§</p>
				<p>8ëê°ì ê±¸ì³ ì² ì íê² ì¤ì¸ì ê·¸ë¦¬ê³  ì¸ë³¸ì£¼ì êµì¡ì ë°ìë¤.</p>
				<p>5ëê° ë¼í´ì´, ìì¬í, ê³ ì  ìê° ììì ë°ìê³  3ëê° ë³ì¦ë¡ ìì ë¹ë¡¯íì¬ ìì°ì² í</p>
				<p>íì´ìí ê·¸ë¦¬ê³  ì¤ë¦¬íì í¬ê´íë ì² í ììì ë°ìë¤</p> 
		<div class="picture">
			<img src="../images/birth01.jpg" width="300" height="250" alt="ì¤ë¥¸ìª½ íìì ìë ì¬ìì ì¤ë¥¸ìª½ ì¸ë¬¼ì´ ë°ì¹´ë¥´í¸">			
			</div>
			</article>
		</section>
		<!-- ë¬¸ìì ë³´ì¡° ë´ì©(ìë¦¼, ê´ê³  ë±ë±)  -->
		<aside id="sidebar">
			<h3>âì ì êµ¬ìâ</h3>
			<p>ì ì êµ¬ìì ìíìë ë¶ë¤ì ì í 010-1111-1234ë¡
				ì°ë½ ì£¼ìê¸° ë°ëëë¤.</p>
				<img src="../images/book1.png" width="130" height="160">
				<img src="../images/book2.png" width="130" height="160">
		</aside>
		<!-- ê¼¬ë¦¿ë§ íë¨ ìì­  -->
		<footer>
			<p> ê¸: ì´ ì í¸ / ì ì ê°, ë²ì­ê°</p>
			<address> E-mail: lsh3715@gmail.com </address>
			<p>Copyright &copy All right reserved</p>
		</footer>
	</div> <!-- id="container" end  -->
</body>
</html>