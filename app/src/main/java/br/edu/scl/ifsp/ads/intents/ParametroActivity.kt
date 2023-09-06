package br.edu.scl.ifsp.ads.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.scl.ifsp.ads.intents.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {
    private val apb: ActivityParametroBinding by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        supportActionBar?.subtitle = "ParametroActivity"

        intent.getStringExtra(MainActivity.PARAMETRO_EXTRA)?.let {
            apb.parametroEt.setText(it)
        }

        apb.entrarParametroBt.setOnClickListener {
            val intentRetorno = Intent()
            intentRetorno.putExtra(MainActivity.PARAMETRO_EXTRA, apb.parametroEt.text.toString())
            setResult(RESULT_OK, intentRetorno)
            finish()
        }
    }
}