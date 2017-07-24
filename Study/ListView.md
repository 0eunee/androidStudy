## ListView
### ListView
* 안드로이드에서 가장 많이 사용되는 위젯
* 리스트 형태로 된 화면 컨트롤
* `Adapter`를 통해 각각의 화면에 디스플레이

### ListView 사용 방법
* ListView에 들어가는 각각의 아이템을 위한 뷰 정의
* 정의된 뷰를 보여줄 클래스를 선언해준다.
* `LayoutInflater` 객체를 이용하여 정의 된 뷰 내용을 객체화 한다.
```java

public class ListViewItemView extends LinearLayout {

    ImageView imageView;
    TextView name;
    TextView phone;
    TextView age;

    public ListViewItemView(Context context) {
        super(context);
        init(context);
    }

    public ListViewItemView(Context context, AttributeSet set) {
        super(context, set);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listViewItem, this, true);

        imageView = (ImageView) findViewById(R.id.Img);
        name = (TextView) findViewById(R.id.name);
        phone = (TextView) findViewById(R.id.phone);
        age = (TextView) findViewById(R.id.age);
    }

    public void setName(String name) {name.setText(name);};
    public void setImg(int resId) {imageView.setImageResource(resId);};
    public void setAge(int age) {phone.setText(String.valueOf(age));};
    public void setPhone(String phone) {age.setText(phone);};
}
```

* `BaseAdapter` 클래스를 상속하여 Adapter 클래스를 정의
```java
class ListAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        public void addItem(SingerItem item) {items.add(item);}

        @Override
        public View getView(int i, View contentView, ViewGroup viewGroup) {
            ListViewItemView view = new ListViewItemView(getApplicationContext());
            SingerItem item = items.get(i);
            view.setName(item.getName());
            view.setPhone(item.getMobile());
            view.setAge(item.getAge());
            view.setImg(item.getResId());
            return view;
        }
    }
```  

* Layout에 ListView 선언해준다.
```xml
<ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></ListView>
```

* ListView를 사용할 Activity에 `ListView` 객체 생성 후 `setAdapter()`에 Adapter 객체 설정
```java
ListView listView = (ListView) findViewById(R.id.listView);
ListAdapter adapter = new ListAdapter();

// adapter에 아이템 추가
adapter.addItem(new SingerItem("LSJ","010-xxxx-xxxx",1,R.drawable.img));

// setAdapter() 매서드에 adapter를 넣어야 리스트뷰가 출력된다.
listView.setAdapter(adapter);
```
