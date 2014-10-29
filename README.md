# TextCounter

A simple subclass of android's [TextView](http://developer.android.com/reference/android/widget/TextView.html) that counts up or down.
Customize the counting using the attributes below.

## Download

``` xml
<dependency>
  <groupId>com.github.premnirmal</groupId>
  <artifactId>TextCounter</artifactId>
  <version>1.0.0</version>
  <type>aar</type>
</dependency>
```

## Usage

### Xml

``` xml
  <com.github.premnirmal.textcounter.CounterView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="20dp"
        android:textSize="30dp"
        android:textColor="@color/orange"
        counter:autoStart="true"
        counter:startValue="100"
        counter:endValue="5000"
        counter:incrementValue="100"
        counter:timeInterval="2"
        counter:prefix="$"
        counter:suffix=" moneys"
        counter:type="integer | decimal | both"
        />
```

### Java

``` java
final CounterView counterView = new CounterView(context);
counterView.setFormatter(new Formatter() {
    @Override
    public String format(String prefix, String suffix, float value) {
    return prefix 
        + NumberFormat.getNumberInstance(Locale.US).format(value) 
        + suffix;
    }
});
counterView.setAutoStart(false);
counterView.setStartValue(200f);
counterView.setEndValue(1000f);
counterView.setIncrement(5f); // the amount the number increments at each time interval
counterView.setTimeInterval(2); // the time interval (ms) at which the text changes
counterView.setPrefix("You have ");
counterView.setSuffix(" points!");
counterView.start(); // you can start anytime if autostart is set to false
```

## Formatter

You can control the text formatting by providing a **Formatter**. Simply implement the interface `com.github.premnirmal.textcounter.Formatter` or use one of the formatters under the `com.github.premnirmal.textcounter.formatters` package.

## API Requirements

- The minimum supported Android version is Android 4.0.0 IceCreamSandwich (API Level 14)

## Contributing

Please fork this repository and contribute back using [pull requests](https://github.com/premnirmal/TextCounter/pulls).

## License

MIT

### Author

> Prem Nirmal | [illegalstate.com](http://illegalstate.com/) | [twitter](https://twitter.com/premnirmal88)
