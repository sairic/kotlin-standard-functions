/**
 * @author Ricardo E. Riveros
 *
 * This example will focus on Kotlin standard extension functions
 * also, apply, let, run and to
 */
package com.sairic.example.kotlinstandardfunctions

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

class KotlinStandardFunctionsTest {

    /**
     * Here we want to showcase that everything inside the run function has its own scope
     */
    @Test
    @DisplayName("Test Scope of the standard 'run' function")
    fun testRunScope() {
        val bimmer = Bimmer(2017, "M3", 444, 64000.00)

        run {
            var bimmer = Bimmer(2016, "M4", 425, 66000.00)
            bimmer.isAccelerating = true
        }

        assertTrue(!bimmer.isAccelerating)
    }

    /**
     * Shows that you can apply a function from an object defined in the 'run' scope
     */
    @Test
    @DisplayName("Show that 'run' function can also return the last object defined inside its scope")
    fun testRunScopeWithFunction() {
        run {
            Bimmer(2016, "M4", 425, 66000.00, true)
        }.showStatus()
    }

    @Test
    @DisplayName("Show that 'this' is implied inside the 'run' extension function")
    fun testRunShowThis() {
        val bimmer = Bimmer(2017, "M3", 444, 64000.00)

        bimmer.run {
            assert(model == "M3")
        }

        bimmer.run {
            assert(this.model == "M3")
        }


    }


}