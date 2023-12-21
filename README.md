# 안녕하세요 진혁입니다! :boy:

# 프로젝트 소개

MVC 패턴을 활용한 신발 경매 웹 사이트

루블은 구매자 , 판매자 모두 경매를 통해 원하는 값에 거래가 가능한 웹 사이트 입니다.

프로젝트 시작은 중고거래 사기 , 특히나 리셀시장 가품으로 인한 피해를 해결해 보고자 시작 하였습니다.

가격 형성은 사용자가 형성 하게 경매를 통한 거래를 하게 하였고,
루블에서는 진품구별 및 보증을 맡아 벽돌,가품이 거래 되는 기존 시장의 문제점을 해결했습니다

---

## 정보
- Team Leader : SungWon Cho (유저페이지 전체)
- Team members : JinHuck Heo (유저 마이페이지, 찜,회원수정, 관리자페이지 전체)

### 개발 기간

- 2023-11-20 ~ 2023-12-20

### 기술 스택 및 개발 환경

- HTML
- CSS
- TailWind
- Mysql
- Apache
- Java 8
- JDK 1.8.0
- Eclips IDE

---

## 유저 기능 
- 로그인, 회원가입
- 회원 정보 변경
- 로그인 시 세션 생성
- 구매, 판매 입찰 기능
- 판매 가격 변경
- 찜하기 찜 취소하기
- 판매 물품 진행 단계 확인 기능
 - (유저가 제품 판매를 했을시 Admin 페이지 에서 배송,검수,판매,반송 처리를 유저 페이지 에서 확인 가능하다)

---

## 관리자 기능
- 로그인 및 회원 가입 
- 회원 id 삭제  (블랙 리스트 회원 삭제)
- 판매 제품 삭제  
- 회원 및 제품 검색   ( IF,LIKE 사용 전체 검색 및 키워드 검색 가능)
- 배송,검수,판매,반송 관리  (판매자가 제품 등록 시 가품을 구별하기 위한 기능)
- 회원 생성은 admin(관리자)만 등록
- admin id 외 직원 id 는 해당 관리 페이지 외 접근 금지 

---


# 유저 결과 화면

### 회원가입 페이지 ID,PASS 중복 불가 체크

![1](https://github.com/HeoJinHuck/LUBLE/assets/138653275/8575f969-bcbb-45be-9b8b-c0c5dfb0db9f)

### 신발 리스트 페이지 카테고리 별 선택 기능

![2](https://github.com/HeoJinHuck/LUBLE/assets/138653275/1b8ffe21-beab-41cc-b8f4-cbfa5d967e97)

### 신발 상세 페이지

![3](https://github.com/HeoJinHuck/LUBLE/assets/138653275/19d10697-0c61-4490-9234-fff7b6bf2de6)

### 즉시 구매, 입찰 (즉시 구매를 원하지 않는다면, 입찰 기능을 활용하여 원하는 가격에 입찰가를 넣어둠)

![4](https://github.com/HeoJinHuck/LUBLE/assets/138653275/454c2f73-67b2-4ca7-bdd7-6640ef53e1f0)


### 판매 내역 페이지  (가격이 높아 판매가 안된다면 판매가격을 낮출 수 있다)

![6](https://github.com/HeoJinHuck/LUBLE/assets/138653275/dd0826aa-0c32-4569-bedd-a35890d1bf9d)


---

# 관리자 결과 화면

### 유저가 상품을 판매했을시 오프라인으로 배송된 택배를 확인함

![8](https://github.com/HeoJinHuck/LUBLE/assets/138653275/c2e74302-7fd4-4841-a22f-e736d632eeaf)

### 배송을 확인하면 검수페이지에서 가품인지 체크를 한다

![9](https://github.com/HeoJinHuck/LUBLE/assets/138653275/a5eb01a5-7ebc-4bf5-a5e8-996b30e98dcc)

### 진품이 확인 됬다면 판매 중으로 바뀌고 유저페이지 신발 리스트에 나타나게 된다.

![10](https://github.com/HeoJinHuck/LUBLE/assets/138653275/01e9ccb0-54f8-4b38-9744-37174e8e752d)

### 가품인것으로 확인 된다면 유저 주소로 반송 처리

![11](https://github.com/HeoJinHuck/LUBLE/assets/138653275/5bbe1461-0a09-429f-9065-950ebe2e2f08)



