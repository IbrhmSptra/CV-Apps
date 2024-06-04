package id.kotlin.cv_app

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    //declare background
    lateinit var mainLayout : ConstraintLayout
    lateinit var profileLayout: ConstraintLayout
    lateinit var animDrawableBg : AnimationDrawable
    lateinit var animDrawablePp : AnimationDrawable
    // declare button
    lateinit var aboutBtn : CardView
    lateinit var educationBtn : CardView
    lateinit var skillsBtn : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init animation background
        mainLayout = findViewById(R.id.mainLayout)
        animDrawableBg = mainLayout.background as AnimationDrawable
        animDrawableBg.setEnterFadeDuration(2500)
        animDrawableBg.setExitFadeDuration(5000)
        animDrawableBg.start()

        //init animation profile
        profileLayout = findViewById(R.id.profileLayout)
        animDrawablePp = profileLayout.background as AnimationDrawable
        animDrawablePp.setEnterFadeDuration(1000)
        animDrawablePp.setExitFadeDuration(1500)
        animDrawablePp.start()

        //fragment init
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer,FragmentAbout())
        fragmentTransaction.commit()
        aboutBtn = findViewById(R.id.about)
        aboutBtn.setCardBackgroundColor(resources.getColor(R.color.white))

        //btn Navigate
        aboutBtn.setOnClickListener {
            navigateFragment(FragmentAbout())
            aboutBtn.setCardBackgroundColor(resources.getColor(R.color.white))
            educationBtn.setCardBackgroundColor(resources.getColor(R.color.transparent))
            skillsBtn.setCardBackgroundColor(resources.getColor(R.color.transparent))
        }
        educationBtn = findViewById(R.id.education)
        educationBtn.setOnClickListener {
            navigateFragment(FragmentEducation())
            educationBtn.setCardBackgroundColor(resources.getColor(R.color.white))
            aboutBtn.setCardBackgroundColor(resources.getColor(R.color.transparent))
            skillsBtn.setCardBackgroundColor(resources.getColor(R.color.transparent))
        }
        skillsBtn = findViewById(R.id.skills)
        skillsBtn.setOnClickListener {
            navigateFragment(FragmentSkills())
            skillsBtn.setCardBackgroundColor(resources.getColor(R.color.white))
            aboutBtn.setCardBackgroundColor(resources.getColor(R.color.transparent))
            educationBtn.setCardBackgroundColor(resources.getColor(R.color.transparent))
        }
    }

    private fun navigateFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}