## ImageSwitcher
### ImageSwitcher
* ImageView를 이용해 이미지를 교체해주는 방법은 스레드 안에서 이미지를 변경해야한다.
* ImageSwitcher 클래스는 여러 개의 이미지를 교체하면서 보여주고 싶을 경우 사용

### ImageSwitcher를 이용한 애니메이션
* Handler 및 ImageSwitcher, Thread 객체 생성
```java
Handler handler = new Handler();
ImageSwitcher swithcer;
Thread thread;
```
* ImageSwitcher 객체 선언 후 Factory 설정
```java
switcher = (ImageSwitcher) findViewById(R.id.switcher);

switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                // 이미지 설정
                return imageView;
            }
        });
      
```
* Thread 클래스를 상속받는 애니메이션 Thread 생성
```java
class ImageThread extends Thread {
        @Override
        public void run() {
          // 애니메이션 실행 부분
        }
    }
```

* 애니메이션을 시작하려는 곳에서 Thread 객체 선언 후 시작
```java
thread = new ImageThread();
thread.start();
```
* 애니메이션 Thread에서 `handler.post()` 매서드를 이용해 파라미터로 객체 전달
```java
handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // switcher에 이미지 설정
                        switcher.setImageResource(R.drawable.img);
                    }
                });
```

