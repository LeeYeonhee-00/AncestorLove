# <p align="center">[우리FISA 3기 클라우드 엔지니어링] AncestorLove 미니 프로젝트
## <p align="center"><font color="blue"> 🖤 조 상 사 랑 🖤</font></p>

---

<h2 style="font-size: 25px;"> 개발팀원👨‍👨‍👧‍👦💻<br>
<br>

|<img src="https://avatars.githubusercontent.com/u/175369539?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/98442485?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/79312705?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/175371231?v=4" width="150" height="150"/>|
|:-:|:-:|:-:|:-:|
|[@김성호](https://github.com/castlhoo)|[@이연희](https://github.com/LeeYeonhee-00)|[@김상민](https://github.com/isshomin)|[@오재웅](https://github.com/ohwoong2)|

---

<br>

## 학습 목적 

- 채울예정

<br>

## 서비스 서사

- 채울예정

<br>

---


## 협업 툴 🌷

|<img src="https://github.com/user-attachments/assets/4260362c-bd6b-4a62-be26-f0e9877d6d2d" width="100" height="100"/>|<img src="https://github.com/user-attachments/assets/891e0922-5faf-42e7-9084-05cf7665de66" width="100" height="100"/>|<img src="https://github.com/user-attachments/assets/01db835f-c1b9-4464-a4ab-246a7909bd39" width="100" height="100"/>|<img src="https://github.com/user-attachments/assets/edacbb9d-b24f-421d-8949-e74dffd265a7" width="100" height="100"/>|<img src="https://github.com/user-attachments/assets/cb500407-367c-4fbd-9034-164b787c454f" width="100" height="100"/>|<img src="https://github.com/user-attachments/assets/7f0cebd8-646a-4c8a-8984-c95c73a38f7f" width="100" height="100"/>|
|:-:|:-:|:-:|:-:|:-:|:-:|
|[github](https://github.com/LeeYeonhee-00/AncestorLove)|[Figma](https://www.figma.com/design/nbH74PZ2kNx8eawHeOr5H0/%EC%A1%B0%EC%83%81%EC%82%AC%EB%9E%91?node-id=0-1&t=SZhNT1U5q2xakiA1-0)|[ERD Cloud](https://www.erdcloud.com/d/PkKH2x6a8DdbHu5sv)|[draw.io](https://app.diagrams.net/#G13KcZneZoogQibX7kvNiEjm0LWQps9WMd)|[Google Drive](https://drive.google.com/drive/folders/1ziIkdKyo4RybZGGjVkOe5-O1DvyDgCOx)|[Google Sheets](https://docs.google.com/spreadsheets/d/10_TurIupL0CsPPRj1C1vxaj9Yeoeu376W5fhB-p0QYE/edit?gid=0#gid=0)|

 <br>
 
 ---
 
<br>

## 개발 환경 구성도 🎨


<p align="left"><img src="https://github.com/user-attachments/assets/ac901fe8-29d6-4156-8783-354af2154d78"></p>
<p align="center"><img src="https://img.shields.io/badge/Framework-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/Build-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white">
<img src="https://img.shields.io/badge/Language-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
<img src="https://img.shields.io/badge/Project Encoding-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/UTF 8-EA2328?style=for-the-badge">

 <br>
 <br>

---

<br>

## 요구사항 정의서 📝
|서비스      |기능        |요구사항 설명|필요 데이터|
|-------------------|------------|----|---|
| 유저           |회원가입     |자체 회원가입 기능  |ID, 비밀번호, 이름, 성별, 나이, 이메일| 
|               |로그인         |로그인 기능 |ID, 비밀번호   | 
| 문의           |문의 등록         |로그인한 유저는 문의를 등록할 수 있음  |작업 종류, 날짜, 주소, 내용| 
|               |댓글 등록 |로그인한 유저는 댓글을 등록할 수 있음   |댓글 내용
| 파트너         |파트너 페이지 |제휴한 파트너들의 목록과 간단한 정보를 볼 수 있는 페이지 |파트너 이름, 파트너 사진, 파트너 작업 지역, 만족도   | 
|               |파트너 상세 페이지      |특정 파트너의 상세한 정보를 볼 수 있는 페이지 |파트너 이름, 평당 금액, 분묘 금액, 파트너 설명, 후기내용, 파트너 사진   |
|               |계약 체결         |파트너는 의뢰에서 계약을 원하는 댓글 하나에만 체결 버튼을 누를 수 있음 |계약 체결   |
| 기 타            |랜딩 페이지         |‘지금 바로 의뢰하기’ 버튼이 있는 랜딩 페이지 |   |
|                |네비게이션 바 |로그인/로그아웃 버튼, 로고 버튼(클릭 시 랜딩 페이지 이동), 의뢰하기 버튼, 파트너 정보 버튼 |   |

<br>

### 1️⃣) 요구사항 

- 랜딩페이지 출력
  - 지금 바로 의뢰하기 버튼
- 로그인
- 회원가입
- 의뢰 문의글 작성
- 댓글 작성
- 의뢰 문의글 조회
- 파트너(기업) 정보 리스트 조회
- 파트너(기업) 상세 정보 조회
- 네비게이션 바 출력
 - 로그인 버튼
 - 홈 버튼(클릭 시 랜딩페이지로)
 - 파트너(기업) 버튼
 - 의뢰하기 버튼
- inquiry는 의뢰하기 게시물 하나를 의미
- 하나의 의뢰에는 하나의 작업만 가능 (작업 = work)

<br>

### 2️⃣) 사전 정의사항

- 기업데이터는 관리자가 직접 데이터베이스에 넣는 것으로 한다.
- 의뢰하기 게시글 작성은 로그인한 사용자만 작성하는 것으로 한다.
- 계약 체결된 댓글에서 게시글에 기입된 날짜 이후 모달창으로 후기를 작성할 수 있게 한다.
- 의뢰하기를 원하는 사용자가 게시글 작성, 파트너 사에서 의뢰하기 게시글을 보고 계약 제의 댓글을 달아 사용자가 원하는 기업과 계약체결이 될 수 있도록 한다.

<br>

## Github 협업 규칙 👮‍♂️

<br>

### 1️⃣) branch 규칙
  - 서비스마다 branch를 만들어서 작업한다.
   - main / user / inquiry / partner / front

<br>

### 2️⃣) 커밋 메세지 규칙
   - 제목과 본문을 빈 행으로 구분한다.
   - 제목은 50글자 이내로 제한한다.
   - 제목의 첫 글자는 대문자로 작성한다.
   - 제목 끝에는 마침표를 넣지 않는다.
   - 제목은 명령문으로 사용하며 과거형을 사용하지 않는다.
   - 본문의 각 행은 72글자 내로 제한한다.
   - 어떻게 보다는 무엇과 왜를 명확히 설명한다.

<br>

### 3️⃣) 커밋 메세지 구조  
```Markdown
#header
type: title(제목)
header는 필수

#body
header에서 표현할 수 없는 상세한 내용 기입
header에서 충분히 표현할 수 있다면 생략 가능

#footer
어떤 이슈에서 왔는지 같은 참조 정보들을 추가하는 용도로 사용
생략가능
```

<br>

### 4️⃣) type 분류 및 용도
|type 이름     |내용        |
|-----------|------------|
|feat|새로운 기능 추가        |
|fix   |버그 수정         |
|doc     |문서 수정         |
|style   |코드 스타일 변경(코드 포맷, 세미콜론 누락 등)|
|design   |UI/UX 디자인 수정|
|test     |테스트 코드 추가 및 수정     |
|refactor     |리팩토링      |
|build     |빌드 파일 수정 및 업데이트       |
|perf    |성능 개선 |
|chore      |자잘한 수정    |
|rename      |파일명 or 폴더명 수정  |
|remove  |파일 삭제 |

---

## 비즈니스 모델 💰

### B2C

- 계약 체결 시 중개 수수료
- 제휴 파트너에 등록(기업 정보 게시) 수수료
- 네이버 카페, 당근마켓 등 웹사이트, 앱 내에 광고 게시


---
<br>

## API명세서 📑


|이름     |태그        |URL     |
|-----------|------------|------|
|회원가입 |POST       |http://127.0.0.1/signup |
|로그인   |POST         |http://127.0.0.1/signup |
|댓글 작성  |POST         |http://127.0.0.1/comment |
|파트너 리스트 조회 |GET |http://127.0.0.1/allpartner |
|파트너 상세 조회   |GET |http://127.0.0.1/partner/{id} |
|의뢰하기 글 작성     |POST     |http://127.0.0.1/inquriy |
|의뢰하기 리스트 조회     |GET      |http://127.0.0.1/allinquriy |
|의뢰하기 상세 조회     |GET       |http://127.0.0.1/inquriy/{id} |
|로그아웃    |POST |http://127.0.0.1/logout |
|계약체결      |POST    |http://127.0.0.1/logout |

---
<br>

<details>
<summary> <h2 style="font-size: 10px;">💻개발 주요 과정</summary>

### 1️⃣) 데이터 스키마

<p align="left"><img src="https://github.com/user-attachments/assets/79ca6973-e11f-48d0-b9d0-0e4fc7d67d3d">

 <br>

### 2️⃣) Entity

<p align="left"><img src="https://github.com/user-attachments/assets/8575f573-f809-43cd-87d4-ae73456a3fcc">

 <br>

### 3️⃣) DTO

<p align="left"><img src="https://github.com/user-attachments/assets/4eb4b078-661d-4706-93cc-5d8585292b5a">

 <br>

### 4️⃣) Controller

<p align="left"><img src="https://github.com/user-attachments/assets/161751fa-3a00-4946-8913-3ab1a6c0a8fc">

 <br>

### 5️⃣) Repository

<p align="left"><img src="https://github.com/user-attachments/assets/34727c50-18ea-4243-b17c-04e9e33b37bd">

 <br>

### 6️⃣) Service

<p align="left"><img src="https://github.com/user-attachments/assets/93bb366a-a284-4f8d-ba84-71a797ad6cb8">

 <br>

<p align="left"><img src="https://github.com/user-attachments/assets/7d0600b3-0872-4e12-bcc2-8bf8bded72b6">

 <br>

### 7️⃣) login.html

<p align="left"><img src="https://github.com/user-attachments/assets/a7fd42c5-02de-431a-8c42-263a1b0e2d63">

 <br>

---

</details>

## 🎞시연 영상

[![조상사랑시연영상](https://github.com/user-attachments/assets/28284586-15b1-439f-8aa8-150ec0e925e6)](https://youtu.be/Gubi7e5XXRs)


<br>

---

## ELK Pipeline🧵

### 1️⃣) 서비스 로그 작성 규칙

- ancestorlove → 태그 추가

<br>

- API 요청 시 → DEBUG 레벨 로그 작성 logger.debug("ancestorlove 의뢰하기 요청");

<br>

- 요청 성공 시 → INFO 레벨 로그 작성 logger.info("ancestorlove 의뢰하기 작성 성공");

<br>

- 요청 실패 시 → WARN 레벨 로그 작성 logger.warn("ancestorlove 의뢰하기 작성 실패");

<br>

- 로그 예시 → 2024-08-16 15:04:03 INFO  c.c.f.c.PartnerController:63 - ancestorlove 의뢰하기 작성 성공사용자 성별 : FEMALE, 사용자 나이 : 22, 의뢰 유형 : 예초, 의뢰장소 : testtest, 작업 날짜 : 2024-08-16T15:03

<br>

### 2️⃣) Filter

```YAML
input {
 # beat에서 데이터를 받을 port지정
  beats {
    port => 5044 
  }
}

filter {
  if [message] =~ /\[ancestorlove\]/ {
    grok {
      match => { "message" => "%{TIMESTAMP_ISO8601:log_timestamp} %{LOGLEVEL:log_level} %{DATA:class} - \[ancestorlove\] %{GREEDYDATA:log_message}" }
    }

    if [log_message] =~ /의뢰하기 작성 성공/ {
      grok {
        match => { "log_message" => "의뢰하기 작성 성공사용자 성별 : %{WORD:gender}, 사용자 나이 : %{NUMBER:age:int}, 의뢰 유형 : %{DATA:request_type}, 의뢰장소 : %{DATA:request_location}, 작업 날짜 : %{TIMESTAMP_ISO8601:work_date}" }
      }

      date {
        match => [ "log_timestamp", "yyyy-MM-dd HH:mm:ss" ]
        target => "request_date"
      }

      mutate {
        remove_field => [ "message", "log_message", "@version", "ecs", "agent", "log", "input", "tags", "host" ]
      }
    } else {
      drop { }
    }
  } else {
    drop { }
  }
}

output {

  # 콘솔창에 어떤 데이터들로 필터링 되었는지 확인
  stdout {
    codec => rubydebug
  }

  # 위에서 설치한 Elasticsearch 로 "ancestorlove" 라는 이름으로 인덱싱 
  elasticsearch {
    hosts => ["http://localhost:9200"]
    index => "ancestorlove"
  }
}
```

<br>

### Elastic Search 결과

<p align="left"><img src="https://github.com/user-attachments/assets/b39f6b8a-fd3a-4bf2-b416-59a0535a8edf">

<br>

<p align="left"><img src="https://github.com/user-attachments/assets/8a275211-295e-45a7-939b-32b4b6805f82">

<br>



1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣9️⃣


## 회 고 📝

### [김성호](https://github.com/castlhoo)
> 1
<br>

### [이연희](https://github.com/LeeYeonhee-00)
> 2

<br>

### [김상민](https://github.com/isshomin)
> 3

<br>

### [오재웅](https://github.com/ohwoong2)
> 4

---
