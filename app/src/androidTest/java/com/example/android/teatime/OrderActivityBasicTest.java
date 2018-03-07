/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.teatime;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This test demos a user clicking the decrement button and verifying that it properly decrease
 * the quantity the total cost.
 */

// TODO (1) Add annotation to specify AndroidJUnitRunner class as the default test runner

    @RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    // TODO (2) Add the rule that provides functional testing of a single activity
    @Rule public ActivityTestRule<OrderActivity> mActivityTestRule =
            new ActivityTestRule<OrderActivity>(OrderActivity.class);

    @Test
    public void clickIncrementButton_ChangesQuantityAndCost() {
        // 1. Find the View
        // 2. Perform Action on the View
        Espresso.onView((ViewMatchers.withId(R.id.increment_button))).perform(ViewActions.click());

        // 3. Check if the View does what you expected:
        // .. the quantity TextView increase by 1
        // ... the cost increase by 1 factor
        // So, here we go:
        Espresso.onView((ViewMatchers.withId(R.id.quantity_text_view)))
                .check(ViewAssertions.matches(ViewMatchers.withText("1")));
        Espresso.onView((ViewMatchers.withId(R.id.cost_text_view)))
                .check(ViewAssertions.matches(ViewMatchers.withText("$5.00")));

    }

    // TODO (3) Finish writing this test which will:

    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {

        //          - Check that the initial quantity is zero
        //          - Click on the decrement button
        Espresso.onView((ViewMatchers.withId(R.id.decrement_button))).perform(ViewActions.click());

        //          - Verify that the decrement button won't decrease the quantity 0 and cost below $0.00
        Espresso.onView((ViewMatchers.withId(R.id.quantity_text_view)))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
        Espresso.onView((ViewMatchers.withId(R.id.cost_text_view)))
                .check(ViewAssertions.matches(ViewMatchers.withText("$0.00")));
    }
}