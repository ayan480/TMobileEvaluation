// Generated by Dagger (https://dagger.dev).
package com.syncoders.data.dataSource.sharedPreferences;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class SharedPreferencesHelper_Factory implements Factory<SharedPreferencesHelper> {
  private final Provider<Context> contextProvider;

  public SharedPreferencesHelper_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferencesHelper get() {
    return newInstance(contextProvider.get());
  }

  public static SharedPreferencesHelper_Factory create(Provider<Context> contextProvider) {
    return new SharedPreferencesHelper_Factory(contextProvider);
  }

  public static SharedPreferencesHelper newInstance(Context context) {
    return new SharedPreferencesHelper(context);
  }
}
