package com.emmanuelmess.robolectricspinnerinmenubugreport

import android.widget.Spinner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.android.controller.ActivityController
import com.emmanuelmess.robolectricspinnerinmenubugreport.R.menu.toolbar
import android.app.Activity
import android.view.Menu
import androidx.appcompat.widget.Toolbar


@RunWith(RobolectricTestRunner::class)
class WorkarroundOne {
    private lateinit var activityController: ActivityController<MainActivity>
    private lateinit var activity: MainActivity
    private lateinit var optionsMenu: Menu

    @Before
    fun setUp() {
        activityController = Robolectric.buildActivity(MainActivity::class.java)
            .create().start().resume()
        createOptionsMenu(activityController)
        activityController.visible()

        activity = activityController.get()
    }

    @Test
    fun testWorkarroundOne() {
        val currencyItem = optionsMenu.findItem(R.id.action_currency)
        val currencyPicker = currencyItem.getActionView() as Spinner
        currencyPicker.setSelection(1)
    }

    private fun createOptionsMenu(activityController: ActivityController<out Activity>) {
        val activity = activityController.get()
        optionsMenu = activity.findViewById<Toolbar>(R.id.action_bar).getMenu()
        activity.onCreateOptionsMenu(optionsMenu)
    }
}