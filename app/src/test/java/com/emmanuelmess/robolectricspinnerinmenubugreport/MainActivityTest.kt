package com.emmanuelmess.robolectricspinnerinmenubugreport

import android.content.Context
import android.widget.Spinner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.android.controller.ActivityController

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    private lateinit var activityController: ActivityController<MainActivity>
    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activityController = Robolectric.buildActivity(MainActivity::class.java)
            .create().start().resume().visible()

        activity = activityController.get()
    }

    @Test
    fun testCurrency() {
        val optionsMenu = shadowOf(activity).optionsMenu
        val currencyItem = optionsMenu.findItem(R.id.action_currency)
        val currencyPicker = currencyItem.getActionView() as Spinner
        currencyPicker.setSelection(1)
    }
}