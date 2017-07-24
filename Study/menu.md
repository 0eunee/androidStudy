# menu

## 1. menu
- `res/menu` 폴더 생성
- menu 폴더에서 마우스 오른쪽 클릭 후 New > menu resources file 선택 후 `layout.xml` 생성
- `MainActivity`에서 `onCreateOptionsMenu()`, `onOptionsItemSelected()` 매서드 오버라이드

### onCreateOptionsMenu
- 메뉴 레이아웃을 불러오는 매서드
```java
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
}
```

### onOptionsItemSelected
- 메뉴 선택 후 이벤트를 실행하는 매서드
```java
public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();

        switch (curId) {
            case R.id.menu_refresh :
                // 이벤트 
                break;
            case R.id.menu_search :
                // 이벤트 
                break;
            case R.id.menu_settings :
                // 이벤트 
                break;
        }

        return super.onOptionsItemSelected(item);
}
``` 
