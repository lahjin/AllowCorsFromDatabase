# Simple Cors from DB

http://localhost:9140/h2-console

JDBC:URL:jdbc:h2:mem:test

JDBC:Name:sa

---

APP_USER 테이블에 데이터를 삽입한다.

CORS 테이블에 허용하는 URL를 지정하여 데이터를 삽입한다.

---

Origin이 다른 클라이언트에서 http://localhost:9140/data를 GET 방식으로 요청한다.

이 때 Header에 Authorization에 APP_USER 테이블의 token 컬럼 값을 넣는다.

응답에 "Data Test"가 정상적으로 응답하는지 테스트한다.