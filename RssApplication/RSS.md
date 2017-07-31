## RSS
### RSS(Really Simple Syndication)
* 자주 바뀌는 내용을 제공하기 위해 사용되는 표준 웹 피드 포멧
* XML로 되어 있으며 파서 방법은 DOM, SAX 방법이 있다.
### SAX
* 문서의 내용을 순차적으로 읽어 들이면서 각각의 노드를 파악하는 방식
* 데이터베이스에 있는 내용을 동척 처리 또는 용량이 큰 문서 처리할 때 적합
### DOM
* 전체 문서를 읽은 후 전체 노드 중 필요한 노드를 찾아 처리하는 방식
* 적은 용량의 문서를 구조화하여 처리할 때 적합

### DOM 방식을 이용한 parse
* 응답 결과물 처리를 위한 객체 생성
```java
DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = builderFactory.newDocumentBuilder();
```
* 서버에 정보 요청, 응답 결과를 스트림 객체로 참조
```java
URL url = new URL("요청할 주소");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setDoInput(true);
conn.setDoOutput(true);

int resCode = conn.getResponseCode();
Log.d(TAG, "Response Code : " + resCode);

InputStream instream = conn.getInputStream();
```
* Document builder 객체를 이용해 Document 생성
```java
Document document = builder.parse(instream);
```
* document 객체 처리
```java
// document에서 Element 가져오기
Element docEle = document.getDocumentElement();
NodeList nodelist = docEle.getElementsByTagName("item");
Element entry = (Element) nodelist.item(0);
Element title = (Element) entry.getElementsByTagName("title").item(0);
String titleValue = "";
if (title != null) {
  Node firstChild = title.getFirstChild();
  if (firstChild != null) {
    titleValue = firstChild.getNodeValue();
  }
}
```
