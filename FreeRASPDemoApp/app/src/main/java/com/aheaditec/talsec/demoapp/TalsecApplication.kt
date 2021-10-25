package com.aheaditec.talsec.demoapp

import android.app.Application
import com.aheaditec.talsec_security.security.api.Talsec
import com.aheaditec.talsec_security.security.api.TalsecConfig
import com.aheaditec.talsec_security.security.api.ThreatListener

class TalsecApplication : Application(), ThreatListener.ThreatDetected {

    override fun onCreate() {
        super.onCreate()

        // Uncomment the following Log.e(...) to get your expectedSigningCertificateHash
        // Copy the result from logcat and assign to expectedSigningCertificateHash
        //Log.e("SigningCertificateHash", Utils.computeSigningCertificateHash(this))

        val config = TalsecConfig(
            expectedPackageName,
            expectedSigningCertificateHash,
            watcherMail,
            supportedAlternativeStores
        )
        ThreatListener(this).registerListener(this)
        Talsec.start(this, config)
    }

    override fun onRootDetected() {
        // Set your reaction
        TODO("Not yet implemented")
    }

    override fun onDebuggerDetected() {
        // Set your reaction
        TODO("Not yet implemented")
    }

    override fun onEmulatorDetected() {
        // Set your reaction
        TODO("Not yet implemented")
    }

    override fun onTamperDetected() {
        // Set your reaction
        TODO("Not yet implemented")
    }

    override fun onUntrustedInstallationSourceDetected() {
        // Set your reaction
        TODO("Not yet implemented")
    }

    override fun onHookDetected() {
        // Set your reaction
        TODO("Not yet implemented")
    }

    override fun onDeviceBindingDetected() {
        // Set your reaction
        TODO("Not yet implemented")
    }

    companion object {
        private const val expectedPackageName =
            "com.aheaditec.talsec.demoapp" // Don't use Context.getPackageName!
        private const val expectedSigningCertificateHash = "mVr/qQLO8DKTwqlL+B1qigl9NoBnbiUs8b4c2Ewcz0k=" // Replace with your release (!) signing certificate hash
        private const val watcherMail = "john@example.com" // for Alerts and Reports
        private val supportedAlternativeStores = arrayOf(
            // Google Play Store and Huawei AppGallery are supported out of the box, you can pass empty array or null or add other stores like the Samsung's one:
            "com.sec.android.app.samsungapps", // Samsung Store
            "adb" // Installation using ADB
        )
    }
}
