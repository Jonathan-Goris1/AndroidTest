package com.datechnologies.androidtest.ui.fragments

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.datechnologies.androidtest.databinding.FragmentAnimationBinding
import com.datechnologies.androidtest.ui.fragments.base.BaseFragment
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

class AnimationFragment : BaseFragment<FragmentAnimationBinding>() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fadeButton.setOnClickListener {
            beginFadeAnimation()
            confetti()

        }
        binding.animationScreen.setOnDragListener(dragListener)

        binding.techImageView.setOnLongClickListener {
            val clipText = "This is our Clip data text"
            val item = ClipData.Item(clipText)
            val mimetype = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimetype, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }

    }
//    private fun playCheer(){
//        val mp = MediaPlayer.create(requireContext(), R.raw.cheering)
//        if(mp.isPlaying){
//            mp.stop()
//            mp.release()
//        }else{mp.start()
//            mp.release()}
//    }

    private val dragListener = View.OnDragListener { view, event ->
        //val layoutParams = binding.techImageView.layoutParams as RelativeLayout.LayoutParams
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)

            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
//                layoutParams?.marginStart = event.x.toInt()
//                layoutParams?.topMargin = event.y.toInt()
//                view.layoutParams = layoutParams
                view.invalidate()
                val v = event.localState as View
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            else -> false
        }
    }

    private fun confetti() {
        binding.viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(1000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12))
                .setPosition(-50f, binding.viewKonfetti.width + 50f, -50f, -50f)
                .streamFor(300, 5000L)
    }

    private fun beginFadeAnimation() {
        // Custom animation on image
        val fadeOut = ObjectAnimator.ofFloat(binding.techImageView, "alpha", 1f, 0f)
        fadeOut.duration = 2000
        val fadeIn = ObjectAnimator.ofFloat(binding.techImageView, "alpha", 0f, 1f)
        fadeIn.duration = 2000
        val mAnimationSet = AnimatorSet()
        mAnimationSet.play(fadeIn).after(fadeOut)
        mAnimationSet.start()
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentAnimationBinding.inflate(inflater, container, false)
}