/**
 * @author Ricardo E. Riveros
 *
 * This example will focus on Kotlin standard extension functions
 * also, apply, let, run, to and use
 */
package com.sairic.example.kotlinstandardfunctions

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

class KotlinStandardFunctionsTest {

    /**
     * Shows that 'run' by default will pass in a reference to this. It can be used implicitly or
     * explicity use 'this'
     */
    @Test
    @DisplayName("Show that 'this' is implied inside the 'run' extension function")
    fun testRunShowThis() {
        val bimmer = Bimmer(2017, "M3", 444, 64000.00)

        bimmer.run {
            assert(model == "M3")
            assert(this.model == "M3")
            horsePower = 475
        }
        assert(bimmer.horsePower == 475)
    }

    @Test
    @DisplayName("Show that you can return any value within the 'run' block")
    fun testRunWithReturn() {
        val bimmer = Bimmer(2017, "M3", 444, 64000.00)

        val bimmerOwnerStatement = bimmer.run {
            assert(model == "M3")
            horsePower = 475
            "I love my car!!!"
        }
        assert(bimmer.horsePower == 475)
        assert(bimmerOwnerStatement == "I love my car!!!")
    }

    /**
     * Here we are demonstrating using 'let' that passes in a 'it' variable referencing the outer
     * object. This acts more like a lambda function
     */
    @Test
    @DisplayName("Show 'let' and how it passes 'it' inside the function scope like a lambda")
    fun testLetIt() {
        val bimmer =Bimmer(2016, "M4", 425, 66000.00, false)

        bimmer.let {
            assert(it.horsePower == 425)
            it.isAccelerating = true
        }
        assert(bimmer.isAccelerating)


        bimmer.let { myawesomebimmer ->
            assert(myawesomebimmer.horsePower == 425)
        }
        assert(bimmer.isAccelerating)

    }


}