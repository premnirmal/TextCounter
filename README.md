[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.premnirmal/TextCounter/badge.png)](http://search.maven.org/#artifactdetails|com.github.premnirmal|TextCounter|1.1.0|)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-TextCounter-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1140)

# TextCounter

A simple subclass of android's [TextView](http://developer.android.com/reference/android/widget/TextView.html) that counts up or down.
Customize the counting using the attributes below.

See the demo project for more implementation details.

![](img/counter.gif)

## Download

### Gradle

``` groovy
compile 'com.github.premnirmal:TextCounter:1.1.0'
```

### Maven Central

``` xml
<dependency>
  <groupId>com.github.premnirmal</groupId>
  <artifactId>TextCounter</artifactId>
  <version>1.1.0</version>
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

> [Prem Nirmal](http://premnirmal.me/)
