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
