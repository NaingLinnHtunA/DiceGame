package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playGame()

    }
    private fun playGame(){

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val score = findViewById<TextView>(R.id.totalScore)
        val bet = findViewById<TextView>(R.id.totalBet)
        val resultText = findViewById<TextView>(R.id.txtResult)
        val diceImage = findViewById<ImageView>(R.id.imgDice)

        btnPlay.visibility=View.VISIBLE

        btnPlay.setOnClickListener {
            val randomNumber = (1+Math.random() * 6).toInt()
            var totalScore = score.text.toString().toInt()
            if (bet.text.isEmpty()){
                resultText.text = "Enter the your bet amount!!"
            }else{
                var betAmount = bet.text.toString().toInt()
                if (totalScore < betAmount){
                    resultText.text = "Bet amount is greater than your score"
                }else if (totalScore == 0){

                }else{
                    when(randomNumber){
                        1 -> {
                            totalScore -= betAmount
                            if (totalScore == 0){
                                gameOver()
                            }else{
                                score.text = totalScore.toString()
                                diceImage.setImageResource(R.drawable.dice_1)
                                bet.text = ""
                                resultText.text = "You Lose!"
                            }
                        }
                        2 -> {
                            totalScore -= betAmount
                            if (totalScore == 0){
                                gameOver()
                            }else{
                                score.text = totalScore.toString()
                                diceImage.setImageResource(R.drawable.dice_2)
                                bet.text = ""
                                resultText.text = "You Lose!"
                            }
                        }
                        3 -> {
                            totalScore = totalScore
                            if (totalScore == 0){
                                gameOver()
                            }else{
                                score.text = totalScore.toString()
                                diceImage.setImageResource(R.drawable.dice_3)
                                bet.text = ""
                                resultText.text = "Drawl!"
                            }

                        }
                        4 -> {
                            totalScore += betAmount
                            if (totalScore == 0){
                                gameOver()
                            }else{
                                score.text = totalScore.toString()
                                diceImage.setImageResource(R.drawable.dice_4)
                                bet.text = ""
                                resultText.text = "You Win!!"
                            }

                        }
                        5 -> {
                            totalScore += betAmount
                            if (totalScore == 0){
                                gameOver()
                            }else{
                                score.text = totalScore.toString()
                                diceImage.setImageResource(R.drawable.dice_5)
                                bet.text = ""
                                resultText.text = "You Win!!"
                            }
                        }
                        6 -> {
                            totalScore += 2*betAmount
                            if (totalScore == 0){
                                gameOver()
                            }else{
                                score.text = totalScore.toString()
                                diceImage.setImageResource(R.drawable.dice_6)
                                bet.text = ""
                                resultText.text = "You Win Double!"
                            }
                        }
                    }
                }

            }

        }
    }

    private fun gameOver(){
        val score = findViewById<TextView>(R.id.totalScore)
        val bet = findViewById<TextView>(R.id.totalBet)
        val resultText = findViewById<TextView>(R.id.txtResult)
        val diceImage = findViewById<ImageView>(R.id.imgDice)

        score.text = 100.toString()
        bet.text = ""
        resultText.text = "Lose!! Game Over!! Try Again"
        diceImage.setImageResource(R.drawable.dice_1)
    }

}