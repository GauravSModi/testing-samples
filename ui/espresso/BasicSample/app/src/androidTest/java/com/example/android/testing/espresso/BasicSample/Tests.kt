package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class Tests {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val STRING_ENTERED: String = "Hello World!"

    @Test
    fun TestButtonChangesTextInSameActivity() {
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(STRING_ENTERED), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt))
            .perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(STRING_ENTERED)))
    }

    @Test
    fun TestButtonChangesTextInDifferentActivity() {
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(STRING_ENTERED), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())
        onView(withId(R.id.show_text_view))
            .check(matches(withText(STRING_ENTERED)))
    }
}