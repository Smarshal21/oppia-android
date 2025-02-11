package org.oppia.android.app.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.oppia.android.app.activity.ActivityComponentImpl
import org.oppia.android.app.activity.InjectableAppCompatActivity
import javax.inject.Inject

/** Activity that controls profile creation and selection. */
class ProfileChooserActivity : InjectableAppCompatActivity() {
  @Inject
  lateinit var profileChooserActivityPresenter: ProfileChooserActivityPresenter

  companion object {
    fun createProfileChooserActivity(context: Context): Intent {
      val intent = Intent(context, ProfileChooserActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (activityComponent as ActivityComponentImpl).inject(this)
    profileChooserActivityPresenter.handleOnCreate()
  }
}
