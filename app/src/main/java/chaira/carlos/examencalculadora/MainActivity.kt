package chaira.carlos.examencalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    public lateinit var tvOperacion : TextView
    public lateinit var tvResultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciar botones
        tvOperacion = findViewById(R.id.tvOperacion)
        tvResultado = findViewById(R.id.tvResultado)

        val btnCero :TextView = findViewById(R.id.btnCero)
        val btnUno :TextView = findViewById(R.id.btnUno)
        val btnDos :TextView = findViewById(R.id.btnDos)
        val btnTres :TextView = findViewById(R.id.btnTres)
        val btnCuatro :TextView = findViewById(R.id.btnCuatro)
        val btnCinco :TextView = findViewById(R.id.btnCinco)
        val btnSeis :TextView = findViewById(R.id.btnSeis)
        val btnSiete :TextView = findViewById(R.id.btnSiete)
        val btnOcho :TextView = findViewById(R.id.btnOcho)
        val btnNueve :TextView = findViewById(R.id.btnNueve)
        val btnSuma :TextView = findViewById(R.id.btnMas)
        val btnResta :TextView = findViewById(R.id.btnMenos)
        val btnMultiplicar :TextView = findViewById(R.id.btnPor)
        val btnDividir :TextView = findViewById(R.id.btnEntre)
        val btnResultado :TextView = findViewById(R.id.btnResult)
        val btnBorrar :TextView = findViewById(R.id.btnBorrar)

        btnCero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        btnUno.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        btnDos.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        btnTres.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        btnCuatro.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        btnCinco.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        btnSeis.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        btnSiete.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        btnOcho.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        btnNueve.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        btnSuma.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        btnResta.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        btnMultiplicar.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        btnDividir.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        btnResultado.setOnClickListener {
            val text = tvOperacion.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResultado.text = longResult.toString()
            } else {
                tvResultado.text = result.toString()
            }
        }

        btnBorrar.setOnClickListener {
            val text = tvOperacion.text.toString()
            if(text.isNotEmpty()) {
                tvOperacion.text = text.dropLast(1)
            }
            tvResultado.text = ""
        }

    }
    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            tvResultado.text = ""
            tvOperacion.append(string)
        } else {
            tvOperacion.append(tvResultado.text)
            tvOperacion.append(string)
            tvResultado.text = ""
        }
    }

}