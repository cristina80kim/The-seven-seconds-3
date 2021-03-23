  * 테이블 정의
    01. 사용자(User; Users)
	02. 숙소(Room_Mst; Room Master)
	03. 룸(Room_Dtl; Room Detail)
	04. 예약 열기/닫기(Open_Rsrv; Open/Close Reservation)
	05. 예약(Rsrv; Reservation)
	06. 결제(Pay; Payment)
	07. 환불(Refd; Refund) ; 사용 안 함
	08. 후기(Revu; Reviews)
	09. 포인트(Poin; Point)
	10. Q&A(QnA; Question and Answer)
	11. FAQ(Frequently Asked Questions)
	12. 공지사항(Noti; Notice); 공지사항
	13. 달력(Caln; Calendar); 휴일 관리용
	14. 공통코드(Code; Common Codes); Q&A Category, 지역, 사업자등록번호
	15. 공통노트(Note; Common Notes); 이용약관, 개인정보처리방침 등
	16. 즐겨찾기


[공통컬럼]
    - C_USER; Tupple 생성자 ID.
    - M_USER; Tupple 수정자 ID.
    - C_DATE; Tupple 생성 날짜/시간
    - M_DATE; Tupple 수정 날짜/시간
	
    -- 00. DB 생성 및 전체 테이블 삭제
	1. SqlDeveloper에서 SYSTEM 또는 SYSDBA 계정으로 접속
	   - 접속이름: 적당히 입력(예: System)
	   - 사용자 이름: SYSTEM (또는 SYSDBA)
	   - 비밀번호: ORACLE 설치시 입력한 SYSTEM 암호
	   - 롤[항목이 있는 경우만 입력]: SYSDBA
	   - 호스트 이름: localhost
	   - 포트: 1521
	   - SID: xe
	   >> 테스트 Btn 또는 접속 Btn
	2. User 생성
	   CREATE USER the7secs IDENTIFIED BY the_seven_secs
       DEFAULT TABLESPACE users
       TEMPORARY TABLESPACE temp;
	3. DBA 권한 부여
	   GRANT CONNECT, RESOURCE, DBA TO the7secs;   
    4. SqlDeveloper >> 접속
       - 사용자 이름: the7secs
       - 비밀번호: the_seven_secs
	   >> 접속 btn
	   
    DROP TABLE users;
	
	DROP SEQUENCE seq_room_mst;
	DROP TABLE room_mst;
	
	DROP SEQUENCE seq_room_dtl;
	DROP TABLE room_dtl;
	
	DROP SEQUENCE seq_open_rsrv;
	DROP TABLE open_rsrv;
	
	DROP SEQUENCE seq_rsrv;
	DROP TABLE rsrv;
	
	-- DROP SEQUENCE seq_pay;
	-- DROP TABLE pay;
	
	DROP SEQUENCE seq_revu;
	DROP TABLE revu;
	
	DROP SEQUENCE seq_point;
	DROP TABLE point;
	
	DROP SEQUENCE seq_qna;
	DROP TABLE qna;
	
	DROP SEQUENCE seq_faq;
	DROP TABLE faq;
	
	DROP SEQUENCE seq_notice;
	DROP TABLE notice;
	
	DROP TABLE caln;
	
	DROP SEQUENCE seq_code;
	DROP TABLE code;

	DROP SEQUENCE seq_note;
	DROP TABLE note;

	
    -- 01. 사용자(Users; Users)
	CREATE TABLE users(
	  ID             VARCHAR2(20) NOT NULL,      -- 사용자 ID.
	  PWD            VARCHAR2(20) NOT NULL,      -- 비밀번호
	  NAME           VARCHAR2(30) NOT NULL,      -- 이름
	  NICKNAME       VARCHAR2(30) NOT NULL,      -- 별명
	  TEL            VARCHAR2(20) NOT NULL,      -- 전화번호
	  EMAIL          VARCHAR2(100) NOT NULL,     -- E-Mail
	  GEN            VARCHAR2(1) NOT NULL,       -- Gender 'M': Male, 'F': Female
	  ROLE           VARCHAR2(1) DEFAULT 'U',    -- 구분; U:개인, 'M':사장, 'A': Admin
      POINT          NUMBER(10) DEFAULT 0 NOT NULL, -- 현재 포인트
	  C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
	  M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
	  C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
	  M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );

	-- 02. 숙소(Room_Mst; Room Master)
    CREATE SEQUENCE seq_room_mst START WITH 1000000000 INCREMENT BY 1 CACHE 10;
    CREATE TABLE room_mst(
	  id             NUMBER(10) NOT NULL,        -- ID
      region         VARCHAR2(40) NOT NULL,      -- 지역
      title          VARCHAR2(200) NOT NULL,     -- 숙소명
	  zip_code       VARCHAR2(10) NOT NULL,      -- 우편번호
      addr           VARCHAR2(300) NOT NULL,     -- 주소
      tel            VARCHAR2(20) NOT NULL,      -- 전화번호
      info           VARCHAR2(2000) NOT NULL,    -- 설명
	  pic1_org       VARCHAR2(300) NULL,         -- 사진1 원본파일명
	  pic1_uuid      VARCHAR2(32) NULL,          -- 사진1 UUID(Universally Unique IDentifier)
	  pic2_org       VARCHAR2(300) NULL,         -- 사진2 원본파일명
	  pic2_uuid      VARCHAR2(32) NULL,          -- 사진2 UUID(Universally Unique IDentifier)
	  pic3_org       VARCHAR2(300) NULL,         -- 사진3 원본파일명
	  pic3_uuid      VARCHAR2(32) NULL,          -- 사진3 UUID(Universally Unique IDentifier)
	  C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
	  M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
	  C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
	  M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );

	-- 03. 룸(Room_Dtl; Room Detail)
    CREATE SEQUENCE seq_room_dtl START WITH 1000000000 INCREMENT BY 1 CACHE 10;
    CREATE TABLE room_dtl(
	  id             NUMBER(10) NOT NULL,        -- ID
	  mst_id         NUMBER(10) NOT NULL,        -- RoomMst(fk)
	  room_name      VARCHAR2(200) NOT NULL,     -- 룸 명
	  num_of_guests  NUMBER(3) NOT NULL,         -- 인원수
	  check_in_time  VARCHAR2(5) NULL,           -- 입실시간
	  check_out_time VARCHAR2(5) NULL,           -- 퇴실시간
	  weekday_price  NUMBER(10) NOT NULL,        -- 평일가격
	  weekend_price  NUMBER(10) NOT NULL,        -- 휴일가격
	  pic1_org       VARCHAR2(300) NULL,         -- 사진1 원본파일명
	  pic1_uuid      VARCHAR2(32) NULL,          -- 사진1 UUID(Universally Unique IDentifier)
	  pic2_org       VARCHAR2(300) NULL,         -- 사진2 원본파일명
	  pic2_uuid      VARCHAR2(32) NULL,          -- 사진2 UUID(Universally Unique IDentifier)
	  pic3_org       VARCHAR2(300) NULL,         -- 사진3 원본파일명
	  pic3_uuid      VARCHAR2(32) NULL,          -- 사진3 UUID(Universally Unique IDentifier)
	  C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
	  M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
	  C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
	  M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );	

	-- 04. 예약 열기/닫기(Open_Rsrv; Open/Close Reservation)
    CREATE SEQUENCE seq_open_rsrv START WITH 1000000000 INCREMENT BY 1 CACHE 10;
	CREATE TABLE Open_Rsrv(
	  id             NUMBER(10) NOT NULL,        -- ID
	  oc_date        DATE NOT NULL,              -- 날짜
	  open_close     VARCHAR2(1) DEFAULT 'O' NOT NULL,  -- 'O': Open, 'C': Close
	  C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
	  M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
	  C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
	  M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
	);

	-- 05. 예약(Rsrv; Reservation)
	CREATE SEQUENCE seq_rsrv START WITH 1000000000 INCREMENT BY 1 CACHE 10;
    CREATE TABLE rsrv(
	  id             NUMBER(10) NOT NULL,        -- ID
      Rsrv_date      DATE NOT NULL,              -- 예약날짜
      Rsrv_stay      VARCHAR2(200) NOT NULL,     -- 숙소명
      Rsrv_room      VARCHAR2(200) NOT NULL,     -- 룸 명
	  room_dtl_id    NUMBER(10) NOT NULL,        -- 룸(객실) id(fk)
      Rsrv_id        VARCHAR2(20) NOT NULL,      -- 예약자 ID.
      Rsrv_name      VARCHAR2(30) NOT NULL,      -- 예약자 이름
      Rsrv_gen       VARCHAR2(1) NOT NULL,       -- 예약자 성별
      Rsrv_tel       VARCHAR2(20) NOT NULL,      -- 예약자 전화번호
      price          NUMBER(10) NOT NULL,        -- 가격
      Rsrv_info      VARCHAR2(20) NOT NULL,      -- 결제 정보(결재수단: 토스/네이페이)
      appr_no        VARCHAR2(30) NOT NULL,      -- 승인번호
      Rsrv_state     VARCHAR2(1) NOT NULL,       -- 예약 상태('1': 예약완료(=결제완료), '2': 예약취소(=환불요청), '3': 환불완료, '9': 처리종료)
      C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
      M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
      C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
      M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );
	
	-- 06. 결제(Pay; Payment) - 사용 안 함
	CREATE SEQUENCE seq_pay START WITH 1000000000 INCREMENT BY 1 CACHE 10;
	-- CREATE TABLE pay(
	--   id             NUMBER(10) NOT NULL,        -- ID
    --   title          VARCHAR2(200) NOT NULL,     -- 숙소명
	--   room_name      VARCHAR2(200) NOT NULL,     -- 룸 명
	--   date_used      DATE NOT NULL,              -- 사용일(=결제일)
    --   price          NUMBER(10) NOT NULL,        -- 가격
    --   C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
    --   M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
    --   C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
    --   M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
	-- );
	
	-- 07. 환불(Refd; Refund)
	
	-- 08. 후기(Revu; Reviews)
	CREATE SEQUENCE seq_revu START WITH 1000000000 INCREMENT BY 1 CACHE 10;
    CREATE TABLE revu(
	  id             NUMBER(10) NOT NULL,        -- ID
      nickname       VARCHAR2(30) NOT NULL,      -- 닉네임
      content        VARCHAR2(500) NULL,         -- 내용
      star           NUMBER(1),                  -- 별점(1~5)
      C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
      M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
      C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
      M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );
	
	-- 09. 포인트(Point; Point)
	CREATE SEQUENCE seq_point START WITH 1000000000 INCREMENT BY 1 CACHE 10;
	CREATE TABLE point(
	  id             NUMBER(10) NOT NULL,        -- ID
      point          NUMBER(10) NOT NULL,        -- 포인트
      kind           VARCHAR2(1) NOT NULL,       -- 적립종류('1': 적립 '2': 차감)
	  room_dtl_id    NUMBER(10) NOT NULL,        -- 룸(객실) id(fk)
      title          VARCHAR2(200) NOT NULL,     -- 숙소명
	  room_name      VARCHAR2(200) NOT NULL,     -- 룸 명
	  date_used      DATE NOT NULL,              -- 사용일
      C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
      M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
      C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
      M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );

	-- 10. Q&A(QnA; Question and Answer)
	CREATE SEQUENCE seq_qna START WITH 1000000000 INCREMENT BY 1 CACHE 10;
	CREATE TABLE qna(
      id             NUMBER(10) NOT NULL,        -- ID
	  nickname       VARCHAR2(20) NOT NULL,      -- nickname
	  no             NUMBER(10) NOT NULL,        -- 글번호
      cate_id        VARCHAR2(30) NOT NULL,      -- 공통코드 faq_cate 참조(***)
	  is_pub         VARCHAR2(1) DEFAULT 'Y' NOT NULL, -- 'Y': 공개글, 'N': 비밀글
      title          VARCHAR2(200) NOT NULL,     -- 제목
      q              VARCHAR2(2000) NULL,        -- 질문 내용
      a              VARCHAR2(2000) NULL,        -- 답변 내용
      C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
      M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
      C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
      M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );
INSERT INTO qna (id, nickname, no, cate_id, is_pub, title, q)
VALUES ((SELECT seq_qna.nextval FROM DUAL), 'yskim', 1, 'cate11', 'Y', 't1', 'q1')
			 
	-- 11. FAQ(Frequently Asked Questions)
	CREATE SEQUENCE seq_faq START WITH 1000000000 INCREMENT BY 1 CACHE 10;
    CREATE TABLE faq(
	  id             NUMBER(10) NOT NULL,        -- ID
	  no             NUMBER(10) NOT NULL,        -- 글번호
      cate_id        VARCHAR2(30) NOT NULL,      -- 공통코드 faq_cate 참조(***)
      title          VARCHAR2(200) NOT NULL,     -- 제목
      content        VARCHAR2(2000) NULL,        -- 내용
      C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
      M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
      C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
      M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );

	-- 12. 공지사항(Notice; Notice); 공지사항
	CREATE SEQUENCE seq_notice START WITH 1000000000 INCREMENT BY 1 CACHE 10;
    CREATE TABLE notice(
	  id             NUMBER(10) NOT NULL,        -- ID
	  no             NUMBER(10) NOT NULL,        -- 글번호
	  nickname       VARCHAR2(30) NOT NULL,      -- 생성자 닉네임(보통 '관리자')
      title          VARCHAR2(200) NOT NULL,     -- 제목
	  content        VARCHAR2(2000) NULL,        -- 내용
      C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
      M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
      C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
      M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
    );
	  
	-- 13. 달력(Caln; Calendar)
	CREATE TABLE caln (
      id             DATE NOT NULL,              -- 날짜
	  is_holi        VARCHAR2(1) DEFAULT 'Y' NULL, -- 'Y': 휴일, 'N': 평일
	  holi_name      VARCHAR2(30) NULL           -- 휴일명
	  -- C_USER, ... M_DATE 생략
	);

	-- 14. 공통코드(Code; Common Codes); Q&A Category, 지역, 사업자등록번호
	CREATE SEQUENCE seq_code START WITH 1000000000 INCREMENT BY 1 CACHE 10;
	CREATE TABLE code(
	  id             NUMBER(10) NOT NULL,        -- ID
	  class1         VARCHAR2(30) NOT NULL,      -- 대분류(분류1)
	  class2         VARCHAR2(30) NOT NULL,      -- 중분류(분류2)
	  class3         VARCHAR2(30) NOT NULL,      -- 소분류(분류3)
	  class4         VARCHAR2(30) NOT NULL,      -- 세분류(?)(분류4)
	  name           VARCHAR2(50) NOT NULL,      -- 분류명
	  dtl            VARCHAR2(300) NULL,         -- 상세 설명
      C_USER         VARCHAR2(20) NOT NULL,      -- 생성자 ID.
      M_USER         VARCHAR2(20) NULL,          -- 수정자 ID.
      C_DATE         TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 생성 날짜/시간
      M_DATE         TIMESTAMP NULL              -- 수성 날짜/시간
	);
	
	-- 15. 공통노트(Note; Common Notes); 이용약관, 개인정보처리방침 등
	CREATE SEQUENCE seq_note START WITH 1000000000 INCREMENT BY 1 CACHE 10;
	CREATE TABLE note(
	  id             NUMBER(10) NOT NULL,        -- ID
	  title          VARCHAR2(200) NOT NULL,     -- 제목
	  content        BLOB NULL                   -- 내용
	);