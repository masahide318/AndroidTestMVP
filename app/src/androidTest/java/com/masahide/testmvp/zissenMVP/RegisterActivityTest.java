package com.masahide.testmvp.zissenMVP;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.masahide.testmvp.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest {
    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule(RegisterActivity.class);

    @Test
    /**
     * EspressoによるUIテスト
     */
    public void test_メールアドレス入力エラー() {
        //メールアドレスに「hoge」と入力する
        onView(withId(R.id.mail_address)).perform(replaceText("hoge"));
        //「メールアドレスが正しくありません」とエラーメッセージが表示されることを確認する
        onView(withId(R.id.error_message)).check(matches(withText("メールアドレスが正しくありません")));
    }

    @Test
    /**
     * 実際にContractで設定したメソッドを呼び出した結果が正しいか確認することもできます
     */
    public void test_メールアドレス入力エラー2() throws Throwable {
        final RegisterActivity activity =
                (RegisterActivity) activityRule.getActivity();
        activityRule.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.showMailAddressFormatError();
            }
        });
        onView(withId(R.id.error_message)).check(matches(withText("メールアドレスが正しくありません")));
    }

}
