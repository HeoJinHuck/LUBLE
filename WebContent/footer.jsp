<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
   <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-color: #fff;
            font-size: 14px;
            color: #000;
        }

			.wrapper {
	    min-height: calc(100vh-100px);;
	    position: relative;
	    padding-bottom: 400px;
	}
	
		footer {
		    position: absolute;
		    bottom: 0;
		    width: 100%;
		   
		    padding: 20px; /* 필요에 따라 패딩을 조절하세요 */
		    text-align: center; /* 텍스트를 가운데 정렬합니다 */
		}
        
        footer p {
            margin-bottom: 10px;
            line-height: 1.5;
            color: #333;
        }

        footer a {
            color: #007aff;
            text-decoration: none;
        }
        
        footer ul {
        	list-style:none;
        }

        footer a:hover {
            text-decoration: underline;

        }
    </style>
</head>
<body>
<div class="wrapper">
<footer>
    <address>
        <p>법인명: (주) | 대표: 조성원<br>
            주소: (01234) 대구광역시 서구 달구벌대로 1234-56 7층<br>
            사업자등록번호: 123-45-56789 [<a href="#">사업자정보확인</a>]<br>
            통신판매업신고번호: 제2020-서울종로-12345호<br>
            개인정보책임자: 조성원 | 이메일: <a href="mailto:mr@naver.com">mr@naver.com</a> | FAX: 02-1234-5678<br>
            Copyright ⓒ 2020 (주) ALL Right Reserved.
        </p>
    </address>

    <ul>
        <li>CUSTOMER CENTER 1544-1129</li>
        <li>Weekday 10:00~17:00 (Lunch 12:00~13:00)</li>
        <li>주말 및 공휴일은 휴무입니다.</li>
    </ul>
</footer>
</div>
</body>
</html>