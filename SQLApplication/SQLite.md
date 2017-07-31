## SQLite
### SQLite
* 안드로이드에서 데이터를 저장하는 가장 간단한 방법
* 데이터베이스의 복사, 이동, 삭제가 매우 쉽다.
### 사용 방법
* SQLiteDatabase 객체 선언
```java
SQLiteDatabase db;
```
* 데이터베이스 생성 또는 선언
```java
db = openOrCreateDatabase("데이터베이스 이름", Activity.MODE_PRIVATE,null);
```
* 테이블 생성 및 쿼리 실행
```java
db.excSQL("쿼리문");
```
