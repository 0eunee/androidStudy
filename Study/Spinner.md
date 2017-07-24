## Spinner
### 1. Spinner
* html의 selectBox랑 비슷함
* Layout에 Spinner 선언
```xml
<Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"></Spinner>
```
* Activity에서 id를 찾는다
```java
Spinner spinner = (Spinner) findViewById(R.id.spinner);
```
* ArrayAdaptor 선언 후 Spinner 모양? 및 들어갈 내용이 정의된 String 배열을 넣는다
```java
String items[] = {"a","b","c"};
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
```

* Spinner에 adapter 객체를 넣으면 된다.
```java
spinner.setAdapter(adapter);
```

* Spinner 클릭 이벤트
```java
spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //선택 후 이벤트
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // 아무것도 선택 하지 않은 경우 이벤트
            }
      });
```
