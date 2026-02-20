package com.mahameet.apps.saiaarti.ui.components.glass

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.*
import platform.Foundation.*

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun GlassContainer(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    UIKitView(
        modifier = modifier,
        factory = {
            val blurEffect = UIBlurEffect.effectWithStyle(
                UIBlurEffectStyle.UIBlurEffectStyleSystemUltraThinMaterial
            )
            val blurView = UIVisualEffectView(blurEffect)
            blurView
        },
        update = { }
    )

    content()
}