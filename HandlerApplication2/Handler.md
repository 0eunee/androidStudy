## Handler

### Handler
* Thread 클래스의 `run()` 메소드에서는 안드로이드 객체에 접근이 불가능하다
ex) `run()` 메소드에서 `TextView` 객체의 `setText()` 메서드 직접 접근 불가 
* 메인 스레드와 서브스레드 간에 Handler를 통해 메세지를 전달

### Handler 사용 방법
* `Handler` 클래스를 상속 받아서 새로운 Handler 클래스 생성
```java
public class ProgressHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // 수행 할 내용
        }
    }
```
* Handler 객체 생성
```java
ProgressHandler handler;
```
* Activity가 만들어질 때 Handler 객체 생성(`onCreate(Bundle savedlnstanceState);` 메서드)
```java
handler = new ProgressHandler();
```
* Thread 에서 필요한 경우 `handler.sendMessage(Message msg);` 메서드를 통해 작업 상태나 결과를 전송
```java
Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            }
        });
``` 

### Runnable
* `handler.post(Runnable r);` 매서드로 보내는 방식
* Handler보다 조금 더 간단하게 보낼 수 있음

### Runnable 사용 방법
* `Runnable` 인터페이스를 구현하는 새로운 클래스 정의 후 `run()` 메서드 안에 실행 코드 정의
```java
public class ProgressRunnable implements Runnable {
        @Override
        public void run() {
          // 수행 내용
        }
    }
```
* `Handler` 변수 및 새로 정의한 `Runnable` 객체 변수 선언
```java
ProgressRunnable runnable;
Handler handler;
```
* Activity가 만들어질 때 Handler, Runnable 객체 생성(`onCreate(Bundle savedlnstanceState);` 메서드)
```java
runnable = new ProgressRunnable();
handler = new Handler();
```
* 스레드의 결과를 화면에 표시하기 위해 `handler.post(Runnable r)` 메소드 호출
```java
Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Thread 실행
                handler.post(runnable);
            }
        });
``` 
