package pt.iade.juliadisconzi.project;

public class Feedprincipal {<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <SearchView
    android:id="@+id/searchView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>

    <ListView
    android:id="@+id/feedListView"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1">
    </ListView>
</LinearLayout>

}
