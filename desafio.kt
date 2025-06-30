enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val formacao = Formacao(
        "Kotlin", listOf(
            ConteudoEducacional(" Introdução a Kotlin", Nivel.BASICO), ConteudoEducacional(
                "Orientação a Objetos com Kotlin",
                Nivel.INTERMEDIARIO,
                duracao = 120
            ),
            ConteudoEducacional(
                "Spring Boot 3 com Kotlin",
                Nivel.DIFICIL,
            )
        )
    )

    formacao.matricular(Usuario("Manoel"))
    formacao.matricular(Usuario("Maria"))

    println(formacao.inscritos)
}