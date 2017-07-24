## EditText
### 1. EditText
* html에서 `input type='text'` 와 같음
* Layout에서 EditText 선언
```xml
<EditText
            android:id="@+id/editText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="name" />
```

### 2. Activity에서 EditText 접근
* Activity에서 EditText 접근 하려면 아이디를 찾아야함
```java
EditText editText = (EditText) findViewById(R.id.editText);
```
### 3. 액티비티에 소프트 키보드가 올라와져 있는 경우
* 해당 액티비티에 onResume() 메서드 오버라이딩
* `getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);` 설정
```java
@Override
    protected void onResume() {
        super.onResume();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
```
### 4. 특정 순간(이벤트) 후에 소프트 키보드 감추거나 보이는 경우
* InputMethodManager 가져옴
```java
InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
// 감출 때
imm.hideSoftInputFromWindow(ViewName.getWindowToken(), 0);
// 보이게 할 때
imm.showSoftInput(ViewName, 0);
```
