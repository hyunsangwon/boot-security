Spring Boot Security simple project
=============

개요 : 같은 개발 환경시 빠른 개발 베이스 구축을 위함
-------------

### 개발 환경 (19-08-21)
***버전 없는 항목은 해당날짜에 맞는 최신버전***

Spring Boot 2.1.7 v  
Spring Security 2.1.7 v  
MyBatis 2.0.1 v  
MySQL   
thymeleaf  
Maven

### Table Modeling
#### 총 3개의 테이블로 구성 한 유저당 1개 이상 권한을 가질 수 있는 것을 고려
<img src="https://k.kakaocdn.net/dn/4juDq/btqxtWzTj6M/Vsy0gJrOOnezroGhaRw0ck/img.png" width="50%"></img>

### Project Structure (중요한것만)
Controller  
+ HomeController (권한 거부페이지,CSRF FROM전송,AJAX전송,메인화면)
+ UserRestController (회원가입 REST API)  
Service
+ HomeService (UserDetailsService 를 구현한 Service)
VO
+ UserPrincipalVO (UserDetails를 구현한 VO) 
Config
+ SecurityConfig (WebSecurityConfigurerAdapter 구현)

### REST API 보내는 방법
{
	"id":"sangwon",
	"password":"1234",
	"name":"현상원",
	"roleName":"ADMIN"
}  
***JSON 형태로 POST로 보내주면 된다.***

### 그외 참고사항
프로퍼티스 파일이 아닌 YAML 파일  
init.sql 테이블 DDL 문법 작성되어 있음
