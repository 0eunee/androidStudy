# fragment

### 1. fragment란
- 하나의 화면에서 전체 또는 일부를 구성할 때 사용
- 화면 UI를 구성할 때 많이 사용

### 2. fragment 사용
- fragment를 사용할 xml layout에 fragment 생성
- fragment에 andorid:name에 fragment로 사용할 class파일 경로 지정
- fragement import파일은 android.support.v4.app.Fragment

```java
FragmentManager manager = getSupportFragmentManager();
listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
```
