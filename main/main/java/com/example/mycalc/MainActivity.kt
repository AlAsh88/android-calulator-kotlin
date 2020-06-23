package com.example.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var op = "*"
    var oldNumber = "0"
    var isNewOp = true

    fun buNumberEvent(view: View) {
        if (isNewOp) {
            editDisplayNum.setText(" ")
        }
        isNewOp = false

        val buttonSelect = view as Button
        var buttonClickValue: String = editDisplayNum.text.toString()

        when (buttonSelect.id) {
            button0.id -> {
                buttonClickValue += "0"
            }
            button1.id -> {
                buttonClickValue += "1"
            }
            button2.id -> {
                buttonClickValue += "2"
            }
            button3.id -> {
                buttonClickValue += "3"
            }
            button4.id -> {
                buttonClickValue += "4"
            }
            button5.id -> {
                buttonClickValue += "5"
            }
            button6.id -> {
                buttonClickValue += "6"
            }
            button7.id -> {
                buttonClickValue += "7"
            }
            button8.id -> {
                buttonClickValue += "8"
            }
            button9.id -> {
                buttonClickValue += "9"
            }
            buttonDot.id -> {
                //TODO prevent adding more than one dot
                buttonClickValue += "."
            }
            buttonPlusMinus.id -> {
                val splitStr = buttonClickValue.split('-')
                if (splitStr.count() > 1) // minus found
                {
                    buttonClickValue = splitStr[1]
                }
                else{//no minus found
                    buttonClickValue = "-" + buttonClickValue
                }

            }
        }
        editDisplayNum.setText(buttonClickValue)
    }


    fun buOpEvent(view: View) {
        val buttonSelect = view as Button

        when (buttonSelect.id) {
            buttonMultiply.id -> {
                op = "*"
            }
            buttonDivide.id -> {
                op = "/"
            }
            buttonMinus.id -> {
                op = "-"

            }
            buttonPlus.id -> {
                op = "+"
            }
        }
        //oldNumber = editDisplayNum.text.toString()
        oldNumber = calculate(oldNumber, editDisplayNum.text.toString()).toString()
        editDisplayNum.setText(oldNumber)
        isNewOp = true
    }

    fun buEqualEvent(view: View) {
        val newNumber = editDisplayNum.text.toString()
        var finalNumber: Double? = null
        finalNumber = calculate(oldNumber, newNumber)
        /*when (op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> finalNumber = oldNumber.toDouble() - newNumber.toDouble()
        }*/
        editDisplayNum.setText(finalNumber.toString())
        isNewOp = true
    }

    fun buPercent (view: View)
    {
        val number = editDisplayNum.text.toString().toDouble()/100
        editDisplayNum.setText(number.toString())
        isNewOp = true
    }

    fun buClear(view: View)
    {
        editDisplayNum.setText("0")
        oldNumber = "0"
        isNewOp = true
    }

    fun calculate(previousNumber : String, currentNumber :String) : Double
    {
        var finalNumber: Double = 0.0;
        when (op) {
            "*" -> {
                finalNumber = previousNumber.toDouble() * currentNumber.toDouble()
            }
            "/" -> {
                if (previousNumber != "0") {
                    finalNumber = previousNumber.toDouble() / currentNumber.toDouble()
                }
                else {
                    finalNumber = currentNumber.toDouble()
                }
            }
            "+" -> {
                finalNumber = previousNumber.toDouble() + currentNumber.toDouble()
            }
            "-" -> finalNumber = previousNumber.toDouble() - currentNumber.toDouble()
        }

        return finalNumber


    }

}