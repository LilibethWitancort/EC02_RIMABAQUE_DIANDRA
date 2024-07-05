package com.AC2_DIANDRA_RIMABAQUE
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.AC2_DIANDRA_RIMABAQUE.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resolverButton: Button = binding.buttonResolver
        resolverButton.setOnClickListener {
            val contenido = obtenerRespuestas()
            enviarRespuestasAGitHub(contenido)
            finish()
        }
    }

    private fun obtenerRespuestas(): String {
        val habilidades = mutableListOf<String>()
        if (binding.checkboxAutoconocimiento.isChecked) habilidades.add("Autoconocimiento")
        if (binding.checkboxEmpatia.isChecked) habilidades.add("Empatía")
        if (binding.checkboxComunicacionAsertiva.isChecked) habilidades.add("Comunicación asertiva")
        if (binding.checkboxTomaDecisiones.isChecked) habilidades.add("Toma de decisiones")
        if (binding.checkboxPensamientoCritico.isChecked) habilidades.add("Pensamiento crítico")
        if (binding.checkboxNinguno.isChecked) habilidades.add("Ninguno")

        val significadoTrabajo = when {
            binding.radioMucho.isChecked -> "Mucho"
            binding.radioMasOMenos.isChecked -> "Más o menos"
            binding.radioPoco.isChecked -> "Poco"
            else -> ""
        }

        val pagoTrabajo = when {
            binding.radioBien.isChecked -> "Bien"
            binding.radioRegular.isChecked -> "Regular"
            binding.radioMal.isChecked -> "Mal"
            else -> ""
        }

        val trabajaPresion = if (binding.radioSiPresion.isChecked) "SI" else "NO"
        val crecimientoTrabajo = if (binding.radioSiCrecimiento.isChecked) "SI" else "NO"

        return """
            Habilidades: ${habilidades.joinToString(", ")}
            Significado del trabajo: $significadoTrabajo
            Pago en el trabajo: $pagoTrabajo
            Trabaja bajo presión: $trabajaPresion
            Oportunidad de crecimiento: $crecimientoTrabajo
        """.trimIndent()
    }

    private fun enviarRespuestasAGitHub(contenido: String) {
        val email = "lilibeth.witancort@hotmail.com"
        val password = "Diandra1234$"
        GitHubUtil.enviarARepo(contenido, email, password)
    }
}
