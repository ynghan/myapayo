# apayo-back
구현 요구사항.

회원 기능
	회원 등록
	회원 조회
	회원 정보 수정

검색 기능
	부위 선택 -> 증상 검색
	
등록 기능
	증상 등록 
  	등록 취소


계층형 구조 사용

- controller, web : 웹 계층

- service : 비지니스 로직, 트랜잭션 처리

- repository : JPA를 직접 사용하는 계층, 엔티티 매니저 사용

- domain : 엔티티가 모여 있는 계층, 모든 계층에서 사용



패키지 구조
- apayo.myapayo
	- domain
	- exception
	- repository
	- service
	- web(app)
	- api

개발 순서
service + repository 개발 -> test case 작성(검증) -> web 계층에 적용


목차
- 회원 도메인 개발
	- 회원 리포지토리 개발
	- 회원 서비스 개발
	- 회원 기능 테스트
- 검색 도메인 개발
	- 검색 리포지토리 개발
	- 검색 서비스 개발
	- 검색 기능 테스트
- 등록 도메인 개발
	- 등록 리포지토리 개발
	- 등록 서비스 개발
	- 등록 기능 테스트
- 앱 계층 개발
- API 개발


테스트 요구사항
- 회원가입을 성공해야 한다.
- 회원가입 할 때 같은 이름이 있으면 예외가 발생해야 한다.


도메인 모델 패턴 (JPA, ORM 등)
: 엔티티에 비지니스 로직을 몰아 넣는 패턴

- 서비스 계층은 단순히 엔티티에 필요한 요청을 위임하는 역할을 한다.

트랜잭션 스크립트 패턴
: 비지니스 로직이 서비스 계층에서 처리하는 패턴


전체적인 테스트보다는 단위 테스트가 중요하다.

JPA 동적쿼리
-> Querydsl로 바꿔본다.(아주좋음)

API를 만들 때는 절대 엔티티를 넘기면 안된다.
-> API 스펙이 변한다.

*템플릿 엔진을 사용해 렌더링하는 컨트롤러와 api 스타일 컨트롤러의 패키지를 분리한다.

xToOne
- Ex. Part -> Member / Symptom -> Part


현재 개발상황
 : 부위 선택 -> 증상 생성 (완료)
