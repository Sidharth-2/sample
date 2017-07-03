package com.seehash.password.login;

import android.content.res.Resources;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;
import com.seehash.password.LoginActivity;
import com.seehash.password.R;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    private Resources resources;

    @Before
    public void init() {

        resources = mActivityRule.getActivity().getResources();
    }

    @Test
    public void testSuccessfulLOGIN() {

        //Find a view with id user_name and type "Chandler" on that view.
        onView(withId(R.id.user_name)).perform(typeText("sidharth"));

        //Find a view with has hint Password and type "sarcasm" as password.
        onView(withHint("Password")).perform(typeText("123"));

        //Close the keyword, otherwise LoginButton won't be visible to Espresso and it will throw an exception.
        closeSoftKeyboard();

        String user_name = "sidharth";

        String password = "123";

        LoginActivity activity = mActivityRule.getActivity();

        View viewById = activity.findViewById(R.id.user_name);

        TextView textView = (TextView) viewById;

        int length = textView.length();

        System.out.println("LEN: " + length);

        junit.framework.Assert.assertTrue(length>7);

        onView(allOf(withId(R.id.user_name))).check(matches(withText(user_name)));

        onView(allOf(withId(R.id.password))).check(matches(withText(password)));

        //Find the LOGIN button and perform click().
        onView(allOf(withText("LOGIN"), isDescendantOfA(withId(R.id.linear_layout)))).perform(click());

    }

    @Test
    public void testFailLOGIN() {

        //Find a view with id user_name and type "Chandler" on that view.
        onView(withId(R.id.user_name)).perform(typeText("sidharth"));

        //Find a view with has hint Password and type "sarcasm" as password.
        onView(withHint("Password")).perform(typeText("1234"));

        //Close the keyword, otherwise LoginButton won't be visible to Espresso and it will throw an
        // exception.
        closeSoftKeyboard();

        String user_name = "sidharth";

        String password = "1234";

        LoginActivity activity = mActivityRule.getActivity();

        View viewById = activity.findViewById(R.id.user_name);

        TextView textView = (TextView) viewById;

        int length = textView.length();

        System.out.println("LEN: " + length);

        // Check the textview length
        junit.framework.Assert.assertTrue(length>8);

        onView(allOf(withId(R.id.user_name))).check(matches(withText(user_name)));

        onView(allOf(withId(R.id.password))).check(matches(withText(password)));

        //Find the LOGIN button and perform click().
        onView(allOf(withText("LOGIN"), isDescendantOfA(withId(R.id.linear_layout)))).perform(click());
    }
}
