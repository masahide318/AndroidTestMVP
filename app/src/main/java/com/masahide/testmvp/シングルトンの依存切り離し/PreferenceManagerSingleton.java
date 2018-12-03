package com.masahide.testmvp.シングルトンの依存切り離し;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * あえてこのクラスはJavaで記述しています。
 * kotlinに関しては後述します。
 */
public class PreferenceManagerSingleton {
    private static PreferenceManagerSingleton instance;
    private SharedPreferences preferences;

    private PreferenceManagerSingleton() {
        preferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
    }

    public static PreferenceManagerSingleton getInstance() {
        if (instance == null) {
            instance = new PreferenceManagerSingleton();
        }
        return instance;
    }

    //singleton のインスタンス差し替え用のsetメソッドを用意する
    public static void setTestingInstance(
            PreferenceManagerSingleton preferenceManagerSingleton) {
        instance = preferenceManagerSingleton;
    }

    public String getUserName() {
        return preferences.getString("name", "");
    }
}