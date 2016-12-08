# Carousel with timer #

### Getting Start ###

1. Create the dots in drawble folder

  Name: *** res/drawble/nonselecteditem_dot.xml ***
  ```
  <?xml version="1.0" encoding="utf-8"?>
  <shape xmlns:android="http://schemas.android.com/apk/res/android"
      android:shape="oval" android:useLevel="true"
      android:dither="true">

      <size android:height="10dip" android:width="10dip"/>

      <solid android:color="#80FFFFFF"/>
  </shape>
  ```

  Name: *** res/drawble/selecteditem_dot.xml ***
  ```
  <?xml version="1.0" encoding="utf-8"?>
  <shape xmlns:android="http://schemas.android.com/apk/res/android"
      android:shape="oval" android:useLevel="true"
      android:dither="true">

      <size android:height="10dip" android:width="10dip"/>

      <solid android:color="@android:color/white"/>
  </shape>
  ```

2. Copy ``` adapter_viewpager.xml ``` to ``` res/layout```

3. Copy ``` CircularViewPagerHandler.java ``` to ``` app/java ```

4. Copy ``` HomeViewPagerAdapter.java ``` to ``` app/java ```

  Now you can start configuration your carousel.
