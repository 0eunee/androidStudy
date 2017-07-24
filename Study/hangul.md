## 디자인 화면 한글 깨짐 해결 방법
1. 안드로이드 설치 폴더에서 `font.xml` 파일 열기
```
C:\Program Files\Android\Android Studio\plugins\android\lib\layoutlib\data\fonts
```

2. `font.xml` 파일 수정 (다른 폴더로 복사 후 수정)

* 수정 전
```xml
<family lang="ko">
  <font weight="400" style="normal" index="1">NotoSansCJK-Regular.ttc</font>
</family>
```

* 수정 후
```xml
<family lang="ko">
  <font weight="400" style="normal" index="1">NanumGothic.ttf</font>
</family>
```

3. 수정한 `font.xml` 붙여넣기
