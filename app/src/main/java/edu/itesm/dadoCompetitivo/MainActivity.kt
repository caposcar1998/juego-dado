package edu.itesm.dadoCompetitivo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var numeroTiro = 1
        var puntajeUno = 0
        var puntajeDos = 0
        botonTirar.setOnClickListener{
            if (numeroTiro < 7){
                if (numeroTiro == 1 || numeroTiro == 3 ||  numeroTiro == 5){
                    numeroTiro += 1
                    botonTirar.text="TURNO P2"
                    val rand = Random.nextInt(1,6)
                    puntajeUno = puntajeUno + rand
                    resultadoDado.text ="$rand"
                    marcadorUno.text = "$puntajeUno"
                }else {
                    numeroTiro += 1
                    botonTirar.text="TURNO P1"
                    val rand = Random.nextInt(1,6)
                    puntajeDos = puntajeDos + rand
                    resultadoDado.text ="$rand"
                    marcadorDos.text = "$puntajeDos"
                    if(numeroTiro == 7){
                        botonTirar.text="Ver resultado"
                    }
                }

            }else {
                    if(puntajeUno > puntajeDos){
                        ganador.text = "Jugador uno es el ganador"
                    }else if (puntajeUno < puntajeDos){
                        ganador.text = "Jugador dos es el ganador"
                    }else {
                        ganador.text = "Empate"
                    }
            }

        }

        repetirJuego.setOnClickListener{
            numeroTiro = 1
            puntajeUno = 0
            puntajeDos = 0
            resultadoDado.text = "0"
            marcadorUno.text = "0"
            marcadorDos.text = "0"
            botonTirar.text= "TURNO P1"
            ganador.text= ""
        }

    }



}