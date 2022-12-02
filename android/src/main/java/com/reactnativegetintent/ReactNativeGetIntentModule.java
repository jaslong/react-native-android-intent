package com.reactnativegetintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import java.util.Collections;
import java.util.Set;

class ReactNativeGetIntentModule extends ReactContextBaseJavaModule {
  public ReactNativeGetIntentModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "ReactNativeGetIntent";
  }

  @ReactMethod
  public void getIntent(Promise promise) {
    final Activity activity = getCurrentActivity();
    if (activity == null) {
      promise.reject(new IllegalStateException("getCurrentActivity() returned null"));
      return;
    }

    final Intent intent = activity.getIntent();

    Set<String> categories = intent.getCategories();
    if (categories == null) {
      categories = Collections.emptySet();
    }

    Bundle extras = intent.getExtras();
    if (extras == null) {
      extras = Bundle.EMPTY;
    }

    // https://reactnative.dev/docs/native-modules-android#argument-types
    final WritableMap jsIntent = Arguments.createMap();
    jsIntent.putString("action", intent.getAction());
    jsIntent.putString("data", intent.getDataString());
    jsIntent.putArray("categories", Arguments.fromArray(categories.toArray(new String[0])));
    jsIntent.putMap("extras", Arguments.fromBundle(extras));
    promise.resolve(jsIntent);
  }
}
